package zPrimerEntrega;

import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	
import javax.swing.table.DefaultTableModel;
public class Ventana7  extends JFrame{
	
	Main2 Gestor = new Main2();
	
		 public Ventana7() {
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
			 			 	      
			 				 	  JButton btnCeibalita = new JButton("Ceibalita"); // reemplaza "Libro"
			 				 	  btnCeibalita.setFont(new Font("Arial", Font.BOLD, 15));
			 				 	  btnCeibalita.setBackground(new Color(186, 255, 255));
			 				 	  btnCeibalita.setAlignmentX(Component.CENTER_ALIGNMENT);
			 				 	  btnCeibalita.setMaximumSize(new Dimension(150, 40));
			 				 	  btnCeibalita.setForeground(Color.BLACK);
			 				 	  btnCeibalita.setBorder(new Borde(9));
			 				 	  panelIzquierdo.add(btnCeibalita);

			 				 	  panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 200))); // espacio arriba
			 			 	      panelIzquierdo.add(btnCeibalita);
			 			 	      panelIzquierdo.add(Box.createVerticalGlue());
			 				 	  
			 			 	      JButton btnSalir = new JButton("Salir");
			 			 	      btnSalir.setFont(new Font("Arial", Font.BOLD, 15));
			 			 	      btnSalir.setBackground(new Color(186, 255, 255));
			 			 	      btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
			 			 	      btnSalir.setMaximumSize(new Dimension(150, 40));
			 			 	      btnSalir.setForeground(Color.BLACK);
			 			 	      btnSalir.setBorder(new Borde(9));
			 			 	      panelIzquierdo.add(btnSalir);
			 			 	      
			 			 	     
			 			 	      panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 10))); // margen inferior
			 			 	       
			 			 	    

			 			 	       panelIzquierdo.add(btnSalir);
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
			 			 	      	btnPrestamo.setBorder(new Borde(9));
			 			 	      	
			 			 	      	panelSuperior.add(btnPrestamo);
			 			 	      	
			 			 	      	//---------Boton devolución---------
			 			 	      	JButton btnDevolucion = new JButton("Devolución");
			 			 	      	
			 			 	      	btnDevolucion.setFont(new Font("Arial", Font.BOLD, 15));
			 			 	      	btnDevolucion.setBackground(new Color(95, 152, 129));
			 			 	      	btnDevolucion.setForeground(Color.BLACK);
			 			 	      	btnDevolucion.setBorder(new Borde(9));
			 			 	      	
			 			 	      	
			 			 	      	panelSuperior.add(btnDevolucion);
			 			 	      	
			 			 	      	panelSuperior.add(Box.createRigidArea(new Dimension(390, 0))); // espaciado
			 			 	      	panelSuperior.add(Box.createHorizontalGlue());
			 			 	      
			 			 	      	//-------Boton agregar-------
			 			 	      	JButton btnAgregar = new JButton("+");
			 			 	      	
			 			 	      	btnAgregar.setFont(new Font("Arial", Font.BOLD, 18));
			 			 	      	btnAgregar.setBackground(new Color(95, 152, 129));     // mismo verde del borde
			 			 	      	btnAgregar.setForeground(Color.BLACK);
			 			 	      	btnAgregar.setBorder(new Borde(9));
			 			 	      	
			 			 	      	panelSuperior.add(btnAgregar);

			 			 	      	
			 			 	      	//-------- Boton tacho-------
			 			 	      	JButton btnEliminar = new JButton("-"); // icono de tacho (no esta funcionando)
			 			 	      	
			 			 	      	btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
			 			 	      	btnEliminar.setBackground(new Color(95,152,129));
			 			 	      	btnEliminar.setForeground(Color.BLACK);
			 			 	      	btnEliminar.setBorder(new Borde(9));
			 			 	      	
			 			 	        panelSuperior.add(btnEliminar);
			 			 	   
			 			 	        
			 			 	        //-------Actualizar--------
			 			 	        
			 			 	      JButton btnActualizar = new JButton("Actializar");
			 			 	      	
			 			 	    btnActualizar.setFont(new Font("Arial", Font.BOLD, 18));
			 			 	  btnActualizar.setBackground(new Color(95, 152, 129));     // mismo verde del borde
			 			 	btnActualizar.setForeground(Color.BLACK);
			 			 	btnActualizar.setBorder(new Borde(9));
			 			 	      	
			 			 	      	panelSuperior.add(btnActualizar);

			 			 	      
			 			 	        
			 			 //------------------------------------------------------------------------------------------------------------
			 			 	        
			 			 	        
			 			 	        // Panel central 
			 			 	        String[] columnas = {"ID Compu", "Prestamo"};
			 			 	        
			 			 	    // Columnas definidas
			 			 	       DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
			 			 	        
			 			 	       btnActualizar.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											Gestor.listarLibro(modelo);
											
										}
									}); 
			 			 	       
			 			 	       
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
			 			 	      //ACCION BOTON AÑADIR
			 			 	        
			 			 	        btnAgregar.addActionListener(new ActionListener() {
			 			 	           @Override
			 			 	            public void actionPerformed(ActionEvent e) {

			 			 	                Gestor.ventana10();
			 			 	                
			 			 	         } 
						 	        });
			 			 	        
			 			 	     // ACCION BOTON PRESTAMO 
						 	        btnPrestamo.addActionListener(new ActionListener() { 
										@Override
										public void actionPerformed(ActionEvent e) {
										
										    Gestor.ventana8();
										} 
						 	        }); 

			 			 	      
						 	       //ACCION BOTON DEVOLUCION
						 	        btnDevolucion.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											
										    Gestor.ventana9();
										    
										} 
						 	        });
									
			 			 	//---------------------------------------------------------------------------------------------------------     	
			 			 	       
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
			 			 	       
			 			 	  

			 			 	      // ------ Logo arriba ------
			 			 	      JLabel logo = new JLabel(new ImageIcon("logo2.png"));
			 			 	      logo.setAlignmentX(Component.CENTER_ALIGNMENT); // centrar
			 			 	      panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 20))); // margen superior
			 			 	      panelIzquierdo.add(logo);
			 			 	      panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 30))); // espacio entre logo y botó

			 			 	        
			 			 	        
			 			 	    }
						 	        
			 			 	        
						 	        }