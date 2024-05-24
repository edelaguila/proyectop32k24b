/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Joseg
 */
public class CursosAsignados {
    private String primer_curso;
    private String segundo_curso;
    private String tercer_curso;
    private String cuarto_curso;
    private String quinto_curso;
    
    public CursosAsignados(String primer_curso,String segundo_curso, String tercer_curso, String cuarto_curso, String quinto_curso){
        this.primer_curso = primer_curso;
        this.segundo_curso = segundo_curso;
        this.tercer_curso = tercer_curso;
        this.cuarto_curso = cuarto_curso;
        this.quinto_curso = quinto_curso;
    }
    
    public String getPrimerCurso() {
        return primer_curso;
    }
    
    public void setPrimerCurso(String primer_curso) {
        this.primer_curso = primer_curso;
    }
    
    public String getSegundoCurso(){
        return segundo_curso;
    }
    
    public void setSegundoCurso(String segundo_curso){
        this.segundo_curso = segundo_curso;
    }
    
    public String getTercerCurso(){
        return tercer_curso;
    }
    
    public void setTercerCurso(String tercer_curso){
        this.tercer_curso = tercer_curso;
    }
    
    public String getCuartoCurso() {
        return cuarto_curso;
    }
    
    public void setCuartoCurso(String cuarto_curso) {
        this.cuarto_curso = cuarto_curso;
    }
    
    public String getQuintoCurso(){
        return quinto_curso;
    }
    
    public void setQuintoCurso(String quinto_curso){
       this.quinto_curso = quinto_curso;
    }
}
