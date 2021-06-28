<%-- 
    Document   : EditMenu
    Created on : 25/06/2021, 05:35:43 PM
    Author     : Ruiz
--%>

<%@page import="Modelo.Ingrediente"%>
<%@page import="ModeloDAO.IngredienteDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.TipoMenu"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.TipoMenuDAO"%>
<%@page import="Modelo.Menu"%>
<%@page import="ModeloDAO.MenuDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <!-- CSS personalizado --> 

        <!--datables CSS básico-->
        <link rel="stylesheet" type="text/css" href="datatables/datatables.min.css"/>
        <!--datables estilo bootstrap 4 CSS-->  
        <link rel="stylesheet"  type="text/css" href="datatables/DataTables-1.10.18/css/dataTables.bootstrap4.min.css">

        <title>JSP Page</title>

    </head>
    <body>
        <h2>Editar menú</h2>
        <form action="CtrlMenu">

            <select name="sltTipoMenu">

                <%

                    MenuDAO daoM = new MenuDAO();
                    int id = Integer.parseInt((String) request.getAttribute("idMenu"));
                    Menu m = (Menu) daoM.list(id);

                    TipoMenuDAO daoTm = new TipoMenuDAO();
                    List<TipoMenu> listTm = daoTm.listar();
                    Iterator<TipoMenu> iterTm = listTm.iterator();
                    TipoMenu tmenus = null;
                    while (iterTm.hasNext()) {

                        tmenus = iterTm.next();
                        if (tmenus.getId() == m.getTipo()) {

                %>

                <option value="<%= tmenus.getId()%>"><%= tmenus.getNombre()%> - Actual</option>            
                <%
                        }
                    }
                    while (iterTm.hasNext()) {

                        tmenus = iterTm.next();
                        if (tmenus.getId() != m.getTipo()) {

                %>

                <option value="<%= tmenus.getId()%>"><%= tmenus.getNombre()%> - Actual</option>            
                <%
                        }
                    }
                %>
            </select>
            <input type="text"  name="txtNombreMenu" required="true" value="<%= m.getNombre()%>">
            <input type="number" name="txtPrecioMenu" required="true" value="<%= m.getPrecio()%>">
            <input type="hidden" name="txtIdMenu" value="<%= m.getId()%>">
            <input type="submit" name="accion" value="Actualizar">
            <a href="CtrlMenu?accion=Menu">Regresar</a>
        </form>

        <h2>Agregar ingredientes</h2>

        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModalCenter">
                        Agregar un nuevo ingrediente
                    </button>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="table-responsive">

                        <table id="tablaIngredientes" class="table table-striped table-bordered table-condensed" >
                            <thead class="text-center">
                                <tr>
                                    <th>Nombre</th>
                                    <th>Calorias</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    IngredienteDAO dao = new IngredienteDAO();
                                    List<Ingrediente> list = dao.listar();
                                    Iterator<Ingrediente> iter = list.iterator();
                                    Ingrediente ingre = null;
                                    while (iter.hasNext()) {

                                        ingre = iter.next();

                                %>

                                <tr>
                                    <td><%=ingre.getNombre()%></td>
                                    <td><%=ingre.getCalorias()%></td>
                                    <td></td>
                                </tr>


                                <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>


        <!-- Modal -->
        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        ...
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>

        <script src="jquery/jquery-3.3.1.min.js"></script>
        <script src="popper/popper.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>

        <!-- datatables JS -->
        <script src="datatables/datatables.min.js" type="text/javascript"></script>

        <script src="js_General/CargarTablaIngredientes.js" type="text/javascript"></script>
    </body>
</html>
