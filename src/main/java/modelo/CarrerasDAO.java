/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.Carreras;
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
 * @author favio
 */
public class CarrerasDAO {
    
    private static final String SQL_SELECT = "SELECT codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera FROM carreras";
    private static final String SQL_INSERT = "INSERT INTO carreras(codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE carreras SET nombre_carrera=?, codigo_facultad=?, estatus_carrera=? WHERE codigo_carrera = ?";
    private static final String SQL_DELETE = "DELETE FROM carreras WHERE codigo_carrera=?";
    private static final String SQL_QUERY = "SELECT codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera FROM carreras WHERE codigo_carrera = ?";
    
    public List<Carreras> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Carreras carrera = null;
        List<Carreras> carreras = new ArrayList<Carreras>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                String codigof = rs.getString("codigo_facultad");
                String estatus = rs.getString("estatus_carrera");
                
                carrera = new Carreras();
                carrera.setCodigo_carrera(codigo);
                carrera.setNombre_carrera(nombre);
                carrera.setCodigo_facultad( codigof);
                carrera.setEstatus_carrera(estatus);
                
                carreras.add(carrera);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return carreras;
    }
    
    public int insert(Carreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, carrera.getCodigo_carrera());
            stmt.setString(2, carrera.getNombre_carrera());
            stmt.setString(3, carrera.getCodigo_facultad());
            stmt.setString(4, carrera.getEstatus_carrera());
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
    
    public int update(Carreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, carrera.getNombre_carrera());
            stmt.setString(2, carrera.getCodigo_facultad());
            stmt.setString(3, carrera.getEstatus_carrera());
            stmt.setString(4, carrera.getCodigo_carrera());
            

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
    
    public int delete(Carreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, carrera.getCodigo_carrera());
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
    
    //    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Carreras query(Carreras carrera) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, carrera.getCodigo_carrera());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                String codigof = rs.getString("codigo_facultad");
                String estatus = rs.getString("estatus_carrera");
                
                carrera = new Carreras();
                carrera.setCodigo_carrera(codigo);
                carrera.setNombre_carrera(nombre);
                carrera.setCodigo_facultad(codigof);
                carrera.setEstatus_carrera(estatus);
        
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return carrera;
    }
    
}
