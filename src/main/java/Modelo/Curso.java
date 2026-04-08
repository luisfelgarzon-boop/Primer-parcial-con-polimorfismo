/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author felip
 */
public class Curso {

    // Asociación: un Curso contiene muchos Estudiantes
    private Estudiante[] estudiantes;
    private int contador;

    public Curso(int cantidad) {
        estudiantes = new Estudiante[cantidad];
        contador    = 0;
    }

    // ─── Operaciones sobre el arreglo ────────────────────────────────────

    public void agregarEstudiante(Estudiante e) {
        if (contador < estudiantes.length) {
            estudiantes[contador] = e;
            contador++;
        }
    }

    /** Ordenamiento burbuja ascendente por nota definitiva */
    public void ordenarAscendente() {
        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - 1 - i; j++) {
                if (estudiantes[j].calcularDefinitiva() >
                    estudiantes[j + 1].calcularDefinitiva()) {
                    Estudiante aux   = estudiantes[j];
                    estudiantes[j]   = estudiantes[j + 1];
                    estudiantes[j+1] = aux;
                }
            }
        }
    }

    // ─── SOBRECARGA: buscarPorCodigo ─────────────────────────────────────

    /** SOBRECARGA 1: búsqueda por código numérico */
    public Estudiante buscarPorCodigo(int codigo) {
        for (int i = 0; i < contador; i++) {
            if (estudiantes[i].getCodigo() == codigo) {
                return estudiantes[i];
            }
        }
        return null;
    }

    /** SOBRECARGA 2: búsqueda por nombre (mismo método, diferente parámetro) */
    public Estudiante buscarPorCodigo(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (estudiantes[i].getNombre().equalsIgnoreCase(nombre)) {
                return estudiantes[i];
            }
        }
        return null;
    }

    // ─── Getters ─────────────────────────────────────────────────────────

    public Estudiante[] getEstudiantes() { return estudiantes; }
    public int          getContador()    { return contador; }
}
