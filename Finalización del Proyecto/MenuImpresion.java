 package ventana;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuImpresion extends JFrame {

    Logica Gestor = new Logica();
  

    public MenuImpresion() {

        // Ventana
        this.setTitle("Biblioteca Liceo Prof. Álvaro Figueredo");
       // this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0, 109, 109));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Panel principal 
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(0, 109, 109));
        add(panelPrincipal);

        // ----Panel izquierdo----
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        panelIzquierdo.setBackground(new Color(0, 109, 109));
        panelIzquierdo.setPreferredSize(new Dimension(200, 600));
        panelIzquierdo.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));

        //-------------------------------------------------------------------------------------------------------
        // ----Logo----
        ImageIcon icono = new ImageIcon("logo2.png");
        Image img = icono.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(img));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 20)));
        panelIzquierdo.add(logo);
        
        //----------------------------------------------------------------------------------------------------------

        //---- Boton impresion ----
        panelIzquierdo.add(Box.createRigidArea(new Dimension(150, 40)));
        JButton btnImpresion = new JButton("Impresión");
        btnImpresion.setFont(new Font("Arial", Font.BOLD, 15));
        btnImpresion.setBackground(new Color(186, 255, 255));
        btnImpresion.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnImpresion.setMaximumSize(new Dimension(150, 40));
        btnImpresion.setForeground(Color.BLACK);
        btnImpresion.setBorder(new Borde(9));
		panelIzquierdo.add(btnImpresion);
        
        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 40))); // espacio arriba
	       panelIzquierdo.add(btnImpresion);
	       panelIzquierdo.add(Box.createVerticalGlue()); // empuja los demás hacia abajo
        
    
        panelIzquierdo.add(btnImpresion);
        panelIzquierdo.add(Box.createVerticalGlue());
        
        
     
        
   //----------------------------------------------------------------     

        // ----Botón Salir-----
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
      
        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 20)));

        panelPrincipal.add(panelIzquierdo, BorderLayout.WEST);

        //-------------------------------------------------------------------------------------------
        
     // Panel Superior
     		JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
     		panelSuperior.setBackground(new Color(186, 255, 255));

     		// ------Monto total-------
     		JButton btnMTotal = new JButton("Monto total");

     		btnMTotal.setFont(new Font("Arial", Font.BOLD, 15));
     		btnMTotal.setBackground(new Color(95, 152, 129)); // verde claro
     		btnMTotal.setForeground(Color.BLACK);
     		btnMTotal.setBorder(new Borde(9));

     		panelSuperior.add(btnMTotal);

     		
     		// -------Boton agregar-------
     		JButton btnAgregar = new JButton("+");

     		btnAgregar.setFont(new Font("Arial", Font.BOLD, 18));
     		btnAgregar.setBackground(new Color(95, 152, 129)); // mismo verde del borde
     		btnAgregar.setForeground(Color.BLACK);
     		btnAgregar.setBorder(new Borde(9));

     		panelSuperior.add(btnAgregar);

     		// -------- Boton tacho-------
     		JButton btnEliminar = new JButton("-"); // icono de eliminar

     		btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
     		btnEliminar.setBackground(new Color(95, 152, 129));
     		btnEliminar.setForeground(Color.BLACK);
     		btnEliminar.setBorder(new Borde(9));

     		panelSuperior.add(btnEliminar);

     		// ------------------------------------------------------------------------------------------------------------

     		// Panel central
     		String[] columnas = { "ID Impresion", "Monto", "Fecha" };

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

     		

     		// -------------------------------------------------------------------------------------------------------------
     		// Contenedor del centro (panel superior + tabla)
     		JPanel panelCentroCompleto = new JPanel(new BorderLayout());
     		panelCentroCompleto.add(panelSuperior, BorderLayout.NORTH);
     		panelCentroCompleto.add(panelTabla, BorderLayout.CENTER);

     		// ------------------------------------------------------------------------------------------------------------
     		// accion del boton añadir

     		btnAgregar.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {

     				Gestor.Monto();

     			}
     		});

     		
     		//Accion del boton eliminar
     		
     		
     		btnEliminar.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				int fila = tabla.getSelectedRow();

     				if (fila != -1) {
     					
     					int Monto = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
     					int confirm = JOptionPane.showConfirmDialog(null,
     							
     							"¿Deseas eliminar el ID de la Impresion: " + Monto + "?",
     							"Confirmar eliminación",
     							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

     					if (confirm == JOptionPane.YES_OPTION) {
     						Gestor.elimImpresion(Monto);
     						modelo.removeRow(fila);
     						JOptionPane.showMessageDialog(null, "Impresion eliminado correctamente.");
     					}
     				} else {
     					JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila.");
     				}
     			}
     		});

   

     		btnMTotal.addActionListener(new ActionListener() {
     			@Override
     			public void actionPerformed(ActionEvent e) {
     	        
     	       
     				int montoTotal = Gestor.obtenerMontoTotalDia(); 

     	        
     				JOptionPane.showMessageDialog(
     						MenuImpresion.this,
     						"El Monto Total de las impresiones de hoy es: " + montoTotal,
     						"Monto Total del Día",
     						JOptionPane.INFORMATION_MESSAGE
     						);
     			}
     		});
     		
     		
     		// ---------------------------------------------------------------------------------------------------------

     		
     		// Panel principal
     		add(panelIzquierdo, BorderLayout.WEST); // cubre toda la altura
     		add(panelCentroCompleto, BorderLayout.CENTER); // superior + tabla

     	// ------ Logo arriba ------
     		JLabel logo2 = new JLabel(new ImageIcon("logo2.png"));
     		logo.setAlignmentX(Component.CENTER_ALIGNMENT); // centrar
     		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 20))); // margen superior
     		panelIzquierdo.add(logo);
     		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 30))); // espacio entre logo y botó

     		
     		
     		//----------------------------------------------------------------------------------------------------------------
     		
     		
     		JButton btnListarImpresion = new JButton("Listar Impresion");
     		btnListarImpresion.setFont(new Font("Arial", Font.BOLD, 15));
     		btnListarImpresion.setBackground(new Color(95, 152, 129));
     		btnListarImpresion.setForeground(Color.BLACK);

     		panelSuperior.add(btnListarImpresion);

     		btnListarImpresion.addActionListener(new ActionListener() {
     		    @Override
     		    public void actionPerformed(ActionEvent e) {
     		        
     		        
     		        modelo.setRowCount(0); 

     		       
     		        Gestor.listarImpresion(modelo);
     		        
     		        panelCentroCompleto.revalidate();
     		        panelCentroCompleto.repaint(); 
     		        
     		        if (modelo.getRowCount() == 0) {
     		            JOptionPane.showMessageDialog(MenuImpresion.this, 
     		                "No se encontraron registros de impresión.", 
     		                "Listado Vacío", JOptionPane.INFORMATION_MESSAGE);
     		        }
     		    }
     		});
     	
     		
    
     	
     	}


}
        
   