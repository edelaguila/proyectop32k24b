/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Jhony
 */
public class Ciclos {

     private String codigo_ciclo;
    private String nombre_ciclo;
    private String estatus_ciclo;

    public Ciclos() {
    }
    
    public Ciclos(String codigo_ciclo, String nombre_ciclo, String estatus_ciclo) {
        this.codigo_ciclo = codigo_ciclo;
        this.nombre_ciclo = nombre_ciclo;
        this.estatus_ciclo = estatus_ciclo;
    }

    public Ciclos(String codigo_ciclo) {
        this.codigo_ciclo = codigo_ciclo;
    }

    public Ciclos(String codigo_ciclo, String nombre_ciclo) {
        this.codigo_ciclo = codigo_ciclo;
        this.nombre_ciclo = nombre_ciclo;
    }

    public String getCodigo_ciclo() {
        return codigo_ciclo;
    }

    public void setCodigo_ciclo(String codigo_ciclo) {
        this.codigo_ciclo = codigo_ciclo;
    }

    public String getNombre_ciclo() {
        return nombre_ciclo;
    }

    public void setNombre_ciclo(String nombre_ciclo) {
        this.nombre_ciclo = nombre_ciclo;
    }

    public String getEstatus_ciclo() {
        return estatus_ciclo;
    }

    public void setEstatus_ciclo(String estatus_ciclo) {
        this.estatus_ciclo = estatus_ciclo;
    }

    @Override
    public String toString() {
        return "Ciclos{" + "codigo_ciclo=" + codigo_ciclo + ", nombre_ciclo=" + nombre_ciclo + ", estatus_ciclo=" + estatus_ciclo + '}';
    }
   
    
}
