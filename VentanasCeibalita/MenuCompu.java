package COMPU;
import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class MenuCompu  extends JFrame{
	
		 public MenuCompu() {
		       
			 			//Ventana
			 	        setTitle("Biblioteca Liceo Prof. Álvaro Figueredo");
			 	        setSize(1000, 600);
			 	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 	        setLocationRelativeTo(null);
			 	        setLayout(new BorderLayout());
			 	        
			 	        GestorCompu gestor = new GestorCompu();
			 	        
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
			 	      btnSalir.addActionListener(new ActionListener() {
			                @Override
			                public void actionPerformed(ActionEvent e) {
			                    dispose(); // cierra la ventana actual
			                  //  Gestor.ventana(); // abre la otra ventana
			                }
			            });
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

			 	        
			 	       
			 	    
			 	        
			 //------------------------------------------------------------------------------------------------------------
			 	        
			 	        
			 	        // Panel central 
			 	        String[] columnas = {"ID Compu", "Prestamo"};
			 	        
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
			 	       btnAgregar.addActionListener(new ActionListener() {
			 	           @Override
			 	            public void actionPerformed(ActionEvent e) {

			 	                JTextField IDField = new JTextField();
			 	                JTextField PrstadoField = new JTextField();
			 	                
			 	               // JCheckBox prestadoCheck = new JCheckBox("Prestado");

			 	                JPanel panel = new JPanel(new GridLayout(0, 1));
			 	                panel.add(new JLabel("ID:"));
			 	                panel.add(IDField);
			 	                panel.add(new JLabel("Prestado:"));
			 	                panel.add(PrstadoField);
			 	              //  panel.add(prestadoCheck);

			 	               Object[] options = {"Añadir"};
			 	              int result = JOptionPane.showOptionDialog(null, panel, "Añadir Computadora",
			 	                      JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
			 	                      null, options, options[0]);

			 	              if (result == 0) { // El usuario presionó "Añadir"
			 	                  try {
			 	                      String isbn = IDField.getText();
			 	                      computadoras nuevo = new computadoras(isbn, rootPaneCheckingEnabled);

			 	                      modelo.addRow(new Object[]{
			 	                              nuevo.getId(),
			 	                              
			 	                      });

			 	                  } catch (NumberFormatException ex) {
			 	                      JOptionPane.showMessageDialog(null, "Vuelvelo a intentar :´] ");
			 	                  }
			 	              }

			 	            }
			 	      });
			 	 
			 	        //-------------------------------------------------------------------------------------------------------------------------
			 	        
			 	  // ACCION BOTON PRESTAMO
			 	        btnPrestamo.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
							
							
							JPanel panelPrestamo = new JPanel(new GridLayout(0,1));
							
							JTextField txtNombre = new JTextField();
			 	                JTextField txtApellido = new JTextField();
			 	                JTextField txtCi = new JTextField();
			 	                JTextField txtNroTel = new JTextField();
			 	                JTextField txtMateria = new JTextField();
			 	                JTextField txtGrupo = new JTextField();
			 	                JTextField txtIsbn = new JTextField();
			 	                
			 	                panelPrestamo.add(new JLabel("Nombre:"));
			 	                panelPrestamo.add(txtNombre);
			 	                panelPrestamo.add(new JLabel("Apellido:"));
			 	                panelPrestamo.add(txtApellido);
			 	                panelPrestamo.add(new JLabel("CI:"));
			 	                panelPrestamo.add(txtCi);
			 	                panelPrestamo.add(new JLabel("Nro Telefono:"));
			 	                panelPrestamo.add(txtNroTel);
			 	                panelPrestamo.add(new JLabel("Materia:"));
			 	                panelPrestamo.add(txtMateria);
			 	                panelPrestamo.add(new JLabel("Grupo:"));
			 	                panelPrestamo.add(txtGrupo);

			 	                int result = JOptionPane.showConfirmDialog(null, panelPrestamo,
			 	                        "Hacer Prestamo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

			 	                if (result == JOptionPane.OK_OPTION) {
			 	                    try {
			 	                        String nombre = txtNombre.getText();
			 	                        String apellido = txtApellido.getText();
			 	                        int ci = Integer.parseInt(txtCi.getText());
			 	                        int nroTel = Integer.parseInt(txtNroTel.getText());
			 	                        String materia = txtMateria.getText();
			 	                        String grupo = txtGrupo.getText();
			 	                        int isbn = Integer.parseInt(txtIsbn.getText());

			 	                        
			 	                        solicitante nuevo = new solicitante(nombre,apellido,ci,nroTel,materia,grupo,isbn);

			 	                        modelo.addRow(new Object[]{
			 	                                nuevo.getNombre(),
			 	                                nuevo.getApellido(),
			 	                                nuevo.getCi(),
			 	                                nuevo.getNroTel(),
			 	                                nuevo.getMateria(),
			 	                                nuevo.getGrupo(),
			 	                                nuevo.getIsbn()
			 	                        });

			 	                    } catch (NumberFormatException ex) {
			 	                        JOptionPane.showMessageDialog(null, "Vuelvelo a intentar :´] ");
			 	                    }
			 	                }						
							}
						});
			 	        
			 	        //---------------------------------------------------------------------------------------------------
			 	      
			 	   //ACCION BOTON DEVOLUCION
			 	        btnDevolucion.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								JPanel panelDevolucion = new JPanel(new GridLayout(0,1));
						 	       panelDevolucion.setBackground(new Color(186, 255, 255));
								
								
								
									JComboBox cmbCi = new JComboBox();
									JComboBox cmbCompu = new JComboBox();

									
				 	                panelDevolucion.add(new JLabel("CI:"));
				 	                panelDevolucion.add(cmbCi);
				 	                panelDevolucion.add(new JLabel("ID Commputadora:"));
				 	                panelDevolucion.add(cmbCompu);
				 	              

				 	                int result = JOptionPane.showConfirmDialog(null, panelDevolucion,
				 	                        "Hacer Devolucion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

				 	                if (result == JOptionPane.OK_OPTION) {
				 	                    try {
				 	                       add(panelDevolucion);

				 	                    } catch (NumberFormatException ex) {
				 	                        JOptionPane.showMessageDialog(null, "Vuelvelo a intentar :´] ");
				 	                    }
				 	                }							
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
			 	       
			 	   // Panel Izquierdo

			 	      // ------ Logo arriba ------
			 	      JLabel logo = new JLabel(new ImageIcon("logo2.png"));
			 	      logo.setAlignmentX(Component.CENTER_ALIGNMENT); // centrar
			 	      panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 20))); // margen superior
			 	      panelIzquierdo.add(logo);
			 	      panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 30))); // espacio entre logo y botó

			 	        
			 	        
			 	    }
	   
			 	        
			 	 }