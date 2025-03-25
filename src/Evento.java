import javax.swing.*;
import java.awt.event.*;
public class Evento extends JFrame implements ActionListener{
    JButton boton1;
    public Evento(){
        setLayout(null);
        boton1=new JButton("Cerrar");
        boton1.setBounds(300,250,100,30);
        add(boton1);
        boton1.addActionListener(this);
        
    }
}
