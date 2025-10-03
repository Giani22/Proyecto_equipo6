 package ventana2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana11 extends JFrame {

    Main2 Gestor = new Main2();
  

    public Ventana11() {

        // Ventana
        this.setTitle("Biblioteca Liceo Prof. Álvaro Figueredo");
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0, 109, 109));

        // Panel principal con BorderLayout
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

        //---- Botón Impresión ----
        panelIzquierdo.add(Box.createRigidArea(new Dimension(150, 40)));
        JButton btnImpresion = crearBoton("Impresión");
        
        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 40))); // espacio arriba
	       panelIzquierdo.add(btnImpresion);
	       panelIzquierdo.add(Box.createVerticalGlue()); // empuja los demás hacia abajo
        
    
        panelIzquierdo.add(btnImpresion);
        panelIzquierdo.add(Box.createVerticalGlue());
        
   //----------------------------------------------------------------     

        // ----Botón Salir-----
        JButton btnSalir = crearBoton("Salir");
      /*  btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        */
        
        panelIzquierdo.add(btnSalir);
        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 20)));

        panelPrincipal.add(panelIzquierdo, BorderLayout.WEST);

        //-------------------------------------------------------------------------------------------
        
        // ----Panel derecho-----
        JPanel panelDerecho = new JPanel();
        panelDerecho.setPreferredSize(new Dimension(300, 200));
        panelDerecho.setBackground(new Color(206, 253, 255));
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        panelDerecho.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JLabel Etiqueta = new JLabel("Monto por impresión");
        Etiqueta.setFont(new Font("Arial", Font.BOLD, 16));
        Etiqueta.setForeground(Color.BLACK);
        Etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelDerecho.add(Etiqueta);
        panelDerecho.add(Box.createRigidArea(new Dimension(0, 10)));

        JTextField campoMonto = new JTextField();
        campoMonto.setMaximumSize(new Dimension(200, 30));
        campoMonto.setBackground(Color.WHITE);
        campoMonto.setForeground(Color.BLACK);
        campoMonto.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        campoMonto.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelDerecho.add(campoMonto);
        panelDerecho.add(Box.createRigidArea(new Dimension(0, 20)));

        // ------ Botón aceptar --------
        JButton btnAceptar = crearBoton("Aceptar");
        btnAceptar.setBackground(new Color(32, 183, 188));
       
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción futura
            }
        });
        panelDerecho.add(btnAceptar);
        panelDerecho.add(Box.createVerticalGlue());

        //--- Contenedor para centrar el panel derecho---
        JPanel contenedorDerecho = new JPanel(new GridBagLayout());
        contenedorDerecho.setBackground(new Color(0, 109, 109));
        contenedorDerecho.add(panelDerecho);
        panelPrincipal.add(contenedorDerecho, BorderLayout.CENTER);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 15));
        boton.setBackground(new Color(206, 253, 255));
        boton.setForeground(Color.BLACK);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setMaximumSize(new Dimension(150, 40));
        boton.setBorder(new Borde(9));

        return boton;
    }
}

