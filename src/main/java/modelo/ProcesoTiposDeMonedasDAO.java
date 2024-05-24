/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import controlador.ProcesoTiposDeMonedas;
import controlador.TiposDeMoneda;
import controlador.TiposDePagos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Kevin
 */
public class ProcesoTiposDeMonedasDAO {
    
    private static final String SQL_QUERY = "SELECT id_tipo_pago, nombre_tipo_pago, cantidad_tipo_pago FROM TiposDePagos WHERE nombre_tipo_pago = ?";
    private static final String SQL_INSERT = "INSERT INTO Tesoreria(codigo_boleta, nombre_tipo_pago, cantidad_tipo_pago, nombre_moneda, fecha, estado_boleta) VALUES(?, ?, ?, ?, ?, ?)";

    public int insert(ProcesoTiposDeMonedas pagosbancarios) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            Date todayDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String fechaActual = sdf.format(todayDate);
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pagosbancarios.getCodigoBoleta());
            stmt.setString(2, pagosbancarios.getNombrePago());
            stmt.setString(3, pagosbancarios.getcantidadPago());
            stmt.setString(4, pagosbancarios.getNombreMoneda());
            stmt.setString(5, fechaActual);
            stmt.setString(6, "Pagado");
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
    
    public TiposDePagos query(TiposDePagos tipoPago) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, tipoPago.getNombrePago());
            rs = stmt.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id_tipo_pago");
                String nombre = rs.getString("nombre_tipo_pago");
                String cantidad = rs.getString("cantidad_tipo_pago");
                
                tipoPago = new TiposDePagos();
                tipoPago.setIdTipoPago(id);
                tipoPago.setNombrePago(nombre);
                tipoPago.setcantidadPago(cantidad);
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
