/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.prueba;


import co.edu.umanizales.listase.modelo.ListaCircularDE;
import co.edu.umanizales.listase.modelo.ListaDE;
import co.edu.umanizales.listase.modelo.ListaSE;
import co.edu.umanizales.listase.modelo.Perro;
/**
 *
 * @author 
 */
public class ProbarListaSE {
    public static void main(String... args)
    {
        //Instanciar una lista se
        ListaSE lista = new ListaSE();
        ListaDE listaPerros= new ListaDE();
        ListaCircularDE listaCircular = new ListaCircularDE();
        
        Perro lulu = new Perro("Lulú",(byte) 1, (byte)9,"hembra");
        listaCircular.adicionarNodoCircular(lulu);
        
        Perro firulais = new Perro("Firulais", (byte)2, (byte)4,"macho");
        listaCircular.adicionarNodoCircular(firulais);
//        
        Perro pastor = new Perro("Tobby", (byte)3, (byte)6,"macho");
        listaCircular.adicionarNodoCircular(pastor);
        
        listaCircular.adicionarNodoCircular(new Perro("robin", (byte)4, (byte)5, "macho"));
        //System.out.println(listaPerros.encontrarPosicion(4).getDato().getNombre());
        //listaPerros.adicionarNodoPorPosicion(3, new Perro("robin", (byte)4, (byte)5,"macho"));
        System.out.println(listaCircular.Sumardatos("impar"));
    }
}
