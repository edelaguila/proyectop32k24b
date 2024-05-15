/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Leticia
 */
public class Seccion {
    
    private String codigo_seccion;
    private String nombre_seccion;
    private String estatus_seccion;

    public Seccion() {
    }

    @Override
    public String toString() {
        return "Seccion{" + "codigo_seccion=" + codigo_seccion + ", nombre_seccion=" + nombre_seccion + ", estatus_seccion=" + estatus_seccion + '}';
    }

    public String getCodigo_seccion() {
        return codigo_seccion;
    }

    public void setCodigo_seccion(String codigo_seccion) {
        this.codigo_seccion = codigo_seccion;
    }

    public String getNombre_seccion() {
        return nombre_seccion;
    }

    public void setNombre_seccion(String nombre_seccion) {
        this.nombre_seccion = nombre_seccion;
    }

    public String getEstatus_seccion() {
        return estatus_seccion;
    }

    public void setEstatus_seccion(String estatus_seccion) {
        this.estatus_seccion = estatus_seccion;
    }

    public Seccion(String codigo_seccion, String nombre_seccion) {
        this.codigo_seccion = codigo_seccion;
        this.nombre_seccion = nombre_seccion;
    }

    public Seccion(String codigo_seccion) {
        this.codigo_seccion = codigo_seccion;
    }

    public Seccion(String codigo_seccion, String nombre_seccion, String estatus_seccion) {
        this.codigo_seccion = codigo_seccion;
        this.nombre_seccion = nombre_seccion;
        this.estatus_seccion = estatus_seccion;
    }    
}
