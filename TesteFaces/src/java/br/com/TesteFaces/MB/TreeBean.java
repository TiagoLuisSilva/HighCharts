/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TesteFaces.MB;

/**
 *
 * @author TIAGO
 */
import java.io.Serializable;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import br.com.TesteFaces.model.Document;
import java.awt.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TreeBean implements Serializable {    
    
    private TreeNode root;    
    private TreeNode selectedNode;    
    
    public TreeBean() {
        root = new DefaultTreeNode("root", null);
        TreeNode documents = new DefaultTreeNode("Documents", root);
        TreeNode pictures = new DefaultTreeNode("Pictures", root);
        TreeNode music = new DefaultTreeNode("Music", root);
        TreeNode work = new DefaultTreeNode("Work", documents);
        TreeNode primefaces = new DefaultTreeNode("PrimeFaces", documents);
//Documents
        TreeNode expenses = new DefaultTreeNode("document", "Expenses.doc", work);
        TreeNode resume = new DefaultTreeNode("document", "Resume.doc", work);
        TreeNode refdoc = new DefaultTreeNode("document", "RefDoc.pages", primefaces);
//Pictures
        TreeNode barca = new DefaultTreeNode("picture", "barcelona.jpg", pictures);
        TreeNode primelogo = new DefaultTreeNode("picture", "logo.jpg", pictures);
        TreeNode optimus = new DefaultTreeNode("picture", "optimus.png", pictures);
//Music
        TreeNode turkish = new DefaultTreeNode("Turkish", music);
        TreeNode cemKaraca = new DefaultTreeNode("Cem Karaca", turkish);
        TreeNode erkinKoray = new DefaultTreeNode("Erkin Koray", turkish);
        TreeNode mogollar = new DefaultTreeNode("Mogollar", turkish);
        TreeNode nemalacak = new DefaultTreeNode("mp3", "Nem Alacak Felek Benim", cemKaraca);
        TreeNode resimdeki = new DefaultTreeNode("mp3", "Resimdeki Goz Yaslari", cemKaraca);
        TreeNode copculer = new DefaultTreeNode("mp3", "Copculer", erkinKoray);
        TreeNode oylebirgecer = new DefaultTreeNode("mp3", "Oyle Bir Gecer", erkinKoray);
        TreeNode toprakana = new DefaultTreeNode("mp3", "Toprak Ana", mogollar);
        TreeNode bisiyapmali = new DefaultTreeNode("mp3", "Bisi Yapmali", mogollar);
    }    
    
    public TreeNode getRoot() {        
        return root;        
    }    
    
    public TreeNode getSelectedNode() {        
        return selectedNode;        
    }    
    
    public void setSelectedNode(TreeNode selectedNode) {        
        this.selectedNode = selectedNode;        
    }    
    
    public void displaySelectedSingle() {

//O segredo está aqui. Vc deve colocar varíos IF
      /* if(builder.toString()="Node 0.0.0")
         {
         //vai para a página que vc quer..Neste caso pesquise sobre JSF Navigation, para vc ter uma idéia de como redirecionar para a pagina que vc quer
         }
         }  */
    }    
}
