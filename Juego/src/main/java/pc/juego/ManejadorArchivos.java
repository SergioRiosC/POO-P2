/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pc.juego;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sergio RC
 */
public class ManejadorArchivos {
    
    public Juego buscarJuego(String user, boolean superUser){
        Juego j=null;
        FileInputStream ficheroEntrada=null;
        
        try{
            if(!superUser){
                ficheroEntrada= new FileInputStream("archivos/" + user + "/juego.txt");
            }else{
                System.out.println("USER NORMAL");
                ficheroEntrada= new FileInputStream("archivos/administrativo/juegos.txt");
            }
            ObjectInputStream tuberiaEntrada = new ObjectInputStream(ficheroEntrada);
            j=(Juego)tuberiaEntrada.readObject();
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return j;
    }
    
    public void guardarJuego(Juego juego, String user, boolean superUser,String nombre){
        
        
        FileOutputStream fichero = null;
        try {
            if(!superUser)
                fichero = new FileOutputStream("archivos/" + user + "/juego.txt");
           
            else{
                fichero = new FileOutputStream("archivos/administrativo/"+nombre,false);
            }
            
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(juego);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fichero.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
    
    public void asignarJuego(Juego juego, String username, String nombre, String password) {
        //juego.crearUsuario(username, nombre, password);
        
        FileOutputStream fichero = null;
        try {
           
             fichero = new FileOutputStream("archivos/" + username + "/juego.txt");
           
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(juego);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fichero.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    
    
    
    
    public String leer(String ruta){
        try{
            File archivo = new File(ruta);
            Scanner lector = new Scanner(archivo);
            StringBuilder data = new StringBuilder();

            while(lector.hasNextLine()){
                String parte = lector.nextLine();
                data.append(parte);
            }
            return data.toString();
        }
        catch (FileNotFoundException e){
            return "1";
        }

    }


    public int escribir(String ruta, String data){
        try{
            FileWriter escritor = new FileWriter(ruta);
            escritor.write(data);
            escritor.close();
            return 0;
        }
        catch (IOException e){
            return 1;
        }
    }


    public int crear_carpeta(String ruta){
        File archivo = new File(ruta);
        if(archivo.mkdir()){
            return 0;
        }
        else{
            return 1;
        }
    }
}
