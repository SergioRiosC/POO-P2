/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package pc.juego;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Sergio RC
 */
public class Manager implements Serializable {

    static int nivel;
    static int campoEjercitos = 20;
    static ArrayList<Arma[]> ejercitoArma = new ArrayList<Arma[]>();
    static ArrayList<Zombie[]> ejercitoZombie = new ArrayList<Zombie[]>();
    static ArrayList<int[]> posicionesZombie =new ArrayList<int[]>();
    static ArrayList<int[]> posicionesArma =new ArrayList<int[]>();
    static ManejadorArchivos MA = new ManejadorArchivos();
    
    

    public static void init() {
        nivel=Integer.valueOf(MA.leer("nivel.txt"));
        for (int i = 1; i < nivel; i++) {
            campoEjercitos += 5;
        }
        ejercitoArma.add(ArmaFactory.armasNivel);
        ejercitoZombie.add(ZombieFactory.zombiesNivel);
    }

    public void guardarJuego() {
        Manager j = new Manager();
        j.nivel = nivel;
        j.campoEjercitos = campoEjercitos;
        j.ejercitoArma = ejercitoArma;
        j.ejercitoZombie = ejercitoZombie;

        String username = "sergio";

        if (MA.crear_carpeta("archivos/" + username) == 0) {
            MA.asignarJuego(j, username, "NOMBRE", "PASS");
        } else {
            MA.guardarJuego(j, username, false, username);
        }
    }
    public static void terminarNivel(){
        System.out.println("TERMINAR NIVEL");
        for (Arma arma : ArmaFactory.armasNivel) {
            if(arma!=null){
                arma.vida=0;
            }
        }
        for (Zombie zombie : ZombieFactory.zombiesNivel) {
            if(zombie!=null){
                zombie.vida=0;
            }
        }
        int nivelAct=Integer.valueOf(MA.leer("nivel.txt"));
        MA.escribir("nivel.txt",String.valueOf(nivelAct+1) );
    }
}
