/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listainfantes.modelo;

/**
 *
 * @author Daniel Quintero
 */
public class ListaCircularDE {

    private NodoDE cabeza;

    private int totalInfantes = 0;

    public ListaCircularDE() {
    }

    public NodoDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDE cabeza) {
        this.cabeza = cabeza;
    }

    public int getTotalInfantes() {
        return totalInfantes;
    }

    public void setTotalInfantes(int totalInfantes) {
        this.totalInfantes = totalInfantes;
    }

    public void adicionarNodoCircular(Infante dato) {
        if (cabeza == null) {
            cabeza = new NodoDE(dato);
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            NodoDE temp = new NodoDE(dato);
            cabeza.getAnterior().setSiguiente(temp);
            temp.setSiguiente(cabeza);
            temp.setAnterior(cabeza.getAnterior());
            cabeza.setAnterior(temp);
        }
        totalInfantes++;
    }

    public void adicionarNodoCircularAlInicio(Infante dato) {
        if (cabeza == null) {
            cabeza = new NodoDE(dato);
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            NodoDE temp = new NodoDE(dato);
            cabeza.getAnterior().setSiguiente(temp);
            temp.setSiguiente(cabeza);
            temp.setAnterior(cabeza.getAnterior());
            cabeza.setAnterior(temp);
            cabeza = temp;
        }
        totalInfantes++;
    }

    public void eliminarEnSitio(Infante Infanteeliminar) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (temp.getDato().getId() != Infanteeliminar.getId()) {
                temp = temp.getSiguiente();
            }
            if (temp == cabeza) {
                //Eliminar cabeza
                cabeza = temp.getSiguiente();
                cabeza.setAnterior(cabeza.getAnterior().getAnterior());
                cabeza.getAnterior().setSiguiente(cabeza);

            } else {
                temp.getSiguiente().setAnterior(temp.getAnterior());
                temp.getAnterior().setSiguiente(temp.getSiguiente());
            }
            totalInfantes--;
        }
    }

    public void adicionarNodoporPosicionB(int posicionIngreso, Infante dato) {
        if (cabeza != null) {
            int cont = 1;
            NodoDE temp = cabeza;
            if (posicionIngreso == cont) {
                adicionarNodoCircularAlInicio(dato);
            } else {
                while (cont != posicionIngreso && temp.getSiguiente() != cabeza) {
                    temp = temp.getSiguiente();
                    cont++;
                }
                if (cont < posicionIngreso) {

                    adicionarNodoCircular(dato);
                } else {
                    NodoDE temp1 = temp.getAnterior();
                    temp.setAnterior(new NodoDE(dato));
                    temp.getAnterior().setAnterior(temp1);
                    temp1.setSiguiente(temp.getAnterior());
                    temp.getAnterior().setSiguiente(temp);

                }
            }

        } else {
            adicionarNodoCircular(dato);
        }
        totalInfantes++;
    }
}
