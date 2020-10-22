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
public class ListaDE {

    private NodoDE cabeza;

    public ListaDE() {
    }

    public NodoDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDE cabeza) {
        this.cabeza = cabeza;
    }

    public void adicionarNodo(Perro dato) {
        if (cabeza == null) {
            //No tiene perros
            cabeza = new NodoDE(dato);
        } else {
            // tiene perros
            NodoDE temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            //Ubicado o parado en el último
            temp.setSiguiente(new NodoDE(dato));
            temp.getSiguiente().setAnterior(temp);

        }
    }

    public void adicionarAlInicio(Perro dato) {

        if (cabeza != null) {
            NodoDE temp = new NodoDE(dato);
            temp.setSiguiente(cabeza);
            cabeza.setAnterior(temp);
            cabeza = temp;

        } else {

            cabeza = new NodoDE(dato);
        }
    }

    public int contarNodosDE() {

        if (cabeza != null) {
            NodoDE temp = cabeza;
            int cont = 1;

            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
                cont++;
            }
            return cont;
        } else {
            return 0;
        }
    }

    public void eliminarPorPosicion(int posEliminar) {
        if (cabeza != null) {
            int cont = 1;
            NodoDE temp = cabeza;
            if (cont == posEliminar) {
                if (cabeza.getSiguiente() == null) {
                    cabeza = null;
                    //   ListaDE nuevaLista = new ListaDE();

                } else {
                    //Eliminar cabeza
                    cabeza = temp.getSiguiente();
                    cabeza.setAnterior(null);
                    //   temp = cabeza;
                }

            } else {
                while (posEliminar != cont) {
                    temp = temp.getSiguiente();
                    cont++;
                }
                if (temp.getSiguiente() == null) {
                    temp.getAnterior().setSiguiente(null);

                } else {
                    temp.getSiguiente().setAnterior(temp.getAnterior());
                    temp.getAnterior().setSiguiente(temp.getSiguiente());
                }
            }
        }
    }

    public void intercambiarPorPosicion(int pos1, int pos2) {
        int cont1 = 1;
        int cont2 = 1;
        NodoDE temp1 = cabeza;
        NodoDE temp2 = cabeza;

        while (cont1 != pos1) {
            temp1 = temp1.getSiguiente();
            cont1++;
        }
        while (cont2 != pos2) {
            temp2 = temp2.getSiguiente();
            cont2++;
        }

        Perro perrotemp = temp1.getDato();
        temp1.setDato(temp2.getDato());
        temp2.setDato(perrotemp);
    }

    public void eliminarEnSitio(Perro perroeliminar) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (temp.getDato().getNumero() != perroeliminar.getNumero()) {
                temp = temp.getSiguiente();
            }
            if (temp == cabeza) {
                if (temp.getSiguiente() == null) {
                    cabeza = null;
                    //  ListaDE nuevaLista = new ListaDE();

                } else {
                    //Eliminar cabeza
                    cabeza = temp.getSiguiente();
                    //temp.setSiguiente(cabeza);
                    cabeza.setAnterior(null);
                    //  temp = cabeza;
                }
            } else if (temp.getSiguiente() == null) {
                temp.getAnterior().setSiguiente(null);

            } else {
                temp.getSiguiente().setAnterior(temp.getAnterior());
                temp.getAnterior().setSiguiente(temp.getSiguiente());
            }

        }
    }

    public String mostrarDatos() {
        String mensaje;
        NodoDE temp = cabeza;
        mensaje = cabeza.getDato().getNombre();
        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
            mensaje += " " + temp.getDato().getNombre();

        }
        return mensaje;
    }

    public void adicionarNodoPorPosicion(int posicionIngreso, Perro dato) {
        if (cabeza != null) {
            int cont = 1;
            if (posicionIngreso == cont) {
                adicionarAlInicio(dato);
            } else {
                NodoDE temp = cabeza;
                while (cont != posicionIngreso - 1 && temp.getSiguiente() != null) {
                    temp = temp.getSiguiente();
                    cont++;
                }
                if (temp.getSiguiente() == null) {

                    adicionarNodo(dato);
                } else {
                    NodoDE temp1 = temp.getSiguiente();
                    temp.setSiguiente(new NodoDE(dato));
                    temp.getSiguiente().setSiguiente(temp1);
                    temp1.setAnterior(temp.getSiguiente());
                    temp.getSiguiente().setAnterior(temp);
                }
            }

        } else {
            adicionarNodo(dato);
        }

    }

    public void adicionarNodoporPosicionB(int posicionIngreso, Perro dato) {
        if (cabeza != null) {
            int cont = 1;
            NodoDE temp = cabeza;
            if (posicionIngreso == cont) {
                adicionarAlInicio(dato);
            } else {
                while (cont != posicionIngreso && temp.getSiguiente() != null) {
                    temp = temp.getSiguiente();
                    cont++;
                }
                if (cont < posicionIngreso) {

                    adicionarNodo(dato);
                } else {
                    NodoDE temp1 = temp.getAnterior();
                    temp.setAnterior(new NodoDE(dato));
                    temp.getAnterior().setAnterior(temp1);
                    temp1.setSiguiente(temp.getAnterior());
                    temp.getAnterior().setSiguiente(temp);
                }
            }

        } else {
            adicionarNodo(dato);
        }
    }

    public void invertir() {
        if (cabeza != null) {
            ListaDE listaTemporal = new ListaDE();
            NodoDE temp = cabeza;
            while (temp != null)//Recorre de principio a fin
            {
                listaTemporal.adicionarAlInicio(temp.getDato());
                temp = temp.getSiguiente();//Ayudante pase al siguiente perro
            }
            cabeza = listaTemporal.getCabeza();
        }
    }

    public Perro encontrarPosicion(int pos) {
        if (cabeza != null) {
            // if (pos <= contarNodos()) {
            int cont = 1;
            NodoDE temp = cabeza;
            while (pos != cont) {
                temp = temp.getSiguiente();
                cont++;
            }
            return temp.getDato();
        }
        return null;
    }

    public void ordenarGenero(int gen) {

        NodoDE temp = cabeza;
        ListaDE nuevaLista = new ListaDE();
        switch (gen) {
            case 1:
                while (temp != null) {
                    if (temp.getDato().getGenero().equalsIgnoreCase("macho")) {
                        nuevaLista.adicionarAlInicio(temp.getDato());
                    } else if (temp.getDato().getGenero().equalsIgnoreCase("hembra")) {
                        nuevaLista.adicionarNodo(temp.getDato());
                    }
                    temp = temp.getSiguiente();
                    cabeza = nuevaLista.getCabeza();
                }
                break;
            case 2:
                while (temp != null) {
                    if (temp.getDato().getGenero().equalsIgnoreCase("hembra")) {
                        nuevaLista.adicionarAlInicio(temp.getDato());
                    } else if (temp.getDato().getGenero().equalsIgnoreCase("macho")) {
                        nuevaLista.adicionarNodo(temp.getDato());
                    }
                    temp = temp.getSiguiente();
                    cabeza = nuevaLista.getCabeza();
                }
                break;
            default:
                break;
        }
    }

    public boolean comprobarID(Perro perroID) {
        NodoDE temp = cabeza;
        while (temp != null) {

            if (temp.getDato().getNumero() == perroID.getNumero()) {
                return false;
            } else {
                temp = temp.getSiguiente();
            }
        }
        return true;
    }
}
