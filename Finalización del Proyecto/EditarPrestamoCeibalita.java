package ventana;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditarPrestamoCeibalita extends JFrame{

	
	   private JTextField textId;
	   private JTextField textCI; 
	    private JTextField textNombre; 
	    private JTextField textApellido; 
	    private JTextField textMateria; 
	    private JTextField textGrupo; 
	    private JTextField textNumero; 
	    
	    private JButton botonGuardar; 
	    
	    private int idOriginal;
	    private int ciOriginal;
	    private String numeroOriginal;
	    
	    public EditarPrestamoCeibalita(Logica gestor, Solicitante5 prestamo) {
	        
	    	this.idOriginal = prestamo.getId();
	        this.ciOriginal = prestamo.getCi(); 
	        this.numeroOriginal = prestamo.getNumero();
	        
	        setTitle("Editar Préstamo");
	        setSize(250, 400); 
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setLocationRelativeTo(null);
	      
	        
	        setLayout(new GridLayout(14, 10, 0, 0));
	        
	        textId = new JTextField(String.valueOf(prestamo.getId()));
	        textId.setEditable(false); 
	       
	        textCI = new JTextField(String.valueOf(prestamo.getCi()));
	        textCI.setEditable(false);
	        
	        
	        textNumero = new JTextField(prestamo.getNumero()); 
	        textNumero.setEditable(false); 

	        
	       
	        textNombre = new JTextField(prestamo.getNombre());
	        textApellido = new JTextField(prestamo.getApellido());
	        textMateria = new JTextField(prestamo.getMateria());
	        textGrupo = new JTextField(prestamo.getGrupo());
	        
	       
	        botonGuardar = new JButton("Guardar cambios");
	        
	        
	        add(new JLabel("ID:"));
	        add(textId);
	        add(new JLabel("CI:"));
	        add(textCI);
	        add(new JLabel("Nombre:"));
	        add(textNombre);
	        add(new JLabel("Apellido:"));
	        add(textApellido);
	        add(new JLabel("Materia:"));
	        add(textMateria);
	        add(new JLabel("Grupo:"));
	        add(textGrupo);
	        add(new JLabel("Numero:"));
	        add(textNumero);
	        add(new JPanel()); 
	        add(botonGuardar);
	        
	        
	        botonGuardar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                
	              
	                
	                String nombre = textNombre.getText().trim();
	                String apellido = textApellido.getText().trim();
	                String materia = textMateria.getText().trim();
	                String grupo = textGrupo.getText().trim();
	                
	                int id = idOriginal; 
	                int ci = ciOriginal; 
	                String numero = numeroOriginal; 
	              
	                try {
	                  
	                   
	                    if (nombre.isEmpty() || apellido.isEmpty() || materia.isEmpty() || grupo.isEmpty()) {
	                        JOptionPane.showMessageDialog(EditarPrestamoCeibalita.this, "Todos los campos deben estar llenos.", "Validación", JOptionPane.WARNING_MESSAGE);
	                        return;
	                    }

	                    
	                    
	                    gestor.modificarPrestamoCeibalita(idOriginal, ciOriginal, nombre, apellido, materia, grupo, numeroOriginal);
	                    
	                    JOptionPane.showMessageDialog(EditarPrestamoCeibalita.this, "Préstamo actualizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	                    dispose(); 

	                } catch (Exception ex) {
	                    JOptionPane.showMessageDialog(EditarPrestamoCeibalita.this, "Error al actualizar el préstamo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	                    ex.printStackTrace();
	                }
	            }
	        });

	       
	        
	    }     
}
