/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package veterinaio;


/**
 *
 * @author alell
 */
public class Veterinaio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           Monitor RC = new Monitor(4);
        
        for(int i = 0; i < 6; i++){
            new Animali(RC, "Gatto").start();
        }
        
        for(int i = 0; i < 8; i++){
            new Animali(RC, "Cane").start();
        }
    }
    
}
