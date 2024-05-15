/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Ciclos;
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
 * @author visitante
 */
public class CiclosDAO {

    private static final String SQL_SELECT = "SELECT codigo_ciclo, nombre_ciclo, estatus_ciclo FROM ciclos";
    private static final String SQL_INSERT = "INSERT INTO ciclos(codigo_ciclo, nombre_ciclo, estatus_ciclo) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE ciclos SET nombre_ciclo=?, estatus_ciclo=? WHERE codigo_ciclo = ?";
    private static final String SQL_DELETE = "DELETE FROM ciclos WHERE codigo_ciclo=?";
    private static final String SQL_QUERY = "SELECT codigo_ciclo, nombre_ciclo, estatus_ciclo FROM ciclos WHERE codigo_ciclo = ?";

    public List<Ciclos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ciclos ciclo = null;
        List<Ciclos> ciclos = new ArrayList<Ciclos>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_ciclo");
                String nombre = rs.getString("nombre_ciclo");
                String estatus = rs.getString("estatus_ciclo");
                
                ciclo = new Ciclos();
                ciclo.setCodigo_ciclo(codigo);
                ciclo.setNombre_ciclo(nombre);
                ciclo.setEstatus_ciclo(estatus);
                
                ciclos.add(ciclo);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return ciclos;
    }

    public int insert(Ciclos ciclo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, ciclo.getCodigo_ciclo());
            stmt.setString(2, ciclo.getNombre_ciclo());
            stmt.setString(3, ciclo.getEstatus_ciclo());
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

    public int update(Ciclos ciclo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, ciclo.getNombre_ciclo());
            stmt.setString(2, ciclo.getEstatus_ciclo());
            stmt.setString(3, ciclo.getCodigo_ciclo());

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

    public int delete(Ciclos ciclo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, ciclo.getCodigo_ciclo());
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
    public Ciclos query(Ciclos ciclo) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, ciclo.getCodigo_ciclo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_ciclo");
                String nombre = rs.getString("nombre_ciclo");
                String estatus = rs.getString("estatus_ciclo");
                
                ciclo = new Ciclos();
                ciclo.setCodigo_ciclo(codigo);
                ciclo.setNombre_ciclo(nombre);
                ciclo.setEstatus_ciclo(estatus);
        
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return ciclo;
    }
        
}
