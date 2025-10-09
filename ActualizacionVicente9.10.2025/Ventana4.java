package zPrimerEntrega;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana4 extends JFrame {
Main2 Gestor = new Main2();
    public Ventana4() {
    	
    	
    	
        setTitle("Añadir Libro");
        setSize(300, 300);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        
        
        JPanel panel = new JPanel(new GridLayout(0, 1));

    	JFrame aviso = new JFrame();	

   
        panel.add(new JLabel("ISBN:"));
        	JTextField txtIsbn = new JTextField();
        panel.add(txtIsbn);
        panel.add(new JLabel("Título:"));
     		JTextField txtTitulo = new JTextField();
        panel.add(txtTitulo);        
        panel.add(new JLabel("Autor:"));
 			JTextField txtAutor = new JTextField();
        panel.add(txtAutor);        
        panel.add(new JLabel("Materia:"));
 		JTextField txtMateria = new JTextField();
        panel.add(txtMateria);        
        panel.add(new JLabel("Copias:"));
 		JTextField txtCopias = new JTextField();
        panel.add(txtCopias);        

        JButton btnAgregar = new JButton("Añadir");
        
   //     Main2.registLibro = {ISBN, Titulo, Autor,Materia ,Copias};
        btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			  int copias = Integer.parseInt(txtCopias.getText());
			  
			  
			  Libro lib = new Libro(txtIsbn.getText(), txtTitulo.getText(), txtAutor.getText(), txtMateria.getText(), copias);
			  
			  if(Gestor.guardarLibro(lib)) {
					JOptionPane.showMessageDialog(aviso, "¡Guardado!");
					}
				//Gestor.regisLibro(getName(), getName(), getTitle(), getWarningString(), getName(), ABORT);
			}
		});
        panel.add(btnAgregar);

        add(panel);
    }
}