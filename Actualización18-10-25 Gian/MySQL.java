package ventana;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MySQL {

	private final String DB_URL = "jdbc:mysql://170.249.219.114/program1_equipo6?useSSL=false";
	private final String DB_USER = "program1_estudiantes";
	private final String DB_PASS = "estudiantesarrayanes";

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

	}

	public void guardarLibroBD(Libro lib1) {
		String sentencia = "INSERT INTO libro(isbn,titulo, autor, materia, copias) VALUES('" + lib1.getIsbn() + "','"
				+ lib1.getTitulo() + "','" + lib1.getAutor() + "','" + lib1.getMateria() + "'," + lib1.getCopias()
				+ ");";

		try {

			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void guardarCeibalitaBD(Datos_Laptops ceibalita) {
		String sentencia = "INSERT INTO Ceibalita VALUES(" + ceibalita.getNumero() + ");";
		try {

			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void listarLibroBD(DefaultTableModel modelo) {

		String sentencia = "SELECT isbn,titulo,autor,materia,copias FROM libro";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();

			modelo.setRowCount(0); // Borra cont tabla

			while (rs.next()) {
				String isbn = rs.getString(1);
				String titulo = rs.getString(2);
				String autor = rs.getString(3);
				String materia = rs.getString(4);
				int copias = rs.getInt(5);

				Object[] fila = { isbn, titulo, autor, materia, copias };
				modelo.addRow(fila);

			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}

	public void listarCeibalitaBD(DefaultTableModel modelo) {

		String sentencia = "SELECT numero FROM Ceibalita";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();

			modelo.setRowCount(0); // Borra cont tabla

			while (rs.next()) {

				int numero = rs.getInt(1);

				Object[] fila = { numero };
				modelo.addRow(fila);

			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}

	public void listarPrestamosLibBD(DefaultTableModel modeloPres) {

		String sentencia = "SELECT ci,nombre,apellido,materia,grupo,isbn FROM pideLibro";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();

			modeloPres.setRowCount(0); // Borra cont tabla

			while (rs.next()) {
				int ci = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
				String materia = rs.getString(4);
				String grupo = rs.getString(5);
				String isbn = rs.getString(6);

				Object[] fila = { ci, nombre, apellido, materia, grupo, isbn };
				modeloPres.addRow(fila);

			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}

	public void listarPrestamosCeibBD(DefaultTableModel modelo) {

		String sentencia = "SELECT ci,nombre,apellido,materia,grupo,numero FROM pideCeibalita";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();

			modelo.setRowCount(0); // Borra cont tabla

			while (rs.next()) {
				int ci = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
				String materia = rs.getString(4);
				String grupo = rs.getString(5);
				int numero = rs.getInt(6);

				Object[] fila = { ci, nombre, apellido, materia, grupo, numero };
				modelo.addRow(fila);

			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void guardarPrestamoLibBD(Solicitante soli) {
		String sentencia = "INSERT INTO pideLibro(ci, nombre, apellido, materia, grupo, isbn) VALUES('" + soli.getCi()
				+ "','" + soli.getNombre() + "','" + soli.getApellido() + "','" + soli.getMateria() + "','"
				+ soli.getGrupo() + "','" + soli.getIsbn() + "');";
		String sentencia2 = "INSERT INTO personas(ci, nombre, apellido, materia, grupo) VALUES('" + soli.getCi() + "','"
				+ soli.getNombre() + "','" + soli.getApellido() + "','" + soli.getMateria() + "','" + soli.getGrupo()
				+ "');";

		System.out.println(sentencia);
		System.out.println(sentencia2);
		try {

			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			PreparedStatement declaracionSQL2 = conexion.prepareStatement(sentencia2);

			declaracionSQL.executeUpdate();
			declaracionSQL2.executeUpdate();

		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void guardarPrestamoCeibBD(Solicitante2 soli) {

		String sentencia = "INSERT INTO pideCeibalita(ci ,nombre, apellido, materia, grupo, numero) VALUES('"
				+ soli.getCi() + "','" + soli.getNombre() + "','" + soli.getApellido() + "','" + soli.getMateria()
				+ "','" + soli.getGrupo() + "','" + soli.getNumero() + "');";
		String sentencia2 = "INSERT INTO personas(ci, nombre, apellido, materia, grupo) VALUES('" + soli.getCi() + "','"
				+ soli.getNombre() + "','" + soli.getApellido() + "','" + soli.getMateria() + "','" + soli.getGrupo()
				+ "');";
		// CURRENT_DATE
		System.out.println(sentencia);
		System.out.println(sentencia2);
		try {

			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			PreparedStatement declaracionSQL2 = conexion.prepareStatement(sentencia2);
			declaracionSQL.executeUpdate();
			declaracionSQL2.executeUpdate();

		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void elimLibroBD(String isbn) {

		String sentencia = "DELETE FROM libro WHERE isbn = '" + isbn + "'";

		try {

			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public void elimCeiablitaBD(int Numero) {

		String sentencia = "DELETE From ceiablita Where id = '" + Numero + "'";

		try {

			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

}
