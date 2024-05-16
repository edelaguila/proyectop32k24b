/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Kevin
 */
public class TesoreriaP {
    
    private String numero_tarjeta;
    private String vcc_tarjeta;
    private String mes_tarjeta;
    private String ano_tarjeta;
    
    public TesoreriaP() {
    }

    public TesoreriaP(String numero_tarjeta, String vcc_tarjeta, String mes_tarjeta, String ano_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
        this.vcc_tarjeta = vcc_tarjeta;
        this.mes_tarjeta = mes_tarjeta;
        this.ano_tarjeta = ano_tarjeta;
    }

    public String getNumeroTarjeta() {
        return numero_tarjeta;
    }

    public void setNumeroTarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public String getVccTarjeta() {
        return vcc_tarjeta;
    }

    public void setVccTarjeta(String vcc_tarjeta) {
        this.vcc_tarjeta = vcc_tarjeta;
    }
    
    public String getMesTarjeta() {
        return mes_tarjeta;
    }

    public void setMesTarjeta(String mes_tarjeta) {
        this.mes_tarjeta = mes_tarjeta;
    }
    
    public String getAnoTarjeta() {
        return ano_tarjeta;
    }

    public void setAnoTarjeta(String ano_tarjeta) {
        this.ano_tarjeta = ano_tarjeta;
    }

    @Override
    public String toString() {
        return "TesoreriaP{" + "numero_tarjeta=" + numero_tarjeta + ", vcc_tarjeta=" + vcc_tarjeta + ", mes_tarjeta=" + mes_tarjeta + ", ano_tarjeta=" + ano_tarjeta +'}';
    }
}
