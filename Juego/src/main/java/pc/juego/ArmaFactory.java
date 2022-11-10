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
public class ArmaFactory {

    static Arma[] armasNivel = new Arma[Manager.campoEjercitos];
    
    public static Arma getNewArma(TIPOARMA tipo,int posX, int posY) {
        Arma a;
        switch (tipo) {
            case CONTACTO:
                if (campoEjercitos() < ArmaContacto.campos) {
                    return null;
                } else {
                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                            a = new ArmaContacto();
                            armasNivel[i]=a;
                            a.posX=posX;
                            a.posY=posY;
                            return a;
                        }
                    }
                    
                }

            case AEREO:
                if (campoEjercitos() < ArmaAerea.campos) {
                    return null;
                } else {
                    
                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                            a =new ArmaAerea();
                            armasNivel[i]=a;
                            a.posX=posX;
                            a.posY=posY;
                            return a;
                        }
                    }
                    
                }

            case MEDIANO_ALCANCE:
                if (campoEjercitos() < ArmaMedianoAlcance.campos) {
                    return null;
                } else {
                    
                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                            a =new ArmaMedianoAlcance();
                            armasNivel[i]=a;
                            a.posX=posX;
                            a.posY=posY;
                            return a;
                        }
                    }
                   
                }

            case IMPACTO:
                if (campoEjercitos() < ArmaImpacto.campos) {
                    return null;
                } else {
                    
                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                            a =new ArmaImpacto();
                            a.posX=posX;
                            a.posY=posY;
                            armasNivel[i]=a;
                            return a;
                        }
                    }
                    
                }
            case BLOQUE:
                if (campoEjercitos() < ArmaBloque.campos) {
                    return null;
                } else {
                    
                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                            a =new ArmaBloque();
                            a.posX=posX;
                            a.posY=posY;
                            
                            armasNivel[i]=a;
                            return a;
                        }
                    }
                    
                    
                }

        }
        Manager.ejercitoArma.add(armasNivel);
        return null;
    }

    public static Arma getNewArma(TIPOARMA tipo, String nombre, String imagen,
            int vida, int ataquePorSegundo, int nivel, int campos, int nivelAparicion) {
        Arma a;
        switch (tipo) {
            case CONTACTO:
                if (campoEjercitos() < ArmaContacto.campos) {
                    return null;
                } else {

                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                             a = new ArmaContacto();
                            a.nombre = nombre;
                            a.imagen = imagen;
                            a.vida = vida;
                            a.ataquePorSegundo = ataquePorSegundo;
                            a.nivel = nivel;
                            a.campos = campos;
                            a.nivelAparicion = nivelAparicion;
                            armasNivel[i] = a;
                            return a;
                        }
                    }

                }
            case AEREO:
                if (campoEjercitos() < ArmaAerea.campos) {
                    return null;
                } else {

                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                             a = new ArmaAerea();
                            a.nombre = nombre;
                            a.imagen = imagen;
                            a.vida = vida;
                            a.ataquePorSegundo = ataquePorSegundo;
                            a.nivel = nivel;
                            a.campos = campos;
                            a.nivelAparicion = nivelAparicion;
                            armasNivel[i] = a;
                            return a;
                        }
                    }

                }

            case MEDIANO_ALCANCE:
                if (campoEjercitos() < ArmaMedianoAlcance.campos) {
                    return null;
                } else {

                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                            a = new ArmaMedianoAlcance();
                            a.nombre = nombre;
                            a.imagen = imagen;
                            a.vida = vida;
                            a.ataquePorSegundo = ataquePorSegundo;
                            a.nivel = nivel;
                            a.campos = campos;
                            a.nivelAparicion = nivelAparicion;
                            armasNivel[i] = a;
                            return a;
                        }
                    }

                }
            case IMPACTO:
                if (campoEjercitos() < ArmaImpacto.campos) {
                    return null;
                } else {

                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                            a = new ArmaImpacto();
                            a.nombre = nombre;
                            a.imagen = imagen;
                            a.vida = vida;
                            a.ataquePorSegundo = ataquePorSegundo;
                            a.nivel = nivel;
                            a.campos = campos;
                            a.nivelAparicion = nivelAparicion;
                            armasNivel[i] = a;
                            return a;
                        }
                    }

                }
        }
        Manager.ejercitoArma.add(armasNivel);
        return null;
    }

    public static int campoEjercitos() {
        int campos = Manager.campoEjercitos;
        for (int i = 0; i < armasNivel.length; i++) {
            if (armasNivel[i] != null) {
                campos = campos - armasNivel[i].campos;
            }
        }
        return campos;
    }
    
    
   

}
