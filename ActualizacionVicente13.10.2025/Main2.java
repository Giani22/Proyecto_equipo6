package zPrimerEntrega;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


public class Main2 {
	
	MySQL bd = new MySQL();

	
	public static void main(String[] args) {
		inicio ventana1 = new inicio();
		ventana1.setVisible(true);
	
		}
	

		
		public void V2() {
		ventana2 V2 = new ventana2();
		V2.setVisible(true);
	}
		
		
		public void ventana3() {
			Ventana3 V3 = new Ventana3();
			V3.setVisible(true);
		
		
	}
		
		public void ventana4() {
		    Ventana4 V4 = new Ventana4();
		    V4.setVisible(true);
	}

		public void ventana5() {
		    Ventana5 V5 = new Ventana5();
		    V5.setVisible(true);
	}

		public void ventana6() {
		    Ventana6 V6 = new Ventana6();
		    V6.setVisible(true);
	}
	
		
		
		public void ventana7() {
			Ventana7 V7 = new Ventana7();
			V7.setVisible(true);
	}
		
		public void ventana8() {
			Ventana8 V8= new Ventana8();
			V8.setVisible(true);
			
	}

		public void ventana9() {
			Ventana9 V9 = new Ventana9();
			V9.setVisible(true);
			
	}

		public void ventana10() {
			Ventana10 V10 = new Ventana10();
			V10.setVisible(true);
			
	}

		public void ventana11() {
			Ventana11 V11 = new Ventana11();
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
		//> <
		public boolean guardarLibro(Libro lib1) {
			boolean resultado = false;
			if(lib1.getIsbn().length()>10) {
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
		public boolean guardarPrestamoLib(Solicitante soli) {
			boolean resultado = false;
			if(soli.getCi()>0) {
				bd.guardarPrestamoLibBD(soli);
				resultado = true;
			}
			return resultado;
					
		}

}