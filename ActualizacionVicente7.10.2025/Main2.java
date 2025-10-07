package zPrimerEntrega;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


public class Main2 {
	
	MySQL bd = new MySQL();
	static ArrayList<Libro> arrayLib = new ArrayList<>();

	
	public boolean regisLibro(String isbn,String titulo, String autor, String materia, int copias) {
		boolean resultado = false;
		
		if(arrayLib.add(new Libro(isbn, titulo, autor, materia, copias))){
			System.out.println(arrayLib.get(0));
			resultado = true;
			System.out.println(isbn + titulo + autor + materia + copias);
		}
		
		return resultado;
	}
	
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
			
			bd.listarAlumno(modelo);
			
			
		}

}