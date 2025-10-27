package ventana;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Datos_Impresion extends JFrame {

   
    Logica Gestor = new Logica();

    public Datos_Impresion() {

       
        setTitle("Añadir Impresión");
        setSize(300, 200);
        setLocationRelativeTo(null);
       // setDefaultCloseOperation(DISPOSE_ON_CLOSE); 

        
        JPanel panel = new JPanel(new GridLayout(0,1)); 

      
        panel.add(new JLabel("Monto:"));
        final JTextField txtMonto = new JTextField();
        panel.add(txtMonto);

        // --- Botón ---
        JButton btnAgregar = new JButton("Añadir");
        panel.add(btnAgregar); 

        
        btnAgregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String montoStr = txtMonto.getText();
                
                if (montoStr.isEmpty()) {
                    JOptionPane.showMessageDialog(Datos_Impresion.this, "El monto no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try {
                   
                    int montoInt = Integer.parseInt(montoStr); 
                   
                    Impresion impr = new Impresion(montoInt); 
                    
                    if (Gestor.guardarImpresion(impr)) {
                        JOptionPane.showMessageDialog(Datos_Impresion.this, "¡Guardado exitoso!", "Información", JOptionPane.INFORMATION_MESSAGE);
                        txtMonto.setText(""); 
                    } else {
                         JOptionPane.showMessageDialog(Datos_Impresion.this, "Error al guardar la impresión.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                   
                    JOptionPane.showMessageDialog(Datos_Impresion.this, 
                                                  "Por favor, introduce un número entero válido para el monto.", 
                                                  "Error de Formato", 
                                                  JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }); 

        
        add(panel); 
        
    }
    
   
}