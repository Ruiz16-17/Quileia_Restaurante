/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Menu;
import ModeloDAO.MenuDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ruiz
 */
public class CtrlMenu extends HttpServlet {

    String listar = "Vista/Menu.jsp";
    String addIngredientes = "Vista/AddIngredientes.jsp";
    String add = "Vista/AddMenu.jsp";
    String editar = "Vista/EditMenu.jsp";
    Menu m = new Menu();
    MenuDAO dao = new MenuDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            
            out.println("<title>Servlet CtrlMenu</title>");
            out.println("</head>");
            out.println("<body>");
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
        //processRequest(request, response);

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

            m.setNombre(nombre);
            m.setTipo(tipoMenu);
            m.setPrecio(precio);
            dao.agregar(m);
            
            acceso = listar;
        } else if (action.equals("editar")) {

            request.setAttribute("idMenu", request.getParameter("id"));
            acceso = editar;
        } else if (action.equals("Actualizar")) {

            int id = Integer.parseInt(request.getParameter("txtIdMenu"));
            int tipoMenu = Integer.parseInt(request.getParameter("sltTipoMenu"));
            String nombre = request.getParameter("txtNombreMenu");
            float precio = Float.parseFloat(request.getParameter("txtPrecioMenu"));
            
            m.setId(id);
            m.setNombre(nombre);
            m.setTipo(tipoMenu);
            m.setPrecio(precio);
            
            dao.editar(m);
            
            acceso = listar;
        }else if(action.equals("eliminar")){
        
            int id = Integer.parseInt(request.getParameter("id"));
            
            m.setId(id);
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
