/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author kenph
 */
public class ActaEvaluacion {
    private String codigo_carrera;
    private String codigo_curso;
    private String codigo_seccion;
    private String codigo_maestro;
    
    public ActaEvaluacion() {
}
        public ActaEvaluacion(String codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }  
        
        public ActaEvaluacion(String codigo_carrera, String codigo_curso) {
        this.codigo_carrera = codigo_carrera;
        this.codigo_curso = codigo_curso;
    }  
        
        public ActaEvaluacion(String codigo_carrera, String codigo_curso, String codigo_seccion) {
        this.codigo_carrera = codigo_carrera;
        this.codigo_curso = codigo_curso;
        this.codigo_seccion = codigo_seccion;
    }  
        
    public ActaEvaluacion(String codigo_carrera, String codigo_curso, String codigo_seccion, String codigo_maestro) {
        this.codigo_carrera = codigo_carrera;
        this.codigo_curso = codigo_curso;
        this.codigo_seccion = codigo_seccion;
        this.codigo_maestro = codigo_maestro;
    }  

    @Override
    public String toString() {
        return "ActaEvaluacion{" + "codigo_carrera=" + codigo_carrera + ", codigo_curso=" + codigo_curso + ", codigo_seccion=" + codigo_seccion + ", codigo_maestro=" + codigo_maestro + '}';
    }

    public String getCodigo_carrera() {
        return codigo_carrera;
    }

    public String getCodigo_curso() {
        return codigo_curso;
    }

    public String getCodigo_seccion() {
        return codigo_seccion;
    }

    public String getCodigo_maestro() {
        return codigo_maestro;
    }

    public void setCodigo_carrera(String codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    public void setCodigo_curso(String codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public void setCodigo_seccion(String codigo_seccion) {
        this.codigo_seccion = codigo_seccion;
    }

    public void setCodigo_maestro(String codigo_maestro) {
        this.codigo_maestro = codigo_maestro;
    }
    
}
