/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.ActaEvaluacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kenph
 */
public class ActaEvaluacionDAO {
    private static final String SQL_QUERY = "SELECT codigo_carrera, codigo_curso, codigo_seccion, codigo_maestro FROM actaevaluacion WHERE codigo_maestro = ?";
    
    public ActaEvaluacion query(ActaEvaluacion acta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, acta.getCodigo_maestro());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo_carrera = rs.getString("codigo_carrera");
                String codigo_curso = rs.getString("codigo_curso");
                String codigo_seccion = rs.getString("codigo_seccion");
                String codigo_maestro = rs.getString("codigo_maestro");

                acta = new ActaEvaluacion();
                acta.setCodigo_carrera(codigo_carrera);
                acta.setCodigo_curso(codigo_curso);
                acta.setCodigo_seccion(codigo_seccion);
                acta.setCodigo_maestro(codigo_maestro);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return acta;
    }
}
