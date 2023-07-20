/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboclinv01;

//import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class SqlConector {
    
    //private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "Carlaandrea98";
    private static final String url = "jdbc:mysql://localhost:3305/laboclinfdb";

    private static Connection con;  
    
    public static Connection conectar(){
        try{
            Class.forName(DRIVER);
            con = (Connection) DriverManager.getConnection(url, user, pass);
            //if(con != null)
            //    JOptionPane.showMessageDialog(null, "Conexion exitosa!");
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexion " + e.getMessage());
        }
        return con;
    }
    
    public static ResultSet executeQuery(String query) throws SQLException{
        ResultSet rs = null;
        PreparedStatement ps = con.prepareStatement(query);
        if(query.contains("UPDATE") || query.contains("INSERT")){
            ps.executeUpdate();
        }else{
            rs = ps.executeQuery();
        }
        return rs;
    }
    
    public static void closeConn(){
        try{
            con.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
