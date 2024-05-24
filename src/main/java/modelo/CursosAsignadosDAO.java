/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import controlador.CursosAsignados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Joseg
 */
public class CursosAsignadosDAO {
    
    private static final String SQL_INSERT = "INSERT INTO cursosasignados(primer_curso, segundo_curso, tercer_curso, cuarto_curso, quinto_curso) VALUES(?, ?, ?, ?, ?)";
    
    public int insert(CursosAsignados cursoasignado){
      Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cursoasignado.getPrimerCurso());
            stmt.setString(2, cursoasignado.getSegundoCurso());
            stmt.setString(3, cursoasignado.getTercerCurso());
            stmt.setString(4, cursoasignado.getCuartoCurso()); 
            stmt.setString(5, cursoasignado.getQuintoCurso());
            System.out.println("Ejecutando query:" + SQL_INSERT);
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
}
