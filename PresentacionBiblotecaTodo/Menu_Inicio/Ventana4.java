package ventana2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana4 extends JFrame {

    public Ventana4() {
    	
    	
    	
        setTitle("Añadir Libro");
        setSize(300, 300);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        
        
        JPanel panel = new JPanel(new GridLayout(0, 1));

        
   
        panel.add(new JLabel("ISBN:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Título:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Autor:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Materia:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Copias:"));
        panel.add(new JTextField());

        JButton btnAgregar = new JButton("Añadir");
        
   //     Main2.registLibro = {ISBN, Titulo, Autor,Materia ,Copias};
        btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
        panel.add(btnAgregar);

        add(panel);
    }
}
