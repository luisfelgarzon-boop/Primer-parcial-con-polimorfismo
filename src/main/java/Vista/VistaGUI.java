/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import Modelo.Estudiante;
import Modelo.EstudianteTecnologia;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author felip
 */
public class VistaGUI {

    // ─── Pide la cantidad de estudiantes ─────────────────────────────────

    public int pedirCantidad() {
        while (true) {
            String input = JOptionPane.showInputDialog(null,
                    "¿Cuántos estudiantes hay en el curso?\n(Debe ser un número mayor a 0)",
                    "Número de estudiantes", JOptionPane.QUESTION_MESSAGE);

            // Si el usuario cierra la ventana o cancela, salimos
            if (input == null) {
                JOptionPane.showMessageDialog(null,
                        "Operación cancelada. Se cerrará el programa.",
                        "Cancelado", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }

            try {
                int n = Integer.parseInt(input.trim());
                if (n > 0) return n;
                // Si llegó aquí, el número no es mayor a 0
                JOptionPane.showMessageDialog(null,
                        "ERROR: La cantidad debe ser mayor a 0.\n" +
                        "Valor ingresado: " + n,
                        "Dato inválido", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "ERROR: \"" + input.trim() + "\" no es un número entero válido.\n" +
                        "Por favor ingrese solo dígitos (ej: 3, 5, 10).",
                        "Dato inválido", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // ─── Pide datos de un estudiante con formulario visual ───────────────

    public Estudiante pedirEstudiante() {
        while (true) {
            JTextField txtCodigo     = new JTextField();
            JTextField txtNombre     = new JTextField();
            JTextField txtDesarrollo = new JTextField();
            JTextField txtMatematica = new JTextField();
            JTextField txtSemestre   = new JTextField();
            JTextField txtPrograma   = new JTextField();

            Object[] fields = {
                "Código (número entero mayor a 21000):", txtCodigo,
                "Nombre completo:",                      txtNombre,
                "Nota Desarrollo (0.0 a 5.0):",          txtDesarrollo,
                "Nota Matemática (0.0 a 5.0):",          txtMatematica,
                "─── Opcional: EstudianteTecnología ───────────", new JLabel(""),
                "Semestre (dejar vacío si no aplica):",  txtSemestre,
                "Programa (dejar vacío si no aplica):",  txtPrograma
            };

            int opt = JOptionPane.showConfirmDialog(null, fields,
                    "Registrar Estudiante", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE);

            if (opt != JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(null,
                        "Registro cancelado por el usuario.",
                        "Cancelado", JOptionPane.WARNING_MESSAGE);
                return null;
            }

            // ── Validar código ───────────────────────────────────────────
            int codigo;
            try {
                codigo = Integer.parseInt(txtCodigo.getText().trim());
                if (codigo <= 21000) {
                    JOptionPane.showMessageDialog(null,
                            "ERROR en Código: debe ser mayor a 21000.\n" +
                            "Valor ingresado: " + codigo + "\nIntente de nuevo.",
                            "Código inválido", JOptionPane.ERROR_MESSAGE);
                    continue; // vuelve a pedir el formulario
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "ERROR en Código: \"" + txtCodigo.getText().trim() +
                        "\" no es un número entero.\nIntente de nuevo.",
                        "Código inválido", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // ── Validar nombre ───────────────────────────────────────────
            String nombre = txtNombre.getText().trim();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "ERROR: El nombre no puede estar vacío.\nIntente de nuevo.",
                        "Nombre inválido", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // ── Validar nota Desarrollo ──────────────────────────────────
            double desarrollo;
            try {
                desarrollo = Double.parseDouble(txtDesarrollo.getText().trim());
                if (desarrollo < 0.0 || desarrollo > 5.0) {
                    JOptionPane.showMessageDialog(null,
                            "ERROR en Nota Desarrollo: debe estar entre 0.0 y 5.0.\n" +
                            "Valor ingresado: " + desarrollo + "\nIntente de nuevo.",
                            "Nota inválida", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "ERROR en Nota Desarrollo: \"" + txtDesarrollo.getText().trim() +
                        "\" no es un número válido.\nUse punto decimal (ej: 3.8)\nIntente de nuevo.",
                        "Nota inválida", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // ── Validar nota Matemática ──────────────────────────────────
            double matematica;
            try {
                matematica = Double.parseDouble(txtMatematica.getText().trim());
                if (matematica < 0.0 || matematica > 5.0) {
                    JOptionPane.showMessageDialog(null,
                            "ERROR en Nota Matemática: debe estar entre 0.0 y 5.0.\n" +
                            "Valor ingresado: " + matematica + "\nIntente de nuevo.",
                            "Nota inválida", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "ERROR en Nota Matemática: \"" + txtMatematica.getText().trim() +
                        "\" no es un número válido.\nUse punto decimal (ej: 4.0)\nIntente de nuevo.",
                        "Nota inválida", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // ── Campos opcionales: EstudianteTecnologia ──────────────────
            String semStr = txtSemestre.getText().trim();
            String prog   = txtPrograma.getText().trim();

            // Solo se crea EstudianteTecnologia si AMBOS campos están llenos
            if (!semStr.isEmpty() && !prog.isEmpty()) {
                int sem;
                try {
                    sem = Integer.parseInt(semStr);
                    if (sem <= 0) {
                        JOptionPane.showMessageDialog(null,
                                "ERROR en Semestre: debe ser un número mayor a 0.\n" +
                                "Valor ingresado: " + sem + "\nIntente de nuevo.",
                                "Semestre inválido", JOptionPane.ERROR_MESSAGE);
                        continue;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "ERROR en Semestre: \"" + semStr +
                            "\" no es un número entero.\nIntente de nuevo.",
                            "Semestre inválido", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                // Crea EstudianteTecnologia (herencia de segundo nivel)
                return new EstudianteTecnologia(codigo, nombre, desarrollo, matematica, sem, prog);
            }

            // Solo llenó uno de los dos campos opcionales → advertencia
            if (!semStr.isEmpty() || !prog.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "AVISO: Para registrar un EstudianteTecnología debe llenar\n" +
                        "TANTO Semestre como Programa. Se registrará como Estudiante normal.",
                        "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            }

            // Crea Estudiante normal
            return new Estudiante(codigo, nombre, desarrollo, matematica);
        }
    }

    // ─── Muestra lista en ventana scrolleable ────────────────────────────

    public void mostrarListaEstudiantes(Estudiante[] estudiantes, int cantidad, String titulo) {
        if (cantidad == 0) {
            JOptionPane.showMessageDialog(null,
                    "No hay estudiantes para mostrar en: " + titulo,
                    titulo, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidad; i++) {
            // POLIMORFISMO: getInfo() llama al método de la subclase correcta
            sb.append(i + 1).append(". ").append(estudiantes[i].getInfo()).append("\n");
        }
        JTextArea area = new JTextArea(sb.toString());
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 12));
        area.setPreferredSize(new Dimension(650, 200));
        JOptionPane.showMessageDialog(null,
                new JScrollPane(area), titulo,
                JOptionPane.INFORMATION_MESSAGE);
    }

    // ─── pedirLimite — CON VALIDACIÓN ────────────────────────────────────

    public double pedirLimite() {
        while (true) {
            String s = JOptionPane.showInputDialog(null,
                    "Ingrese la nota límite para filtrar estudiantes.\n" +
                    "Rango válido: 0.0 a 5.0",
                    "Nota límite", JOptionPane.QUESTION_MESSAGE);

            if (s == null) {
                JOptionPane.showMessageDialog(null,
                        "Operación cancelada. Se usará límite 3.0 por defecto.",
                        "Cancelado", JOptionPane.WARNING_MESSAGE);
                return 3.0;
            }

            try {
                double valor = Double.parseDouble(s.trim());
                if (valor >= 0.0 && valor <= 5.0) return valor;
                JOptionPane.showMessageDialog(null,
                        "ERROR: El límite debe estar entre 0.0 y 5.0.\n" +
                        "Valor ingresado: " + valor + "\nIntente de nuevo.",
                        "Límite inválido", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "ERROR: \"" + s.trim() + "\" no es un número válido.\n" +
                        "Use punto decimal (ej: 3.5)\nIntente de nuevo.",
                        "Límite inválido", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // ─── pedirIncremento — CON VALIDACIÓN ────────────────────────────────

    public double pedirIncremento() {
        while (true) {
            String s = JOptionPane.showInputDialog(null,
                    "Ingrese el incremento para la nota de Desarrollo.\n" +
                    "Rango válido: 0.0 a 0.5",
                    "Incremento", JOptionPane.QUESTION_MESSAGE);

            if (s == null) {
                JOptionPane.showMessageDialog(null,
                        "Operación cancelada. Se usará incremento 0.0.",
                        "Cancelado", JOptionPane.WARNING_MESSAGE);
                return 0.0;
            }

            try {
                double valor = Double.parseDouble(s.trim());
                if (valor >= 0.0 && valor <= 0.5) return valor;
                JOptionPane.showMessageDialog(null,
                        "ERROR: El incremento debe estar entre 0.0 y 0.5.\n" +
                        "Valor ingresado: " + valor + "\n" +
                        "(No se permite incrementar más de media décima a la vez)\n" +
                        "Intente de nuevo.",
                        "Incremento inválido", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "ERROR: \"" + s.trim() + "\" no es un número válido.\n" +
                        "Use punto decimal (ej: 0.3)\nIntente de nuevo.",
                        "Incremento inválido", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // ─── pedirCodigo — CON VALIDACIÓN ────────────────────────────────────

    public int pedirCodigo() {
        while (true) {
            String s = JOptionPane.showInputDialog(null,
                    "Ingrese el código del estudiante a modificar.\n" +
                    "(Debe ser un número entero mayor a 21000)",
                    "Buscar estudiante", JOptionPane.QUESTION_MESSAGE);

            if (s == null) {
                JOptionPane.showMessageDialog(null,
                        "Búsqueda cancelada. Se retornará código -1.",
                        "Cancelado", JOptionPane.WARNING_MESSAGE);
                return -1;
            }

            try {
                int codigo = Integer.parseInt(s.trim());
                if (codigo > 21000) return codigo;
                JOptionPane.showMessageDialog(null,
                        "ERROR: El código debe ser mayor a 21000.\n" +
                        "Valor ingresado: " + codigo + "\nIntente de nuevo.",
                        "Código inválido", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "ERROR: \"" + s.trim() + "\" no es un número entero.\n" +
                        "Ingrese solo dígitos (ej: 22501)\nIntente de nuevo.",
                        "Código inválido", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // ─── pedirNuevaNota — CON VALIDACIÓN ─────────────────────────────────

    public double pedirNuevaNota(String tipo) {
        while (true) {
            String s = JOptionPane.showInputDialog(null,
                    "Ingrese la nueva nota de " + tipo + ".\n" +
                    "Rango válido: 0.0 a 5.0",
                    "Nueva nota - " + tipo, JOptionPane.QUESTION_MESSAGE);

            if (s == null) {
                JOptionPane.showMessageDialog(null,
                        "Modificación cancelada. La nota no será cambiada (se usará 0.0).",
                        "Cancelado", JOptionPane.WARNING_MESSAGE);
                return 0.0;
            }

            try {
                double nota = Double.parseDouble(s.trim());
                if (nota >= 0.0 && nota <= 5.0) return nota;
                JOptionPane.showMessageDialog(null,
                        "ERROR: La nota de " + tipo + " debe estar entre 0.0 y 5.0.\n" +
                        "Valor ingresado: " + nota + "\nIntente de nuevo.",
                        "Nota inválida", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "ERROR: \"" + s.trim() + "\" no es un número válido.\n" +
                        "Use punto decimal (ej: 4.2)\nIntente de nuevo.",
                        "Nota inválida", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // ─── mostrarMensaje ───────────────────────────────────────────────────

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje,
                "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}
