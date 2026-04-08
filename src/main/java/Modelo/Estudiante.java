/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author felip
 */
public class Estudiante extends Persona {

    private int    codigo;
    private double notaDesarrollo;
    private double notaMatematica;

    public Estudiante(int codigo, String nombre,
                      double notaDesarrollo, double notaMatematica) {
        super(nombre);   // llama al constructor de Persona
        this.codigo         = codigo;
        this.notaDesarrollo = notaDesarrollo;
        this.notaMatematica = notaMatematica;
    }

    // ─── Lógica de negocio ───────────────────────────────────────────────

    /** Fórmula: Desarrollo 55% + Matemática 45% */
    public double calcularDefinitiva() {
        return (notaDesarrollo * 0.55) + (notaMatematica * 0.45);
    }

    public String estadoAprobacion() {
        return calcularDefinitiva() >= 3.5 ? "SI APRUEBA" : "NO APRUEBA";
    }

    /** Incrementa la nota de desarrollo sin superar 5.0 */
    public void incrementarDesarrollo(double incremento) {
        if (notaDesarrollo + incremento <= 5.0) {
            notaDesarrollo += incremento;
        } else {
            notaDesarrollo = 5.0;
        }
    }

    // ─── SOBRECARGA: modificarNota ───────────────────────────────────────

    /** SOBRECARGA 1: modifica solo la nota de Desarrollo */
    public void modificarNota(double nuevaDesarrollo) {
        this.notaDesarrollo = nuevaDesarrollo;
    }

    /** SOBRECARGA 2: modifica ambas notas */
    public void modificarNota(double nuevaDesarrollo, double nuevaMatematica) {
        this.notaDesarrollo = nuevaDesarrollo;
        this.notaMatematica = nuevaMatematica;
    }

    // ─── POLIMORFISMO: sobreescribe getInfo() de Persona ─────────────────

    @Override
    public String getInfo() {
        return String.format(
            "[Estudiante] %d - %s | Des: %.2f | Mat: %.2f | Def: %.2f | %s",
            codigo, nombre, notaDesarrollo, notaMatematica,
            calcularDefinitiva(), estadoAprobacion()
        );
    }

    // ─── Getters ─────────────────────────────────────────────────────────

    public int    getCodigo()           { return codigo; }
    public double getNotaDesarrollo()   { return notaDesarrollo; }
    public double getNotaMatematica()   { return notaMatematica; }
}
