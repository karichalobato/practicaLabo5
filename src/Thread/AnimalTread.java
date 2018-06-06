/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import javax.swing.JLabel;

/**
 *
 * @author LN710Q
 */
    public class AnimalTread extends Thread{
    private String nombre;
    private int limite;
    private JLabel animal;
    private int x;
    private int y;
    
    public AnimalTread(){
        
    }
    public AnimalTread(String nombre,int x,int y,int limite,JLabel animal){
        this.nombre=nombre;
        this.animal=animal;
        this.x=x;
        this.y=y;
        this.limite=limite;
        this.animal=animal;
        
    }

    @Override
    public void run() {
        for(int i=x;i<this.limite;i+=10){
            System.out.println(this.nombre+" avanza");
            this.animal.setLocation(i, y);
            if(this.nombre=="tortuga"){
                 try{
                sleep(200);
            }catch(InterruptedException e){
                e.printStackTrace();
            } 
            }else{
               try{
                sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            } 
            }
           
          
          
        }
          System.out.println(this.nombre + " a llegado a la meta");
          yield();
        
    }
    
    
    
    
}


