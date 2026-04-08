/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author felip
 */
import Modelo.Curso;
import Modelo.Estudiante;
import Vista.VistaCurso;

public class ControladorCurso {

    private Curso     curso;
    private VistaCurso vista;

    public ControladorCurso(Curso curso, VistaCurso vista) {
        this.curso = curso;
        this.vista = vista;
    }

    public void iniciar() {

        // Registro de todos los estudiantes
        for (int i = 0; i < curso.getEstudiantes().length; i++) {
            curso.agregarEstudiante(vista.pedirEstudiante());
        }

        // Ordenamiento ascendente por definitiva
        curso.ordenarAscendente();

        vista.mostrarMensaje("\n--- LISTA ORDENADA ---");
        for (int i = 0; i < curso.getContador(); i++) {
            vista.mostrarEstudiante(curso.getEstudiantes()[i]);
        }

        // Filtro por límite
        double limite = vista.pedirLimite();
        vista.mostrarMensaje("\n--- SUPERIORES AL LÍMITE ---");
        for (int i = 0; i < curso.getContador(); i++) {
            Estudiante e = curso.getEstudiantes()[i];
            if (e.calcularDefinitiva() > limite) {
                vista.mostrarEstudiante(e);
            }
        }

        // Incremento a todos
        double incremento = vista.pedirIncremento();
        for (int i = 0; i < curso.getContador(); i++) {
            curso.getEstudiantes()[i].incrementarDesarrollo(incremento);
        }

        // Búsqueda y modificación
        int codigo = vista.pedirCodigo();
        Estudiante encontrado = curso.buscarPorCodigo(codigo);

        if (encontrado != null) {
            double nuevaDes = vista.pedirNuevaNota("Desarrollo");
            double nuevaMat = vista.pedirNuevaNota("Matemática");
            encontrado.modificarNota(nuevaDes, nuevaMat); // SOBRECARGA 2 parámetros
            vista.mostrarMensaje("Notas modificadas correctamente.");
        } else {
            vista.mostrarMensaje("No existe un estudiante con ese código.");
        }
    }
}