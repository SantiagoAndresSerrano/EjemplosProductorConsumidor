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
public class HiloC extends Thread {

    @Override
    public void run() {

        while (true) {

            try {

                Recipiente.consumidor.acquire();
                for (int i = 0; i < Recipiente.CANTIDAD; i++) {
                    Thread.sleep((int) (Math.random() * 2000));
                    System.out.println("Consumo " + i);
                    Recipiente.cantidad[i] = 0;
                }
                System.out.println("***CONSUMI TODAS LAS PORCIONES***");
                System.out.println(Arrays.toString(Recipiente.cantidad));
                System.out.println("==========================");

                Thread.sleep(1000);
                Recipiente.productor.release();
            } catch (InterruptedException e) {

            }
        }
    }

}
