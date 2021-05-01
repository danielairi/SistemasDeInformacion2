package Conexion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author PC
 */
public class ConexionBD {
    private Connection con; 
    
    public ConexionBD()throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://DESKTOP-G4JHGIT\\SQLEXPRESS:1433;databaseName=Websis;user=sa;password=sisinfo2;"; 
        con = DriverManager.getConnection(connectionURL);
    }
    
    public Connection conexion(){
        return con;
    }

}
