/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pc.juego;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import pc.juego.Juego;

/**
 *
 * @author Sergio RC
 */
public enum TIPOZOMBIE {
    CONTACTO,
    AEREO,
    CHOQUE,
    MEDIO_ALCANCE
}

abstract class Zombie extends Thread {

    String nombre;
    String imagen;
    ArrayList<JButton> botones = Juego.getBotones();
    int posX;
    int posY;
    int[] pos = new int[2];
    int vida=100;
    int ataquePorSegundo;
    int nivel;
    int campos;
    int nivelAparicion;

    public abstract void atacar(int posX, int posY);

    public abstract void morir();

    public abstract void mover();

}

class ZombieContacto extends Zombie {

    static int campos = 1;
    //int posX /*= (int) (Math.random() * 23)*/;
    //int posY /*= (int) (Math.random() * 23)*/;
    int[] nuevo = new int[2];

    @Override
    public void atacar(int posX, int posY) {
        //System.out.println("ATACAR");
        int c=0;
        for (Arma arma : ArmaFactory.armasNivel) {
            
            if(arma!=null && arma.posX==posX && arma.posY==posY){
                //System.out.println("BAJA VIDA BLOQUE: X: "+arma.posX+" Y: "+posY);
                arma.vida=arma.vida-10;
                if (arma.vida <= 0) {
                    for (int[] p : Manager.posicionesArma) {
                        if (p[0] == posX && p[1] == posY) {
                            Manager.posicionesArma.remove(p);
                            break;
                        }
                    }
                    ArmaFactory.armasNivel[c] = null;
                }
            }
            c++;
        }
    }

    @Override
    public void morir() {
        //System.out.println("MORIR");

    }

    @Override
    public void mover() {
        //System.out.println("MOVER");
        buscarBoton(posX, posY).setBackground(null);
        buscarBoton(posX, posY).setText(null);
        

        
        int[] act = new int[2];
        act[0] = posX;
        act[1] = posY;
        if (posX > 12) {
            posX--;
        }
        if (posY > 12) {
            posY--;
        }
        if (posX < 12) {
            posX++;
        }
        if (posY < 12) {
            posY++;
        }
        //pos[0] = posX;
        //pos[1] = posY;
        int[] nuevo = new int[2];
        nuevo[0] = posX;
        nuevo[1] = posY;
        boolean ocupada = false;
        for (int[] p : Manager.posicionesZombie) {
            if (p[0] == nuevo[0] && p[1] == nuevo[1]) {
                posX = act[0];
                pos[0] = act[0];
                posY = act[1];
                pos[1] = act[1];
                ocupada = true;
                break;
            }
        }
        for (int[] p : Manager.posicionesArma) {
            if (p[0] == nuevo[0] && p[1] == nuevo[1]) {
                posX = act[0];
                pos[0] = act[0];
                posY = act[1];
                pos[1] = act[1];
                ocupada = true;
                atacar(nuevo[0],nuevo[1]);
                break;
            }
        }
        if (!ocupada) {

            Manager.posicionesZombie.add(nuevo);
            int remove = 0;
            for (int[] p : Manager.posicionesZombie) {
                if (p[0] == act[0] && p[1] == act[1]) {
                    Manager.posicionesZombie.remove(remove);
                    break;
                }
                remove++;
            }
        }

        buscarBoton(posX, posY).setBackground(Color.red);
        buscarBoton(posX, posY).setText("Z");
        buscarBoton(posX, posY).setEnabled(true);

    }

