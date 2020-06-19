/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guerreros;

import java.util.concurrent.Semaphore;

/**
 *
 * @author santi
 */
public class SalonFiesta {

    public Guerrero[] guerreros;
    static volatile int enEspera=0;
    
    public static Semaphore salonDisponible =new Semaphore(1);
    
    
    public SalonFiesta(int cantidadGuerreros) {
        guerreros = new Guerrero[cantidadGuerreros];
    
        cargarGuerreros();
    }
    
    public final void cargarGuerreros(){
    int contador=0;
    for(Guerrero g:guerreros){
        g = new Guerrero(contador);
        g.setName(""+contador);
        g.start();
        contador++;
    }
  
        
    }
    
    
}
