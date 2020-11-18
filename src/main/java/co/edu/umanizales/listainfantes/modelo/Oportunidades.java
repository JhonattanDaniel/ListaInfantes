/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listainfantes.modelo;

import java.io.Serializable;

/**
 *
 * @author Daniel Quintero
 */
public class Oportunidades implements Serializable{
    
    private Infante infante;
    private int oportunidad;

    public Oportunidades() {
    }

    public Oportunidades(Infante infante, int oportunidad) {
        this.infante = infante;
        this.oportunidad = oportunidad;
    }

    public Infante getInfante() {
        return infante;
    }

    public void setInfante(Infante infante) {
        this.infante = infante;
    }

    public int getOportunidad() {
        return oportunidad;
    }

    public void setOportunidad(int oportunidad) {
        this.oportunidad = oportunidad;
    }
    
    
}
