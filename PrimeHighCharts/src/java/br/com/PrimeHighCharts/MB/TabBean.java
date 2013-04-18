/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PrimeHighCharts.MB;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author TIAGO
 */
@ManagedBean
@ViewScoped
public class TabBean {
  
    private List<String> tabs;  
  
    public TabBean() {  
        tabs = new ArrayList<String>();  
  
        for(int i = 0; i < 30; i++) {  
           tabs.add("Tab " + i);   
        }  
    }  
  
    public List<String> getTabs() {  
        return tabs;  
    }  
        /**
         * @param tabs the tabs to set
         */
        public void setTabs(List<String> tabs) {
            this.tabs = tabs;
        }
    }  

