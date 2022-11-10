/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pc.juego;

import static pc.juego.ArmaFactory.armasNivel;
import pc.juego.Manager;

/**
 *
 * @author Sergio RC
 */
public class ZombieFactory {

    static Zombie[] zombiesNivel = new Zombie[Manager.campoEjercitos];

    public static Zombie getNewZombie(TIPOZOMBIE tipo, int posX, int posY) {
        Zombie z;
        switch (tipo) {
            case AEREO:
                if (campoEjercitos() < ZombieAereo.campos) {
                    return null;
                } else {
                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            z = new ZombieAereo();
                            z.posX=posX;
                            z.posY=posY;
                            zombiesNivel[i] = z;
                            return z;

                        }
                    }
                }
            case CONTACTO:
                if (campoEjercitos() < ZombieContacto.campos) {
                    return null;
                } else {
                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            z = new ZombieContacto();
                            z.posX=posX;
                            z.posY=posY;
                            zombiesNivel[i] = z;
                            return z;
                        }
                    }

                }

            case MEDIO_ALCANCE:
                if (campoEjercitos() < ZombieMedioAlcance.campos) {
                    return null;
                } else {
                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            z = new ZombieMedioAlcance();
                            z.posX=posX;
                            z.posY=posY;
                            zombiesNivel[i] = z;
                            return z;
                        }
                    }

                }
            case CHOQUE:
                if (campoEjercitos() < ZombieChoque.campos) {
                    return null;
                } else {
                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            z = new ZombieChoque();
                            z.posX=posX;
                            z.posY=posY;
                            zombiesNivel[i] = z;
                            return z;
                        }
                    }
                }
        }
        Manager.ejercitoZombie.add(zombiesNivel);
        return null;
    }

    public static Zombie getNewZombie(TIPOZOMBIE tipo,int posX,int posY, String nombre, String imagen,
            int vida, int ataquePorSegundo, int nivel, int campos, int nivelAparicion) {
        Zombie z;
        switch (tipo) {
            case AEREO:

                if (campoEjercitos() < ZombieAereo.campos) {
                    return null;
                } else {

                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            z = new ZombieAereo();
                            z.nombre = nombre;
                            z.imagen = imagen;
                            z.vida = vida;
                            z.ataquePorSegundo = ataquePorSegundo;
                            z.nivel = nivel;
                            z.campos = campos;
                            z.nivelAparicion = nivelAparicion;
                            z.posX=posX;
                            z.posY=posY;
                            zombiesNivel[i] = z;
                            return z;
                        }
                    }

                }
            case CONTACTO:
                if (campoEjercitos() < ZombieContacto.campos) {
                    return null;
                } else {

                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            z = new ZombieContacto();
                            z.nombre = nombre;
                            z.imagen = imagen;
                            z.vida = vida;
                            z.ataquePorSegundo = ataquePorSegundo;
                            z.nivel = nivel;
                            z.campos = campos;
                            
                            z.nivelAparicion = nivelAparicion;
                            z.posX=posX;
                            z.posY=posY;
                            zombiesNivel[i] = z;
                            return z;
                        }
                    }

                }

            case MEDIO_ALCANCE:
                if (campoEjercitos() < ZombieMedioAlcance.campos) {
                    return null;
                } else {

                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            z = new ZombieMedioAlcance();
                            z.nombre = nombre;
                            z.imagen = imagen;
                            z.vida = vida;
                            z.ataquePorSegundo = ataquePorSegundo;
                            z.nivel = nivel;
                            z.campos = campos;
                            z.nivelAparicion = nivelAparicion;
                            z.posX=posX;
                            z.posY=posY;
                            zombiesNivel[i] = z;
                            return z;
                        }
                    }
                }
            case CHOQUE:
                if (campoEjercitos() < ZombieChoque.campos) {
                    return null;
                } else {

                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            z = new ZombieAereo();
                            z.nombre = nombre;
                            z.imagen = imagen;
                            z.vida = vida;
                            z.ataquePorSegundo = ataquePorSegundo;
                            z.nivel = nivel;
                            z.campos = campos;
                            z.nivelAparicion = nivelAparicion;
                            z.posX=posX;
                            z.posY=posY;
                            zombiesNivel[i] = z;
                            return z;
                        }
                    }
                }
        }
        Manager.ejercitoZombie.add(zombiesNivel);
        return null;
    }

    public static int campoEjercitos() {
        int campos = Manager.campoEjercitos;
        for (int i = 0; i < zombiesNivel.length; i++) {
            if (zombiesNivel[i] != null) {
                campos = campos - zombiesNivel[i].campos;
            }
        }
        return campos;
    }

}
