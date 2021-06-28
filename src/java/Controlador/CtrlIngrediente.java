/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ingrediente;
import ModeloDAO.IngredienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ruiz
 */
@WebServlet(name = "CtrlIngrediente", urlPatterns = {"/CtrlIngrediente"})
public class CtrlIngrediente extends HttpServlet {

    String listar = "Vista/Menu.jsp";
    String add = "Vista/AddIngredientes.jsp";
    String editar = "Vista/EditMenu.jsp";
    Ingrediente ingre = new Ingrediente();
    IngredienteDAO dao = new IngredienteDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CtrlIngrediente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CtrlIngrediente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equals("Menu")) {

            acceso = listar;
        } else if (action.equals("AddMenu")) {

            acceso = add;
        } else if (action.equals("Agregar")) {

            int tipoMenu = Integer.parseInt(request.getParameter("sltTipoMenu"));
            String nombre = request.getParameter("txtNombreMenu");
            float precio = Float.parseFloat(request.getParameter("txtPrecioMenu"));

            ingre.setNombre(nombre);
            dao.agregar(ingre);
            acceso = listar;//Este es para dirigirse a la lista después de ser agregado, pero en este caso se debe agregar a los ingredientes
        } else if (action.equals("editar")) {

            request.setAttribute("idMenu", request.getParameter("id"));
            acceso = editar;
        } else if (action.equals("Actualizar")) {

            int id = Integer.parseInt(request.getParameter("txtIdMenu"));
            int tipoMenu = Integer.parseInt(request.getParameter("sltTipoMenu"));
            String nombre = request.getParameter("txtNombreMenu");
            float precio = Float.parseFloat(request.getParameter("txtPrecioMenu"));
            
            ingre.setId(id);
            ingre.setNombre(nombre);
            
            dao.editar(ingre);
            acceso = listar;
        }else if(action.equals("eliminar")){
        
            int id = Integer.parseInt(request.getParameter("id"));
            
            ingre.setId(id);
            dao.eliminar(id);
            acceso = listar;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
