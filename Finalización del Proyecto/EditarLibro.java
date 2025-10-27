package ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditarLibro extends JFrame {
    private Logica gestor; 

    private JTextField textTitulo;
    private JTextField textAutor;
    private JTextField textCantidad; 
    private JTextField textMateria; 
    private JTextField textIsbn; 

    private String isbnOriginal; 

    public EditarLibro(Logica gestor, Libro libro) {
        this.gestor = gestor;
        this.isbnOriginal = libro.getIsbn(); 

        setTitle("Editar Libro");
        setSize(300, 350); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

       
        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
        
        
        textIsbn = new JTextField(libro.getIsbn());
        textIsbn.setEditable(false);

        textTitulo = new JTextField(libro.getTitulo());
        textAutor = new JTextField(libro.getAutor());
        textMateria = new JTextField(libro.getMateria());
        textCantidad = new JTextField(String.valueOf(libro.getCopias()));

       
        panel.add(new JLabel("ISBN:"));
        panel.add(textIsbn);

        panel.add(new JLabel("Título:"));
        panel.add(textTitulo);

        panel.add(new JLabel("Autor:"));
        panel.add(textAutor);

        panel.add(new JLabel("Materia:"));
        panel.add(textMateria);

        panel.add(new JLabel("Copias:"));
        panel.add(textCantidad);

      
        JButton botonGuardar = new JButton("Guardar cambios");
        panel.add(botonGuardar);

        
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = textTitulo.getText().trim();
                String autor = textAutor.getText().trim();
                String materia = textMateria.getText().trim();

                if (titulo.isEmpty() || autor.isEmpty() || materia.isEmpty() || textCantidad.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(EditarLibro.this,
                            "Todos los campos deben estar llenos", "Validación",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int copias = Integer.parseInt(textCantidad.getText().trim());
                    if (copias <= 0) {
                        JOptionPane.showMessageDialog(EditarLibro.this,
                                "La cantidad de ejemplares debe ser mayor que cero", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    gestor.modificarLibro(isbnOriginal, titulo, autor, materia, copias);
                    JOptionPane.showMessageDialog(EditarLibro.this,
                            "Libro actualizado correctamente", "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(EditarLibro.this,
                            "La cantidad debe ser un número entero válido", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(EditarLibro.this,
                            "Error al actualizar el libro: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

       
        add(panel);
        setVisible(true);
    }
}
