/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TesteFaces.MB;

import br.com.TesteFaces.dao.UsuarioDAO;
import br.com.TesteFaces.model.Frutas;
import br.com.TesteFaces.model.Usuario;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

@ManagedBean
@ViewScoped
public class LoginMB implements Serializable {

    @ManagedProperty(value = UsuarioMB.INJECTION_NAME)
    private UsuarioMB userMB;
    private static final long serialVersionUID = 1L;
    private Usuario user = new Usuario();
    private String loginusu;
    private String password;

    public String login() throws IOException {
        UsuarioDAO usuDao = new UsuarioDAO();

        Usuario usera = usuDao.isValidLogin(user.getUsuario(), user.getSenha());
        boolean loggedIn = false;
        FacesContext contexto = FacesContext.getCurrentInstance();

        if (usera != null) {
            //	getUserMB().setUser(user); 
            loggedIn = true;
            HttpServletRequest request = (HttpServletRequest) contexto.getExternalContext().getRequest();
            request.getSession().setAttribute("user", usera);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/index.jsf");
        } else {
            loggedIn = false;
            contexto.addMessage(null, new FacesMessage("Login", "Usuario ou Senha Invalidos"));
        }

        RequestContext context = RequestContext.getCurrentInstance();
        context.addCallbackParam("loggedIn", loggedIn);
        
        JSONObject responseDetailsJson = new JSONObject();
        JSONArray formDetailsJson = new JSONArray();
 
        return null;
    }

    /**
     * @return the user
     */
    public Usuario getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Usuario user) {
        this.user = user;
    }

    /**
     * @return the userMB
     */
    public UsuarioMB getUserMB() {
        return userMB;
    }

    /**
     * @param userMB the userMB to set
     */
    public void setUserMB(UsuarioMB userMB) {
        this.userMB = userMB;
    }
}
