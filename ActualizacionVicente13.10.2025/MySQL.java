package zPrimerEntrega;

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
	
	public void listarLibroBD(DefaultTableModel modelo) {
		
		String sentencia = "SELECT isbn,titulo,autor,materia,copias FROM libro";
		
		
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			modelo.setRowCount(0); //Borra cont tabla
			
			while (rs.next()) {
				String isbn= rs.getString(1);
				String titulo= rs.getString(2);
				String autor = rs.getString(3);
				String materia = rs.getString(4);
				int copias = rs.getInt(5);
				
				Object[] fila = { isbn, titulo, autor, materia,copias};
				modelo.addRow(fila);
				
			}
		
		
		} catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	
	}
	public void listarPrestamosLibBD(DefaultTableModel modeloPres) {
		
		String sentencia = "SELECT nombre,apellido,ci,materia,grupo,isbn FROM pideLibro";
		
		
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			modeloPres.setRowCount(0); //Borra cont tabla
			
			while (rs.next()) {
				String nombre= rs.getString(1);
				String apellido= rs.getString(2);
				int ci = rs.getInt(3);
				String materia = rs.getString(4);
				String grupo = rs.getString(5);
				String isbn = rs.getString(6);

				Object[] fila = { nombre, apellido, ci, materia, grupo, isbn};
				modeloPres.addRow(fila);
				
			}
		
		
		} catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	
	}
	public void listarCeibalitaBD(DefaultTableModel modelo) {
		
		String sentencia = "SELECT numero FROM Ceibalita";
		
		
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			modelo.setRowCount(0); //Borra cont tabla
			
			while (rs.next()) {
			
				int numero = rs.getInt(1);
				
				Object[] fila = {numero};
				modelo.addRow(fila);
				
			}
		
		
		} catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	
	}

public void guardarLibroBD(Libro lib1) {
	String sentencia = "INSERT INTO libro(isbn,titulo, autor, materia, copias) VALUES('" + lib1.getIsbn() +"','" + lib1.getTitulo() + "','" + lib1.getAutor() +"','" + lib1.getMateria()+"',"+ lib1.getCopias()+");";	
	
	try {
		
		Connection conexion = getConnection();
		PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
		declaracionSQL.executeUpdate();
		
	} catch (SQLException ex) {

		JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	}
}


public void guardarCeibalitaBD(Datos_Laptops ceibalita) {
	String sentencia = "INSERT INTO Ceibalita(numero) VALUES(" + ceibalita.getNumero()+");";	
	try {
		
		Connection conexion = getConnection();
		PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
		declaracionSQL.executeUpdate();
		
	} catch (SQLException ex) {

		JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	}
}

	public void guardarPrestamoLibBD(Solicitante soli) {
	String sentencia = "INSERT INTO pideLibro(nombre, apellido, ci, materia, grupo, isbn) VALUES('" + soli.getNombre() + "','" + soli.getApellido() + "','" + soli.getCi() +"','" + soli.getMateria()+"','" + soli.getGrupo()+"','" + soli.getIsbn() + "');";
System.out.println(sentencia);
	try {
		
		Connection conexion = getConnection();
		PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
		declaracionSQL.executeUpdate();
		
	} catch (SQLException ex) {

		JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	}
	}		
}
