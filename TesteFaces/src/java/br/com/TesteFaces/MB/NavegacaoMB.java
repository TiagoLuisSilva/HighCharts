/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TesteFaces.MB;

import br.com.TesteFaces.dao.UsuarioDAO;
import br.com.TesteFaces.model.Usuario;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

@ManagedBean
@RequestScoped
/**
 *
 * @author TIAGO
 */
public class NavegacaoMB implements Serializable {

    private String url = "/pages/inicial.xhtml";

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public void setPagina1() {
        setUrl("/pages/pagina1.xhtml");
    }

    public void setPagina2() {
        setUrl("/pages/pagina2.xhtml");
    }

    public void Mudapagina() throws IOException {

	FacesContext contexto = FacesContext.getCurrentInstance();
		
        HttpServletRequest request = (HttpServletRequest) contexto.getExternalContext().getRequest();
      
        FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/pagina1.jsf");
    }
    /**
     * @return the url1
     */
}
