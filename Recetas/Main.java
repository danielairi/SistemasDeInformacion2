
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main {
    
    ConexionBD conexion;
    
    public void main(){
        conexion = new ConexionBD();
        Inicio ini = new Inicio(conexion);
    }
}