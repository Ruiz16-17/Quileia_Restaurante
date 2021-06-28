<%-- 
    Document   : AddMenu
    Created on : 25/06/2021, 05:35:32 PM
    Author     : Ruiz
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.TipoMenu"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.TipoMenuDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Agregar menú</h2>
        <form action="CtrlMenu">
            <select name="sltTipoMenu" required="true">
                <option>Tipo de menú</option>
                <%
                    TipoMenuDAO dao = new TipoMenuDAO();
                    List<TipoMenu> list = dao.listar();
                    Iterator<TipoMenu> iter = list.iterator();
                    TipoMenu tmenus = null;
                    while (iter.hasNext()) {

                        tmenus = iter.next();

                %>
                <option value="<%= tmenus.getId()%>"><%= tmenus.getNombre()%></option>
                <%}%>
            </select>

            <input type="text" placeholder="Nombre del menú" name="txtNombreMenu" required="true">
            <input type="number" placeholder="Precio del menú" name="txtPrecioMenu" required="true">
            <input type="submit" name="accion" value="Agregar">
        </form>
         
            <script src="../js_General/funcionesMenu.js" type="text/javascript"></script>
    </body>
</html>
