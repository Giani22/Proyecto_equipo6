package ventana;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AñadirLibro extends JFrame {
Logica Gestor = new Logica();
    public AñadirLibro() {
    	
    	
    	
        setTitle("Añadir Libro");
        setSize(300, 300);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        
        
        JPanel panel = new JPanel(new GridLayout(0, 1));

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
        
  
        btnAgregar.addActionListener(new ActionListener() {
			
        	@Override
			public void actionPerformed(ActionEvent e) {
                
               
                if (txtCopias.getText().isEmpty() || txtIsbn.getText().isEmpty()) {
                     JOptionPane.showMessageDialog(AñadirLibro.this, "El ISBN y las copias no pueden estar vacíos.", "Validación", JOptionPane.WARNING_MESSAGE);
                     return;
                }

             
                try {
                  
                    int copias = Integer.parseInt(txtCopias.getText());
                    
                   
                    Libro lib = new Libro(txtIsbn.getText(), txtTitulo.getText(), txtAutor.getText(), txtMateria.getText(), copias);
                    
                   
                    if (Gestor.guardarLibro(lib)) {
                        JOptionPane.showMessageDialog(AñadirLibro.this, "¡Libro guardado con éxito!", "Guardado", JOptionPane.INFORMATION_MESSAGE);
                        
                       
                        txtIsbn.setText("");
                        txtTitulo.setText("");
                        txtAutor.setText("");
                        txtMateria.setText("");
                        txtCopias.setText("");
                        
					} else {
                       
                        JOptionPane.showMessageDialog(AñadirLibro.this, "Error al guardar el libro en la lógica.", "Error", JOptionPane.ERROR_MESSAGE);
					}
                
                
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AñadirLibro.this, 
                                                  "Por favor, introduce un número entero válido en el campo 'Copias'.", 
                                                  "Error de Formato", 
                                                  JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                   
                    JOptionPane.showMessageDialog(AñadirLibro.this, 
                                                  "Ocurrió un error inesperado: " + ex.getMessage(), 
                                                  "Error General", 
                                                  JOptionPane.ERROR_MESSAGE);
                }
			}
		});
        
        panel.add(btnAgregar);

        add(panel);
        
    }
}