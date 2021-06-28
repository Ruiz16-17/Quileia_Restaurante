/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Interfaces.CRUD_Ingrediente;
import Modelo.Ingrediente;
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
public class IngredienteDAO implements CRUD_Ingrediente{
    
    conectar cn = new conectar();
    Connection con;
    PreparedStatement statement;
    ResultSet resultado;
    Ingrediente ingre = new Ingrediente();

    @Override
    public List listar() {
        ArrayList<Ingrediente> list = new ArrayList<>();
        String sql = "SELECT * FROM tblingredientes";
        try {
            con = cn.getConnection();
            statement = con.prepareStatement(sql);
            resultado = statement.executeQuery();
            
            while (resultado.next()) {
                Ingrediente ingred = new Ingrediente();
                ingred.setId(resultado.getInt("Id"));
                ingred.setNombre(resultado.getString("Nombre"));
                ingred.setCalorias(resultado.getInt("Calorias"));
                list.add(ingred);
                
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Ingrediente list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar(Ingrediente ingre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Ingrediente ingre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
