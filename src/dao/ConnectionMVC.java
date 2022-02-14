/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class ConnectionMVC {
    
    public Connection getConnection()
    {
        Connection conn = null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_gestao?useSSL=false", "root", "root");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return conn;
    }
}
