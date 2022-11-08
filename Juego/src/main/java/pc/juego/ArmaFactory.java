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
    
    public static Arma getNewArma(TIPOARMA tipo) {

        switch (tipo) {
            case CONTACTO:
                if (campoEjercitos() < ArmaContacto.campos) {
                    return null;
                } else {
                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                            Arma a = new ArmaContacto();
                            armasNivel[i]=a;
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
                            Arma a =new ArmaAerea();
                            armasNivel[i]=a;
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
                            Arma a =new ArmaMedianoAlcance();
                            armasNivel[i]=a;
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
                            Arma a =new ArmaImpacto();
                            armasNivel[i]=a;
                            return a;
                        }
                    }
                    
                }

        }
        return null;
    }

    public static Arma getNewArma(TIPOARMA tipo, String nombre, String imagen,
            int vida, int ataquePorSegundo, int nivel, int campos, int nivelAparicion) {

        switch (tipo) {
            case CONTACTO:
                if (campoEjercitos() < ArmaContacto.campos) {
                    return null;
                } else {

                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                            Arma a = new ArmaContacto();
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
                            Arma a1 = new ArmaAerea();
                            a1.nombre = nombre;
                            a1.imagen = imagen;
                            a1.vida = vida;
                            a1.ataquePorSegundo = ataquePorSegundo;
                            a1.nivel = nivel;
                            a1.campos = campos;
                            a1.nivelAparicion = nivelAparicion;
                            armasNivel[i] = a1;
                            return a1;
                        }
                    }

                }

            case MEDIANO_ALCANCE:
                if (campoEjercitos() < ArmaMedianoAlcance.campos) {
                    return null;
                } else {

                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                            Arma a2 = new ArmaMedianoAlcance();
                            a2.nombre = nombre;
                            a2.imagen = imagen;
                            a2.vida = vida;
                            a2.ataquePorSegundo = ataquePorSegundo;
                            a2.nivel = nivel;
                            a2.campos = campos;
                            a2.nivelAparicion = nivelAparicion;
                            armasNivel[i] = a2;
                            return a2;
                        }
                    }

                }
            case IMPACTO:
                if (campoEjercitos() < ArmaImpacto.campos) {
                    return null;
                } else {

                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                            Arma a3 = new ArmaImpacto();
                            a3.nombre = nombre;
                            a3.imagen = imagen;
                            a3.vida = vida;
                            a3.ataquePorSegundo = ataquePorSegundo;
                            a3.nivel = nivel;
                            a3.campos = campos;
                            a3.nivelAparicion = nivelAparicion;
                            armasNivel[i] = a3;
                            return a3;
                        }
                    }

                }
        }
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
