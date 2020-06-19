/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gasolinera;

import Gasolinera.Vista.EstacionGasolina;

/**
 *
 * @author santi
 */
public class Coche extends Thread {

    static final int NIVEL_MAX = 10;
    public static int nivelActualG = NIVEL_MAX;
    int kilometraje = 50;

    @Override
    public void run() {
        try {
            EstacionGasolina.consumidor.acquire();
            while (kilometraje > 0) {

                if (nivelActualG > 0) {
                    movimiento();
                    Thread.sleep((int) (Math.random() * 500)+200);
                    System.out.println("Avanzo... Gasolina:[" + nivelActualG + "] Kilometraje: [" + kilometraje+"]");

                }

                if (nivelActualG == 0 && kilometraje>0) {
                    
                    Thread.sleep(500);
                    System.out.println("Gasté mas de un 80% de gasolina, iré a la gasolinera");
                    volverALaGasolinera();
                    Thread.sleep(500);
                    System.out.println("Llegué a gasolinera");
                    EstacionGasolina.productor.release();
                    EstacionGasolina.consumidor.acquire();
                }

            }
            
            System.out.println("**** Mi kilometraje se acabó ****");
            this.interrupt();
        } catch (InterruptedException e) {

        }
    }

    private void movimiento() {

        this.kilometraje--;
        nivelActualG--;

    }

    private void volverALaGasolinera() {

        System.out.println("Vuelvo a la gasolinera");

    }

}
