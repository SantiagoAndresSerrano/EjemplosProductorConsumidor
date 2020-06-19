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
public class Guerrero extends Thread {

    int id;
    Vasallo miVasallo = new Vasallo();

    public Guerrero(int id) {

        this.id = id;
        miVasallo.setName(""+id);
    }

    public void setInt(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        try {
            
            guerra();
            Thread.sleep(800);
            System.out.println("~~Guerrero : [" + this.getName() + "] volvió de la guerra, quiere festejar!");
            miVasallo.start();
            
            SalonFiesta.enEspera++;
            Thread.sleep(500);
            SalonFiesta.salonDisponible.acquire();
            SalonFiesta.enEspera--;
            System.out.println(""+SalonFiesta.enEspera+" en espera");
            
            fiesta();
            miVasallo.limpiarSalon();
            System.out.println("");
            
            interrupt();

        } catch (InterruptedException e) {

        }

    }

    private void fiesta() throws InterruptedException {

        int fiesta = ((int) (Math.random() * 50));
        System.out.println("****Guerrero [" + this.getName() + "] está de fiesta)");

        while (fiesta > 0) {
            Thread.sleep(150);
            fiesta--;
        }
       
    }

    private void guerra() throws InterruptedException {

        int guerra = ((int) (Math.random() * 10));

            System.out.println("-Guerrero [" + this.getName() + "] está en guerra");
            
        while (guerra > 0) {
            try {
                Thread.sleep(50);
                guerra--;
            } catch (InterruptedException ex) {
                Logger.getLogger(Guerrero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
