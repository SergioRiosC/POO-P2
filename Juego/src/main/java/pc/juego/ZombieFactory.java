/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pc.juego;

import pc.juego.Manager;

/**
 *
 * @author Sergio RC
 */
public class ZombieFactory {

    static Zombie[] zombiesNivel = new Zombie[Manager.campoEjercitos];

    public static Zombie getNewZombie(TIPOZOMBIE tipo, int posX, int posY) {

        switch (tipo) {
            case AEREO:
                if (campoEjercitos() < ZombieAereo.campos) {
                    return null;
                } else {
                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            Zombie z = new ZombieAereo();
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
                            Zombie z = new ZombieContacto();
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
                            Zombie z = new ZombieMedioAlcance();
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
                            Zombie z = new ZombieChoque();
                            z.posX=posX;
                            z.posY=posY;
                            zombiesNivel[i] = z;
                            return z;
                        }
                    }
                }
        }
        return null;
    }

    public static Zombie getNewZombie(TIPOZOMBIE tipo, String nombre, String imagen,
            int vida, int ataquePorSegundo, int nivel, int campos, int nivelAparicion) {

        switch (tipo) {
            case AEREO:

                if (campoEjercitos() < ZombieAereo.campos) {
                    return null;
                } else {

                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            Zombie z = new ZombieAereo();
                            z.nombre = nombre;
                            z.imagen = imagen;
                            z.vida = vida;
                            z.ataquePorSegundo = ataquePorSegundo;
                            z.nivel = nivel;
                            z.campos = campos;
                            z.nivelAparicion = nivelAparicion;
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
                            Zombie z1 = new ZombieContacto();
                            z1.nombre = nombre;
                            z1.imagen = imagen;
                            z1.vida = vida;
                            z1.ataquePorSegundo = ataquePorSegundo;
                            z1.nivel = nivel;
                            z1.campos = campos;
                            z1.nivelAparicion = nivelAparicion;
                            zombiesNivel[i] = z1;
                            return z1;
                        }
                    }

                }

            case MEDIO_ALCANCE:
                if (campoEjercitos() < ZombieMedioAlcance.campos) {
                    return null;
                } else {

                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            Zombie z2 = new ZombieAereo();
                            z2.nombre = nombre;
                            z2.imagen = imagen;
                            z2.vida = vida;
                            z2.ataquePorSegundo = ataquePorSegundo;
                            z2.nivel = nivel;
                            z2.campos = campos;
                            z2.nivelAparicion = nivelAparicion;
                            zombiesNivel[i] = z2;
                            return z2;
                        }
                    }
                }
            case CHOQUE:
                if (campoEjercitos() < ZombieChoque.campos) {
                    return null;
                } else {

                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            Zombie z3 = new ZombieAereo();
                            z3.nombre = nombre;
                            z3.imagen = imagen;
                            z3.vida = vida;
                            z3.ataquePorSegundo = ataquePorSegundo;
                            z3.nivel = nivel;
                            z3.campos = campos;
                            z3.nivelAparicion = nivelAparicion;
                            zombiesNivel[i] = z3;
                            return z3;
                        }
                    }
                }
        }
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
