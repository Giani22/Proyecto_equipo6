 package ventana2;

import javax.swing.*;
import java.awt.*;

public class Ventana10 extends JFrame {

    public Ventana10() {
    	
        setTitle("Añadir");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1));

        
        panel.add(new JLabel("ID:"));
        panel.add(new JComboBox<>());

        JButton btnAgregar = new JButton("Añadir");
        

        panel.add(btnAgregar);

        add(panel);
    }
}
