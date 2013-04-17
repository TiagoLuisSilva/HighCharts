/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TesteFaces.dao;
import br.com.TesteFaces.model.Usuario;
import java.sql.*; 
/**
 *
 * @author TIAGO
 */
public class UsuarioDAO {
    
    private GenericDAO genericDao = new GenericDAO();
    public Connection conn = genericDao.conectar();
    private Usuario user = null;
    
    public Usuario isValidLogin(String usuario, String password)  {
	try {	    
            String sql;  
            sql = "select usuario, senha, nomeusuario from usuarios where usuario = ? and senha = ?";  
            PreparedStatement ps;  
  
            ps = conn.prepareStatement(sql);  
            ps.setString(1, usuario);  
            ps.setString(2, password);  
  
            ResultSet rs;  
            rs = ps.executeQuery();  
  
            if (rs.next()) {  
                user = new Usuario();
                user.setUsuario(rs.getString("usuario"));
                user.setSenha(rs.getString("senha")); 
                user.setNomeusu(rs.getString("nomeusuario")); 
            }  
  
            ps.close();  
     
            return user;  
        }
         
         catch (SQLException ex)
         {  
            System.out.println("Erro ao recuperar cliente/ senha.");    
            throw new RuntimeException();  
         }  
}
}

