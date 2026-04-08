/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author felip
 */
import java.util.Scanner;
import Modelo.Estudiante;

public class VistaCurso {

    private Scanner sc;

    public VistaCurso() {
        sc = new Scanner(System.in);
    }

    public int pedirCantidad() {
        int cantidad;
        do {
            System.out.print("Número de estudiantes: ");
            while (!sc.hasNextInt()) {
                System.out.println("Debe ingresar un número válido.");
                sc.next();
            }
            cantidad = sc.nextInt();
        } while (cantidad <= 0);
        return cantidad;
    }

    public Estudiante pedirEstudiante() {
        int codigo;
        do {
            System.out.print("Código (>21000): ");
            while (!sc.hasNextInt()) {
                System.out.println("Debe ingresar un número válido.");
                sc.next();
            }
            codigo = sc.nextInt();
        } while (codigo <= 21000);

        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        double desarrollo;
        do {
            System.out.print("Nota Desarrollo (0-5): ");
            while (!sc.hasNextDouble()) {
                System.out.println("Debe ingresar un número válido.");
                sc.next();
            }
            desarrollo = sc.nextDouble();
        } while (desarrollo < 0 || desarrollo > 5);

        double matematica;
        do {
            System.out.print("Nota Matemática (0-5): ");
            while (!sc.hasNextDouble()) {
                System.out.println("Debe ingresar un número válido.");
                sc.next();
            }
            matematica = sc.nextDouble();
        } while (matematica < 0 || matematica > 5);

        return new Estudiante(codigo, nombre, desarrollo, matematica);
    }

    public double pedirLimite() {
        double limite;
        do {
            System.out.print("Nota límite (0-5): ");
            while (!sc.hasNextDouble()) {
                System.out.println("Debe ingresar un número válido.");
                sc.next();
            }
            limite = sc.nextDouble();
        } while (limite < 0 || limite > 5);
        return limite;
    }

    public double pedirIncremento() {
        double incremento;
        do {
            System.out.print("Incremento (0-0.5): ");
            while (!sc.hasNextDouble()) {
                System.out.println("Debe ingresar un número válido.");
                sc.next();
            }
            incremento = sc.nextDouble();
        } while (incremento < 0 || incremento > 0.5);
        return incremento;
    }

    public int pedirCodigo() {
        System.out.print("Código a modificar: ");
        while (!sc.hasNextInt()) {
            System.out.println("Debe ingresar un número válido.");
            sc.next();
        }
        return sc.nextInt();
    }

    public double pedirNuevaNota(String tipo) {
        double nota;
        do {
            System.out.print("Nueva nota de " + tipo + " (0-5): ");
            while (!sc.hasNextDouble()) {
                System.out.println("Debe ingresar un número válido.");
                sc.next();
            }
            nota = sc.nextDouble();
        } while (nota < 0 || nota > 5);
        return nota;
    }

    public void mostrarEstudiante(Estudiante e) {
        System.out.printf("%d - %s - %.2f - %.2f - %.2f - %s%n",
                e.getCodigo(), e.getNombre(),
                e.getNotaDesarrollo(), e.getNotaMatematica(),
                e.calcularDefinitiva(), e.estadoAprobacion());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
}