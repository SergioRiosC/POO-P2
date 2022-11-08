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
import pc.juego.visual;

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
    Boolean alive = true;
    ArrayList<JButton> botones = visual.getBotones();
    int posX;
    int posY;
    int[] pos = new int[2];
    int vida;
    int ataquePorSegundo;
    int nivel;
    int campos;
    int nivelAparicion;

    public abstract void atacar();

    public abstract void morir();

    public abstract void mover();

}

class ZombieContacto extends Zombie {

    static int campos = 1;
    int vida = 100;
    int posX = (int) (Math.random() * 23);
    int posY = (int) (Math.random() * 23);

    @Override
    public void atacar() {
        //System.out.println("ATACAR");
        /*if(buscarBoton(posX-1, posY-1)."getElemento"){
            elemento.vida=elemento.vida-X daño
        }*/
    }

    @Override
    public void morir() {
        //System.out.println("MORIR");
        if (vida == 0) {
            alive = false;
            stop();
        }

    }

    @Override
    public void mover() {
        //System.out.println("MOVER");

        buscarBoton(posX, posY).setEnabled(false);
        for (int[] p : Juego.posiciones) {
        }
        System.out.println("");
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
        for (int[] p : Juego.posiciones) {
            if (p[0] == nuevo[0] && p[1] == nuevo[1]) {
                posX = act[0];
                pos[0] = act[0];
                posY = act[1];
                pos[1] = act[1];
                ocupada = true;
                break;
            }
        }
        if (!ocupada) {

            Juego.posiciones.add(nuevo);
            int remove = 0;
            for (int[] p : Juego.posiciones) {
                if (p[0] == act[0] && p[1] == act[1]) {
                    Juego.posiciones.remove(remove);
                    break;
                }
                remove++;
            }
        }

        buscarBoton(posX, posY).setBackground(Color.red);
        buscarBoton(posX, posY).setEnabled(true);

    }

    @Override
    public void run() {
        ArrayList<JButton> botones = visual.getBotones();
        while (alive) {

            try {
                morir();
                mover();
                atacar();
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ZombieContacto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        morir();
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
    int vida = 100;
    int posX = (int) (Math.random() * 23);
    int posY = (int) (Math.random() * 23);

    @Override
    public void atacar() {
        
    }

    @Override
    public void morir() {
        //System.out.println("MORIR");
        if (vida == 0) {
            alive = false;
            stop();
        }
    }

    @Override
    public void mover() {
        buscarBoton(posX, posY).setEnabled(false);
        for (int[] p : Juego.posiciones) {
        }
        System.out.println("");
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
        for (int[] p : Juego.posiciones) {
            if (p[0] == nuevo[0] && p[1] == nuevo[1]) {
                posX = act[0];
                pos[0] = act[0];
                posY = act[1];
                pos[1] = act[1];
                ocupada = true;
                break;
            }
        }
        if (!ocupada) {

            Juego.posiciones.add(nuevo);
            int remove = 0;
            for (int[] p : Juego.posiciones) {
                if (p[0] == act[0] && p[1] == act[1]) {
                    Juego.posiciones.remove(remove);
                    break;
                }
                remove++;
            }
        }

        buscarBoton(posX, posY).setBackground(Color.blue);
        buscarBoton(posX, posY).setEnabled(true);
    }
    
    @Override
    public void run() {
        ArrayList<JButton> botones = visual.getBotones();
        while (alive) {

            try {
                morir();
                mover();
                atacar();
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ZombieContacto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        morir();
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
    int vida = 100;
    int posX = (int) (Math.random() * 23);
    int posY = (int) (Math.random() * 23);

    @Override
    public void atacar() {
        
    }

    @Override
    public void morir() {
        //System.out.println("MORIR");
        if (vida == 0) {
            alive = false;
            stop();
        }
    }

    @Override
    public void mover() {
        
    }

}

class ZombieMedioAlcance extends Zombie {

    static int campos = 1;
    int vida = 100;
    int posX = (int) (Math.random() * 23);
    int posY = (int) (Math.random() * 23);

    @Override
    public void atacar() {
        
    }

    @Override
    public void morir() {
        //System.out.println("MORIR");
        if (vida == 0) {
            alive = false;
            stop();
        }
    }

    @Override
    public void mover() {
        buscarBoton(posX, posY).setEnabled(false);
        for (int[] p : Juego.posiciones) {
            
        }
        System.out.println("");
        int[] act = new int[2];
        act[0] = posX;
        act[1] = posY;
        if (posX > 12) {
            posX = posX - 2;
        }
        if (posY > 12) {
            posY = posY - 2;
        }
        if (posX < 12) {
            posX = posX + 2;
        }
        if (posY < 12) {
            posY = posY + 2;
        }
        //pos[0] = posX;
        //pos[1] = posY;
        int[] nuevo = new int[2];
        nuevo[0] = posX;
        nuevo[1] = posY;
        boolean ocupada = false;
        for (int[] p : Juego.posiciones) {
            if (p[0] == nuevo[0] && p[1] == nuevo[1]) {
                posX = act[0];
                pos[0] = act[0];
                posY = act[1];
                pos[1] = act[1];
                ocupada = true;
                break;
            }
        }
        if (!ocupada) {
            Juego.posiciones.add(nuevo);
            int remove = 0;
            for (int[] p : Juego.posiciones) {
                if (p[0] == act[0] && p[1] == act[1]) {
                    Juego.posiciones.remove(remove);
                    break;
                }
                remove++;
            }
        }

        buscarBoton(posX, posY).setBackground(Color.yellow);
        buscarBoton(posX, posY).setEnabled(true);
    }

    
    @Override
    public void run() {
        ArrayList<JButton> botones = visual.getBotones();
        while (alive) {

            try {
                morir();
                mover();
                atacar();
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ZombieContacto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        morir();
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
