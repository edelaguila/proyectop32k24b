/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import controlador.TiposDePagos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Joseg
 */
public class TiposDePagoDAO {
     private static final String SQL_SELECT = "SELECT id_tipo_pago, nombre, descripcion FROM TiposDePagos";
    private static final String SQL_INSERT = "INSERT INTO TiposDePagos(nombre, descripcion) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE TiposDePagos SET nombre=?, descripcion=? WHERE id_tipo_pago = ?";
    private static final String SQL_DELETE = "DELETE FROM TiposDePagos WHERE id_tipo_pago=?";
    private static final String SQL_QUERY = "SELECT id_tipo_pago, nombre, descripcion FROM TiposDePagos WHERE id_tipo_pago = ?";

    public List<TiposDePagos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TiposDePagos tipoPago = null;
        List<TiposDePagos> tiposDePagos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_tipo_pago");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");

                tipoPago = new TiposDePagos(id, nombre, descripcion);
                tiposDePagos.add(tipoPago);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return tiposDePagos;
    }

    public int insert(TiposDePagos tipoPago) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, tipoPago.getNombre());
            stmt.setString(2, tipoPago.getDescripcion());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(TiposDePagos tipoPago) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, tipoPago.getNombre());
            stmt.setString(2, tipoPago.getDescripcion());
            stmt.setInt(3, tipoPago.getIdTipoPago());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(TiposDePagos tipoPago) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, tipoPago.getIdTipoPago());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public TiposDePagos query(TiposDePagos tipoPago) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, tipoPago.getIdTipoPago());
            rs = stmt.executeQuery();
            if (rs.next()) {
                tipoPago.setNombre(rs.getString("nombre"));
                tipoPago.setDescripcion(rs.getString("descripcion"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return tipoPago;
    }
}
