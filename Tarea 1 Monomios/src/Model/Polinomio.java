/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author j4v13
 */
public class Polinomio {
    
    private Monomio inicio;
    
    public Polinomio multiplicar(Polinomio p){
        Polinomio producto = new Polinomio();
        Monomio auxI = inicio;
        Monomio auxJ;
        while(auxI!=null) {
            auxJ = p.getInicio();
            while(auxJ != null){
                Monomio m = new Monomio(auxI.getCoeficiente()*auxJ.getCoeficiente(),
                    auxI.getExponente()+auxJ.getExponente());
                producto.agregar(m);
                auxJ = auxJ.getSiguiente();
            }
            auxI = auxI.getSiguiente();
        }
        producto.Simplificar();
        return producto;
    }
    
    public void Simplificar() {   
        this.ordena();        
        if (inicio != null && inicio.getSiguiente() != null) {
            Monomio aux = inicio;
            inicio = null;
            Monomio sum;
            while (aux != null) {    
                sum = new Monomio(aux.getCoeficiente(),aux.getExponente());
                while (aux.getSiguiente() != null && aux.isMismoGrado(aux.getSiguiente())){
                    sum.suma(aux.getSiguiente());               
                    aux = aux.getSiguiente();
                }
                this.agregar(sum);
                aux = aux.getSiguiente();
            }
        }
    }
    
    public boolean ordena() {
        if(inicio == null || inicio.getSiguiente() == null)
            return false;
        Monomio aux;
        Monomio auxI = inicio;
        Monomio auxJ = inicio.getSiguiente();
        while (auxI != null && auxI.getSiguiente() != null) {
            while (auxJ != null) {
                if (auxI.compara(auxJ) < 0) {
                    aux = new Monomio();
                    aux.setCoeficiente(auxI.getCoeficiente());
                    aux.setExponente(auxI.getExponente());
                    auxI.setCoeficiente(auxJ.getCoeficiente());
                    auxI.setExponente(auxJ.getExponente());
                    auxJ.setCoeficiente(aux.getCoeficiente());
                    auxJ.setExponente(aux.getExponente());
                }                
                auxJ = auxJ.getSiguiente();
            }
            auxI = auxI.getSiguiente();
            if (auxI.getSiguiente() != null)
                auxJ = auxI.getSiguiente();
            else
                auxI = null;
        }
        return true;
    }
    
    public void agregar(Integer x, Integer y) {
        Monomio m = new Monomio(x,y);
        agregar(m);
    }      
    
    public void agregar(Monomio m) {
        if(inicio == null) {
            inicio = m;
        } else {
            Monomio aux = inicio;
            while(aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(m);
        }      
    }          
    
    public Polinomio clonar(Boolean signo) {
        int s = 1;
        if(!signo)
            s=-1;
        if(inicio == null)
            return null;
        Monomio aux = inicio;
        Polinomio clon = new Polinomio();
        while (aux!= null) {
            clon.agregar(aux.getCoeficiente()*s, aux.getExponente());
            aux = aux.getSiguiente();
        }
        return clon;
    }
    
    public Monomio ultimo() {
        if(inicio == null)
            return null;
        Monomio aux = inicio;
        while (aux.getSiguiente()!= null) {
            aux = aux.getSiguiente();
        }
        return aux;
    }
    
    public String toString() {
        String s = new String();
        s = "";
        Monomio aux = inicio;
        while (aux != null) {
            s += aux.toString();
            aux = aux.getSiguiente();
        }
        return s;
    }

    public Monomio getInicio() {
        return inicio;
    }

    public void setInicio(Monomio inicio) {
        this.inicio = inicio;
    }
            
}
