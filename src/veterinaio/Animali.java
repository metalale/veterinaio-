/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaio;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alell
 */
public class Animali extends Thread{
    Monitor RC;
    String tipo;

    public Animali(Monitor RC, String tipo) {
        this.RC = RC;
        this.tipo = tipo;
    }


    
    @Override
    public void run(){
        if(tipo.equals("Gatto")){
            int i = RC.entraGatto();
            try {
                Thread.sleep((int) (Math.random() * 2500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Animali.class.getName()).log(Level.SEVERE, null, ex);
            }
            RC.esceGatto(i);
        }else{
            int i = RC.entraCane();
            try {
                Thread.sleep((int) (Math.random() * 2500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Animali.class.getName()).log(Level.SEVERE, null, ex);
            }
            RC.esceCane(i);
        }
    
}
}

