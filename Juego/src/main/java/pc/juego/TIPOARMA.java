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

/**
 *
 * @author Sergio RC
 */
public enum TIPOARMA {
    CONTACTO,
    MEDIANO_ALCANCE,
    AEREO,
    IMPACTO,
    ATAQUE_MULTIPLE,
    BLOQUE
}

abstract class Arma extends Thread {

    public String nombre;
    public String imagen;
    public int vida = 10;
    int posX;
    int posY;
    int ataquePorSegundo;
    public int nivel;
    public int campos;
    public int nivelAparicion;
    ArrayList<JButton> botones = Juego.getBotones();

    public abstract void atacar();

    public abstract void morir();

}

class ArmaContacto extends Arma {

    static int campos = 1;

    //int posX;
    //int posY;
    @Override
    public void atacar() {
        int c = 0;
        for (Zombie zombie : ZombieFactory.zombiesNivel) {
            if (zombie != null) {
                if ((zombie.posX == posX + 1 && zombie.posY == posY) || (zombie.posX == posX - 1 && zombie.posY == posY)
                        || (zombie.posX == posX && zombie.posY == posY + 1) || (zombie.posX == posX && zombie.posY == posY - 1)
                        || (zombie.posX == posX + 1 && zombie.posY == posY + 1) || (zombie.posX == posX - 1 && zombie.posY == posY - 1)
                        || (zombie.posX == posX + 1 && zombie.posY == posY - 1) || (zombie.posX == posX - 1 && zombie.posY == posY + 1)){
                    
                    zombie.vida = zombie.vida - 10;
                    if (zombie.vida <= 0) {
                        
                        for (int[] p : Manager.posicionesZombie) {
                            if (p[0] == zombie.posX && p[1] == zombie.posY) {
                                
                                Manager.posicionesZombie.remove(p);
                                break;
                            }
                        }
                        
                        ZombieFactory.zombiesNivel[c] = null;
                    }
                }
                c++;
            }

        }
    }

    @Override
    public void morir() {

    }

