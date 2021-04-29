import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Write a description of class NuevaReceta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NuevaReceta extends JFrame
{
    private Inicio inicio;
    private JButton botonA;
    private JButton botonB;
    private JLabel label1;
    private JTextField nombre;
    private JLabel label2;
    private JTextArea ingredientes;
    private JLabel label3;
    private JTextArea procedimiento;
    
    public NuevaReceta(Inicio ini){
        inicio = ini; 
        botonA = new JButton("Atras");
        botonB = new JButton("Guardar");
        label1 = new JLabel("Nombre");
        nombre = new JTextField();
        label2 = new JLabel ("Ingredientes");
        ingredientes = new JTextArea();
        label3 = new JLabel("Procedimiento");
        procedimiento = new JTextArea();
        configurarPantalla();
    }
    
    private void configurarPantalla(){
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.pink);
        
        botonA.setBounds(75,425,75,25);
        botonA.setFont(new Font("bertilda",Font.BOLD, 10));
        botonA.setBackground(new Color(220,208,255));
        add(botonA);
        
        botonB.setBounds(350,425,75,25);
        botonB.setFont(new Font("bertilda",Font.BOLD, 10));
        botonB.setBackground(new Color(220,208,255));
        add(botonB);
        
        label1.setBounds(15,5,450,25);
        label1.setFont(new Font("bertilda",Font.BOLD, 10));
        label1.setBackground(Color.pink);
        add(label1);
        
        nombre.setBounds(15,35,450,25);
        nombre.setFont(new Font("bertilda",Font.BOLD, 10));
        add(nombre);
        
        label2.setBounds(15,65,450,25);
        label2.setFont(new Font("bertilda",Font.BOLD, 10));
        label2.setBackground(Color.pink);
        add(label2);
        
        ingredientes.setBounds(15,95,450,135);
        ingredientes.setFont(new Font("bertilda",Font.BOLD, 10));
        add(ingredientes);
        
        label3.setBounds(15,235,450,25);
        label3.setFont(new Font("bertilda",Font.BOLD, 10));
        label3.setBackground(Color.pink);
        add(label3);
        
        procedimiento.setBounds(15,260,450,150);
        procedimiento.setFont(new Font("bertilda",Font.BOLD, 10));
        add(procedimiento);
        
        botonA.addActionListener(new botonNA());
        botonB.addActionListener(new botonNB());
    }
    
    private class botonNA implements ActionListener{
        public void actionPerformed(ActionEvent e){
            inicio.setVisible(true);
            dispose();
        }
    }
    
    private class botonNB implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(inicio.guardarReceta(new Receta(nombre.getText(), ingredientes.getText(), procedimiento.getText()))){
                inicio.setVisible(true);
                dispose();
            }
        }
    }
}
