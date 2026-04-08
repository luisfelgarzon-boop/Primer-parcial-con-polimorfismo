/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Curso;
import Modelo.Estudiante;
import Vista.VistaGUI;
import javax.swing.JOptionPane;
/**
 *
 * @author felip
 */
public class ControladorCursoGUI {

    private Curso    curso;
    private VistaGUI vista;

    public ControladorCursoGUI(Curso curso, VistaGUI vista) {
        this.curso = curso;
        this.vista = vista;
    }

    public void iniciar() {

        // Registro de todos los estudiantes
        for (int i = 0; i < curso.getEstudiantes().length; i++) {
            Estudiante e = vista.pedirEstudiante();
            if (e != null) curso.agregarEstudiante(e);
        }

        // Ordenar y mostrar lista completa
        curso.ordenarAscendente();
        vista.mostrarListaEstudiantes(curso.getEstudiantes(),
                curso.getContador(), "Lista Ordenada por Definitiva");

        // Filtro por límite
        double limite = vista.pedirLimite();
        Estudiante[] superiores = new Estudiante[curso.getContador()];
        int cnt = 0;
        for (int i = 0; i < curso.getContador(); i++) {
            if (curso.getEstudiantes()[i].calcularDefinitiva() > limite)
                superiores[cnt++] = curso.getEstudiantes()[i];
        }
        vista.mostrarListaEstudiantes(superiores, cnt,
                "Superiores al límite " + limite);

        // Incremento
        double incremento = vista.pedirIncremento();
        for (int i = 0; i < curso.getContador(); i++)
            curso.getEstudiantes()[i].incrementarDesarrollo(incremento);
        vista.mostrarMensaje("Incremento de " + incremento + " aplicado correctamente.");

        // Búsqueda y modificación con SOBRECARGA visible al usuario
        int codigo = vista.pedirCodigo();
        Estudiante encontrado = curso.buscarPorCodigo(codigo);

        if (encontrado != null) {
            String[] opts = {"Solo Desarrollo (1 parámetro)", "Ambas notas (2 parámetros)"};
            int op = JOptionPane.showOptionDialog(null,
                    "¿Qué notas deseas modificar?\n" +
                    "Esto demuestra SOBRECARGA: mismo método con diferente número de parámetros.",
                    "Modificar nota - Sobrecarga",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opts, opts[1]);

            if (op == 0) {
                double nd = vista.pedirNuevaNota("Desarrollo");
                encontrado.modificarNota(nd);           // SOBRECARGA 1 parámetro
            } else {
                double nd = vista.pedirNuevaNota("Desarrollo");
                double nm = vista.pedirNuevaNota("Matemática");
                encontrado.modificarNota(nd, nm);       // SOBRECARGA 2 parámetros
            }
            vista.mostrarMensaje("Notas modificadas:\n" + encontrado.getInfo());
        } else {
            vista.mostrarMensaje("No existe estudiante con código " + codigo + ".");
        }
    }
}

