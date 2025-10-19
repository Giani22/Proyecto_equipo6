package ventana;

public class PideLibro {
	
	String ci;
	String nombre;
	String apellido;
	String materia;
	String grupo;
	String isbn;
	
	 public PideLibro(String ci,String nombre, String apellido,String materia,String grupo, String isbn) {
		 this.nombre = nombre;
	        this.apellido = apellido;
	        this.materia=materia;
	        this.grupo=grupo;
	        this.isbn=isbn;
	
}

	 
	 public String getCi() {
		 return ci;
	 }

	 public void setCi(String ci) {
		 this.ci = ci;
	 }
	 public String getNombre() {
		 return nombre;
	 }

	 public void setNombre(String nombre) {
		 this.nombre = nombre;
	 }

	 public String getApellido() {
		 return apellido;
	 }

	 public void setApellido(String apellido) {
		 this.apellido = apellido;
	 }

	 
	 public String getMateria() {
		 return materia;
	 }

	 public void setMateria(String materia) {
		 this.materia = materia;
	 }

	 public String getGrupo() {
		 return grupo;
	 }

	 public void setGrupo(String grupo) {
		 this.grupo = grupo;
	 }
	 
	 public String getIsbn() {
		 return isbn;
	 }

	 public void setIsbn(String isbn) {
		 this.isbn = isbn;
	 }
}

	
