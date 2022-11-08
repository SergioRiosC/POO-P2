/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pc.juego;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio RC
 */
public enum TIPOARMA{
    CONTACTO,
    MEDIANO_ALCANCE,
    AEREO,
    IMPACTO,
    ATAQUE_MULTIPLE,
    BLOQUE
}


 abstract class Arma extends Thread{
    public String nombre;
    public String imagen;
    public int vida=100;
    int posX;
    int posY;
    int ataquePorSegundo;
    public int nivel;
    public int campos;
    public int nivelAparicion;
    public abstract void atacar();
    public abstract void morir();
    
}

class ArmaContacto extends Arma{
    static int campos=1;
    @Override
    public void atacar() {
       
    }

    @Override
    public void morir() {
        
    }
    @Override
    public void run(){
        
    }
}

class ArmaMedianoAlcance extends Arma{
    static int campos=1;
    @Override
    public void atacar() {
        
    }

    @Override
    public void morir() {
    }
    
    @Override
    public void run(){
        
    }
}

class ArmaAerea extends Arma{
    static int campos=1;
    @Override
    public void atacar() {
    }

    @Override
    public void morir() {
    }
    
    @Override
    public void run(){
        
    }
}

class ArmaImpacto extends Arma{
    static int campos=1;
    @Override
    public void atacar() {
    }

    @Override
    public void morir() {
    }
    
    @Override
    public void run(){
        
    }
}

class ArmaAtaqueMultiple extends Arma{
    static int campos=1;
    @Override
    public void atacar() {
    }

    @Override
    public void morir() {
    }
    
    @Override
    public void run(){
        
    }
}

class ArmaBloque extends Arma{
    static int campos=2;
    @Override
    public void atacar() {
    }

    @Override
    public void morir() {
    }
    @Override
    public void run(){
        
        while(vida>0){
            System.out.println("BLOQUE CON VIDA: "+vida);
            
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ArmaBloque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(vida<=0){
            interrupt();
        }
        
    }
}