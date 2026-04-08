/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author felip
 */
public class EstudianteTecnologia extends Estudiante {

    private int    semestre;
    private String programa;

    public EstudianteTecnologia(int codigo, String nombre,
                                double notaDesarrollo, double notaMatematica,
                                int semestre, String programa) {
        super(codigo, nombre, notaDesarrollo, notaMatematica); // llama a Estudiante
        this.semestre = semestre;
        this.programa = programa;
    }

    public int    getSemestre() { return semestre; }
    public String getPrograma() { return programa; }

    /**
     * POLIMORFISMO: sobreescribe getInfo() con información adicional
     * (semestre y programa) propia de esta subclase.
     *
     * CORRECCIÓN: se corrige el typo "[TecnologíA]" → "[Tecnología]"
     */
    @Override
    public String getInfo() {
        return String.format(
            "[Tecnología] %d - %s | Sem: %d | %s | Des: %.2f | Mat: %.2f | Def: %.2f | %s",
            getCodigo(), nombre, semestre, programa,
            getNotaDesarrollo(), getNotaMatematica(),
            calcularDefinitiva(), estadoAprobacion()
        );
    }
}
