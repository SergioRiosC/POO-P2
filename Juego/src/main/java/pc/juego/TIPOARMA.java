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
    public int vida = 1000;
    int posX;
    int posY;
    int ataquePorSegundo;
    public int nivel;
    public int campos;
    public int nivelAparicion;

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

class ArmaAerea extends Arma {

    static int campos = 1;

    @Override
    public void atacar() {
        int c = 0;
        for (Zombie zombie : ZombieFactory.zombiesNivel) {
            if (zombie != null) {
                if ((zombie.posX == posX && zombie.posY == posY)){
                    
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
            System.out.println("BLOQUE CON VIDA: " + vida);

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
