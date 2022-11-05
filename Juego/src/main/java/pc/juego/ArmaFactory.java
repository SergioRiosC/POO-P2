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
public class ArmaFactory {

    static Arma[] armasNivel = new Arma[Juego.campoEjercitos];
    
    public static Arma getNewDefensa(TIPOARMA tipo) {

        switch (tipo) {
            case CONTACTO:
                if (campoEjercitos() < ArmaContacto.campos) {
                    return null;
                } else {
                    Arma a = new ArmaContacto();
                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                            armasNivel[i]=a;
                        }
                    }
                    return a;
                }

            case AEREO:
                if (campoEjercitos() < ArmaAerea.campos) {
                    return null;
                } else {
                    Arma a =new ArmaAerea();
                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                            armasNivel[i]=a;
                        }
                    }
                    return a;
                }

            case MEDIANO_ALCANCE:
                if (campoEjercitos() < ArmaMedianoAlcance.campos) {
                    return null;
                } else {
                    Arma a =new ArmaMedianoAlcance();
                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                            armasNivel[i]=a;
                        }
                    }
                    return a;
                }

            case IMPACTO:
                if (campoEjercitos() < ArmaImpacto.campos) {
                    return null;
                } else {
                    Arma a =new ArmaImpacto();
                    for (int i = 0; i < armasNivel.length; i++) {
                        if (armasNivel[i] == null) {
                            armasNivel[i]=a;
                        }
                    }
                    return a;
                }

        }
        return null;
    }

    public static Arma getNewDefensa(TIPOARMA tipo, String nombre, String imagen,
            int vida, int ataquePorSegundo, int nivel, int campos, int nivelAparicion) {

        switch (tipo) {
            case CONTACTO:
                Arma a = new ArmaAerea();
                a.nombre = nombre;
                a.imagen = imagen;
                a.vida = vida;
                a.ataquePorSegundo = ataquePorSegundo;
                a.nivel = nivel;
                a.campos = campos;
                a.nivelAparicion = nivelAparicion;

                return a;
            case AEREO:
                Arma a1 = new ArmaAerea();
                a1.nombre = nombre;
                a1.imagen = imagen;
                a1.vida = vida;
                a1.ataquePorSegundo = ataquePorSegundo;
                a1.nivel = nivel;
                a1.campos = campos;
                a1.nivelAparicion = nivelAparicion;

                return a1;

            case MEDIANO_ALCANCE:
                Arma a2 = new ArmaAerea();
                a2.nombre = nombre;
                a2.imagen = imagen;
                a2.vida = vida;
                a2.ataquePorSegundo = ataquePorSegundo;
                a2.nivel = nivel;
                a2.campos = campos;
                a2.nivelAparicion = nivelAparicion;

                return a2;
            case IMPACTO:
                Arma a3 = new ArmaAerea();
                a3.nombre = nombre;
                a3.imagen = imagen;
                a3.vida = vida;
                a3.ataquePorSegundo = ataquePorSegundo;
                a3.nivel = nivel;
                a3.campos = campos;
                a3.nivelAparicion = nivelAparicion;

                return a3;
        }
        return null;
    }

    public static int campoEjercitos() {
        int campos = Juego.campoEjercitos;
        for (int i = 0; i < armasNivel.length; i++) {
            if (armasNivel[i] != null) {
                campos = campos - armasNivel[i].campos;
            }
        }
        return campos;
    }

}
