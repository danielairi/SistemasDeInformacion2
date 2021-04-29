import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * Write a description of class Inicio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Inicio extends JFrame 
{
    private JButton boton;
    private ConexionBD conexion;
    
    public Inicio(ConexionBD c){
        conexion = c;
        boton = new JButton("Agregar Receta");
        configurarPantalla();
    }
    
    private void configurarPantalla(){
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        
        ImageIcon imagen= new ImageIcon("Imagenes/Recetario Postres.png");
        JLabel fondo = new JLabel(imagen);
        fondo.setBounds(0,0,500,475);
        fondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,500,Image.SCALE_SMOOTH)));
        add(fondo);
        
        boton.setBounds(100,400,300,50);
        boton.setFont(new Font("bertilda",Font.BOLD, 20));
        boton.setBackground(new Color(214, 234, 248));
        add(boton);
        
        boton.addActionListener(new botonN(this));
    }
    
    public boolean guardarReceta(Receta receta){
        if(!conexion.existeReceta(receta.nombre)){ 
            conexion.aniadirPostre(receta.nombre, receta.ingredientes, receta. procedimiento);
            JOptionPane mensaje = new JOptionPane();
            mensaje.showMessageDialog(this, "Receta guardada con exito", "", JOptionPane.INFORMATION_MESSAGE);
            
            return true;
        }
        JOptionPane mensaje = new JOptionPane();
        mensaje.setVisible(true);
        mensaje.showMessageDialog(this, "La receta que desea ingresar ya existe", "", JOptionPane.INFORMATION_MESSAGE);
        
        return false;
    }
    
    private class botonN implements ActionListener{
        NuevaReceta nr;
        
        public botonN(Inicio ini){
            nr = new NuevaReceta(ini);
        }
        
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            nr.setVisible(true);
        }
    }
}
