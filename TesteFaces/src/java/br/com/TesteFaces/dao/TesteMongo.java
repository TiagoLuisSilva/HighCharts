package br.com.TesteFaces.dao;

 
import br.com.TesteFaces.model.Frutas;
import com.mongodb.BasicDBObject; 
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class TesteMongo {
 

    public static void main(String[] args) {
        new TesteMongo().executar();
    }

   
    public void executar() {
           FrutasDAO fd = new FrutasDAO(); 
           List<Frutas> lfrutas = fd.ListarFrutas(); 
           for(Frutas x : lfrutas){  
           System.out.println("Fruta"+ x.getFruta().toString() + "QTD:" + x.getQtd());    
           } 
           System.out.println("Done"); 
    }
}