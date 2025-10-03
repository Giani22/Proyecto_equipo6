package ventana2;

import javax.swing.*;
import java.awt.*;

public class Ventana5 extends JFrame {

    public Ventana5() {
        setTitle("Préstamo");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("Nombre:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Apellido:"));
        panel.add(new JTextField());
        panel.add(new JLabel("CI:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Nro Teléfono:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Materia:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Grupo:"));
        panel.add(new JTextField());
        panel.add(new JLabel("ISBN:"));
        panel.add(new JTextField());

        JButton btnAgregar = new JButton("Prestar");
        

        panel.add(btnAgregar);

        add(panel);
    }
}
