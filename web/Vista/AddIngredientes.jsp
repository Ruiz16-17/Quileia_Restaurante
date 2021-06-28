<%-- 
    Document   : AddIngredientes
    Created on : 27/06/2021, 01:44:07 PM
    Author     : Ruiz
--%>

<%@page import="Modelo.TipoMenu"%>
<%@page import="ModeloDAO.TipoMenuDAO"%>
<%@page import="Modelo.Menu"%>
<%@page import="ModeloDAO.MenuDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Ingrediente"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.IngredienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
                    String tipoMenuActual = "";
                    
                    MenuDAO daoM = new MenuDAO();
                    int id = Integer.parseInt((String) request.getAttribute("idMenu"));
                    Menu m = (Menu) daoM.list(id);
                    
                    TipoMenuDAO daoTm = new TipoMenuDAO();
                    List<TipoMenu> listTm = daoTm.listar();
                    Iterator<TipoMenu> iterTm = listTm.iterator();
                    TipoMenu tmenus = null;
                    while (iterTm.hasNext()) {

                        tmenus = iterTm.next();
                        if(tmenus.getId()==m.getTipo()){
                        
                            tipoMenuActual = tmenus.getNombre();
                        }
                }%>
        
        <input type="text" name="txtTipoMenu" value="<%= tipoMenuActual%>" readonly="true">
            <input type="text"  name="txtNombreMenu" required="true" value="<%= m.getNombre()%>">
            <input type="number" name="txtPrecioMenu" required="true" value="<%= m.getPrecio()%>">
            <input type="hidden" name="txtIdMenu" value="<%= m.getId()%>">
        
        <div id="tablaMenu">

            <table border="1">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Calorias</th>
                    </tr>
                </thead>
                <%
                    IngredienteDAO dao = new IngredienteDAO();
                    List<Ingrediente> list = dao.listar();
                    Iterator<Ingrediente> iter = list.iterator();
                    Ingrediente ingre = null;
                    while (iter.hasNext()) {

                        ingre = iter.next();

                %>
                <tbody>
                    <tr>
                        <td><%= ingre.getNombre()%></td>
                        <td><%= ingre.getCalorias()%></td>
                        <td>Agregar al menú</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
