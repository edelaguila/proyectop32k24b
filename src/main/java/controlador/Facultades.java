package controlador;

/**
 * Clase creada por WILBER ORDOÑEZ
 * Fecha y hora de creacion: 07/05/2024 01:36 AM
 * Clase encargada de FACULTADES
 */
public class Facultades {
    private String codigo_facultad;
    private String nombre_facultad;
    private String ubicacion_facultad;
    private String telefono_facultad;
    private String decano_facultad;
    private String estatus_facultad;
    
    public Facultades() {
    }
    
    @Override
    public String toString() {
        return "Facultades{" + "codigo_facultad=" + codigo_facultad + ", nombre_facultad=" + nombre_facultad + ", ubicacion_facultad=" + ubicacion_facultad + ", telefono_facultad=" + telefono_facultad + ", decano_facultad=" + decano_facultad + ", estatus_facultad=" + estatus_facultad + '}';
    }
    
    public String getCodigo_facultad() {
        return codigo_facultad;
    }

    public void setCodigo_facultad(String codigo_facultad) {
        this.codigo_facultad = codigo_facultad;
    }

    public String getNombre_facultad() {
        return nombre_facultad;
    }

    public void setNombre_facultad(String nombre_facultad) {
        this.nombre_facultad = nombre_facultad;
    }

    public String getUbicacion_facultad() {
        return ubicacion_facultad;
    }

    public void setUbicacion_facultad(String ubicacion_facultad) {
        this.ubicacion_facultad = ubicacion_facultad;
    }

    public String getTelefono_facultad() {
        return telefono_facultad;
    }

    public void setTelefono_facultad(String telefono_facultad) {
        this.telefono_facultad = telefono_facultad;
    }

    public String getDecano_facultad() {
        return decano_facultad;
    }

    public void setDecano_facultad(String decano_facultad) {
        this.decano_facultad = decano_facultad;
    }

    public String getEstatus_facultad() {
        return estatus_facultad;
    }

    public void setEstatus_facultad(String estatus_facultad) {
        this.estatus_facultad = estatus_facultad;
    }
    
    public Facultades(String codigo_facultad){
        this.codigo_facultad = codigo_facultad;
    }
    
    public Facultades(String codigo_facultad, String nombre_facultad){
        this.codigo_facultad = codigo_facultad;
        this.nombre_facultad = nombre_facultad;
    }
    
    public Facultades(String codigo_facultad, String nombre_facultad, String ubicacion_facultad){
        this.codigo_facultad = codigo_facultad;
        this.nombre_facultad = nombre_facultad;
        this.ubicacion_facultad = ubicacion_facultad;
    }
    
    public Facultades(String codigo_facultad, String nombre_facultad, String ubicacion_facultad, String telefono_facultad){
        this.codigo_facultad = codigo_facultad;
        this.nombre_facultad = nombre_facultad;
        this.ubicacion_facultad = ubicacion_facultad;
        this.telefono_facultad = telefono_facultad;
    }
    
    public Facultades(String codigo_facultad, String nombre_facultad, String ubicacion_facultad, String telefono_facultad, String decano_facultad){
        this.codigo_facultad = codigo_facultad;
        this.nombre_facultad = nombre_facultad;
        this.ubicacion_facultad = ubicacion_facultad;
        this.telefono_facultad = telefono_facultad;
        this.decano_facultad = decano_facultad;
    }
    
    public Facultades(String codigo_facultad, String nombre_facultad, String ubicacion_facultad, String telefono_facultad, String decano_facultad, String estatus_facultad){
        this.codigo_facultad = codigo_facultad;
        this.nombre_facultad = nombre_facultad;
        this.ubicacion_facultad = ubicacion_facultad;
        this.telefono_facultad = telefono_facultad;
        this.decano_facultad = decano_facultad;
        this.estatus_facultad = estatus_facultad;
    }
}
