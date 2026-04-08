/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author felip
 */
public abstract class Persona {

    // Atributo compartido por todas las subclases (protected = accesible en subclases)
    protected String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Método abstracto: POLIMORFISMO.
     * Cada subclase DEBE implementarlo con su propia versión.
     * Permite tratar objetos distintos (Estudiante, EstudianteTecnologia)
     * de forma uniforme a través de la referencia Persona.
     */
    public abstract String getInfo();
}
