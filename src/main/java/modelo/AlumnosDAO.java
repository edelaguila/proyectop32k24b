/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

//Importan Librerias, principalmente la de Alumnos
import controlador.Alumnos;
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
//Creacion de la clase Alumnos Dao y los parametros de la base de datos
public class AlumnosDAO {
 
    private static final String SQL_SELECT = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos";
    private static final String SQL_INSERT = "INSERT INTO alumnos(carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE alumnos SET nombre_alumno=?, direccion_alumno=?, telefono_alumno=?, email_alumno=?, estatus_alumno=? WHERE carnet_alumno = ?";
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE carnet_alumno=?";
    private static final String SQL_QUERY = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos WHERE carnet_alumno = ?";
    
    public List<Alumnos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alumnos alumno = null;
        List<Alumnos> alumnos = new ArrayList<Alumnos>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String carnet = rs.getString("carnet_alumno");
                String nombre = rs.getString("nombre_alumno");
                String direccion = rs.getString("direccion_alumno");
                String telefono = rs.getString("telefono_alumno");
                String email = rs.getString("email_alumno");
                String estatus = rs.getString("estatus_alumno");
                
                alumno = new Alumnos();
                alumno.setCarnet_alumno(carnet);
                alumno.setNombre_alumno(nombre);
                alumno.setDireccion_alumno(direccion);
                alumno.setTelefono_alumno(telefono);
                alumno.setEmail_alumno(email);
                alumno.setEstatus_alumno(estatus);
                
                alumnos.add(alumno);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return alumnos;
    }
    
    public int insert(Alumnos alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumno.getCarnet_alumno());
            stmt.setString(2, alumno.getNombre_alumno());
            stmt.setString(3, alumno.getDireccion_alumno());
            stmt.setString(4, alumno.getTelefono_alumno());
            stmt.setString(5, alumno.getEmail_alumno());
            stmt.setString(6, alumno.getEstatus_alumno());
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
    
    public int update(Alumnos alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, alumno.getNombre_alumno());
            stmt.setString(2, alumno.getDireccion_alumno());
            stmt.setString(3, alumno.getTelefono_alumno());
            stmt.setString(4, alumno.getEmail_alumno());
            stmt.setString(5, alumno.getEstatus_alumno());
            stmt.setString(6, alumno.getCarnet_alumno());
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
    
    public int delete(Alumnos alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, alumno.getCarnet_alumno());
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
    
    public Alumnos query(Alumnos alumno) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, alumno.getCarnet_alumno());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                String carnet = rs.getString("carnet_alumno");
                String nombre = rs.getString("nombre_alumno");
                String direccion = rs.getString("direccion_alumno");
                String telefono = rs.getString("telefono_alumno");
                String email = rs.getString("email_alumno");
                String estatus = rs.getString("estatus_alumno");
                
                alumno = new Alumnos();
                alumno.setCarnet_alumno(carnet);
                alumno.setNombre_alumno(nombre);
                alumno.setDireccion_alumno(direccion);
                alumno.setTelefono_alumno(telefono);
                alumno.setEmail_alumno(email);
                alumno.setEstatus_alumno(estatus);
        
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return alumno;
    }
}
