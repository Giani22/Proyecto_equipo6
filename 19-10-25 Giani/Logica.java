package ventana;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
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
		//> <
		public boolean guardarLibro(Libro lib1) {
			boolean resultado = false;
			if(lib1.getIsbn().length()>0) {
				bd.guardarLibroBD(lib1);
				resultado = true;
			}
			
			return resultado;
			
		}
		public boolean guardarCeibalita(Datos_Laptops ceibalita) {
			boolean resultado = false;
			if(ceibalita.getNumero()>0 && ceibalita.getNumero()<200) {
				bd.guardarCeibalitaBD(ceibalita);
				resultado = true;
			}
			return resultado;
					
		}

		
	
	public boolean guardarPrestamoCeib(Solicitante2 modelo) {
		boolean resultado = false;
		if(modelo.getCi()>0) {
			bd.guardarPrestamoCeibBD(modelo);
			resultado = true;
		}
		return resultado;
			
}



	public boolean guardarPrestamoLibro(Solicitante modelo) {
		boolean resultado = false;
		if(modelo.getCi()>0) {
			bd.guardarPrestamoLibBD(modelo);
			resultado = true;
		}
		return resultado;
		
	}

	public void elimLibro(String isbn) {
	   bd.elimLibroBD(isbn);
	}
	
		
	
	public void elimCeibalita(int Numero) {
	        bd.elimCeibalitaBD(Numero);

	        
	}


	public void elimLibroPres(String isbn) {
		   bd.elimLibroPresBD(isbn);
		}
		
			
		
		public void elimCeibalitaPres(int Numero) {
		        bd.elimCeibalitaPresBD(Numero);

		        
		}

	public void ventana1() {
		inicio ventana1 = new inicio();
		ventana1.setVisible(true);
	
	}



	
		
	}
