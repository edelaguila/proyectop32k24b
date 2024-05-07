package modelo;

import controlador.Bancos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancosDAO {

    private static final String SQL_SELECT = "SELECT id_banco, nombre_banco FROM bancos";
    private static final String SQL_INSERT = "INSERT INTO bancos(id_banco, nombre_banco) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE bancos SET nombre_banco=? WHERE id_banco = ?";
    private static final String SQL_DELETE = "DELETE FROM bancos WHERE id_banco=?";
    private static final String SQL_QUERY = "SELECT id_banco, nombre_banco FROM bancos WHERE id_banco = ?";

    public List<Bancos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Bancos banco = null;
        List<Bancos> bancos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id_banco");
                String nombre = rs.getString("nombre_banco");
                
                banco = new Bancos();
                banco.setIdBanco(id);
                banco.setNombreBanco(nombre);
                
                bancos.add(banco);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return bancos;
    }

    public int insert(Bancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, banco.getIdBanco());
            stmt.setString(2, banco.getNombreBanco());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Bancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, banco.getNombreBanco());
            stmt.setString(2, banco.getIdBanco());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Bancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, banco.getIdBanco());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Bancos query(Bancos banco) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, banco.getIdBanco());
            rs = stmt.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id_banco");
                String nombre = rs.getString("nombre_banco");
                
                banco = new Bancos();
                banco.setIdBanco(id);
                banco.setNombreBanco(nombre);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return banco;
    }   
}
