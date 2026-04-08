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

public class CursoTest {

    @Test
    public void testAgregarEstudianteYContador() {

        Curso curso = new Curso(2);

        Estudiante e1 = new Estudiante(22001, "A", 4, 3);
        curso.agregarEstudiante(e1);

        // Verifica que el contador aumente correctamente
        assertEquals(1, curso.getContador());
    }

    @Test
    public void testBuscarPorCodigo_Existe() {

        Curso curso = new Curso(2);

        Estudiante e1 = new Estudiante(22001, "A", 4, 3);
        curso.agregarEstudiante(e1);

        Estudiante encontrado = curso.buscarPorCodigo(22001);

        // Verifica que encuentre el estudiante
        assertNotNull(encontrado);

        // Verifica que sea el correcto
        assertEquals("A", encontrado.getNombre());
    }

    @Test
    public void testBuscarPorCodigo_NoExiste() {

        Curso curso = new Curso(2);

        Estudiante encontrado = curso.buscarPorCodigo(99999);

        // Verifica que retorne null si no existe
        assertNull(encontrado);
    }

    @Test
    public void testOrdenarAscendente() {

        Curso curso = new Curso(2);

        Estudiante e1 = new Estudiante(22001, "A", 5, 5); // 5.0
        Estudiante e2 = new Estudiante(22002, "B", 3, 3); // 3.0

        curso.agregarEstudiante(e1);
        curso.agregarEstudiante(e2);

        curso.ordenarAscendente();

        Estudiante[] lista = curso.getEstudiantes();

        // Verifica que esté ordenado de menor a mayor definitiva
        assertTrue(lista[0].calcularDefinitiva() <= lista[1].calcularDefinitiva());
    }

    @Test
    public void testGetEstudiantes() {

        Curso curso = new Curso(1);

        // Verifica que el arreglo no sea null
        assertNotNull(curso.getEstudiantes());
    }
}