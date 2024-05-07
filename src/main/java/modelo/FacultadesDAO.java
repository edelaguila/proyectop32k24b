package modelo;

import controlador.Facultades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de interactuar con la tabla de facultades en la base de datos
 */
public class FacultadesDAO {

    private static final String SQL_SELECT = "SELECT codigo_facultad, nombre_facultad, ubicacion_facultad, telefono_facultad, decano_facultad, estatus_facultad FROM facultades";
    private static final String SQL_INSERT = "INSERT INTO facultades(codigo_facultad, nombre_facultad, ubicacion_facultad, telefono_facultad, decano_facultad, estatus_facultad) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE facultades SET nombre_facultad=?, ubicacion_facultad=?, telefono_facultad=?, decano_facultad=?, estatus_facultad=? WHERE codigo_facultad = ?";
    private static final String SQL_DELETE = "DELETE FROM facultades WHERE codigo_facultad=?";
    private static final String SQL_QUERY = "SELECT codigo_facultad, nombre_facultad, ubicacion_facultad, telefono_facultad, decano_facultad, estatus_facultad FROM facultades WHERE codigo_facultad = ?";

    public List<Facultades> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Facultades facultad = null;
        List<Facultades> facultades = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_facultad");
                String nombre = rs.getString("nombre_facultad");
                String ubicacion = rs.getString("ubicacion_facultad");
                String telefono = rs.getString("telefono_facultad");
                String decano = rs.getString("decano_facultad");
                String estatus = rs.getString("estatus_facultad");

                facultad = new Facultades();
                facultad.setCodigo_facultad(codigo);
                facultad.setNombre_facultad(nombre);
                facultad.setUbicacion_facultad(ubicacion);
                facultad.setTelefono_facultad(telefono);
                facultad.setDecano_facultad(decano);
                facultad.setEstatus_facultad(estatus);

                facultades.add(facultad);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return facultades;
    }

    public int insert(Facultades facultad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, facultad.getCodigo_facultad());
            stmt.setString(2, facultad.getNombre_facultad());
            stmt.setString(3, facultad.getUbicacion_facultad());
            stmt.setString(4, facultad.getTelefono_facultad());
            stmt.setString(5, facultad.getDecano_facultad());
            stmt.setString(6, facultad.getEstatus_facultad());
            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Facultades facultad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, facultad.getNombre_facultad());
            stmt.setString(2, facultad.getUbicacion_facultad());
            stmt.setString(3, facultad.getTelefono_facultad());
            stmt.setString(4, facultad.getDecano_facultad());
            stmt.setString(5, facultad.getEstatus_facultad());
            stmt.setString(6, facultad.getCodigo_facultad());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Facultades facultad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, facultad.getCodigo_facultad());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Facultades query(Facultades facultad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, facultad.getCodigo_facultad());
            rs = stmt.executeQuery();
            while (rs.next()) {

                String codigo = rs.getString("codigo_facultad");
                String nombre = rs.getString("nombre_facultad");
                String ubicacion = rs.getString("ubicacion_facultad");
                String telefono = rs.getString("telefono_facultad");
                String decano = rs.getString("decano_facultad");
                String estatus = rs.getString("estatus_facultad");

                facultad = new Facultades();
                facultad.setCodigo_facultad(codigo);
                facultad.setNombre_facultad(nombre);
                facultad.setUbicacion_facultad(ubicacion);
                facultad.setTelefono_facultad(telefono);
                facultad.setDecano_facultad(decano);
                facultad.setEstatus_facultad(estatus);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return facultad;
    }
}
