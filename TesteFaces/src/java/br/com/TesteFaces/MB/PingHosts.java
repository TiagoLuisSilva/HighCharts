
package br.com.TesteFaces.MB;  //**********Mude seu pacote **********
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable; 
import java.util.Scanner;
 
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext; 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class PingHosts implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public String testeping;
    private String saida;
    public String getTesteping() {
        return testeping;
    }

    public void setTesteping(String testeping) {
        this.testeping = testeping;

    }

    public void testaPingHosts() { 
        try {
            Runtime runtime = Runtime.getRuntime();

            Process proc = runtime.exec("ping " + testeping);
            
            proc.waitFor();

            Scanner sc = new Scanner(proc.getInputStream());
            String retorno = "";
            int perdas = 0;
            int index1 = 0; 
            saida = "";
            while (sc.hasNext()) {
                retorno = sc.nextLine();
                index1 = retorno.indexOf("Enviados = "); // Procura a string para ver se esta 
                saida = saida + retorno + "\r\n";                                            //     na linha certa do retorno
                if (index1 > 0) { //caso index1 > 0 ele ta na linha certa caso não retorna -1 sempre
                    perdas = Integer.parseInt(retorno.substring(53, 54));  // Retorna numero de pacotes perdidos (pega a posição na string)
                    if (perdas == 0)  // 0 perdar  = OK 
                   {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"OK Servidor 100% de retorno!", null));  
    
                    } else if (perdas >= 0 && perdas < 4)  // se tem perda entre 0 e 4 pacotes = WARN
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Servidor com rede oscilando!",null));    
                    }
                    else if (perdas == 4) // 4 pacotes perdidos  = ERROR
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Servidor não responde!",null));    
                    }
                }
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Problem :( " + e)); 
        } // Caso algum erro nos comando acima apresenta a causa aqui ^  
    }

    /**
     * @return the saida
     */
    public String getSaida() {
        return saida;
    }

    /**
     * @param saida the saida to set
     */
    public void setSaida(String saida) {
        this.saida = saida;
    }
}
