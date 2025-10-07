package zPrimerEntrega;

public class Libro {

	String isbn;
	String titulo;
	String autor;
	String materia;
	int copias;
	boolean prestado;
	
	
	public Libro(String isbn,String titulo, String autor, String materia, int copias) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.materia = materia;
		this.copias = copias;
		
		
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}



	public String getMateria() {
		return materia;
	}


	public void setMateria(String materia) {
		this.materia = materia;
	}


	public int getCopias() {
		return copias;
	}


	public void setCopias(int copias) {
		this.copias = copias;
	}


	
	
	
}