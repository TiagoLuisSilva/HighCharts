 
package br.com.TesteFaces.MB;

import java.io.Serializable;

import javax.faces.bean.ManagedBean; 
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.faces.context.FacesContext;

import br.com.TesteFaces.model.Usuario;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
 
@ManagedBean(name="userMB")
@ViewScoped
public class UsuarioMB implements Serializable {
	public static final String INJECTION_NAME = "#{UsuarioMB}";
	private static final long serialVersionUID = 1L;
	private Usuario user;
 
	public String logOut() throws IOException {
		getRequest().getSession().invalidate();
                FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/login.jsf");  
                return null;
	}
         
        
    public String chklogin() throws IOException   {  
            FacesContext contexto = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) contexto.getExternalContext().getRequest(); 
            user =  (Usuario) request.getSession().getAttribute("user");
            if (user == null){   
                 contexto.addMessage(null, new FacesMessage("Login", "Por favor efetuar o Login" ));  
                FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/login.jsf"); 
            } 
        return null;
    }
    public void usuarioLogado()
    {
    
            FacesContext contexto = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) contexto.getExternalContext().getRequest(); 
            user =  (Usuario) request.getSession().getAttribute("user");
            
    }
	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
}