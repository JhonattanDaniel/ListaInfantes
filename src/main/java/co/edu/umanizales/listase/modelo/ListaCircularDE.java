/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.modelo;

/**
 *
 * @author Daniel Quintero
 */
public class ListaCircularDE {

    private NodoDE cabeza;

    private int totalPerros = 0;

    public ListaCircularDE() {
    }

    public NodoDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDE cabeza) {
        this.cabeza = cabeza;
    }

    public int getTotalPerros() {
        return totalPerros;
    }

    public void setTotalPerros(int totalPerros) {
        this.totalPerros = totalPerros;
    }

    public void adicionarNodoCircular(Perro dato) {
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
        totalPerros++;
    }

    public int Sumardatos(String tipo) {
        NodoDE temp = cabeza.getAnterior();
        int sumaTotal = 0;
        if (tipo.equals("par")) {
            if (totalPerros % 2 != 0) {
                temp = temp.getAnterior();
            }
            sumaTotal = temp.getDato().getNumero();
            while (temp.getAnterior() != cabeza) {
                temp = temp.getAnterior().getAnterior();
                sumaTotal += temp.getDato().getNumero();
            }

        } else if (tipo.equals("impar")) {
            if (totalPerros % 2 == 0) {
                temp = temp.getAnterior();
            }
            sumaTotal = temp.getDato().getNumero();
            while (temp.getAnterior() != cabeza.getAnterior()) {
                temp = temp.getAnterior().getAnterior();
                sumaTotal += temp.getDato().getNumero();
            }
        }
        return sumaTotal;
    }
}
