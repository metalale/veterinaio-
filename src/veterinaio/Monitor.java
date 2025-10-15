/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaio;


import java.lang.System.Logger;
import java.util.logging.Level;

/**
 *
 * @author alell
 */
public class Monitor {
    private int buffer;
    private int occupato = 0, cani = 0, gatti = 0;
    private boolean isGatto = false;

    public Monitor(int buffer) {
        this.buffer = buffer;
    }
    
    public synchronized int entraGatto(){
        while(occupato >= buffer){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        occupato++;
        gatti++;
        isGatto = true;
        System.out.println("Il gatto " + gatti + " e' entrato. Gatti dentro: " + occupato);
        return gatti;
    }
    
    public synchronized void esceGatto(int g){
        occupato--;
        
        System.out.println("Il gatto " + g + " e' uscito. Gatti dentro: " + occupato);
        
        if(occupato == 0){
            isGatto = false;
        }
        notifyAll();
    }
    
    public synchronized int entraCane(){
        while(occupato >= buffer || isGatto == true){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        cani++;
        occupato++;
        System.out.println("Il cane " + cani + " e' entrato. Cani dentro: " + occupato);
        return cani;
    }
    
    public synchronized void esceCane(int g){
        occupato--;
        
        System.out.println("Il cane " + g + " e' uscito. Cani dentro: " + occupato);
        
        notifyAll();
        
    }
    
}