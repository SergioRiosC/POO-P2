/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pc.Juego;

import java.io.Serializable;

/**
 *
 * @author Sergio RC
 */
public class Usuario implements Serializable{
    private String username;
    private String nombre;
    private String password;

    public Usuario(String username, String nombre, String password) {
        this.username = username;
        this.nombre = nombre;
        this.password = password;
    }

    public String getId() {
        return username;
    }

    public void setId(String id) {
        this.username = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }
   
    
}