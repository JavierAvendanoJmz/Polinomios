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
public class Monomio {
    private Integer coeficiente;
    private Integer exponente;
    private Monomio siguiente;
    
    public Monomio multiplica (Monomio m){
        return new Monomio(this.coeficiente *= m.getCoeficiente(),
                    this.exponente += m.getExponente());
    }
    
    public Monomio resta (Monomio m){
        if (this.isMismoGrado(m)) {
            return new Monomio(this.coeficiente -= m.getCoeficiente(),
                    this.getExponente());
        } else {
            return null;
        }
    }
    
    public Monomio suma (Monomio m){
        if (this.isMismoGrado(m)) {
            return new Monomio(this.coeficiente += m.getCoeficiente(),
                    this.getExponente());
        } else {
            return null;
        }
    }
    
    public boolean isMismoGrado (Monomio m){
        return this.exponente== m.getExponente();
    }
    
    public int compara (Monomio m){
        if (this.exponente > m.getExponente()) {
            return 1;
        } else if (this.exponente < m.getExponente()){
            return -1;
        }else {
            if (this.coeficiente > m.getCoeficiente()) {
                return 1;
            } else if(this.coeficiente < m.getCoeficiente()){
                return -1;
            } else {
                return 0;
            }
        }    
    }
    
    public String toString() {
        return coeficiente>0 ? "+" + coeficiente + "x^" + exponente + " ":
                coeficiente + "x^" + exponente + " ";
    }

    public Monomio() {
    }

    public Monomio(Integer coeficiente, Integer exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }

    public Integer getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(Integer coeficiente) {
        this.coeficiente = coeficiente;
    }

    public Integer getExponente() {
        return exponente;
    }

    public void setExponente(Integer exponente) {
        this.exponente = exponente;
    }

    public Monomio getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Monomio siguiente) {
        this.siguiente = siguiente;
    }
    
}
