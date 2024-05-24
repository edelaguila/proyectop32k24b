/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Kevin
 */
public class ProcesoTiposDeMonedas {
    private String codigoBoleta;
    private String nombre_tipo_pago; 
    private String cantidad_tipo_pago;
    private String nombre_moneda;
    
    public ProcesoTiposDeMonedas() {
        
    }
    
    public ProcesoTiposDeMonedas(String codigoBoleta, String nombre_tipo_pago, String cantidad_tipo_pago, String nombre_moneda) {
        this.codigoBoleta = codigoBoleta;
        this.nombre_tipo_pago = nombre_tipo_pago;
        this.cantidad_tipo_pago = cantidad_tipo_pago;
        this.nombre_moneda = nombre_moneda;
    }
    
    public String getCodigoBoleta() {
        return codigoBoleta;
    }

    public void setCodigoBoleta(String codigoBoleta) {
        this.codigoBoleta = codigoBoleta;
    }
    
    public String getNombrePago() {
        return nombre_tipo_pago;
    }

    public void setNombrePago(String nombre_tipo_pago) {
        this.nombre_tipo_pago = nombre_tipo_pago;
    }
    
    public String getcantidadPago() {
        return cantidad_tipo_pago;
    }
    
    public void setcantidadPago(String cantidad_tipo_pago){
        this.cantidad_tipo_pago = cantidad_tipo_pago;
    }
    
    public String getNombreMoneda() {
        return nombre_moneda;
    }

    public void setNombreMoneda(String nombre_moneda) {
        this.nombre_moneda = nombre_moneda;
    }
}
