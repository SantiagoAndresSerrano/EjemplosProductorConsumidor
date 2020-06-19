/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductorHiloConsumidor;

import java.util.concurrent.Semaphore;

/**
 *
 * @author santi
 */
public class Recipiente {
    public static int CANTIDAD=5;
    public static int[] cantidad =new int[CANTIDAD];
    
    public static Semaphore consumidor=new Semaphore(0);
    public static Semaphore productor=new Semaphore(1);
    
    
    
    public void producir(){
    
        HiloP producir = new HiloP();
        producir.start();
    
    }
    public void consumir(){
    
    HiloC consumir = new HiloC();
        consumir.start();
    
    }
    
    
}
