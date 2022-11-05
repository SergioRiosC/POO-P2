/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pc.juego;
import pc.juego.Juego;
/**
 *
 * @author Sergio RC
 */
public class ZombieFactory {
    static Juego j = new Juego();
    static Zombie[] zombiesNivel = new Zombie[Juego.campoEjercitos];
    
    public static Zombie getNewZombie(TIPOZOMBIE tipo){
        
        switch (tipo) {
            case AEREO:
                if (campoEjercitos() < ZombieAereo.campos) {
                    return null;
                } else {
                    Zombie z = new ZombieAereo();
                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            zombiesNivel[i]=z;
                        }
                    }
                    return z;
                }
            case CONTACTO:
                if (campoEjercitos() < ZombieContacto.campos) {
                    return null;
                } else {
                    Zombie z = new ZombieContacto();
                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            zombiesNivel[i]=z;
                        }
                    }
                    return z;
                }
                
            case MEDIO_ALCANCE:
                if (campoEjercitos() < ZombieMedioAlcance.campos) {
                    return null;
                } else {
                    Zombie z = new ZombieMedioAlcance();
                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            zombiesNivel[i]=z;
                        }
                    }
                    return z;
                }
            case CHOQUE:
                if (campoEjercitos() < ZombieChoque.campos) {
                    return null;
                } else {
                    Zombie z = new ZombieChoque();
                    for (int i = 0; i < zombiesNivel.length; i++) {
                        if (zombiesNivel[i] == null) {
                            zombiesNivel[i]=z;
                        }
                    }
                    return z;
                }
        }
        return null;
    }
    
    public static Zombie getNewZombie(TIPOZOMBIE tipo, String nombre, String imagen,
            int vida, int ataquePorSegundo,int nivel,int campos,int nivelAparicion){
        
        switch (tipo) {
            case AEREO:
                Zombie z=new ZombieAereo();
                z.nombre=nombre;
                z.imagen=imagen;
                z.vida=vida;
                z.ataquePorSegundo=ataquePorSegundo;
                z.nivel=nivel;
                z.campos=campos;
                z.nivelAparicion=nivelAparicion;
                
                
                return z;
            case CONTACTO:
                Zombie z1=new ZombieContacto();
                z1.nombre=nombre;
                z1.imagen=imagen;
                z1.vida=vida;
                z1.ataquePorSegundo=ataquePorSegundo;
                z1.nivel=nivel;
                z1.campos=campos;
                z1.nivelAparicion=nivelAparicion;
                
                
                return z1;
            case MEDIO_ALCANCE:
                Zombie z2=new ZombieAereo();
                z2.nombre=nombre;
                z2.imagen=imagen;
                z2.vida=vida;
                z2.ataquePorSegundo=ataquePorSegundo;
                z2.nivel=nivel;
                z2.campos=campos;
                z2.nivelAparicion=nivelAparicion;
                
                
                return z2;
            case CHOQUE:
                Zombie z3=new ZombieAereo();
                z3.nombre=nombre;
                z3.imagen=imagen;
                z3.vida=vida;
                z3.ataquePorSegundo=ataquePorSegundo;
                z3.nivel=nivel;
                z3.campos=campos;
                z3.nivelAparicion=nivelAparicion;
                
                
                return z3;
        }
        return null;
    }
    
    public static int campoEjercitos() {
        int campos = Juego.campoEjercitos;
        for (int i = 0; i < zombiesNivel.length; i++) {
            if (zombiesNivel[i] != null) {
                campos = campos - zombiesNivel[i].campos;
            }
        }
        return campos;
    }
    
}
