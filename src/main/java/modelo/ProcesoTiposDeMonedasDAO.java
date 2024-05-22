/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import controlador.TiposDePagos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kevin
 */
public class ProcesoTiposDeMonedasDAO {
    
    private static final String SQL_QUERY = "SELECT id_tipo_pago, nombre_tipo_pago, cantidad_tipo_pago FROM TiposDePagos WHERE nombre_tipo_pago = ?";
    

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
