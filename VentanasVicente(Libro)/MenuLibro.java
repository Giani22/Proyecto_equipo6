package MenuLibro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

import Ventana3.Borde;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MenuLibro extends JFrame{
	GestorDeVentanas Gestor = new GestorDeVentanas();	
	 public MenuLibro() {
	       
		 			//Ventana
		 	        setTitle("Biblioteca Liceo Prof. Álvaro Figueredo");
		 	        setSize(1000, 600);
		 	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 	        setLocationRelativeTo(null);
		 	        setLayout(new BorderLayout());
		 	        
		 	        GestorDeVentanas gestor = new GestorDeVentanas();
		 	        
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
		 	       panelIzquierdo.add(Box.createVerticalGlue()); // empuja los demás hacia abajo

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
		 	      	btnPrestamo.setBorder(new Borde(9));
		 	      	
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
		 	      	JButton btnEliminar = new JButton("Eliminar"); // icono de tacho (no esta funcionando)
		 	      	
		 	      	btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		 	      	btnEliminar.setBackground(new Color(95,152,129));
		 	      	btnEliminar.setForeground(Color.BLACK);
		 	      	btnEliminar.setBorder(new Borde(9));
		 	      	
		 	        panelSuperior.add(btnEliminar);
		 	        
		 	       
		 	        
		 	       
		 	    
		 	        
		 //------------------------------------------------------------------------------------------------------------
		 	        
		 	        
		 	        // Panel central 
		 	        String[] columnas = {"ISBN", "Titulo", "Autor", "País", "Materia", "Copias", "Prestado"};
		 	        
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

		 	                JTextField isbnField = new JTextField();
		 	                JTextField tituloField = new JTextField();
		 	                JTextField autorField = new JTextField();
		 	                JTextField paisField = new JTextField();
		 	                JTextField materiaField = new JTextField();
		 	                JTextField copiasField = new JTextField();
		 	                JCheckBox prestadoCheck = new JCheckBox("Prestado");

		 	                JPanel panel = new JPanel(new GridLayout(0, 1));
		 	                panel.add(new JLabel("ISBN:"));
		 	                panel.add(isbnField);
		 	                panel.add(new JLabel("Titulo:"));
		 	                panel.add(tituloField);
		 	                panel.add(new JLabel("Autor:"));
		 	                panel.add(autorField);
		 	                panel.add(new JLabel("Pais origen:"));
		 	                panel.add(paisField);
		 	                panel.add(new JLabel("Materia:"));
		 	                panel.add(materiaField);
		 	                panel.add(new JLabel("Copias:"));
		 	                panel.add(copiasField);
		 	                panel.add(prestadoCheck);

		 	                int result = JOptionPane.showConfirmDialog(null, panel,
		 	                        "Añadir Libro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		 	                if (result == JOptionPane.OK_OPTION) {
		 	                    try {
		 	                        String isbn = isbnField.getText();
		 	                        String titulo = tituloField.getText();
		 	                        String autor = autorField.getText();
		 	                        String pais = paisField.getText();
		 	                        String materia = materiaField.getText();
		 	                        int copias = Integer.parseInt(copiasField.getText());
		 	                        boolean prestado = prestadoCheck.isSelected();

		 	                        Libro nuevo = new Libro(isbn, titulo, autor, pais, materia, copias, prestado);

		 	                        modelo.addRow(new Object[]{
		 	                                nuevo.getIsbn(),
		 	                                nuevo.getTitulo(),
		 	                                nuevo.getAutor(),
		 	                                nuevo.getPais(),
		 	                                nuevo.getMateria(),
		 	                                nuevo.getCopias(),
		 	                                nuevo.isPrestado()
		 	                        });

		 	                    } catch (NumberFormatException ex) {
		 	                        JOptionPane.showMessageDialog(null, "Vuelvelo a intentar :´] ");
		 	                    }
		 	                }
		 	            }
		 	        });
		 	 
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

		 	                        
		 	                        Solicitante nuevo = new Solicitante(nombre,apellido,ci,nroTel,materia,grupo,isbn);

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
		 	      
		 	   //ACCION BOTON DEVOLUCION
		 	        btnDevolucion.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							JPanel panelDevolucion = new JPanel(new GridLayout(0,1));
					 	       panelDevolucion.setBackground(new Color(186, 255, 255));
							
							
							
								JComboBox cmbCi = new JComboBox();
								JComboBox cmbIsbn = new JComboBox();

								
			 	                panelDevolucion.add(new JLabel("CI:"));
			 	                panelDevolucion.add(cmbCi);
			 	                panelDevolucion.add(new JLabel("ISBN:"));
			 	                panelDevolucion.add(cmbIsbn);
			 	              

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
		 	      
		 	        // Panel principal
		 	        
		 	        
		 	        
		 	        
		 	       add(panelIzquierdo, BorderLayout.WEST);   // cubre toda la altura
		 	       add(panelCentroCompleto, BorderLayout.CENTER); // superior + tabla
		 	        
		 	        
		 	      //  add(panelSuperior, BorderLayout.NORTH);
		 	       // add(panelTabla, BorderLayout.CENTER);
		 	       	        
		 	        //Logo
		 	        JLabel logo = new JLabel(new ImageIcon("logo.png"));
		 	        logo.setBounds(0, 0, 150, 150);
		 	        panelIzquierdo.add(logo);
		 	        
		 	        //Fin de la tabla 1
		 	        
		 	        
		 	    }
   
		 	        

		 	 }
