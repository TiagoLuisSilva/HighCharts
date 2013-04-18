/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PrimeHighCharts.Model;

import java.util.ArrayList;

/**
 *
 * @author TIAGO
 */
public class Paises {
 private String pais;
 private ArrayList valores;

 public Paises(){}
 public Paises (String pais, ArrayList valores)
 {
      this.pais = pais;
      this.valores = valores;
              
 }
    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the valores
     */
    public ArrayList getValores() {
        return valores;
    }

    /**
     * @param valores the valores to set
     */
    public void setValores(ArrayList valores) {
        this.valores = valores;
    }
}
