/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;

/**
 *
 * @author j4v13
 */
public class Controlador {    

    Polinomio polinomio;
    Polinomio polinomio2;
    
    public String multiplicar() {
        if(polinomio.getInicio() == null || polinomio2.getInicio() == null)
            return "Falta polinomio para operacion";
        Polinomio producto = polinomio.multiplicar(polinomio2);
        return producto.toString();
    }
    
    public String restar() {
        return unir(false);
    }
    
    public String sumar() {
        return unir(true);
    }
    
    private String unir(Boolean signo) {
        if(polinomio.getInicio() == null || polinomio2.getInicio() == null)
            return "Falta polinomio para operacion";
        Polinomio poliClon = polinomio.clonar(true);
        Polinomio poli2Clon = polinomio2.clonar(signo);
        Monomio aux = poliClon.ultimo();
        aux.setSiguiente(poli2Clon.getInicio());
        poliClon.Simplificar();
        return poliClon.toString();
    }
    
    public String Simplifica(int i){
        if(i == 1) {
            polinomio.Simplificar();
            return polinomio.toString();
        } else {
            polinomio2.Simplificar();
            return polinomio2.toString();
        }
    }
    
    public String agregar(int i, String c, String e) {
        if(i == 1) {
            polinomio.agregar(Integer.valueOf(c), Integer.valueOf(e));
            return polinomio.toString();
        } else {
            polinomio2.agregar(Integer.valueOf(c), Integer.valueOf(e));
            return polinomio2.toString();
        }
    }    
    
    public Controlador() {     
        polinomio = new Polinomio();
        polinomio2 = new Polinomio();
    }
    
}
