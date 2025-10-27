package ventana;


import javax.swing.table.DefaultTableModel;


public class Logica {
	
	MySQL bd = new MySQL();

	
	public static void main(String[] args) {
		inicio ventana1 = new inicio();
		ventana1.setVisible(true);
	
		}
	

		
		public void V2() {
		Menu V2 = new Menu();
		V2.setVisible(true);
	}
		
		
		public void ventana3() {
			MenuLibro V3 = new MenuLibro();
			V3.setVisible(true);
		
		
	}
		
		public void ventana4() {
		    AñadirLibro V4 = new AñadirLibro();
		    V4.setVisible(true);
	}

		public void ventana5() {
		    PrestamoLibro V5 = new PrestamoLibro();
		    V5.setVisible(true);
	}

		public void ventana6() {
		    DevolucionLibro V6 = new DevolucionLibro();
		    V6.setVisible(true);
	}
	
		
		
		public void ventana7() {
			MenuCeib V7 = new MenuCeib();
			V7.setVisible(true);
	}
		
		public void ventana8() {
			PrestamoCeib V8= new PrestamoCeib();
			V8.setVisible(true);
			
	}

		public void ventana9() {
			DevolucionCeib V9 = new DevolucionCeib();
			V9.setVisible(true);
			
	}

		public void ventana10() {
			AñadirCeib V10 = new AñadirCeib();
			V10.setVisible(true);
			
	}

		public void ventana11() {
			MenuImpresion V11 = new MenuImpresion();
			V11.setVisible(true);
			
	}

		public void MenuImpresion() {
			MenuImpresion V12 = new MenuImpresion();
			V12.setVisible(true);
			
	}
		
		public void Monto() {
			Monto V13 = new Monto();
			V13.setVisible(true);
			
	}
		
		public void listarLibro (DefaultTableModel modelo) {
			
			bd.listarLibroBD(modelo);
			
			
		}
		public void listarCeibalita (DefaultTableModel modelo) {
			
			bd.listarCeibalitaBD(modelo);
			
			
		}
		public void listarPrestamoLib (DefaultTableModel modeloPres) {
			
			bd.listarPrestamosLibBD(modeloPres);
			
		}
		public void listarPrestamoCeib (DefaultTableModel modeloPres) {
			
			bd.listarPrestamosCeibBD(modeloPres);
		}
		
		public void listarImpresion(DefaultTableModel model) {
			bd.listarImpresionBD(model);
			
		}

		
	
		public boolean guardarLibro(Libro lib1) {
			boolean resultado = false;
			if(lib1.getIsbn().length()>0) {
				bd.AltaLibroBD(lib1);
				resultado = true;
			}
			
			return resultado;
			
		}
		public boolean guardarCeibalita(Datos_Ceibalita ceibalita) {
			boolean resultado = false;
			if(ceibalita.getNumero().length()>0) {
				bd.AltaCeibalitaBD(ceibalita);
				resultado = true;
			}
			return resultado;
					
		}

		
	
		public boolean guardarPrestamoCeib(Solicitante2 modelo) {
			boolean resultado = false;
			if(modelo.getCi()>0) {
				bd.AltaPrestamoCeibalitaBD(modelo);
				resultado = true;
			}
			return resultado;
				
	}



	public boolean guardarPrestamoLibro(Solicitante modelo) {
		boolean resultado = false;
		if(modelo.getCi()>0) {
			bd.AltaPrestamoLibBD(modelo);
			resultado = true;
		}
		return resultado;
		
	}
	
	public boolean guardarImpresion(Impresion impresion) {
		boolean resultado = false;
		if (impresion.getMonto() > 0) {
			bd.AltaImpresionBD(impresion);
			resultado = true;
		}
		return resultado;
				
	}

	public void elimLibro(String isbn) {
	   bd.elimLibroBD(isbn);
	}
	
		
	
	public void elimCeibalita(String Numero) {
	        bd.elimCeibalitaBD(Numero);

	        
	}


	public void elimLibroPres(String isbn) {
		   bd.elimLibroPresBD(isbn);
		}
		
			
		
		public void elimCeibalitaPres(int Numero) {
		        bd.elimCeibalitaPresBD(Numero);

		        
		}
		
		public void elimImpresion(int Monto) {
	        bd.elimImpresionBD(Monto);

	        
	}

	public void ventana1() {
		inicio ventana1 = new inicio();
		ventana1.setVisible(true);
	
	}



	public void modificarLibro(String isbn, String titulo, String autor, String materia, int copias) {
		 bd.modificarLibroBD(isbn,titulo,autor,materia,copias);
		
		
		
	}
	



	
	public void modificarPrestamoLibro(int id, int ci, String nombre, String apellido, String materia, String grupo, String isbn) {
	    bd.modificarPrestamoLibroBD(id, ci, nombre, apellido, materia, grupo, isbn);
	}

	
	public void modificarPrestamoCeibalita(int id,int ci, String nombre, String apellido, String materia, String grupo, String numero) {
	    bd.modificarPrestamoCeibalitaBD(id, ci, nombre,apellido, materia, grupo, numero);
	}

	public int obtenerMontoTotalDia() {
	    MySQL conexionMySQL = new MySQL(); 
	    return conexionMySQL.calcularMontoTotalDia();
	
	}





}	
	
