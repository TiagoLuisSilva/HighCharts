/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TesteFaces.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.TesteFaces.MB.ChartController;
import br.com.TesteFaces.dao.FrutasDAO;
import br.com.TesteFaces.model.Frutas;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

/**
 *
 * @author TIAGO
 */
public class ServletJson extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JSONException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            ChartController chartctrl = new ChartController();
            //  JSONObject datachart = (JSONObject) chartctrl.geravalores();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletJson</title>");
            out.println("</head>");
            out.println("<body>");
            //    out.println(datachart.toString());
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    @SuppressWarnings("empty-statement")
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
        try {
             
           /* String parametro1 = request.getParameter("param");
            int[] qtds = {3, 2, 5};
            List<Frutas1> frutas = new ArrayList<Frutas1>();
            Frutas1 fruta = new Frutas1("Banana", qtds);
            frutas.add(fruta); 
            fruta = new Frutas1("Maça", new int[]{3,2,9});
            frutas.add(fruta);
            fruta = new Frutas1("Uva", new int[]{9,5,7});
            frutas.add(fruta);*/
               FrutasDAO fd = new FrutasDAO(); 
            List<Frutas> lfrutas = fd.ListarFrutas(); 
           
            Gson gson = new Gson();
            String json = gson.toJson(lfrutas);
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json); 
        } catch (Exception e) {
            Logger.getLogger(ServletJson.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
