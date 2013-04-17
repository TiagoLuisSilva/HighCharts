/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TesteFaces.dao;

import java.sql.*; 
import java.sql.DriverManager; 
/**
 *
 * @author TIAGO
 */
public class GenericDAO {
    
    public Connection conectar() 
    {
       
        String driver = "org.postgresql.Driver";  
        String user   = "postgres";  
        String senha = "123";  
        String url      = "jdbc:postgresql://localhost:5432/teste";
        Connection con = null;    
        try  
        {  
            Class.forName(driver);  
  
            con = (Connection) DriverManager.getConnection(url, user, senha);  
  
            System.out.println("Conexão realizada com sucesso.");  
        }  
        catch (ClassNotFoundException ex)  
        {  
            System.out.print(ex.getMessage());  
        }   
        catch (SQLException e)  
        {  
            System.out.print(e.getMessage());  
        }  
         return con;
        
    }
    public void GenericDAO(){}
}
