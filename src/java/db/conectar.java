/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruiz
 */
public class conectar {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String cadenaConexion = "jdbc:mysql://localhost:3306/quileia_restaurante";
    private static String user = "Ruiz";
    private static String password = "123";
    public Connection conn;

    public static Connection conectar() {

        Connection conexion = null;
        try {
            
                Class.forName(driver);
                conexion = (Connection) DriverManager.getConnection(cadenaConexion,user,password);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "No se estableció la conexión" + e.getMessage());
        }
        
        return conexion;
    }
 
}
