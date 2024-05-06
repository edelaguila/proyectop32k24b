/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

//Importan Librerias, principalmente la de Maestros
import controlador.Maestros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author kenph
 */
//Creacion de la clase Maestros Dao y los parametros de la base de datos
public class MaestrosDAO {
 
    private static final String SQL_SELECT = "SELECT codigo_maestro, nombre_maestro, direccion_maestro, telefono_maetro, email_maestro, estatus_maestro FROM maestros";
    private static final String SQL_INSERT = "INSERT INTO maestros(codigo_maestro, nombre_maestro, direccion_maestro, telefono_maetro, email_maestro, estatus_maestro) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE maestros SET nombre_maestro=?, direccion_maestro=?, telefono_maetro=?, email_maestro=?, estatus_maestro=? WHERE codigo_maestro = ?";
    private static final String SQL_DELETE = "DELETE FROM maestros WHERE codigo_maestro=?";
    private static final String SQL_QUERY = "SELECT codigo_maestro, nombre_maestro, direccion_maestro, telefono_maetro, email_maestro, estatus_maestro FROM maestros WHERE codigo_maestro = ?";
    
    public List<Maestros> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Maestros maestro = null;
        List<Maestros> maestros = new ArrayList<Maestros>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_maestro");
                String nombre = rs.getString("nombre_maestro");
                String direccion = rs.getString("direccion_maestro");
                String telefono = rs.getString("telefono_maetro");
                String email = rs.getString("email_maestro");
                String estatus = rs.getString("estatus_maestro");
                
                maestro = new Maestros();
                maestro.setCodigo_maestro(codigo);
                maestro.setNombre_maestro(nombre);
                maestro.setDireccion_maestro(direccion);
                maestro.setTelefono_maestro(telefono);
                maestro.setEmail_maestro(email);
                maestro.setEstatus_maestro(estatus);
                
                maestros.add(maestro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return maestros;
    }
    
    public int insert(Maestros maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, maestro.getCodigo_maestro());
            stmt.setString(2, maestro.getNombre_maestro());
            stmt.setString(3, maestro.getDireccion_maestro());
            stmt.setString(4, maestro.getTelefono_maestro());
            stmt.setString(5, maestro.getEmail_maestro());
            stmt.setString(6, maestro.getEstatus_maestro());
            System.out.println("ejecutando query:" + SQL_INSERT);
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
    
    public int update(Maestros maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, maestro.getNombre_maestro());
            stmt.setString(2, maestro.getDireccion_maestro());
            stmt.setString(3, maestro.getTelefono_maestro());
            stmt.setString(4, maestro.getEmail_maestro());
            stmt.setString(5, maestro.getEstatus_maestro());
            stmt.setString(6, maestro.getCodigo_maestro());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public int delete(Maestros maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, maestro.getCodigo_maestro());
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
    
    public Maestros query(Maestros maestro) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, maestro.getCodigo_maestro());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                String codigo = rs.getString("codigo_maestro");
                String nombre = rs.getString("nombre_maestro");
                String direccion = rs.getString("direccion_maestro");
                String telefono = rs.getString("telefono_maetro");
                String email = rs.getString("email_maestro");
                String estatus = rs.getString("estatus_maestro");
                
                maestro = new Maestros();
                maestro.setCodigo_maestro(codigo);
                maestro.setNombre_maestro(nombre);
                maestro.setDireccion_maestro(direccion);
                maestro.setTelefono_maestro(telefono);
                maestro.setEmail_maestro(email);
                maestro.setEstatus_maestro(estatus);
        
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return maestro;
    }
}
