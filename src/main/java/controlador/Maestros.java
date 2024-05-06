/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author kenph
 */
//Creacion de la nueva Clase Maestros, creando las variables privadas tipo String
public class Maestros {
    private String codigo_maestro;
    private String nombre_maestro;
    private String direccion_maestro;
    private String telefono_maetro;
    private String email_maestro;
    private String estatus_maestro;
    
    //Constructor vacio
    public Maestros() {
    }
    
    //To string para qué no nos salga los resultados en memoria
    @Override
    public String toString() {
        return "Maestros{" + "codigo_maestro=" + codigo_maestro + ", nombre_maestro=" + nombre_maestro + ", direccion_maestro=" + direccion_maestro + ", telefono_maestro=" + telefono_maetro + ", email_maestro=" + email_maestro + ", estatus_maestro=" + estatus_maestro + '}';
    }
    
    // Getter y Setter de cada uno de las variables
    public String getCodigo_maestro(){
        return codigo_maestro;
    }

    public void setCodigo_maestro(String codigo_maestro) {
        this.codigo_maestro = codigo_maestro;
    }

    public String getDireccion_maestro() {
        return direccion_maestro;
    }

    public void setDireccion_maestro(String direccion_maestro) {
        this.direccion_maestro = direccion_maestro;
    }

    public String getEmail_maestro() {
        return email_maestro;
    }

    public void setEmail_maestro(String email_maestro) {
        this.email_maestro = email_maestro;
    }

    public String getEstatus_maestro() {
        return estatus_maestro;
    }

    public void setEstatus_maestro(String estatus_maestro) {
        this.estatus_maestro = estatus_maestro;
    }

    public String getNombre_maestro() {
        return nombre_maestro;
    }

    public void setNombre_maestro(String nombre_maestro) {
        this.nombre_maestro = nombre_maestro;
    }

    public String getTelefono_maestro() {
        return telefono_maetro;
    }

    public void setTelefono_maestro(String telefono_maetro) {
        this.telefono_maetro = telefono_maetro;
    }
    
    //Constructores con variables individuales
    public Maestros(String codigo_maestro){
        this.codigo_maestro = codigo_maestro;
    }
    
    public Maestros(String codigo_maestro, String nombre_maestro){
        this.codigo_maestro = codigo_maestro;
        this.nombre_maestro = nombre_maestro;
    }
    
    public Maestros(String codigo_maestro, String nombre_maestro, String direccion_maestro){
        this.codigo_maestro = codigo_maestro;
        this.nombre_maestro = nombre_maestro;
        this.direccion_maestro = direccion_maestro;
    }
    
    public Maestros(String codigo_maestro, String nombre_maestro, String direccion_maestro, String telefono_maetro){
        this.codigo_maestro = codigo_maestro;
        this.nombre_maestro = nombre_maestro;
        this.direccion_maestro = direccion_maestro;
        this.telefono_maetro = telefono_maetro;
    }
    
    public Maestros(String codigo_maestro, String nombre_maestro, String direccion_maestro, String telefono_maetro, String email_maestro){
        this.codigo_maestro = codigo_maestro;
        this.nombre_maestro = nombre_maestro;
        this.direccion_maestro = direccion_maestro;
        this.telefono_maetro = telefono_maetro;
        this.email_maestro = email_maestro;
    }
    
    public Maestros(String codigo_maestro, String nombre_maestro, String direccion_maestro, String telefono_maetro, String email_maestro, String estatus_maestro){
        this.codigo_maestro = codigo_maestro;
        this.nombre_maestro = nombre_maestro;
        this.direccion_maestro = direccion_maestro;
        this.telefono_maetro = telefono_maetro;
        this.email_maestro = email_maestro;
        this.estatus_maestro = estatus_maestro;
    }
    
    
}
