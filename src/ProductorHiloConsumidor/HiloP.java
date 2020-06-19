/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductorHiloConsumidor;

import java.util.Arrays;

/**
 *
 * @author santi
 */
public class HiloP extends Thread {

    @Override
    public void run() {
        while (true) {
            try {

                Recipiente.productor.acquire();
                System.out.println("========PRODUCIRÉ=========");
                for (int i = 0; i < Recipiente.CANTIDAD; i++) {
                    Thread.sleep((int) (Math.random() * 2000));
                    System.out.println("Produzco " + i + " cantidad");
                    Recipiente.cantidad[i] = (i+1);
                }
                System.out.println("***PRODUCÍ " + Recipiente.CANTIDAD + " CANTIDADES***");
                System.out.println(Arrays.toString(Recipiente.cantidad));
                System.out.println("==========================");
                Recipiente.consumidor.release();
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}
