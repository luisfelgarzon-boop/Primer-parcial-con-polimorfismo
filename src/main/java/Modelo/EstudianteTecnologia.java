/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author felip
 */
// HERENCIA: extiende Estudiante, que a su vez extiende Persona
public class EstudianteTecnologia extends Estudiante {

    private int semestre;      // atributo propio de esta subclase
    private String programa;   // ej: "Ingeniería de Sistemas"

    public EstudianteTecnologia(int codigo, String nombre,
                                 double notaDesarrollo, double notaMatematica,
                                 int semestre, String programa) {
        super(codigo, nombre, notaDesarrollo, notaMatematica); // llama a Estudiante
        this.semestre = semestre;
        this.programa = programa;
    }

    public int getSemestre()   { return semestre; }
    public String getPrograma(){ return programa; }

    // POLIMORFISMO: sobreescribe getInfo() con información adicional
    @Override
    public String getInfo() {
        return String.format("[TecnologíA] %d - %s | Sem: %d | %s | Des: %.2f | Mat: %.2f | Def: %.2f | %s",
                getCodigo(), nombre, semestre, programa,
                getNotaDesarrollo(), getNotaMatematica(),
                calcularDefinitiva(), estadoAprobacion());
    }
}
