/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listainfantes.modelo;

import java.io.Serializable;

/**
 *
 * @author
 */
public class Infante implements Serializable {

    private String nombre;
    private boolean genero;
    private byte id;

    public Infante() {
    }

    public Infante(String nombre, boolean genero, byte id) {
        this.nombre = nombre;
        this.genero = genero;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

}
