/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pc.juego;

import java.util.ArrayList;

/**
 *
 * @author Sergio RC
 */
public class Juego {
    static int nivel=1;
    static int campoEjercitos=20;
    ArrayList<Arma[]> ejercitoArma=new ArrayList<Arma[]>();
    ArrayList<Zombie[]> ejercitoZombie=new ArrayList<Zombie[]>();
    
    
    public static void main(String[] args) {
      
    }

    
    public void init(){
        
        for(int i =1;i<nivel;i++){
            campoEjercitos+=5;
        }
        ejercitoArma.add(ArmaFactory.armasNivel);
        ejercitoZombie.add(ZombieFactory.zombiesNivel);
    }
}
