/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TesteFaces.model;

import java.util.List;

/**
 *
 * @author Babji Prashanth, Chetty
 */
public class Series {
    private String name;
    private List<Long> data;

    public Series() {}

    public Series(String name, List<Long> data) {
        this.name = name;
        this.data = data;
    }
}