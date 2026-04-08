/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author felip
 */
public class EstudianteTest {

    @Test
    public void testCalcularDefinitiva() {

        Estudiante e = new Estudiante(22001, "Luis", 4.0, 3.0);

        double definitiva = e.calcularDefinitiva();

        // Verifica que el cálculo con 55% y 45% sea correcto
        assertEquals(3.55, definitiva, 0.01);
    }

    @Test
    public void testEstadoAprobacion_SiAprueba() {

        Estudiante e = new Estudiante(22001, "Ana", 4.0, 4.0);

        // Verifica caso donde la definitiva es >= 3.5
        assertEquals("SI APRUEBA", e.estadoAprobacion());
    }

    @Test
    public void testEstadoAprobacion_NoAprueba() {

        Estudiante e = new Estudiante(22001, "Ana", 2.0, 2.0);

        // Verifica caso donde la definitiva es < 3.5
        assertEquals("NO APRUEBA", e.estadoAprobacion());
    }

    @Test
    public void testIncrementarDesarrollo_Normal() {

        Estudiante e = new Estudiante(22001, "Pedro", 4.0, 3.0);

        e.incrementarDesarrollo(0.3);

        // Verifica incremento normal sin superar 5.0
        assertEquals(4.3, e.getNotaDesarrollo(), 0.01);
    }

    @Test
    public void testIncrementarDesarrollo_NoSupera5() {

        Estudiante e = new Estudiante(22001, "Pedro", 4.9, 3.0);

        e.incrementarDesarrollo(0.5);

        // Verifica que no sobrepase el límite máximo
        assertEquals(5.0, e.getNotaDesarrollo(), 0.01);
    }

    @Test
    public void testModificarNota() {

        Estudiante e = new Estudiante(22001, "Carlos", 3.0, 3.0);

        e.modificarNota(4.5, 4.0);

        // Verifica que ambas notas cambien correctamente
        assertEquals(4.5, e.getNotaDesarrollo(), 0.01);
        assertEquals(4.0, e.getNotaMatematica(), 0.01);
    }

    @Test
    public void testGetters() {

        Estudiante e = new Estudiante(22001, "Maria", 4.0, 3.5);

        // Verifica acceso correcto a los atributos
        assertEquals(22001, e.getCodigo());
        assertEquals("Maria", e.getNombre());
        assertEquals(4.0, e.getNotaDesarrollo(), 0.01);
        assertEquals(3.5, e.getNotaMatematica(), 0.01);
    }
}

