/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gasolinera.Vista;

import Gasolinera.Coche;
import Gasolinera.Coche;
import Gasolinera.Gasolina;
import Gasolinera.Gasolina;
import java.util.concurrent.Semaphore;


/**
 *
 * @author santi
 */
public class EstacionGasolina extends Thread {

    public static Coche coche = new Coche();
    public static Gasolina gasolina = new Gasolina();

    public static Semaphore consumidor = new Semaphore(1);
    public static Semaphore productor = new Semaphore(0);

    public EstacionGasolina() {

    }

    @Override
    public void run() {

        coche.start();
        gasolina.start();

    }

}
