package ventana;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inicio extends JFrame {
Logica Gestor = new Logica();
	    public inicio() {
	    
	    	this.setTitle("Biblioteca Liceo Prof. Álvaro Figueredo");
		       //this.setSize(1000, 600);
		       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       this.setLocationRelativeTo(null);
		       this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		       getContentPane().setBackground(new Color(0, 109, 109)); //fondo verde
	    	
		       
		    //----------------------------------------------------------------------------------------------------------------   
		       
		       
	    	//-----panel---------
		       JPanel panel1 = new JPanel();
		        panel1.setBackground(new Color(0, 109, 109)); // igual que fondo
		        panel1.setLayout(new GridBagLayout());
		        add(panel1); //206, 253, 255 //color de el cuadro donde estan las palabras
		        
		   //-------------------------------------------------------------------------------------------------------------------     
		        
		    //--------iniciar sesión------
		        
		        JPanel panelCentral = new JPanel();
		        panelCentral.setBackground(new Color(206, 253, 255));
		        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		        panelCentral.setBorder(BorderFactory.createCompoundBorder(
		                BorderFactory.createLineBorder(Color.BLACK), // borde negro
		                BorderFactory.createEmptyBorder(20, 20, 20, 20))); // padding interno
		        panelCentral.setPreferredSize(new Dimension(300, 400)); // mas alto verticalmente
		        
		        
		        
		  //-----------------------------------------------------------------------------------------------------------------------   
		 /*    // ---------Logo--------
		        ImageIcon icono = new ImageIcon("imagenes/logo.png"); 
		        Image img = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		        JLabel logo = new JLabel(new ImageIcon(img));
		        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
		        panelCentral.add(Box.createRigidArea(new Dimension(0, 20))); // espacio vertical
		        
		    */
		  
		  //--------------------------------------------------------------------------------------------------------------------
		     
		        // ------Contraseña--------
		        JLabel label = new JLabel("Contraseña");
		        label.setFont(new Font("Arial", Font.BOLD, 16));
		        label.setForeground(Color.BLACK);
		        label.setAlignmentX(Component.CENTER_ALIGNMENT);
		        
		        panelCentral.add(label);
		        
		        panelCentral.add(Box.createRigidArea(new Dimension(0, 10)));

		  
		        
		        //------ Ingreso contraseña---------
		        JPasswordField contra = new JPasswordField(15);
		        contra.setMaximumSize(new Dimension(200, 30));
		        contra.setBackground(new Color(32, 183, 188));
		        contra.setForeground(Color.BLACK);
		        contra.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		        contra.setEchoChar('*');
		        contra.setAlignmentX(Component.CENTER_ALIGNMENT);
		        panelCentral.add(contra);
		        panelCentral.add(Box.createRigidArea(new Dimension(0, 20)));

		        
		//-------------------------------------------------------------------------------------------------------------------------        
		        
		        //------- Boton ingresar--------
		        JButton btn = new JButton("Aceptar");
		        btn.setFont(new Font("Arial", Font.BOLD, 15));
		        btn.setBackground(new Color(32, 183, 188));
		        btn.setForeground(Color.BLACK);
		        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		        btn.setBorder(new Borde(6));
		        panelCentral.add(btn);

		        panelCentral.add(Box.createVerticalGlue());
		        
		        
						 btn.addActionListener(new ActionListener() {
					        	//contraseña predefinda
					        	String contraseña = "pepe";
						        String ingresada = new String(contra.getPassword());
								@Override
								public void actionPerformed(ActionEvent e) {
									String ingresada = new String(contra.getPassword());
									if (ingresada.equals(contraseña)) {				      
							            dispose();
										Gestor.V2();
							        } else {
							            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
							        }
								}
				});
		        
		        panel1.add(panelCentral);
		//-----------------------------------------------------------------------------------------------------------------
		      
		        panelCentral.add(Box.createVerticalGlue()); // empuja hacia abajo los componentes
		        panelCentral.add(label);
		        panelCentral.add(Box.createRigidArea(new Dimension(0, 10)));
		        panelCentral.add(contra);
		        panelCentral.add(Box.createRigidArea(new Dimension(0, 20)));
		        panelCentral.add(btn);
		        panelCentral.add(Box.createVerticalGlue()); // empuja hacia arriba el resto
		        
		        panel1.add(panelCentral);
	    	
	    	//------------------------------------------------------
		        
		     
  
	    }
	
}
