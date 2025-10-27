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


public class Monto extends JFrame {
    
    
    Logica Gestor = new Logica();

    public Monto() {
        
        setTitle("Añadir Monto"); 
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
       
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JTextField txtMonto = new JTextField();
        
        panel.add(new JLabel("Monto:")); 
        panel.add(txtMonto);

        JButton btnAñadirImpre = new JButton("Añadir");
        
        
        btnAñadirImpre.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String monto1 = txtMonto.getText().trim();

                if (monto1.isEmpty()) {
                    JOptionPane.showMessageDialog(Monto.this, "Debe ingresar un monto.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                
                int monto = Integer.parseInt(monto1); 
            
                
                Impresion pago = new Impresion(monto);
                
                
                if (Gestor.guardarImpresion(pago)) {
                    JOptionPane.showMessageDialog(Monto.this, "¡Guardado!"); 
                    dispose(); 
                } else {
                    JOptionPane.showMessageDialog(Monto.this, "Error al guardar la impresión.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(btnAñadirImpre);

        add(panel);
        setVisible(true);
    }
}