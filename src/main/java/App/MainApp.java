/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package App;

/**
 *
 * @author felip
 */
import Modelo.Curso;
import Vista.VistaCurso;
import Vista.VistaGUI;
import Controlador.ControladorCurso;
import Controlador.ControladorCursoGUI;
import javax.swing.JOptionPane;

public class MainApp {

    public static void main(String[] args) {

        String[] opciones = {"Consola (texto)", "Interfaz Gráfica (Swing)"};
        int eleccion = JOptionPane.showOptionDialog(null,
                "¿Cómo deseas ejecutar el sistema?",
                "Modo de ejecución",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opciones, opciones[1]);

        if (eleccion == 0) {
            // Modo consola
            VistaCurso vista      = new VistaCurso();
            int cantidad          = vista.pedirCantidad();
            Curso curso           = new Curso(cantidad);
            ControladorCurso ctrl = new ControladorCurso(curso, vista);
            ctrl.iniciar();

        } else {
            // Modo GUI
            VistaGUI vista           = new VistaGUI();
            int cantidad             = vista.pedirCantidad();
            Curso curso              = new Curso(cantidad);
            ControladorCursoGUI ctrl = new ControladorCursoGUI(curso, vista);
            ctrl.iniciar();
        }
    }
}
