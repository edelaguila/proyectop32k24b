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
     private static final String SQL_SELECT = "SELECT id_tipo_pago, nombre_tipo_pago, cantidad_tipo_pago FROM TiposDePagos";
     private static final String SQL_INSERT = "INSERT INTO TiposDePagos(nombre_tipo_pago) VALUES(?)";
     private static final String SQL_UPDATE = "UPDATE TiposDePagos SET id_tipo_pago=? WHERE id_tipo_pago = ?";
     private static final String SQL_DELETE = "DELETE FROM TiposDePagos WHERE id_tipo_pago=?";
     private static final String SQL_QUERY = "SELECT id_tipo_pago, nombre_tipo_pago, cantidad_tipo_pago FROM TiposDePagos WHERE id_tipo_pago = ?";

    public List<TiposDePagos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TiposDePagos tipoPago = null;
        List<TiposDePagos> tiposDePagos = new ArrayList<TiposDePagos>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id_tipo_pago");
                String nombre = rs.getString("nombre_tipo_pago");
                String cantidad = rs.getString("cantidad_tipo_pago");
              
                tipoPago = new TiposDePagos();
                tipoPago.setIdTipoPago(id);
                tipoPago.setNombrePago(nombre);
                tipoPago.setcantidadPago(cantidad);
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
            stmt.setString(1, tipoPago.getNombrePago());
            System.out.println("ejecución query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
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
            System.out.println("Ejecución query:" + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, tipoPago.getNombrePago());
            stmt.setString(2, tipoPago.getIdTipoPago());
            stmt.setString(3, tipoPago.getcantidadPago());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizad:" + rows);
            
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
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, tipoPago.getIdTipoPago());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
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
            stmt.setString(1, tipoPago.getIdTipoPago());
            rs = stmt.executeQuery();
            if (rs.next()) {
                tipoPago.setNombrePago(rs.getString("nombre_tipo_pago"));
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
