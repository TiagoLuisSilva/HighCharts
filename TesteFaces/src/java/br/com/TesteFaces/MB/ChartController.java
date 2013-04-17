/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TesteFaces.MB;

import br.com.TesteFaces.model.Series;
import br.com.TesteFaces.model.Frutas;
import com.google.gson.Gson;
import java.io.File;
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

/**
 * Chart Controller
 *
 * @author Babji Prashanth, Chetty
 */
@ManagedBean
@RequestScoped
public class ChartController {

    private String[] categorias = {"Laranja", "Banana", "Pera"};
    private int valores[];
    private ArrayList dados = new ArrayList();
    private int[] vals = {1, 2, 3};
    private String chartData;
    private String categories;
    private List<String> categoryList = new ArrayList<String>();
    private List<Long> heapSizeList = new ArrayList<Long>();
    private List<Long> usedHeapSizeList = new ArrayList<Long>();
    SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");//dd/MM/yyyy
    private static final long MB = 1024 * 1024;
    int index = 0;
    private Long[] longs;

    /**
     * Load Chart Data
     */
    public void loadChartData() {
        if (heapSizeList.size() > 10) {
            heapSizeList.remove(0);
            usedHeapSizeList.remove(0);
            categoryList.remove(0);
        }
        List<Series> series = new ArrayList<Series>();

        malloc();
        long heapSize = Runtime.getRuntime().maxMemory();
        heapSizeList.add(heapSize / MB);
        usedHeapSizeList.add((heapSize - Runtime.getRuntime().freeMemory()) / MB);

        series.add(new Series("Heap Size", heapSizeList));
        series.add(new Series("Used Heap", usedHeapSizeList));


        categoryList.add(sdfDate.format(new Date()));

        setCategories(new Gson().toJson(categoryList));
    }

    public String getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(String categories) {
        this.categories = categories;
    }

    private void malloc() {
        if (index % 2 == 0) {
            longs = new Long[100000];
            for (int i = 0; i < 1000; i++) {
                longs[i] = Long.valueOf(i);
            }
        } else {
            longs = null;
        }
        index++;
    }

    /**
     * @return the categorias
     */
    public String[] getCategorias() {
        return categorias;
    }

    /**
     * @param categorias the categorias to set
     */
    public void setCategorias(String[] categorias) {
        this.categorias = categorias;
    }

    /**
     * @return the valores
     */
    public int[] getValores() {
        return valores;
    }

    /**
     * @param valores the valores to set
     */
    public void setValores(int[] valores) {
        this.valores = valores;
    }

    public void geravalores() throws JSONException {
       
        /*    int[] qtds = {3, 2, 5};
            List<Frutas> frutas = new ArrayList<Frutas>();
            Frutas fruta = new Frutas("Banana", qtds);
            frutas.add(fruta); 
            fruta = new Frutas("Maça", new int[]{3,2,9});
            frutas.add(fruta);
            fruta = new Frutas("Uva", new int[]{9,5,7});
            frutas.add(fruta);
            Gson gson = new Gson();
            String json = gson.toJson(frutas);
            setChartData(json);*/

    }

    /**
     * @return the chartData
     */
    public String getChartData() {
        return chartData;
    }

    /**
     * @param chartData the chartData to set
     */
    public void setChartData(String chartData) {
        this.chartData = chartData;
    }

    /**
     * @return the dados
     */
    public ArrayList getDados() {
        return dados;
    }

    /**
     * @param dados the dados to set
     */
    public void setDados(ArrayList dados) {
        this.dados = dados;
    }

    /**
     * @return the vals
     */
    public int[] getVals() {
        return vals;
    }

    /**
     * @param vals the vals to set
     */
    public void setVals(int[] vals) {
        this.vals = vals;
    }
}
