package ventana;

import javax.swing.*;
import java.awt.*;

public class DevolucionLibro extends JFrame {

    public DevolucionLibro() {
    	
        setTitle("Devolución");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("CI:"));
        panel.add(new JComboBox<>());
        panel.add(new JLabel("ISBN:"));
        panel.add(new JComboBox<>());

        JButton btnAgregar = new JButton("Devolver");
        

        panel.add(btnAgregar);

        add(panel);
    }
}
