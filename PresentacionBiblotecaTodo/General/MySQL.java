package ventana2;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MySQL {
	

	private final String DB_URL = "jdbc:mysql://23.111.185.242/program1_equipo6?useSSL=false";
	private final String DB_USER = "program1_estudiantes";
	private final String DB_PASS = "estudiantesarrayanes";
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		
		
	}
	
public void listarAlumno(DefaultTableModel modelo) {
		
		String sentencia = "SELECT ci, nombre, apellido , telefono, grupo , materia FROM personas";	
		
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			modelo.setRowCount(0); //Borrar con Tabla
			
			while (rs.next()) {
			
				String ci = rs.getString(1);
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
				int telefono = rs.getInt(4);
				String grupo = rs.getString(5);
				String materia = rs.getString(6);
				
				Object[] fila = {ci, nombre, apellido, telefono, grupo, materia};
				modelo.addRow(fila);
			}
			
		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
		
	}
	
}