package ventana2;

public class Libro {

	String isbn;
	String titulo;
	String autor;
	String pais;
	String materia;
	int copias;
	boolean prestado;
	
	
	public Libro(String isbn,String titulo, String autor, String pais, String materia, int copias, boolean prestado) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.pais = pais;
		this.materia = materia;
		this.copias = copias;
		this.prestado = prestado;
		
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


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
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


	public boolean isPrestado() {
		return prestado;
	}


	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	
	
}
