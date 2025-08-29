package ventana2;

public class Solicitante {

	
		String nombre, apellido;
		int ci, nroTel;
		String materia, grupo;
		int isbn;
		public Solicitante(String nombre, String apellido, int ci, int nroTel, String materia, String grupo, int isbn) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.ci = ci;
			this.nroTel = nroTel;
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
		public int getNroTel() {
			return nroTel;
		}
		public void setNroTel(int nroTel) {
			this.nroTel = nroTel;
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
		public int getIsbn() {
			return isbn;
		}
		public void setIsbn(int isbn) {
			this.isbn = isbn;
		}
		
	}
	

