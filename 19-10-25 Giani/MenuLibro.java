package ventana;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuLibro extends JFrame {

	Logica Gestor = new Logica();

	public MenuLibro() {

		// Ventana
		setTitle("Biblioteca Liceo Prof. Álvaro Figueredo");
		// setSize(1500, 1200);
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
		JButton btnLibro = new JButton("Libro");
		btnLibro.setFont(new Font("Arial", Font.BOLD, 15));
		btnLibro.setBackground(new Color(186, 255, 255));
		btnLibro.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLibro.setMaximumSize(new Dimension(150, 40));
		btnLibro.setForeground(Color.BLACK);
		btnLibro.setBorder(new Borde(9));

		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 200))); // espacio arriba
		panelIzquierdo.add(btnLibro);
		panelIzquierdo.add(Box.createVerticalGlue()); // empuja los demas hacia abajo

		// ------Boton Salir--------
		JButton Salir = new JButton("SALIR");
		Salir.setFont(new Font("Arial", Font.BOLD, 15));
		Salir.setBackground(new Color(186, 255, 255));
		Salir.setAlignmentX(Component.CENTER_ALIGNMENT);
		Salir.setMaximumSize(new Dimension(150, 40));
		Salir.setForeground(Color.BLACK);
		Salir.setBorder(new Borde(9));
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

		// Panel Superior
		JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		panelSuperior.setBackground(new Color(186, 255, 255));

		// ------Boton préstamo-------
		JButton btnPrestamo = new JButton("Préstamo");

		btnPrestamo.setFont(new Font("Arial", Font.BOLD, 15));
		btnPrestamo.setBackground(new Color(95, 152, 129)); // verde claro
		btnPrestamo.setForeground(Color.BLACK);
		// btnPrestamo.setBorder(new Borde(9));

		btnLibro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // cierra la ventana actual
				// Gestor.ventana(); // abre la otra ventana
			}
		});

		panelSuperior.add(btnPrestamo);

		// ---------Boton devolución---------
		JButton btnDevolucion = new JButton("Devolución");

		btnDevolucion.setFont(new Font("Arial", Font.BOLD, 15));
		btnDevolucion.setBackground(new Color(95, 152, 129));
		btnDevolucion.setForeground(Color.BLACK);
		// btnDevolucion.setBorder(new Borde(9));

		panelSuperior.add(btnDevolucion);

		panelSuperior.add(Box.createRigidArea(new Dimension(350, 0))); // espaciado
		panelSuperior.add(Box.createHorizontalGlue());

		// -------Boton agregar-------
		JButton btnAgregar = new JButton("+");

		btnAgregar.setFont(new Font("Arial", Font.BOLD, 18));
		btnAgregar.setBackground(new Color(95, 152, 129)); // mismo verde del borde
		btnAgregar.setForeground(Color.BLACK);
		// btnAgregar.setBorder(new Borde(9));

		panelSuperior.add(btnAgregar);

		// -------- Boton tacho-------
		JButton btnEliminar = new JButton("-");

		btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEliminar.setBackground(new Color(95, 152, 129));
		btnEliminar.setForeground(Color.BLACK);
		// btnEliminar.setBorder(new Borde(9));

		panelSuperior.add(btnEliminar);

		// ------------------------------------------------------------------------------------------------------------

		// Panel central
		String[] columnas = { "ISBN", "Titulo", "Autor", "Materia", "Copias", "Prestado" };

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

		String[] columnasPres = { "CI", "Nombre", "Apellido", "Materia", "Grupo", "ISBN" };

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
		// -------------------------------------------------------------------------------------------------------------
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

		// ------------------------------------------------------------------------------------------------------------------

		// -----Accion del boton eliminar------

		// ACCION BOTON ELIMINAR
				btnEliminar.addActionListener(new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) {
				        JTable tablaActiva = (panelTablaPres.getParent() == panelCentroCompleto) ? tablaPres : tabla; 

				        
				        if (tablaActiva == tabla) { 
				            int fila = tabla.getSelectedRow();

				            if (fila != -1) {
				                int isbn = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
				                int confirm = JOptionPane.showConfirmDialog(null,
				                        "¿Deseas eliminar el Libro: " + isbn + "?",
				                        "Confirmar eliminación",
				                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				                if (confirm == JOptionPane.YES_OPTION) {
				                    Gestor.elimCeibalita(isbn); 
				                    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
				                    modelo.removeRow(fila);
				                    JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
				                }
				            } else {
				                JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila.", "Error", JOptionPane.ERROR_MESSAGE);
				            }
				        } else {
				            JOptionPane.showMessageDialog(null, "El botón '-' solo elimina el listado. Usa el botón 'Devolución' para registrar la finalización de un préstamo.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				        }
				    }
				});
				
		
		// ---------------------------------------------------------------------------------------------------------

		// -------- Boton Modificar----------------------------------------
		JButton btnModificar = new JButton("Modificar");

		btnModificar.setFont(new Font("Arial", Font.BOLD, 16));
		btnModificar.setBackground(new Color(95, 152, 129));
		btnModificar.setForeground(Color.BLACK);
		// btnModificar.setBorder(new Borde(9));

		panelSuperior.add(btnModificar);
		
		// ... después del listener de btnEliminar

		// -----Accion del boton Modificar------

		/*btnModificar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int filaSeleccionada = tabla.getSelectedRow();

		        if (filaSeleccionada != -1) {
		            try {
		                // Obtener datos actuales de la fila seleccionada
		                String isbnActual = tabla.getValueAt(filaSeleccionada, 0).toString();
		                String tituloActual = tabla.getValueAt(filaSeleccionada, 1).toString();
		                String autorActual = tabla.getValueAt(filaSeleccionada, 2).toString();
		                String materiaActual = tabla.getValueAt(filaSeleccionada, 3).toString();
		                String copiaActual = tabla.getValueAt(filaSeleccionada, 4).toString();

		                
		                String nuevoTitulo = JOptionPane.showInputDialog(null, "Ingrese el nuevo Título:", tituloActual);
		                if (nuevoTitulo == null || nuevoTitulo.trim().isEmpty()) { nuevoTitulo = tituloActual; }

		                String nuevoAutor = JOptionPane.showInputDialog(null, "Ingrese el nuevo Autor:", autorActual);
		                if (nuevoAutor == null || nuevoAutor.trim().isEmpty()) { nuevoAutor = autorActual; }

		                String nuevaMateria = JOptionPane.showInputDialog(null, "Ingrese la nueva Materia:", materiaActual);
		                if (nuevaMateria == null || nuevaMateria.trim().isEmpty()) { nuevaMateria = materiaActual; }

		                String strNuevaCopia = JOptionPane.showInputDialog(null, "Ingrese el nuevo número de Copias:", copiaActual);
		                if (strNuevaCopia == null || strNuevaCopia.trim().isEmpty()) { strNuevaCopia = copiaActual; }

		                int nuevaCopia = Integer.parseInt(strNuevaCopia);

		                
		                Gestor.modificarLibroBD(isbnActual, nuevoTitulo, nuevoAutor, nuevaMateria, nuevaCopia);

		               
		                for (ActionListener al : btnListadoLib.getActionListeners()) {
		                    al.actionPerformed(new ActionEvent(btnListadoLib, ActionEvent.ACTION_PERFORMED, ""));
		                }
		                
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "El número de copias debe ser un número entero válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
		            } catch (Exception ex) {
		                JOptionPane.showMessageDialog(null, "Error al procesar la modificación: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Por favor, selecciona el libro que deseas modificar en la tabla.", "Selección Requerida", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});
*/

		
		
		// ---------------------------------------------------------------------------------------------------------

		// Panel principal
		add(panelIzquierdo, BorderLayout.WEST); // cubre toda la altura
		add(panelCentroCompleto, BorderLayout.CENTER); // superior + tabla

		// Logo
		JLabel logo = new JLabel(new ImageIcon("logo.png"));
		logo.setBounds(0, 0, 150, 150);
		panelIzquierdo.add(logo);

		JButton btnListadoLib = new JButton("Listar Libros");
		btnListadoLib.setFont(new Font("Arial", Font.BOLD, 15));
		btnListadoLib.setBackground(new Color(95, 152, 129));
		btnListadoLib.setForeground(Color.BLACK);

		btnListadoLib.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelTablaPres.setVisible(false);
				Gestor.listarLibro(modelo);
				panelTabla.setVisible(true);
			}
		});
		panelSuperior.add(btnListadoLib);

		JButton btnListadoPres = new JButton("Listar Prestamos");
		btnListadoPres.setFont(new Font("Arial", Font.BOLD, 15));
		btnListadoPres.setBackground(new Color(95, 152, 129));
		btnListadoPres.setForeground(Color.BLACK);

		btnListadoPres.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelTabla.setVisible(false);
				panelTablaPres.setVisible(true);
				Gestor.listarPrestamoLib(modeloPres);
				panelCentroCompleto.add(panelTablaPres, BorderLayout.CENTER);
			}
		});
		panelSuperior.add(btnListadoPres);

	}
}