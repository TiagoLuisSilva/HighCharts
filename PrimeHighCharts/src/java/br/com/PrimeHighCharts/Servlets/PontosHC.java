/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PrimeHighCharts.Servlets;

import br.com.PrimeHighCharts.Model.Paises;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TIAGO
 */
public class PontosHC extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PontosHC</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PontosHC at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Paises> lpaises = new ArrayList<Paises>();
        ArrayList valores;
        valores = gerarvalores();
        Paises pais = new Paises("Brazil", valores);
        lpaises.add(pais);
        valores = gerarvalores();
        pais = new Paises("Venezuela", valores);
        lpaises.add(pais);
        valores = gerarvalores();
        pais = new Paises("Argentina", valores);
        lpaises.add(pais);


        Gson gson = new Gson();
        String json = gson.toJson(lpaises);
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);


    }

    public ArrayList gerarvalores() {
        Random rd = new Random();
        ArrayList valores = new ArrayList();
        double valor = 0;
        for (int i = 0; i < 9; i++) {

            valor = rd.nextInt(30);
            valores.add(valor);
        }
        return valores;

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
        processRequest(request, response);
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
