package zPrimerEntrega;

public class Solicitante {

	
		String nombre, apellido;
		int ci;
		String materia, grupo;
		String isbn;
		public Solicitante(String nombre, String apellido, int ci, String materia, String grupo, String isbn) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.ci = ci;
			this.materia = materia;
			this.grupo = grupo;
			this.isbn = isbn;
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
		public int getCi() {
			return ci;
		}
		public void setCi(int ci) {
			this.ci = ci;
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
	
