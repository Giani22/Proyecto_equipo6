package ventana2;

import javax.swing.*;
import java.awt.*;

public class ventana2 extends JFrame{

	public ventana2() {
		
	
		//ventana
		this.setTitle("Biblioteca Liceo Prof. Álvaro Figueredo");
			this.setSize(1000,600);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			getContentPane().setBackground(new Color(0, 109, 109)); //fondo verde
			
		//----------------------------------------------------------------------------------------------------------
			JPanel panel1 = new JPanel();
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
			panel1.setBackground(new Color(0, 109, 109));

			panel1.setPreferredSize(new Dimension(1000, 600));
			panel1.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
			panel1.setMinimumSize(new Dimension(1000, 600));

			add(panel1); 
       		
    //--------------------------------------------------------------------------------------------------------------   	 
       	
    // Panel izquierdo 
       JPanel panelIzquierdo = new JPanel();
       		panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
       		panelIzquierdo.setBackground(new Color(0, 109, 109));
       		panelIzquierdo.setPreferredSize(new Dimension(200, 600));
       		panelIzquierdo.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
       	
       		
       	//----------------------------------------------------------------------------------------------------------

       	// Logo
       		/*
       		JFrame frame = new JFrame("Mostrar Imagen");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            // Cargar la imagen
            ImageIcon imagen = new ImageIcon("imagen.png");

            // Crear un JLabel y agregar la imagen
            JLabel etiqueta = new JLabel(imagen);
            frame.add(etiqueta);

       		
	        ImageIcon icono = new ImageIcon("imagenes/logo.png"); 
	        Image img = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	        JLabel logo = new JLabel(new ImageIcon(img));
	        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
	        panel2.add(Box.createRigidArea(new Dimension(0, 20))); // espacio vertical
	        */

       	//----------------------------------------------------------------------------------------------------------
       		
       // ----Botones del menú----
       		
       		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 200))); //los mueve hacia a bajo
       		
       		panelIzquierdo.add(crearBoton("Libro"));
       		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 10)));
       		panelIzquierdo.add(crearBoton("Ceibalita"));
       		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 10)));
       		panelIzquierdo.add(crearBoton("Impresión"));
       		panelIzquierdo.add(Box.createVerticalGlue());
       
       //----- Boton salir -----
       JButton btnSalir = new JButton("SALIR");
       		btnSalir.setFont(new Font("Arial", Font.BOLD, 15));
       		btnSalir.setBackground(new Color (186, 255, 255));
       		btnSalir.setForeground(Color.BLACK);
       		btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
       		btnSalir.setMaximumSize(new Dimension(150, 40));
       		btnSalir.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       		btnSalir.setBorder(new Borde(9));
       		
       		
       		panelIzquierdo.add(btnSalir);
       		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 20)));
       		
       		
       	//----------------------------------------------------------------------------------------------------------

       // -----Panel Central (contenido vacio por ahora)-----
       JPanel panelCentral = new JPanel();
       		panelCentral.setBackground(new Color(0, 109, 109));
       		panelCentral.setPreferredSize(new Dimension(800, 600));

       
       		panel1.add(panelIzquierdo, BorderLayout.WEST);
       	
       		panel1.add(panelCentral, BorderLayout.CENTER);
   }

			private JButton crearBoton(String texto) {
					JButton boton = new JButton(texto);
					boton.setFont(new Font("Arial", Font.BOLD, 15));
					boton.setBackground(new Color (206, 253, 255));
					boton.setForeground(Color.BLACK);
					boton.setAlignmentX(Component.CENTER_ALIGNMENT);
					boton.setMaximumSize(new Dimension(150, 40));
					boton.setBorder(new Borde(9));
       		
				return boton;
   }

 
}