    @Override
    public void run() {
        Manager.posicionesZombie.clear();
        while (vida>0) {
            try {
                mover();
                //atacar();
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ZombieContacto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(vida<=0){
            buscarBoton(posX, posY).setBackground(null);
            buscarBoton(posX, posY).setText(null);
            interrupt();
        }
    }

    public JButton buscarBoton(int posX, int posY) {
        for (JButton boton : botones) {

            if ((boton.getName().split("-")[0]).equals(String.valueOf(posX))
                    && (boton.getName().split("-")[1]).equals(String.valueOf(posY))) {
                return boton;
            }

        }
        return null;

    }
}

class ZombieAereo extends Zombie {
    static int campos = 1;
    //int posX /*= (int) (Math.random() * 23)*/;
    //int posY /*= (int) (Math.random() * 23)*/;

    @Override
    public void atacar(int posX, int posY) {
        int c=0;
        for (Arma arma : ArmaFactory.armasNivel) {
            
            if(arma!=null && arma.posX==posX && arma.posY==posY){
                arma.vida=arma.vida-10;
                if (arma.vida <= 0) {
                    for (int[] p : Manager.posicionesArma) {
                        if (p[0] == posX && p[1] == posY) {
                            Manager.posicionesArma.remove(p);
                            break;
                        }
                    }
                    ArmaFactory.armasNivel[c] = null;
                }
            }
            c++;
        }
    }

    @Override
    public void morir() {
        //System.out.println("MORIR");
        
    }

    @Override
    public void mover() {
        buscarBoton(posX, posY).setBackground(null);
        buscarBoton(posX, posY).setText(null);
        int[] act = new int[2];
        act[0] = posX;
        act[1] = posY;
        if (posX > 12) {
            posX--;
        }
        if (posY > 12) {
            posY--;
        }
        if (posX < 12) {
            posX++;
        }
        if (posY < 12) {
            posY++;
        }
        int[] nuevo = new int[2];
        nuevo[0] = posX;
        nuevo[1] = posY;
        boolean atacando = false;
        
        for (int[] p : Manager.posicionesArma) {
            if (p[0] == act[0] && p[1] == act[1]) {
                atacando = true;
                atacar(act[0],act[1]);
                break;
            }
        }
        
        if (!atacando) {

            Manager.posicionesZombie.add(nuevo);
            int remove = 0;
            for (int[] p : Manager.posicionesZombie) {
                if (p[0] == act[0] && p[1] == act[1]) {
                    Manager.posicionesZombie.remove(remove);
                    break;
                }
                remove++;
            }
        }

        buscarBoton(posX, posY).setBackground(Color.blue);
        buscarBoton(posX, posY).setText("Z");
        buscarBoton(posX, posY).setEnabled(true);
    }
    
    @Override
    public void run() {
        ArrayList<JButton> botones = Juego.getBotones();
        while (vida>0) {

            try {
                morir();
                mover();
                //atacar();
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ZombieContacto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(vida<=0){
            buscarBoton(posX, posY).setBackground(null);
            buscarBoton(posX, posY).setText(null);
            interrupt();
        }
    }

    public JButton buscarBoton(int posX, int posY) {
        for (JButton boton : botones) {

            if ((boton.getName().split("-")[0]).equals(String.valueOf(posX))
                    && (boton.getName().split("-")[1]).equals(String.valueOf(posY))) {
                return boton;
            }

        }
        return null;

    }

}

class ZombieChoque extends Zombie {

    static int campos = 1;
    //int posX /*= (int) (Math.random() * 23)*/;
    //int posY /*= (int) (Math.random() * 23)*/;

    @Override
    public void atacar(int posX, int posY) {
        int c=0;
        for (Arma arma : ArmaFactory.armasNivel) {
            
            if(arma!=null && arma.posX==posX && arma.posY==posY){
                arma.vida=arma.vida-10;
                if (arma.vida <= 0) {
                    for (int[] p : Manager.posicionesArma) {
                        if (p[0] == posX && p[1] == posY) {
                            Manager.posicionesArma.remove(p);
                            break;
                        }
                    }
                    ArmaFactory.armasNivel[c] = null;
                }
            }
            c++;
        }
    }

    @Override
    public void morir() {
        //System.out.println("MORIR");
        
    }

    @Override
    public void mover() {
        
    }

}

class ZombieMedioAlcance extends Zombie {

    static int campos = 1;
    //int posX /*= (int) (Math.random() * 23)*/;
    //int posY /*= (int) (Math.random() * 23)*/;

    @Override
    public void atacar(int posX, int posY) {
        int c=0;
        for (Arma arma : ArmaFactory.armasNivel) {
            
            if(arma!=null && arma.posX==posX && arma.posY==posY){
                arma.vida=arma.vida-10;
                if (arma.vida <= 0) {
                    for (int[] p : Manager.posicionesArma) {
                        if (p[0] == posX && p[1] == posY) {
                            Manager.posicionesArma.remove(p);
                            break;
                        }
                    }
                    ArmaFactory.armasNivel[c] = null;
                }
            }
            c++;
        }
    }

    @Override
    public void morir() {
        //System.out.println("MORIR");
        
    }

    @Override
    public void mover() {
        buscarBoton(posX, posY).setBackground(null);
        buscarBoton(posX, posY).setText(null);
        for (int[] p : Manager.posicionesZombie) {
            
        }
        int[] act = new int[2];
        act[0] = posX;
        act[1] = posY;
        if (posX > 12) {
            posX --;
        }
        if (posY > 12) {
            posY --;
        }
        if (posX < 12) {
            posX ++;
        }
        if (posY < 12) {
            posY ++;
        }
        //pos[0] = posX;
        //pos[1] = posY;
        int[] nuevo = new int[2];
        nuevo[0] = posX;
        nuevo[1] = posY;
        boolean ocupada = false;
        for (int[] p : Manager.posicionesZombie) {
            if (p[0] == nuevo[0] && p[1] == nuevo[1]) {
                posX = act[0];
                pos[0] = act[0];
                posY = act[1];
                pos[1] = act[1];
                ocupada = true;
                break;
            }
        }
        for (int[] p : Manager.posicionesArma) {
            if (p[0] == nuevo[0] && p[1] == nuevo[1]) {
                posX = act[0];
                pos[0] = act[0];
                posY = act[1];
                pos[1] = act[1];
                ocupada = true;
                atacar(nuevo[0],nuevo[1]);
                break;
            }
        }
        
        if (!ocupada) {
            Manager.posicionesZombie.add(nuevo);
            int remove = 0;
            for (int[] p : Manager.posicionesZombie) {
                if (p[0] == act[0] && p[1] == act[1]) {
                    Manager.posicionesZombie.remove(remove);
                    break;
                }
                remove++;
            }
        }

        buscarBoton(posX, posY).setBackground(Color.yellow);
        buscarBoton(posX, posY).setText("Z");
        buscarBoton(posX, posY).setEnabled(true);
    }

    
    @Override
    public void run() {
        ArrayList<JButton> botones = Juego.getBotones();
        while (vida>0) {

            try {
                morir();
                mover();
                //atacar();
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ZombieContacto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(vida<=0){
            buscarBoton(posX, posY).setBackground(null);
            buscarBoton(posX, posY).setText(null);
            interrupt();    
        }
    }
    public JButton buscarBoton(int posX, int posY) {
        for (JButton boton : botones) {

            if ((boton.getName().split("-")[0]).equals(String.valueOf(posX))
                    && (boton.getName().split("-")[1]).equals(String.valueOf(posY))) {
                return boton;
            }

        }
        return null;

    }
}
