/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pc.juego;

import java.util.ArrayList;
import javax.swing.JButton;
import pc.juego.visual;
/**
 *
 * @author Sergio RC
 */
public enum TIPOZOMBIE{
    CONTACTO,
    AEREO,
    CHOQUE,
    MEDIO_ALCANCE
}

abstract class Zombie extends Thread{
    String nombre;
    String imagen;
    ArrayList<JButton> botones = visual.getBotones();
    int posX;
    int posY;
    int vida;
    int ataquePorSegundo;
    int nivel;
    int campos;
    int nivelAparicion;
    public abstract void atacar();
    public abstract void morir();
    public abstract void mover();
    
}
class ZombieContacto extends Zombie{
    static int campos=1;
    @Override
    public void atacar() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void morir() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void mover() {
         
    }
    
}

class ZombieAereo extends Zombie{
    static int campos=1;
    @Override
    public void atacar() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void morir() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void mover() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}

class ZombieChoque extends Zombie{
    static int campos=1;
    @Override
    public void atacar() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void morir() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void mover() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}

class ZombieMedioAlcance extends Zombie{
    static int campos=1;
    @Override
    public void atacar() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void morir() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void mover() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}