package ventana;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MySQL {

	private final String DB_URL = "jdbc:mysql://localhost:3306/proyecto?useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "";
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

	}
	

	public void AltaLibroBD(Libro lib1) {
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

	public void AltaCeibalitaBD(Datos_Ceibalita ceibalita) {

		String sentencia = "INSERT INTO Ceibalita VALUES(" + ceibalita.getNumero() + ");";
		try {

			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}
	
	
	// Clase MySQL.java

public boolean AltaImpresionBD(Impresion pago) {

    String sentencia = "INSERT INTO impresion (monto) VALUES (?);";
    
    try (Connection conexion = getConnection();
         PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia)) {
        
        declaracionSQL.setInt(1, pago.getMonto());
        
        int filasAfectadas = declaracionSQL.executeUpdate();

        return filasAfectadas > 0;

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al guardar impresión en BD: " + ex.getMessage());
        ex.printStackTrace();
        return false;
    }
}
	

	public void AltaPrestamoLibBD(Solicitante soli) {
	    

	    String sentenciaPrestamo = "INSERT INTO pideLibro(ci, nombre, apellido, materia, grupo, isbn) VALUES('" 
	            + soli.getCi() + "','" + soli.getNombre() + "','" + soli.getApellido() + "','" 
	            + soli.getMateria() + "','" + soli.getGrupo() + "','" + soli.getIsbn() + "');";

	    String sentenciaPersona = "INSERT INTO personas(ci, nombre, apellido, materia, grupo) VALUES('" 
	            + soli.getCi() + "','" + soli.getNombre() + "','" + soli.getApellido() + "','" 
	            + soli.getMateria() + "','" + soli.getGrupo() + "');";

	    String sentenciaBuscar = "SELECT ci FROM personas WHERE ci = '" + soli.getCi() + "';";

	    try {
	        Connection conexion = getConnection();

	        // Buscar si la persona ya existe
	        PreparedStatement psBuscar = conexion.prepareStatement(sentenciaBuscar);
	        ResultSet rs = psBuscar.executeQuery();

	        // Si no existe, se guarda persona primero
	        if (!rs.next()) {
	            PreparedStatement psPersona = conexion.prepareStatement(sentenciaPersona);
	            psPersona.executeUpdate();
	            System.out.println("Persona registrada por primera vez.");
	        } else {
	            System.out.println("La persona ya existía, no se registró nuevamente.");
	        }

	        // Se guarda el préstamo (siempre)
	        PreparedStatement psPrestamo = conexion.prepareStatement(sentenciaPrestamo);
	        psPrestamo.executeUpdate();
	        System.out.println("Préstamo registrado correctamente.");

	        JOptionPane.showMessageDialog(null, "Préstamo guardado exitosamente.");

	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }
	}
	
	
	public void AltaPrestamoCeibalitaBD(Solicitante2 soli2) {
	    /*
	     * SELECT BUSCANDO POR CEDULA DEL SOLICITANTE
	     *
	     * IF EL RESULTADO DEL SELECT NO ESTÁ VACÍO → NO GUARDO PERSONA, SOLO PRÉSTAMO
	     * ELSE → GUARDO PERSONA Y LUEGO PRÉSTAMO
	     */

	    String sentenciaPrestamo = "INSERT INTO pideCeibalita(ci, nombre, apellido, materia, grupo, numero) VALUES('" 
	            + soli2.getCi() + "','" + soli2.getNombre() + "','" + soli2.getApellido() + "','" 
	            + soli2.getMateria() + "','" + soli2.getGrupo() + "','" + soli2.getNumero() + "');";

	    String sentenciaPersona = "INSERT INTO personas(ci, nombre, apellido, materia, grupo) VALUES('" 
	            + soli2.getCi() + "','" + soli2.getNombre() + "','" + soli2.getApellido() + "','" 
	            + soli2.getMateria() + "','" + soli2.getGrupo() + "');";

	    String sentenciaBuscar = "SELECT ci FROM personas WHERE ci = '" + soli2.getCi() + "';";

	    try {
	        Connection conexion = getConnection();

	        // Buscar si la persona ya existe
	        PreparedStatement psBuscar = conexion.prepareStatement(sentenciaBuscar);
	        ResultSet rs = psBuscar.executeQuery();

	        // Si no existe, se guarda persona primero
	        if (!rs.next()) {
	            PreparedStatement psPersona = conexion.prepareStatement(sentenciaPersona);
	            psPersona.executeUpdate();
	            System.out.println("Persona registrada por primera vez.");
	        } else {
	            System.out.println("La persona ya existía, no se registró nuevamente.");
	        }

	        // Se guarda el préstamo (siempre)
	        PreparedStatement psPrestamo = conexion.prepareStatement(sentenciaPrestamo);
	        psPrestamo.executeUpdate();
	        System.out.println("Préstamo de Ceibalita registrado correctamente.");

	        JOptionPane.showMessageDialog(null, "Préstamo de Ceibalita guardado exitosamente.");

	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }
	}
	//-------------------------------------------------------------------------------------------

	

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

		String sentencia = "SELECT id,ci,nombre,apellido,materia,grupo,isbn FROM pidelibro";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();

			modeloPres.setRowCount(0); // Borra cont tabla

			while (rs.next()) {
				int id =rs.getInt(1);
				int ci = rs.getInt(2);
				String nombre = rs.getString(3);
				String apellido = rs.getString(4);
				String materia = rs.getString(5);
				String grupo = rs.getString(6);
				String isbn = rs.getString(7);

				Object[] fila = { id, ci, nombre, apellido, materia, grupo, isbn };
				modeloPres.addRow(fila);

			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

	}

	public void listarPrestamosCeibBD(DefaultTableModel modelo) {

		String sentencia = "SELECT id, ci,nombre,apellido,materia,grupo,numero FROM pideCeibalita";

		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();

			modelo.setRowCount(0); // Borra cont tabla

			while (rs.next()) {
				int id =rs.getInt(1);
				int ci = rs.getInt(2);
				String nombre = rs.getString(3);
				String apellido = rs.getString(4);
				String materia = rs.getString(5);
				String grupo = rs.getString(6);
				int numero = rs.getInt(7);

				Object[] fila = {id, ci, nombre, apellido, materia, grupo, numero };
				modelo.addRow(fila);

			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}
	
	
	

	public void listarImpresionBD(DefaultTableModel model) {
   
    String sentencia = "SELECT id_impresion, monto, fecha_registro FROM impresion";
    
    try (Connection conexion = getConnection();
         PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
         ResultSet rs = declaracionSQL.executeQuery()) {
        
        while (rs.next()) {
            
            int id = rs.getInt("id_impresion");
            int monto = rs.getInt("monto");
            
            String fecha = rs.getString("fecha_registro"); 
            
          
            Object[] fila = {id, monto, fecha}; 
            model.addRow(fila);
        }

    } catch (SQLException ex) {
       
        JOptionPane.showMessageDialog(null, "Error al listar impresión: " + ex.getMessage());
        ex.printStackTrace();
    }
}

	
	//-------------------------------------------------------------------------------------------
	
	

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

	public void elimCeibalitaBD(String Numero) {

		String sentencia = "DELETE From Ceibalita Where numero = '" + Numero + "'";

		try {

			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}
	
	// Clase MySQL.java

public void elimImpresionBD(int idImpresion) {

   
    String sentencia = "DELETE FROM impresion WHERE id_impresion = ?";

    try (Connection conexion = getConnection();
         PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia)) {

        
        declaracionSQL.setInt(1, idImpresion); 
        
        declaracionSQL.executeUpdate();
        
        

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al eliminar impresión: " + ex.getMessage());
        ex.printStackTrace(); 
    }
}


	public void elimLibroPresBD(String isbn) {

		   
		    String sentencia = "DELETE FROM pidelibro WHERE isbn = ?";

		    try (Connection conexion = getConnection();
		         PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia)) {

		        
		        declaracionSQL.setString(1, isbn); 
		        
		        int filasAfectadas = declaracionSQL.executeUpdate();

		        if (filasAfectadas > 0) {
		           
		        }

		    } catch (SQLException ex) {
		        JOptionPane.showMessageDialog(null, "Error al eliminar el préstamo: " + ex.getMessage());
		        ex.printStackTrace();
		    }
		}

	public void elimCeibalitaPresBD(int Numero) {

		String sentencia = "DELETE From pideceibalita Where numero = '" + Numero + "'";

		try (Connection conexion = getConnection();
		         PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia)) {

		        
		        declaracionSQL.setLong(1, Numero); 
		        
		        int filasAfectadas = declaracionSQL.executeUpdate();

		        if (filasAfectadas > 0) {
		           
		        }

		    } catch (SQLException ex) {
		        JOptionPane.showMessageDialog(null, "Error al eliminar el préstamo: " + ex.getMessage());
		        ex.printStackTrace();
		    }
		}

	//-------------------------------------------------------------------------------------------
	
	
	public void modificarLibroBD (String isbn, String titulo, String autor, String materia, int copias) {
	    
	    
	    String sentencia = "UPDATE libro SET "
	                     + "titulo = ?, "
	                     + "autor = ?, "
	                     + "materia = ?, "
	                     + "copias = ? "
	                     + "WHERE isbn = ?";
	    
	  
	    try (Connection conexion = getConnection(); 
	         PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia)) {
	     
	        declaracionSQL.setString(1, titulo);
	        declaracionSQL.setString(2, autor);
	        declaracionSQL.setString(3, materia);
	        declaracionSQL.setInt(4, copias);
	        
	        
	        declaracionSQL.setString(5, isbn); 
	        
	        int filasAfectadas = declaracionSQL.executeUpdate();
	        
	       
	        if (filasAfectadas > 0) {
	            JOptionPane.showMessageDialog(null, "Libro modificado con éxito");
	        } else {
	            JOptionPane.showMessageDialog(null, "Advertencia: No se encontró el libro con ISBN " + isbn, "Advertencia", JOptionPane.WARNING_MESSAGE);
	        }
	       
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error al actualizar libro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	       
	    }
	}
		
	
	public void modificarPrestamoLibroBD (int id, int ci, String apellido, String materia, String grupo, String nombre, String isbn) {
			
	    
	    String sentencia = "UPDATE pideLibro SET "
	            + "nombre = ?, "
	            + "apellido = ?, "
	            + "materia = ?, "
	            + "grupo = ? "
	            + "WHERE id = ?"; 


	    try (Connection conexion = getConnection(); 
	         PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia)) {
	    
	       
	        declaracionSQL.setString(1, nombre);
	        declaracionSQL.setString(2, apellido);
	        declaracionSQL.setString(3, materia);
	        declaracionSQL.setString(4, grupo);
	        
	        
	        declaracionSQL.setInt(5, id);
	        
	        int filasAfectadas = declaracionSQL.executeUpdate();
	        
	       
	        if (filasAfectadas > 0) {
	            JOptionPane.showMessageDialog(null, "Préstamo actualizado con éxito. ID: " + id);
	        } else {
	            
	            JOptionPane.showMessageDialog(null, 
	                "Advertencia: No se encontró el préstamo con ID: " + id + 
	                " (CI: " + ci + ", ISBN: " + isbn + ")", 
	                "Advertencia", JOptionPane.WARNING_MESSAGE);
	        }
	       
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error al actualizar préstamo (ID: " + id + "): " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public void modificarPrestamoCeibalitaBD (int id,int ci, String nombre, String apellido, String materia, String grupo, String numero) {
			
	    
	    String sentencia = "UPDATE pideCeibalita SET "
	            + "nombre = ?, "
	            + "apellido = ?, "
	            + "materia = ?, "
	            + "grupo = ? "
	            + "WHERE id = ?"; 


	    try (Connection conexion = getConnection(); 
	         PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia)) {
	    
	       
	        declaracionSQL.setString(1, nombre);
	        declaracionSQL.setString(2, apellido);
	        declaracionSQL.setString(3, materia);
	        declaracionSQL.setString(4, grupo);
	        
	        
	        declaracionSQL.setInt(5, id);
	        
	        int filasAfectadas = declaracionSQL.executeUpdate();
	        
	       
	        if (filasAfectadas > 0) {
	            JOptionPane.showMessageDialog(null, "Préstamo actualizado con éxito. ID: " + id);
	        } else {
	            
	            JOptionPane.showMessageDialog(null, 
	                "Advertencia: No se encontró el préstamo con ID: " + id + 
	                " (CI: " + ci + ", ISBN: " + numero + ")", 
	                "Advertencia", JOptionPane.WARNING_MESSAGE);
	        }
	       
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error al actualizar préstamo (ID: " + id + "): " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	



	public int calcularMontoTotalDia() {
		int total = 0;
 
 
		String sentencia = "SELECT SUM(monto) AS total_dia FROM impresion WHERE DATE(fecha_registro) = DATE(NOW())";

		try (Connection conexion = getConnection();
				PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
				ResultSet rs = declaracionSQL.executeQuery()) {
     
			if (rs.next()) {
       
				total = rs.getInt("total_dia");
			}

		}	 catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al calcular el monto total del día: " + ex.getMessage());
			ex.printStackTrace();
		}
		return total;


}

	
		
	
		
	

		
	}
	

	

