 
package br.com.TesteFaces.model;
 
import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
    private String usuario;
    private String senha;
    private String nomeusu;

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the nomeusu
     */
    public String getNomeusu() {
        return nomeusu;
    }

    /**
     * @param nomeusu the nomeusu to set
     */
    public void setNomeusu(String nomeusu) {
        this.nomeusu = nomeusu;
    }
 
    
}
