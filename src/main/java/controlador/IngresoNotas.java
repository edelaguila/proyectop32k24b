/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author kenph
 */
public class IngresoNotas {
    private String cod_acta;
    private String not_semestre;
    private String not_año;
    private String carnet_alumno;
    private int not_parcial1;
    private int not_parcial2;
    private int not_examenfinal;
    private int not_zonatareas;
    private int not_totalpuntos;
    
    //Constructores
    public IngresoNotas(String cod_acta, String not_semestre, String not_año, String carnet_alumno, int not_parcial1, int not_parcial2, int not_examenfinal, int not_zonatareas, int not_totalpuntos){
    this.cod_acta = cod_acta;
    this.not_semestre = not_semestre;
    this.not_año = not_año;
    this.carnet_alumno = carnet_alumno;
    this.not_parcial1 = not_parcial1;
    this.not_parcial2 = not_parcial2;
    this.not_examenfinal = not_examenfinal;
    this.not_zonatareas = not_zonatareas;
    this.not_totalpuntos = not_totalpuntos;
    }
    
    public IngresoNotas(String cod_acta, String not_semestre, String not_año, String carnet_alumno, int not_parcial1, int not_parcial2, int not_examenfinal, int not_zonatareas){
    this.cod_acta = cod_acta;
    this.not_semestre = not_semestre;
    this.not_año = not_año;
    this.carnet_alumno = carnet_alumno;
    this.not_parcial1 = not_parcial1;
    this.not_parcial2 = not_parcial2;
    this.not_examenfinal = not_examenfinal;
    this.not_zonatareas = not_zonatareas;
    }
    
    public IngresoNotas(String cod_acta, String not_semestre, String not_año, String carnet_alumno, int not_parcial1, int not_parcial2, int not_examenfinal){
    this.cod_acta = cod_acta;
    this.not_semestre = not_semestre;
    this.not_año = not_año;
    this.carnet_alumno = carnet_alumno;
    this.not_parcial1 = not_parcial1;
    this.not_parcial2 = not_parcial2;
    this.not_examenfinal = not_examenfinal;
    }
    
    public IngresoNotas(String cod_acta, String not_semestre, String not_año, String carnet_alumno, int not_parcial1, int not_parcial2){
    this.cod_acta = cod_acta;
    this.not_semestre = not_semestre;
    this.not_año = not_año;
    this.carnet_alumno = carnet_alumno;
    this.not_parcial1 = not_parcial1;
    this.not_parcial2 = not_parcial2;
    }
    
    public IngresoNotas(String cod_acta, String not_semestre, String not_año, String carnet_alumno, int not_parcial1){
    this.cod_acta = cod_acta;
    this.not_semestre = not_semestre;
    this.not_año = not_año;
    this.carnet_alumno = carnet_alumno;
    this.not_parcial1 = not_parcial1;
    }
    
    public IngresoNotas(String cod_acta, String not_semestre, String not_año, String carnet_alumno){
    this.cod_acta = cod_acta;
    this.not_semestre = not_semestre;
    this.not_año = not_año;
    this.carnet_alumno = carnet_alumno;
    }
    
        public IngresoNotas(String cod_acta, String not_semestre, String not_año){
    this.cod_acta = cod_acta;
    this.not_semestre = not_semestre;
    this.not_año = not_año;
    }
        
    public IngresoNotas(String cod_acta, String not_semestre){
    this.cod_acta = cod_acta;
    this.not_semestre = not_semestre;
    }
    
    public IngresoNotas(String cod_acta){
    this.cod_acta = cod_acta;
    }
    
    public IngresoNotas(){
    }

    public String getCod_acta() {
        return cod_acta;
    }

    public String getNot_semestre() {
        return not_semestre;
    }

    public String getNot_año() {
        return not_año;
    }

    public String getCarnet_alumno() {
        return carnet_alumno;
    }

    public int getNot_parcial1() {
        return not_parcial1;
    }

    public int getNot_parcial2() {
        return not_parcial2;
    }

    public int getNot_examenfinal() {
        return not_examenfinal;
    }

    public int getNot_zonatareas() {
        return not_zonatareas;
    }

    public int getNot_totalpuntos() {
        return not_totalpuntos;
    }

    public void setCod_acta(String cod_acta) {
        this.cod_acta = cod_acta;
    }

    public void setNot_semestre(String not_semestre) {
        this.not_semestre = not_semestre;
    }

    public void setNot_año(String not_año) {
        this.not_año = not_año;
    }

    public void setCarnet_alumno(String carnet_alumno) {
        this.carnet_alumno = carnet_alumno;
    }

    public void setNot_parcial1(int not_parcial1) {
        this.not_parcial1 = not_parcial1;
    }

    public void setNot_parcial2(int not_parcial2) {
        this.not_parcial2 = not_parcial2;
    }

    public void setNot_examenfinal(int not_examenfinal) {
        this.not_examenfinal = not_examenfinal;
    }

    public void setNot_zonatareas(int not_zonatareas) {
        this.not_zonatareas = not_zonatareas;
    }

    public void setNot_totalpuntos(int not_totalpuntos) {
        this.not_totalpuntos = not_totalpuntos;
    }
 
    public int calculoNotaFinal(int not_parcial1, int not_parcial2, int not_examenfinal, int not_zonatareas){
        int nota1 = not_parcial1;
        int nota2 = not_parcial2;
        int nota3 = not_examenfinal;
        int nota4 = not_zonatareas;
        
        int notaFinal = nota1 + nota2 + nota3 + nota4;
        
        return notaFinal;
    }
    
}
