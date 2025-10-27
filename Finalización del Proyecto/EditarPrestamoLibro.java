package ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditarPrestamoLibro extends JFrame {

    private JTextField textId;
    private JTextField textCI; 
    private JTextField textNombre; 
    private JTextField textApellido; 
    private JTextField textMateria; 
    private JTextField textGrupo; 
    private JTextField textIsbn; 

    private int idOriginal;
    private int ciOriginal;
    private String isbnOriginal;

    public EditarPrestamoLibro(Logica gestor, Solicitante4 prestamo) {

        this.idOriginal = prestamo.getId();
        this.ciOriginal = prestamo.getCi(); 
        this.isbnOriginal = prestamo.getIsbn();

        setTitle("Editar Préstamo");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

     
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
      
        textId = new JTextField(String.valueOf(prestamo.getId()));
        textId.setEditable(false);

        textCI = new JTextField(String.valueOf(prestamo.getCi()));
        textCI.setEditable(false);

        textIsbn = new JTextField(prestamo.getIsbn());
        textIsbn.setEditable(false);

        textNombre = new JTextField(prestamo.getNombre());
        textApellido = new JTextField(prestamo.getApellido());
        textMateria = new JTextField(prestamo.getMateria());
        textGrupo = new JTextField(prestamo.getGrupo());

 
        panel.add(new JLabel("ID:"));
        panel.add(textId);

        panel.add(new JLabel("CI:"));
        panel.add(textCI);

        panel.add(new JLabel("Nombre:"));
        panel.add(textNombre);

        panel.add(new JLabel("Apellido:"));
        panel.add(textApellido);

        panel.add(new JLabel("Materia:"));
        panel.add(textMateria);

        panel.add(new JLabel("Grupo:"));
        panel.add(textGrupo);

        panel.add(new JLabel("ISBN:"));
        panel.add(textIsbn);

 
        JButton btnGuardar = new JButton("Guardar");
        panel.add(btnGuardar);

       
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = textNombre.getText().trim();
                String apellido = textApellido.getText().trim();
                String materia = textMateria.getText().trim();
                String grupo = textGrupo.getText().trim();

                if (nombre.isEmpty() || apellido.isEmpty() || materia.isEmpty() || grupo.isEmpty()) {
                    JOptionPane.showMessageDialog(EditarPrestamoLibro.this,
                            "Todos los campos deben estar llenos.", "Validación",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    gestor.modificarPrestamoLibro(idOriginal, ciOriginal, nombre, apellido, materia, grupo, isbnOriginal);
                    JOptionPane.showMessageDialog(EditarPrestamoLibro.this,
                            "Préstamo actualizado correctamente", "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(EditarPrestamoLibro.this,
                            "Error al actualizar el préstamo: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        
        add(panel);
        setVisible(true);
    }
}
