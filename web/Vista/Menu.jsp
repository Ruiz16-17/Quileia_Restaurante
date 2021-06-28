<%-- 
    Document   : Menu
    Created on : 25/06/2021, 12:57:02 PM
    Author     : Ruiz
--%>

<%@page import="Modelo.Menu"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.MenuDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Menu</title>
    </head>
    <body>
        
        <a href="CtrlMenu?accion=AddMenu">Agregar un nuevo menú</a>
        <div id="tablaMenu">
            <table border="1">
                <thead>
                    <tr>
                        <th>Tipo de Menú</th>
                        <th>Nombre del menú</th>
                        <th>Lista de Ingredientes</th>
                        <th>Precio</th>
                    </tr>
                </thead>
                <%
                    MenuDAO dao = new MenuDAO();
                    List<Menu>list=dao.listar();
                    Iterator<Menu>iter=list.iterator();
                    Menu menus = null;
                    while(iter.hasNext()){
                    
                        menus=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td><%= menus.getTipo()%></td>
                        <td><%= menus.getNombre()%></td>
                        <td>Ingredientes</td>
                        <td><%= menus.getPrecio()%></td>
                        <td><a href="CtrlMenu?accion=editar&id=<%= menus.getId()%>">Editar/Agregar ingredientes</a></td>
                        <td><a href="CtrlMenu?accion=eliminar&id=<%= menus.getId()%>">Eliminar</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
        
    </body>
</html>