    @Override
    public void run() {

        while (vida > 0) {
            //System.out.println("VIDA CONTACTO: "+vida);
            try {
                atacar();
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ArmaContacto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}

class ArmaMedianoAlcance extends Arma {

    static int campos = 1;

    @Override
    public void atacar() {
        int c = 0;
        for (Zombie zombie : ZombieFactory.zombiesNivel) {
            if (zombie != null) {
                if ((zombie.posX == posX + 2 && zombie.posY == posY) || (zombie.posX == posX - 2 && zombie.posY == posY)
                        || (zombie.posX == posX && zombie.posY == posY + 2) || (zombie.posX == posX && zombie.posY == posY - 2)
                        || (zombie.posX == posX + 2 && zombie.posY == posY + 2) || (zombie.posX == posX - 2 && zombie.posY == posY - 2)
                        || (zombie.posX == posX + 2 && zombie.posY == posY - 2) || (zombie.posX == posX - 2 && zombie.posY == posY + 2)){
                    System.out.println("MEDIANO ATACANDO");
                    zombie.vida = zombie.vida - 50;
                    if (zombie.vida <= 0) {
                        
                        for (int[] p : Manager.posicionesZombie) {
                            if (p[0] == zombie.posX && p[1] == zombie.posY) {
                                
                                Manager.posicionesZombie.remove(p);
                                break;
                            }
                        }
                        
                        ZombieFactory.zombiesNivel[c] = null;
                    }
                }
                c++;
            }

        }
    }

    @Override
    public void morir() {
    }

    @Override
    public void run() {
        while (vida>0) {
            try {
                atacar();
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

class ArmaAerea extends Arma {

    static int campos = 1;

    @Override
    public void atacar() {
        int c = 0;
        for (Zombie zombie : ZombieFactory.zombiesNivel) {
            if (zombie != null) {
                if ((zombie.posX == posX && zombie.posY == posY)){
                    
                    zombie.vida = zombie.vida - 500;
                    if (zombie.vida <= 0) {
                        
                        for (int[] p : Manager.posicionesZombie) {
                            if (p[0] == zombie.posX && p[1] == zombie.posY) {
                                
                                Manager.posicionesZombie.remove(p);
                                break;
                            }
                        }
                        
                        ZombieFactory.zombiesNivel[c] = null;
                    }
                }
                c++;
            }

        }
    }

    @Override
    public void morir() {
    }
    public void mover(){
        buscarBoton(posX, posY).setBackground(null);
        buscarBoton(posX, posY).setText(null);
        int[] act = new int[2];
        act[0] = posX;
        act[1] = posY;
        Random aleatorio = new Random(System.currentTimeMillis());
        posX=posX+(int)(Math.random()*(2-(-2)+1)+(-2));
        posY=posY+(int)(Math.random()*(2-(-2)+1)+(-2));
        if(posX>=24 ||posY>=24){
            posX=posX-1;
            posY=posY-1;
        }
        
        int[] nuevo = new int[2];
        nuevo[0] = posX;
        nuevo[1] = posY;
        boolean atacando = false;
        
        for (int[] p : Manager.posicionesZombie) {
            if (p[0] == act[0] && p[1] == act[1]) {
                atacando = true;
                atacar();
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

class ArmaImpacto extends Arma {

    static int campos = 1;

    @Override
    public void atacar() {
        int c = 0;
        for (Zombie zombie : ZombieFactory.zombiesNivel) {
            if (zombie != null) {
                if ((zombie.posX == posX + 1 && zombie.posY == posY) || (zombie.posX == posX - 1 && zombie.posY == posY)
                        || (zombie.posX == posX && zombie.posY == posY + 1) || (zombie.posX == posX && zombie.posY == posY - 1)
                        || (zombie.posX == posX + 1 && zombie.posY == posY + 1) || (zombie.posX == posX - 1 && zombie.posY == posY - 1)
                        || (zombie.posX == posX + 1 && zombie.posY == posY - 1) || (zombie.posX == posX - 1 && zombie.posY == posY + 1)){
                    
                    zombie.vida = zombie.vida - 50;
                    if (zombie.vida <= 0) {
                        
                        for (int[] p : Manager.posicionesZombie) {
                            if (p[0] == zombie.posX && p[1] == zombie.posY) {
                                
                                Manager.posicionesZombie.remove(p);
                                break;
                            }
                        }
                        
                        ZombieFactory.zombiesNivel[c] = null;
                    }
                }
                c++;
            }

        }
        vida=-1;
    }

    @Override
    public void morir() {
    }

    @Override
    public void run() {

    }
}

class ArmaAtaqueMultiple extends Arma {

    static int campos = 1;

    @Override
    public void atacar() {
        int c = 0;
        for (Zombie zombie : ZombieFactory.zombiesNivel) {
            if (zombie != null) {
                if ((zombie.posX == posX + 1 && zombie.posY == posY) || (zombie.posX == posX - 1 && zombie.posY == posY)
                        || (zombie.posX == posX && zombie.posY == posY + 1) || (zombie.posX == posX && zombie.posY == posY - 1)
                        || (zombie.posX == posX + 1 && zombie.posY == posY + 1) || (zombie.posX == posX - 1 && zombie.posY == posY - 1)
                        || (zombie.posX == posX + 1 && zombie.posY == posY - 1) || (zombie.posX == posX - 1 && zombie.posY == posY + 1)){
                    
                    zombie.vida = zombie.vida - 50;
                    if (zombie.vida <= 0) {
                        
                        for (int[] p : Manager.posicionesZombie) {
                            if (p[0] == zombie.posX && p[1] == zombie.posY) {
                                
                                Manager.posicionesZombie.remove(p);
                                break;
                            }
                        }
                        
                        ZombieFactory.zombiesNivel[c] = null;
                    }
                }
                c++;
            }

        }
    }

    @Override
    public void morir() {
    }

    @Override
    public void run() {

    }
}

class ArmaBloque extends Arma {

    static int campos = 2;

    @Override
    public void atacar() {
    }

    @Override
    public void morir() {
    }

    @Override
    public void run() {

        while (vida > 0) {

            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ArmaBloque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (vida <= 0) {
            interrupt();
        }

    }
}
