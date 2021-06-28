/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Interfaces.CRUD_TipoMenu;
import Modelo.TipoMenu;

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
public class TipoMenuDAO implements CRUD_TipoMenu{

    conectar cn = new conectar();
    Connection con;
    PreparedStatement statement;
    ResultSet resultado;
    TipoMenu menu1 = new TipoMenu();
    
    @Override
    public List listar() {
        
        ArrayList<TipoMenu> list = new ArrayList<>();
        String consultaSQL = "SELECT * FROM tbl_tipo_menu";
        try {
            con = cn.getConnection();
            statement = con.prepareStatement(consultaSQL);
            resultado = statement.executeQuery();
            
            while (resultado.next()) {
                TipoMenu tm = new TipoMenu();
                tm.setId(resultado.getInt("Id"));
                tm.setNombre(resultado.getString("Nombre"));
                list.add(tm);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
