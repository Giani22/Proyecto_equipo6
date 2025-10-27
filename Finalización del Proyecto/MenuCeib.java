package ventana;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;

public class MenuCeib extends JFrame {

	Logica Gestor = new Logica();

	public MenuCeib() {
		// Ventana
		setTitle("Biblioteca Liceo Prof. Álvaro Figueredo");
		// setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// -------------------------------------------------------------------------------------------------------------

		// Panel Izquierdo
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
		panelIzquierdo.setBackground(new Color(0, 109, 109));
		panelIzquierdo.setPreferredSize(new Dimension(200, 600));

		// -------Boton Libro-------

		JButton btnCeibalita = new JButton("Ceibalita"); // reemplaza "Libro"
		btnCeibalita.setFont(new Font("Arial", Font.BOLD, 15));
		btnCeibalita.setBackground(new Color(186, 255, 255));
		btnCeibalita.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCeibalita.setMaximumSize(new Dimension(150, 40));
		btnCeibalita.setForeground(Color.BLACK);
		btnCeibalita.setBorder(new Borde(9));

		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 200))); // espacio arriba
		panelIzquierdo.add(btnCeibalita);
		panelIzquierdo.add(Box.createVerticalGlue());

		btnCeibalita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Gestor.ventana7();
			}
		});

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
				dispose();
				Gestor.V2();
			}
		});

		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 10))); // margen inferior

		panelIzquierdo.add(btnSalir);
		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 20)));

		// ----------------------------------------------------------------------------------------------------------

		// Panel Superior
		JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		panelSuperior.setBackground(new Color(186, 255, 255));

		// ------Boton préstamo-------
		JButton btnPrestamo = new JButton("Préstamo");

		btnPrestamo.setFont(new Font("Arial", Font.BOLD, 15));
		btnPrestamo.setBackground(new Color(95, 152, 129)); // verde claro
		btnPrestamo.setForeground(Color.BLACK);
		btnPrestamo.setBorder(new Borde(9));

		panelSuperior.add(btnPrestamo);

		// ---------Boton devolución---------
		JButton btnDevolucion = new JButton("Devolución");

		btnDevolucion.setFont(new Font("Arial", Font.BOLD, 15));
		btnDevolucion.setBackground(new Color(95, 152, 129));
		btnDevolucion.setForeground(Color.BLACK);
		btnDevolucion.setBorder(new Borde(9));

		panelSuperior.add(btnDevolucion);

		panelSuperior.add(Box.createRigidArea(new Dimension(390, 0))); // espaciado
		panelSuperior.add(Box.createHorizontalGlue());

		// -------Boton agregar-------
		JButton btnAgregar = new JButton("+");

		btnAgregar.setFont(new Font("Arial", Font.BOLD, 18));
		btnAgregar.setBackground(new Color(95, 152, 129)); // mismo verde del borde
		btnAgregar.setForeground(Color.BLACK);
		btnAgregar.setBorder(new Borde(9));

		panelSuperior.add(btnAgregar);

		// -------- Boton tacho-------
		JButton btnEliminar = new JButton("-");

		btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEliminar.setBackground(new Color(95, 152, 129));
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setBorder(new Borde(9));

		panelSuperior.add(btnEliminar);

		// ------------------------------------------------------------------------------------------------------------

		// Panel central
		String[] columnas = { "ID Compu" };

		// Columnas definidas
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

		JTable tabla = new JTable(modelo);
		tabla.setGridColor(Color.BLACK); // color de lineas
		tabla.setShowGrid(true); // mostrar lineas
		tabla.setBackground(new Color(186, 255, 255));
		tabla.getTableHeader().setBackground(new Color(173, 226, 206));
		tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

		JScrollPane scrollTabla = new JScrollPane(tabla);
		scrollTabla.getViewport().setBackground(new Color(186, 255, 255));

		JPanel panelTabla = new JPanel(new BorderLayout());
		panelTabla.setBackground(new Color(186, 255, 255));
		panelTabla.setBorder(BorderFactory.createLineBorder(new Color(95, 152, 129), 2));
		panelTabla.add(scrollTabla, BorderLayout.CENTER);

		String[] columnasPres = { "ID","CI", "Nombre", "Apellido", "Materia", "Grupo", "Numero" };

		// Columnas definidas
		DefaultTableModel modeloPres = new DefaultTableModel(columnasPres, 0);

		JTable tablaPres = new JTable(modeloPres);
		tablaPres.setGridColor(Color.BLACK); // color de lineas
		tablaPres.setShowGrid(true); // mostrar lineas
		tablaPres.setBackground(new Color(186, 255, 255));
		tablaPres.getTableHeader().setBackground(new Color(173, 226, 206));
		tablaPres.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

		JScrollPane scrollTablaPres = new JScrollPane(tablaPres);
		scrollTablaPres.getViewport().setBackground(new Color(186, 255, 255));

		JPanel panelTablaPres = new JPanel(new BorderLayout());
		panelTablaPres.setBackground(new Color(186, 255, 255));
		panelTablaPres.setBorder(BorderFactory.createLineBorder(new Color(95, 152, 129), 2));
		panelTablaPres.add(scrollTablaPres, BorderLayout.CENTER);

		JTable tabla1 = new JTable(modelo);
		tabla1.setGridColor(Color.BLACK); // color de lineas
		tabla1.setShowGrid(true); // mostrar lineas
		tabla1.setBackground(new Color(186, 255, 255));
		tabla1.getTableHeader().setBackground(new Color(173, 226, 206));
		tabla1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

		JScrollPane scrollTabla1 = new JScrollPane(tabla1);
		scrollTabla1.getViewport().setBackground(new Color(186, 255, 255));

		JPanel panelTabla1 = new JPanel(new BorderLayout());
		panelTabla1.setBackground(new Color(186, 255, 255));
		panelTabla1.setBorder(BorderFactory.createLineBorder(new Color(95, 152, 129), 2));
		panelTabla1.add(scrollTabla1, BorderLayout.CENTER);

		// -------------------------------------------------------------------------------------------------------------
		// Contenedor del centro (panel superior + tabla)
		JPanel panelCentroCompleto = new JPanel(new BorderLayout());
		panelCentroCompleto.add(panelSuperior, BorderLayout.NORTH);
		panelCentroCompleto.add(panelTabla1, BorderLayout.CENTER);

		// ------------------------------------------------------------------------------------------------------------
		// accion boton añadir

		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Gestor.ventana10();

			}
		});

		// accion boton prestamo
		btnPrestamo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Gestor.ventana8();
			}
		});

		// accion del boton devolucion
		

				btnDevolucion.addActionListener(new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) {
				        
				        int fila = tablaPres.getSelectedRow();

				        if (fila != -1) {
				            
				           
				        	int numero = Integer.parseInt(tablaPres.getValueAt(fila, 0).toString());
				            
				           
				            int confirm = JOptionPane.showConfirmDialog(
				                MenuCeib.this,
				                "¿Deseas registrar la devolución y eliminar el préstamo ceibalita con  nuemro: " + numero + "?",
				                "Confirmar Devolución",
				                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE
				            );

				            if (confirm == JOptionPane.YES_OPTION) {
				                
				                Gestor.elimCeibalitaPres(numero); 
				                
				                
				                modelo.removeRow(fila);
				                
				                JOptionPane.showMessageDialog(MenuCeib.this, "Devolución registrada para el numero: " + numero);
				            }
				        } else {
				            JOptionPane.showMessageDialog(MenuCeib.this, "Por favor, selecciona una fila para devolver.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				        }
				    }
				});

	
		// ---------------------------------------------------------------------------------------------------------

		//Accion del boton eliminar
		
		
		btnEliminar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		       
		    	
		    	
		        int fila = tabla1.getSelectedRow();
		        
		        if (fila != -1) {

		            String numero = tabla1.getValueAt(fila, 0).toString(); 

		            int confirm = JOptionPane.showConfirmDialog(null,
		                    
		                    "¿Deseas eliminar el numero de la Ceibalita: " + numero + "?",
		                    "Confirmar eliminación",
		                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		          
		            if (confirm == JOptionPane.YES_OPTION) {
		               
		                Gestor.elimCeibalita(numero);

		                modelo.removeRow(fila);
		                
		                JOptionPane.showMessageDialog(null, "Ceibalita eliminado correctamente.");
		            }
		        } else {
		           
		            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila.");
		        }
		    }
		});

		// -------- Boton Modificar----------------------------------------
				JButton btnModificar = new JButton("Modificar Prestamo");

				btnModificar.setFont(new Font("Arial", Font.BOLD, 16));
				btnModificar.setBackground(new Color(95, 152, 129));
				btnModificar.setForeground(Color.BLACK);
				// btnModificar.setBorder(new Borde(9));

				panelSuperior.add(btnModificar);
				
				// -----Accion del boton Modificar Prestamo------
				btnModificar.addActionListener(new ActionListener() {
				    
				    @Override
				    public void actionPerformed(ActionEvent e) {
				        
				        
				        int fila = tablaPres.getSelectedRow();
				        
				        if (fila == -1) {
				            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				            return;
				        }
				        
				        try {
				           
				        	
				        	
				             
				        	int id = Integer.parseInt(tablaPres.getValueAt(fila, 0).toString());
				        	int ci = Integer.parseInt(tablaPres.getValueAt(fila, 1).toString());
				        	String nombre = tablaPres.getValueAt(fila, 2).toString();
				        	String apellido = tablaPres.getValueAt(fila, 3).toString();
				        	String materia = tablaPres.getValueAt(fila, 4).toString();
				        	String grupo = tablaPres.getValueAt(fila, 5).toString();
				        	String numero = tablaPres.getValueAt(fila, 6).toString();
				            
				            
				        	Solicitante5 prestamoAEditar = new Solicitante5(id, ci,nombre, apellido, materia, grupo, numero);
				        	
				            EditarPrestamoCeibalita editarPrestamo = new EditarPrestamoCeibalita(Gestor, prestamoAEditar);
				            editarPrestamo.setVisible(true);
				            
				            
				        } catch (NumberFormatException ex) {
				             JOptionPane.showMessageDialog(null, "Error: La CI debe ser un número entero válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
				             ex.printStackTrace();
				        } catch (Exception ex) {
				             JOptionPane.showMessageDialog(null, "Error al preparar la edición: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				             ex.printStackTrace();
				        }
				    }
				});
		
		
		
		// ---------------------------------------------------------------------------------------------------------
		// Panel principal
		add(panelIzquierdo, BorderLayout.WEST); // cubre toda la altura
		add(panelCentroCompleto, BorderLayout.CENTER); // superior + tabla

		// ------ Logo arriba ------
		JLabel logo = new JLabel(new ImageIcon("logo2.png"));
		logo.setAlignmentX(Component.CENTER_ALIGNMENT); // centrar
		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 20))); // margen superior
		panelIzquierdo.add(logo);
		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 30))); // espacio entre logo y botó

		JButton btnListadoCeib = new JButton("Listar Ceibalita");
		btnListadoCeib.setFont(new Font("Arial", Font.BOLD, 15));
		btnListadoCeib.setBackground(new Color(95, 152, 129));
		btnListadoCeib.setForeground(Color.BLACK);

		panelSuperior.add(btnListadoCeib);

		JButton btnListadoPrestamo = new JButton("Listar Prestamos");
		panelSuperior.add(btnListadoPrestamo);
		btnListadoPrestamo.setFont(new Font("Arial", Font.BOLD, 15));
		btnListadoPrestamo.setBackground(new Color(95, 152, 129));
		btnListadoPrestamo.setForeground(Color.BLACK);
	

		
		btnListadoCeib.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        panelCentroCompleto.remove(panelTablaPres); 
		        panelCentroCompleto.add(panelTabla1, BorderLayout.CENTER); 
		        Gestor.listarCeibalita((DefaultTableModel) tabla1.getModel()); 
		        panelCentroCompleto.revalidate();
		        panelCentroCompleto.repaint(); 
		    }
		});
	
		btnListadoPrestamo.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        panelCentroCompleto.remove(panelTabla1);
		        panelCentroCompleto.add(panelTablaPres, BorderLayout.CENTER);
		        Gestor.listarPrestamoCeib((DefaultTableModel) tablaPres.getModel());
		        panelCentroCompleto.revalidate();
		        panelCentroCompleto.repaint(); 
		    }
		});

		
	
	}

}