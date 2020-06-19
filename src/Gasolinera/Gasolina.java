/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gasolinera;

import Gasolinera.Vista.EstacionGasolina;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class Gasolina extends Thread {

    int cantidadActualGasolina = 200;
   

    @Override
    public void run() {

        while (cantidadActualGasolina > 0) {
            try {
            
          
                EstacionGasolina.productor.acquire();
                
                Thread.sleep(500);
                cargarGasolina();

                if (Coche.nivelActualG >= Coche.NIVEL_MAX) {
                    System.out.println("Carro lleno...");
                    Thread.sleep(500);
                    EstacionGasolina.consumidor.release();
                    
                }
            } catch (InterruptedException ex) {
            }
        }

    }

    private void cargarGasolina() {
    
    while(Coche.nivelActualG<Coche.NIVEL_MAX){
        try {
            Thread.sleep((int) (Math.random() * 800));
            Coche.nivelActualG++;
            this.cantidadActualGasolina--;
            System.out.println("*****************");
            System.out.println("Cargo gasolina a carro ["+Coche.nivelActualG+"] // Cantidad actual de la gasolinera: ["+cantidadActualGasolina+']');
            System.out.println("*****************");
        } catch (InterruptedException ex) {
            Logger.getLogger(Gasolina.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }    
        
    }

}
