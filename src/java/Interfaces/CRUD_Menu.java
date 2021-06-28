/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Menu;
import java.util.List;

/**
 *
 * @author Ruiz
 */
public interface CRUD_Menu {
    public List listar();
    public Menu list(int id);
    public boolean agregar(Menu menus);
    public boolean editar(Menu menus);
    public boolean eliminar(int id);
}
