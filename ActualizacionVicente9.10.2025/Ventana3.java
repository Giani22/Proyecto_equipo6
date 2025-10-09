package zPrimerEntrega;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana3 extends JFrame{

	Main2 Gestor = new Main2();
		public Ventana3() {
		       
			 
			
			
			 			//Ventana
			 	        setTitle("Biblioteca Liceo Prof. Álvaro Figueredo");
			 	        setSize(1000, 600);
			 	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 	        setLocationRelativeTo(null);
			 	        setLayout(new BorderLayout());
			 	        
			 	      
			 	        
			 //-------------------------------------------------------------------------------------------------------------	        
			 	        
			 	        

			 	        // Panel Izquierdo
			 	        JPanel panelIzquierdo = new JPanel();
			 	        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS)); 		
			 	        panelIzquierdo.setBackground(new Color(0, 109, 109));
			 	        panelIzquierdo.setPreferredSize(new Dimension(200, 600));
			 	        
			 	     //-------Boton Libro-------
			 	       JButton btnLibro = new JButton("Libro");
			 	       btnLibro.setFont(new Font("Arial", Font.BOLD, 15));
			 	       btnLibro.setBackground(new Color (186, 255, 255));
			 	       btnLibro.setAlignmentX(Component.CENTER_ALIGNMENT);
			 	       btnLibro.setMaximumSize(new Dimension(150, 40));
			 	       btnLibro.setForeground(Color.BLACK);
			 	       btnLibro.setBorder(new Borde(9));

			 	       panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 200))); // espacio arriba
			 	       panelIzquierdo.add(btnLibro);
			 	       panelIzquierdo.add(Box.createVerticalGlue()); // empuja los demas hacia abajo

			 	       //------Boton Salir--------
			 	       JButton Salir = new JButton("SALIR");
			 	       Salir.setFont(new Font("Arial", Font.BOLD, 15));
			 	       Salir.setBackground(new Color (186, 255, 255)); 
			 	       Salir.setAlignmentX(Component.CENTER_ALIGNMENT);
			 	       Salir.setMaximumSize(new Dimension(150, 40));
			 	       Salir.setForeground(Color.BLACK);
			 	       Salir.setBorder(new Borde(9));
			 	       
			 	    

			 	       panelIzquierdo.add(Salir);
			 	       panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 20)));
			 	      
			//----------------------------------------------------------------------------------------------------------
			 	      	
			 	       //Panel Superior
			 	       JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
			 	       panelSuperior.setBackground(new Color(186, 255, 255));
			 	        
			 	      	
			 	      
			 	       //------Boton préstamo-------
			 	        JButton btnPrestamo = new JButton("Préstamo");
			 	        
			 	       	btnPrestamo.setFont(new Font("Arial", Font.BOLD, 15));
			 	      	btnPrestamo.setBackground(new Color(95, 152, 129));   // verde claro
			 	      	btnPrestamo.setForeground(Color.BLACK);
			 	      //	btnPrestamo.setBorder(new Borde(9));
			 	      	
			 	      	btnLibro.addActionListener(new ActionListener() {
			                @Override
			                public void actionPerformed(ActionEvent e) {
			                    dispose(); // cierra la ventana actual
			                  //  Gestor.ventana(); // abre la otra ventana
			                }
			            });
			 	      	
			 	      	
			 	      	panelSuperior.add(btnPrestamo);
			 	      	
			 	      	//---------Boton devolución---------
			 	      	JButton btnDevolucion = new JButton("Devolución");
			 	      	
			 	      	btnDevolucion.setFont(new Font("Arial", Font.BOLD, 15));
			 	      	btnDevolucion.setBackground(new Color(95, 152, 129));
			 	      	btnDevolucion.setForeground(Color.BLACK);
			 	     // 	btnDevolucion.setBorder(new Borde(9));
			 	      	
			 	      	
			 	      	panelSuperior.add(btnDevolucion);
			 	      	
			 	      	panelSuperior.add(Box.createRigidArea(new Dimension(350, 0))); // espaciado
			 	      	panelSuperior.add(Box.createHorizontalGlue());
			 	      
			 	        
			 	        
			 	      	//-------Boton agregar-------
			 	      	JButton btnAgregar = new JButton("+");
			 	      	
			 	      	btnAgregar.setFont(new Font("Arial", Font.BOLD, 18));
			 	      	btnAgregar.setBackground(new Color(95, 152, 129));     // mismo verde del borde
			 	      	btnAgregar.setForeground(Color.BLACK);
			 	      //	btnAgregar.setBorder(new Borde(9));
			 	      	
			 	      	panelSuperior.add(btnAgregar);

			 	      	
			 	      	//-------- Boton tacho-------
			 	      	JButton btnEliminar = new JButton("-"); 
			 	      	
			 	      	btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
			 	      	btnEliminar.setBackground(new Color(95,152,129));
			 	      	btnEliminar.setForeground(Color.BLACK);
			 	      //	btnEliminar.setBorder(new Borde(9));
			 	      	
			 	        panelSuperior.add(btnEliminar);
			 	        
			 	       
			 	        
			 	       
			 	    
			 	        
			 //------------------------------------------------------------------------------------------------------------
			 	        
			 	        
			 	        // Panel central 
			 	        String[] columnas = {"ISBN", "Titulo", "Autor", "Materia", "Copias", "Prestado"};
			 	        
			 	    // Columnas definidas
			 	       DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
			 	        
			 	        
			 	       JTable tabla = new JTable(modelo);
			 	       tabla.setGridColor(Color.BLACK);     // color de lineas
			 	       tabla.setShowGrid(true);             // mostrar lineas
			 	       tabla.setBackground(new Color(186, 255, 255));
			 	       tabla.getTableHeader().setBackground(new Color(173, 226, 206));
			 	       tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

			 	       JScrollPane scrollTabla = new JScrollPane(tabla);
			 	       scrollTabla.getViewport().setBackground(new Color(186, 255, 255));

			 	       JPanel panelTabla = new JPanel(new BorderLayout());
			 	       panelTabla.setBackground(new Color(186, 255, 255));
			 	       panelTabla.setBorder(BorderFactory.createLineBorder(new Color(95,152,129),2));
			 	       panelTabla.add(scrollTabla, BorderLayout.CENTER);
			 	       
			 	    //-------------------------------------------------------------------------------------------------------------
			 	        // Contenedor del centro (panel superior + tabla)
			 	       
			 	        JPanel panelCentroCompleto = new JPanel(new BorderLayout());
			 	        panelCentroCompleto.add(panelSuperior, BorderLayout.NORTH);
			 	        panelCentroCompleto.add(panelTabla, BorderLayout.CENTER);
			 	       
			 	   // ------------------------------------------------------------------------------------------------------------
			 	        // Accion del boton "+"
			 	        
			 	       btnAgregar.addActionListener(new ActionListener() {
			 	    	    @Override
			 	    	    public void actionPerformed(ActionEvent e) {
			 	    	    
			 	    	    	Gestor.ventana4();
			 	    	  
			 	    	    
			 	    	    }
			 	    	    });
			 	 
			 	 // boton prestamo
			 	       
			 	      btnPrestamo.addActionListener(new ActionListener() {
			 	    	    @Override
			 	    	    public void actionPerformed(ActionEvent e) {
			 	    	        Gestor.ventana5(); 
			 	    	    }
			 	    	});
					
			 	   // boton devolucion
			 	       
			 	     btnDevolucion.addActionListener(new ActionListener() {
			 	        @Override
			 	        public void actionPerformed(ActionEvent e) {
			 	        
			 	        	Gestor.ventana6();
			 	        	
			 	        } 
			 	        });
								
								
								
							
		//------------------------------------------------------------------------------------------------------------------
			 	        
			 	        //-----Accion del boton eliminar------
			 	        
			 	       btnEliminar.addActionListener(new ActionListener() {
			 	    	    @Override
			 	    	    public void actionPerformed(ActionEvent e) {
			 	    	    	
			 	    	        // obtiene la fila seleccionada
			 	    	        int filaSeleccionada = tabla.getSelectedRow();

			 	    	        if (filaSeleccionada >= 0) { // por si hay fila seleccionada
			 	    	            int confirm = JOptionPane.showConfirmDialog(
			 	    	                    null,
			 	    	                    "¿Deseas eliminar esta fila?",
			 	    	                    "Confirmar eliminación",
			 	    	                    JOptionPane.YES_NO_OPTION,
			 	    	                    JOptionPane.WARNING_MESSAGE
			 	    	            );

			 	    	            if (confirm == JOptionPane.YES_OPTION) {
			 	    	                modelo.removeRow(filaSeleccionada); // Elimina la fila
			 	    	                JOptionPane.showMessageDialog(
			 	    	                        null,
			 	    	                        "Borrado exitosamente",
			 	    	                        "Éxito",
			 	    	                        JOptionPane.INFORMATION_MESSAGE
			 	    	                );
			 	    	            }
			 	    	        } else { // No se seleccionó ninguna fila
			 	    	            JOptionPane.showMessageDialog(
			 	    	                    null,
			 	    	                    "Por favor selecciona una fila para eliminar",
			 	    	                    "Atención",
			 	    	                    JOptionPane.WARNING_MESSAGE
			 	    	            );
			 	    	        }
			 	    	    }
			 	    	});

			 	//---------------------------------------------------------------------------------------------------------     	
			 	      
			 	        // Panel principal
			 	       add(panelIzquierdo, BorderLayout.WEST);   // cubre toda la altura
			 	       add(panelCentroCompleto, BorderLayout.CENTER); // superior + tabla
			 	       	        
			 	        //Logo
			 	        JLabel logo = new JLabel(new ImageIcon("logo.png"));
			 	        logo.setBounds(0, 0, 150, 150);
			 	        panelIzquierdo.add(logo);
			 	        
			 	      
			 	        
			 	      JButton btnListadoLib = new JButton("Listar"); 
			 	      btnListadoLib.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							Gestor.listarLibro(modelo);
						}
					});
			 	      panelSuperior.add(btnListadoLib);
			 	    }
						
			 	        
			 	        
			 	 
}