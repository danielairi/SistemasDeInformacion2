
/**
 * Write a description of class ConexionBD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionBD
{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public ConexionBD(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recetas","root","root");
            st = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void aniadirPostre(String n, String i, String p){
        try {
            String postre = "INSERT INTO postres(nombre, ingredientes, procedimiento)VALUES('" + n + "', '" + i + "', '" + p +"')";
            st.executeUpdate(postre);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void borrarPostre(String nombreP){
        try{
            String postre = "DELETE FROM postres WHERE nombre =  '"+ nombreP + "'";
            st.executeUpdate(postre);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean existeReceta (String nombreP){
        try{
            String query = "SELECT * FROM postres";
            rs = st.executeQuery(query); 
            nombreP = nombreP.toUpperCase();
            while (rs.next()){
                String nombre = rs.getString("nombre").toUpperCase();
                
                if(nombre.equals(nombreP)) 
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
