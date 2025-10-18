package ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AñadirCeib extends JFrame {
Logica Gestor = new Logica();
   public AñadirCeib() {
   	
       setTitle("Añadir");
       setSize(300, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   		JFrame aviso = new JFrame();	
   		
   		
       JPanel panel = new JPanel(new GridLayout(0, 1));
       JTextField txtId = new JTextField();
       
       panel.add(new JLabel("ID:"));
       panel.add(txtId);

       JButton btnAñadirCei = new JButton("Añadir");
       
       
       
       btnAñadirCei.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			  int numero = Integer.parseInt(txtId.getText());
			
			  
			  Datos_Laptops ceibal = new Datos_Laptops(numero);
			  
			  if(Gestor.guardarCeibalita(ceibal)) {
					JOptionPane.showMessageDialog(aviso, "¡Guardado!");
					}
				
			}
		});

       panel.add(btnAñadirCei);

       add(panel);
   }
}