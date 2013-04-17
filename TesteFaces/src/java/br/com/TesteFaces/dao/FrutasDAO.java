/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TesteFaces.dao;

import br.com.TesteFaces.model.Frutas;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TIAGO
 */
public class FrutasDAO {

    private DBCollection col;

    public boolean conectar() throws MongoException {
        try {
            MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("sacolao");
            col = db.getCollection("frutas");
            return true;
        } catch (UnknownHostException e) {
        }
        return false;
    }

    @SuppressWarnings("element-type-mismatch")
    public List<Frutas> ListarFrutas() {
        conectar();

        List<Frutas> lfrutas = new ArrayList<Frutas>();
        Frutas fruta = new Frutas();
        try {
            conectar();
            DBCursor cursor = col.find();
            DBObject doc;
            int idx;
            float qtdint;
            String nomefruta;
            while (cursor.hasNext()) {
                doc = cursor.next();
                nomefruta = doc.get("fruta").toString();
                int qtds;
                String qtd;
                qtd = doc.get("qtd").toString();
                qtdint = Float.parseFloat(qtd);
                boolean tem = false;
                if (lfrutas.isEmpty()) {
                    fruta = new Frutas(doc.get("fruta").toString(), (int) qtdint);
                } else {

                    for (Frutas x : lfrutas) {
                        if (x.getFruta().equals(nomefruta)) {
                            idx = lfrutas.indexOf(x);
                            qtds = lfrutas.get(idx).getQtd();
                            qtds = qtds + (int) qtdint;
                            lfrutas.get(idx).setQtd(qtds);
                            tem = true;
                        }
                    }
                    if (!tem) 
                    {
                        fruta = new Frutas(doc.get("fruta").toString(), (int) qtdint);
                    }
                }
                if (!lfrutas.contains(fruta)) {
                    lfrutas.add(fruta);
                }
            }

            cursor.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return lfrutas;
    }
}
