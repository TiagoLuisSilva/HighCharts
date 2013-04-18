/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PrimeHighCharts.Model;

/**
 *
 * @author TIAGO
 */
public class Frutas { 
    private String fruta;
    private int qtd; 
 
    public Frutas(String fruta, int qtd )
    {
      this.fruta = fruta;
      this.qtd = qtd;
    }

    public Frutas() {
         
    }
    /**
     * @return the fruta
     */
    public String getFruta() {
        return fruta;
    }

    /**
     * @param fruta the fruta to set
     */
    public void setFruta(String fruta) {
        this.fruta = fruta;
    }

    
    /**
     * @return the qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param qtd the qtd to set
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
}
