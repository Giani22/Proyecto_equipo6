package ventana;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuLibro extends JFrame {

	
	Logica Gestor = new Logica();
	protected int ci;
	
    private JTable tabla;
    private DefaultTableModel modelo;
    private JTable tablaPres;
    private DefaultTableModel modeloPres;


	public MenuLibro() {

		// Ventana
		setTitle("Biblioteca Liceo Prof. Álvaro Figueredo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// -------------------------------------------------------------------------------------------------------------

		// Panel Izquierdo (Mismo código)
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
		panelIzquierdo.setBackground(new Color(0, 109, 109));
		panelIzquierdo.setPreferredSize(new Dimension(200, 600));

		// -------Boton Libro-------
		JButton btnLibro = new JButton("Libro");
		btnLibro.setFont(new Font("Arial", Font.BOLD, 15));
		btnLibro.setBackground(new Color(186, 255, 255));
		btnLibro.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLibro.setMaximumSize(new Dimension(150, 40));
		btnLibro.setForeground(Color.BLACK);
		// btnLibro.setBorder(new Borde(9)); // Se asume que Borde es una clase existente

		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 200)));
		panelIzquierdo.add(btnLibro);
		panelIzquierdo.add(Box.createVerticalGlue()); 

		// ------Boton Salir--------
		JButton Salir = new JButton("SALIR");
		Salir.setFont(new Font("Arial", Font.BOLD, 15));
		Salir.setBackground(new Color(186, 255, 255));
		Salir.setAlignmentX(Component.CENTER_ALIGNMENT);
		Salir.setMaximumSize(new Dimension(150, 40));
		Salir.setForeground(Color.BLACK);
		// Salir.setBorder(new Borde(9));
		Salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Gestor.V2();
			}
		});

		panelIzquierdo.add(Salir);
		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 20)));

		// ----------------------------------------------------------------------------------------------------------

		// Panel Superior (Mismo código)
		JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		panelSuperior.setBackground(new Color(186, 255, 255));

		// ------Boton préstamo-------
		JButton btnPrestamo = new JButton("Préstamo");
		btnPrestamo.setFont(new Font("Arial", Font.BOLD, 15));
		btnPrestamo.setBackground(new Color(95, 152, 129)); 
		btnPrestamo.setForeground(Color.BLACK);

		btnLibro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); 
				// Gestor.ventana(); 
			}
		});

		panelSuperior.add(btnPrestamo);

		// ---------Boton devolución---------
		JButton btnDevolucion = new JButton("Devolución");
		btnDevolucion.setFont(new Font("Arial", Font.BOLD, 15));
		btnDevolucion.setBackground(new Color(95, 152, 129));
		btnDevolucion.setForeground(Color.BLACK);

		panelSuperior.add(btnDevolucion);

		panelSuperior.add(Box.createRigidArea(new Dimension(240, 0))); 
		panelSuperior.add(Box.createHorizontalGlue());

		// -------Boton agregar-------
		JButton btnAgregar = new JButton("+");
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 18));
		btnAgregar.setBackground(new Color(95, 152, 129));
		btnAgregar.setForeground(Color.BLACK);

		panelSuperior.add(btnAgregar);

		// -------- Boton tacho-------
		JButton btnEliminar = new JButton("-");
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEliminar.setBackground(new Color(95, 152, 129));
		btnEliminar.setForeground(Color.BLACK);

		panelSuperior.add(btnEliminar);

		// ------------------------------------------------------------------------------------------------------------

		// Panel central
		String[] columnas = { "ISBN", "Titulo", "Autor", "Materia", "Copias" };

		// variables de instancia
		this.modelo = new DefaultTableModel(columnas, 0);
		this.tabla = new JTable(modelo);
		tabla.setGridColor(Color.BLACK); 
		tabla.setShowGrid(true); 
		tabla.setBackground(new Color(186, 255, 255));
		tabla.getTableHeader().setBackground(new Color(173, 226, 206));
		tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

		JScrollPane scrollTabla = new JScrollPane(tabla);
		scrollTabla.getViewport().setBackground(new Color(186, 255, 255));

		JPanel panelTabla = new JPanel(new BorderLayout());
		panelTabla.setBackground(new Color(186, 255, 255));
		panelTabla.setBorder(BorderFactory.createLineBorder(new Color(95, 152, 129), 2));
		panelTabla.add(scrollTabla, BorderLayout.CENTER);

		//  Tabla de Préstamos
		String[] columnasPres = { "ID", "CI", "Nombre", "Apellido", "Materia", "Grupo", "ISBN" };

		//  variables de instancia
		this.modeloPres = new DefaultTableModel(columnasPres, 0);
		this.tablaPres = new JTable(modeloPres);
		tablaPres.setGridColor(Color.BLACK);
		tablaPres.setShowGrid(true);
		tablaPres.setBackground(new Color(186, 255, 255));
		tablaPres.getTableHeader().setBackground(new Color(173, 226, 206));
		tablaPres.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

		JScrollPane scrollTablaPres = new JScrollPane(tablaPres);
		scrollTablaPres.getViewport().setBackground(new Color(186, 255, 255));

		JPanel panelTablaPres = new JPanel(new BorderLayout());
		panelTablaPres.setBackground(new Color(186, 255, 255));
		panelTablaPres.setBorder(BorderFactory.createLineBorder(new Color(95, 152, 129), 2));
		panelTablaPres.add(scrollTablaPres, BorderLayout.CENTER);
		
		// -------------------------------------------------------------------------------------------------------------
		// Contenedor del centro (panel superior + tabla)

		JPanel panelCentroCompleto = new JPanel(new BorderLayout());
		panelCentroCompleto.add(panelSuperior, BorderLayout.NORTH);
		panelCentroCompleto.add(panelTabla, BorderLayout.CENTER); // Muestra la tabla de libros por defecto

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

		// boton devolucion (Eliminar Préstamo)
		btnDevolucion.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		        
		        int fila = tablaPres.getSelectedRow();

		        if (fila != -1) {
		            
		          
		            String isbn = tablaPres.getValueAt(fila, 5).toString();
		            
		           
		            int confirm = JOptionPane.showConfirmDialog(
		                MenuLibro.this,
		                "¿Deseas registrar la devolución y eliminar el préstamo del libro con ISBN: " + isbn + "?",
		                "Confirmar Devolución",
		                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE
		            );

		            if (confirm == JOptionPane.YES_OPTION) {
		                
		                Gestor.elimLibroPres(isbn); 
		                
		                // modeloPres para eliminar la fila
		                modeloPres.removeRow(fila);
		                
		                JOptionPane.showMessageDialog(MenuLibro.this, "Devolución registrada para el ISBN: " + isbn);
		            }
		        } else {
		            JOptionPane.showMessageDialog(MenuLibro.this, "Por favor, selecciona una fila para devolver.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});

		// ------------------------------------------------------------------------------------------------------------------

		// -----Accion del boton eliminar ------
		btnEliminar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int fila = tabla.getSelectedRow();

		        if (fila != -1) {
		            String isbn = tabla.getValueAt(fila, 0).toString(); 

		            int confirm = JOptionPane.showConfirmDialog(null,
		                    "¿Deseas eliminar el ISBN del Libro: " + isbn + "?",
		                    "Confirmar eliminación",
		                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		            if (confirm == JOptionPane.YES_OPTION) {
		                Gestor.elimLibro(isbn);
		                modelo.removeRow(fila);
		                
		                JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila.");
		        }
		    }
		});
				
		
		// ---------------------------------------------------------------------------------------------------------

		// -------- Boton Modificar----------------------------------------
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Arial", Font.BOLD, 16));
		btnModificar.setBackground(new Color(95, 152, 129));
		btnModificar.setForeground(Color.BLACK);

		panelSuperior.add(btnModificar);
		
		
		// -----Accion del boton Modificar ------
		btnModificar.addActionListener(new ActionListener() {
		    
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		        int fila = tabla.getSelectedRow();
		        
		        if (fila != -1) {
		            
		            try {
		                
		                String isbn = tabla.getValueAt(fila, 0).toString(); 
		                String titulo = tabla.getValueAt(fila, 1).toString(); 
		                String autor = tabla.getValueAt(fila, 2).toString();  
		                String materia = tabla.getValueAt(fila, 3).toString(); 
		                
		                
		                int copias = Integer.parseInt(tabla.getValueAt(fila, 4).toString()); 
		                
		                Libro libroAEditar = new Libro(isbn, titulo, autor, materia, copias);
		                
		                EditarLibro editar = new EditarLibro(Gestor, libroAEditar);
		                
		                editar.setVisible(true);
		                
		            } catch (NumberFormatException ex) {
		                 JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla: La cantidad de copias no es un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
		                 ex.printStackTrace(); 
		            } catch (Exception ex) {
		                 JOptionPane.showMessageDialog(null, "Error al preparar la edición: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		                 ex.printStackTrace();
		            }
		            
		        } else {
		            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});
		
		

		// -------- Boton Modificar Prestamo----------------------------------------
		JButton btnModificar2 = new JButton("Modificar Prestamo");

		btnModificar2.setFont(new Font("Arial", Font.BOLD, 16));
		btnModificar2.setBackground(new Color(95, 152, 129));
		btnModificar2.setForeground(Color.BLACK);

		panelSuperior.add(btnModificar2);

		// -----Accion del boton Modificar Prestamo------
		btnModificar2.addActionListener(new ActionListener() {
		    
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
		        	String isbn = tablaPres.getValueAt(fila, 6).toString();
		            
		            
		        	Solicitante4 prestamoAEditar = new Solicitante4(id, ci, nombre, apellido, materia, grupo, isbn);
		        	
		            EditarPrestamoLibro editarPrestamo = new EditarPrestamoLibro(Gestor, prestamoAEditar);
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
		add(panelIzquierdo, BorderLayout.WEST); 
		add(panelCentroCompleto, BorderLayout.CENTER); 

		// Logo 
		JLabel logo = new JLabel(new ImageIcon("logo.png"));
		logo.setBounds(0, 0, 150, 150);
		panelIzquierdo.add(logo);

		// Botón Listar Libros
		JButton btnListadoLib = new JButton("Listar Libros");
		btnListadoLib.setFont(new Font("Arial", Font.BOLD, 15));
		btnListadoLib.setBackground(new Color(95, 152, 129));
		btnListadoLib.setForeground(Color.BLACK);

		btnListadoLib.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelTablaPres.setVisible(false);
				modelo.setRowCount(0); // Limpiar antes de listar
				Gestor.listarLibro(modelo);
				panelTabla.setVisible(true);
			}
		});
		panelSuperior.add(btnListadoLib);

		// Botón Listar Préstamos
		JButton btnListadoPres = new JButton("Listar Prestamos");
		btnListadoPres.setFont(new Font("Arial", Font.BOLD, 15));
		btnListadoPres.setBackground(new Color(95, 152, 129));
		btnListadoPres.setForeground(Color.BLACK);

		btnListadoPres.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelTabla.setVisible(false);
				panelTablaPres.setVisible(true);
				
				modeloPres.setRowCount(0); 
				Gestor.listarPrestamoLib(modeloPres);
				
				panelCentroCompleto.add(panelTablaPres, BorderLayout.CENTER);
			}
		});
		panelSuperior.add(btnListadoPres);

	}
}