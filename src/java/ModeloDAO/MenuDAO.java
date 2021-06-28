/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Interfaces.CRUD_Menu;
import Modelo.Menu;
import db.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruiz
 */
public class MenuDAO implements CRUD_Menu{

    conectar cn = new conectar();
    Connection con;
    PreparedStatement statement;
    ResultSet resultado;
    Menu menu1 = new Menu();
    
    @Override
    public List listar() {
        
        ArrayList<Menu> list = new ArrayList<>();
        String sql = "SELECT * FROM tblmenu";
        try {
            con = cn.getConnection();
            statement = con.prepareStatement(sql);
            resultado = statement.executeQuery();
            
            while (resultado.next()) {
                Menu m = new Menu();
                m.setId(resultado.getInt("Id"));
                m.setTipo(resultado.getInt("Tipo"));
                m.setNombre(resultado.getString("Nombre"));
                m.setPrecio(resultado.getFloat("Precio"));
                list.add(m);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    

    @Override
    public Menu list(int id) {
        ArrayList<Menu> list = new ArrayList<>();
        String sql = "SELECT * FROM tblmenu WHERE Id =" + id;
        try {
            con = cn.getConnection();
            statement = con.prepareStatement(sql);
            resultado = statement.executeQuery();
            
            while (resultado.next()) {
                
                menu1.setId(resultado.getInt("Id"));
                menu1.setTipo(resultado.getInt("Tipo"));
                menu1.setNombre(resultado.getString("Nombre"));
                menu1.setPrecio(resultado.getFloat("Precio"));
                
            }
        } catch (Exception e) {
        }
        return menu1;
    }

    @Override
    public boolean agregar(Menu menus) {
        String sql = "INSERT INTO tblmenu(Tipo,Nombre,Precio) VALUES "
                + "('"+menus.getTipo()+"','"+menus.getNombre()+"',"+menus.getPrecio()+")";
        
        try {
            
            con = cn.getConnection();
            statement = con.prepareStatement(sql);
            statement.executeUpdate();
            
        } catch (Exception e) {
        }
        
        return false;
    }

    @Override
    public boolean editar(Menu menus) {
        String sql = "UPDATE tblmenu set "
                + "Tipo = "+menus.getTipo()+" ,"
                + "Nombre = '"+menus.getNombre()+"' ,"
                + "Precio = "+menus.getPrecio()
                + " WHERE Id = "+menus.getId();
        
        try {
            
            con = cn.getConnection();
            statement = con.prepareStatement(sql);
            statement.executeUpdate();
            
        } catch (Exception e) {
        }
        
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM tblmenu WHERE Id = "+id;
        
        try {
            
            con = cn.getConnection();
            statement = con.prepareStatement(sql);
            statement.executeUpdate();
            
        } catch (Exception e) {
        }
        
        return false;
    }
    
}
