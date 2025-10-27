package ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PrestamoCeib extends JFrame{

	Logica Gestor = new Logica();
    public PrestamoCeib() {
    	 
        setTitle("Préstamo");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1));
    	JFrame aviso = new JFrame();	

        
    	panel.add(new JLabel("CI:"));
    	JTextField txtCi = new JTextField();
    	panel.add(txtCi);      
        panel.add(new JLabel("Nombre:"));
        	JTextField txtNombre = new JTextField();
        panel.add(txtNombre);
        panel.add(new JLabel("Apellido:"));
        	JTextField txtApellido = new JTextField();
        panel.add(txtApellido);  
        panel.add(new JLabel("Materia:"));
        	JTextField txtMateria = new JTextField();
        panel.add(txtMateria);
        panel.add(new JLabel("Grupo:"));
        	JTextField txtGrupo = new JTextField();
        panel.add(txtGrupo);
        panel.add(new JLabel("Numero:"));
        	JTextField txtNumero = new JTextField();
        panel.add(txtNumero);
        
        JButton btnPrestar = new JButton("Prestar");
        btnPrestar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 int ci = Integer.parseInt(txtCi.getText());
				 int numero = Integer.parseInt(txtNumero.getText());
				  
				  
				  Solicitante2 soli2 = new Solicitante2(ci ,txtNombre.getText(), txtApellido.getText(),  txtMateria.getText(), txtGrupo.getText(), numero);
				  
				  if(Gestor.guardarPrestamoCeib(soli2)){
				
					  
						JOptionPane.showMessageDialog(aviso, "¡Guardado!");
						}
				
			}
			});
        
		//Gestor.regisLibro(getName(), getName(), getTitle(), getWarningString(), getName(), ABORT);


        panel.add(btnPrestar);

        add(panel);
        }
    }