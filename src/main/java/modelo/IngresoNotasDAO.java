/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.IngresoNotas;
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
public class IngresoNotasDAO {
    private static final String SQL_SELECT = "SELECT cod_acta, not_semestre, not_año, carnet_alumno, not_parcial1, not_parcial2, not_examenfinal, not_zonatareas, not_totalpuntos FROM ingresonotas";
    private static final String SQL_INSERT = "INSERT INTO ingresonotas(cod_acta, not_semestre, not_año, carnet_alumno, not_parcial1, not_parcial2, not_examenfinal, not_zonatareas, not_totalpuntos) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE ingresonotas SET not_semestre=?, not_año=?, carnet_alumno=?, not_parcial1=?, not_parcial2=?, not_examenfinal=?, not_zonatareas=?, not_totalpuntos=?  WHERE cod_acta = ?";
    private static final String SQL_DELETE = "DELETE FROM ingresonotas WHERE cod_acta=?";
    private static final String SQL_QUERY = "SELECT cod_acta, not_semestre, not_año, carnet_alumno, not_parcial1, not_parcial2, not_examenfinal, not_zonatareas, not_totalpuntos FROM ingresonotas WHERE cod_acta= ?";
    
    public List<IngresoNotas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        IngresoNotas nota = null;
        List<IngresoNotas> notas = new ArrayList<IngresoNotas>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("cod_acta");
                String semestre = rs.getString("not_semestre");
                String año = rs.getString("not_año");
                String carnet = rs.getString("carnet_alumno"); 
                int parcial1 = rs.getInt("not_parcial1");
                int parcial2 = rs.getInt("not_parcial2");
                int examenfinal = rs.getInt("not_examenfinal");
                int tareas = rs.getInt("not_zonatareas");
                int total = rs.getInt("not_totalpuntos");
                
                nota = new IngresoNotas();
                nota.setCod_acta(codigo);
                nota.setNot_semestre(semestre);
                nota.setNot_año(año);
                nota.setCarnet_alumno(carnet);
                nota.setNot_parcial1(parcial1);
                nota.setNot_parcial2(parcial2);
                nota.setNot_examenfinal(examenfinal);
                nota.setNot_zonatareas(tareas);
                nota.setNot_totalpuntos(total);
                
                notas.add(nota);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return notas;
    }
    
    public int insert(IngresoNotas nota) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, nota.getCod_acta());
            stmt.setString(2, nota.getNot_semestre());
            stmt.setString(3, nota.getNot_año());
            stmt.setString(4, nota.getCarnet_alumno());
            stmt.setInt(5, nota.getNot_parcial1());
            stmt.setInt(6, nota.getNot_parcial2());
            stmt.setInt(7, nota.getNot_examenfinal());
            stmt.setInt(8, nota.getNot_zonatareas());
            stmt.setInt(9, nota.getNot_totalpuntos());
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
    
    public int update(IngresoNotas nota) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, nota.getNot_semestre());
            stmt.setString(2, nota.getNot_año());
            stmt.setString(3, nota.getCarnet_alumno());
            stmt.setInt(4, nota.getNot_parcial1());
            stmt.setInt(5, nota.getNot_parcial2());
            stmt.setInt(6, nota.getNot_examenfinal());
            stmt.setInt(7, nota.getNot_zonatareas());
            stmt.setInt(8, nota.getNot_totalpuntos());
            stmt.setString(9, nota.getCod_acta());
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
    
    public int delete(IngresoNotas nota) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, nota.getCod_acta());
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
    
    public IngresoNotas query(IngresoNotas nota) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, nota.getCod_acta());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                String semestre = rs.getString("not_semestre");
                String año = rs.getString("not_año");
                String carnet = rs.getString("carnet_alumno"); 
                int parcial1 = rs.getInt("not_parcial1");
                int parcial2 = rs.getInt("not_parcial2");
                int examenfinal = rs.getInt("not_examenfinal");
                int tareas = rs.getInt("not_zonatareas");
                int total = rs.getInt("not_totalpuntos");
                
                
                nota = new IngresoNotas();
                nota.setNot_semestre(semestre);
                nota.setNot_año(año);
                nota.setCarnet_alumno(carnet);
                nota.setNot_parcial1(parcial1);
                nota.setNot_parcial2(parcial2);
                nota.setNot_examenfinal(examenfinal);
                nota.setNot_zonatareas(tareas);
                nota.setNot_totalpuntos(total);
        
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return nota;
    }
}
