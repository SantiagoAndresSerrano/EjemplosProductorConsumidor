/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guerreros;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class Vasallo extends Thread {

    public void run() {
        conseguirSalon();
    }

    public void conseguirSalon() {

        System.out.print(SalonFiesta.enEspera+" en espera"+" ");
        System.out.println("#Vasallo [" + this.getName() + "] buscará un salon disponible***");
        
    }

    public void limpiarSalon() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("<=>Guerrero [" + this.getName() + "] terminó su fiesta, arreglaré el Salón ");
        System.out.println("*=* Salón arreglado y desocupado por Vasallo [" + this.getName() + "]");
        SalonFiesta.salonDisponible.release();
        System.out.println("");
        interrupt();

    }

}
