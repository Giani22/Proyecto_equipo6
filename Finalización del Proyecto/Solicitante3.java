package ventana;

public class Solicitante3  {

		int ci;
		String nombre, apellido;
		String materia, grupo;
		
		
		public Solicitante3(int ci,String nombre, String apellido, String materia, String grupo) {
			super();
			
			this.ci = ci;
			this.nombre = nombre;
			this.apellido = apellido;
			this.materia = materia;
			this.grupo = grupo;
			
			
		}


		public int getCi() {
			return ci;
		}


		public void setCi(int ci) {
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


		public static String getIsbn() {
			
			return null;
		}
		
	
	}

