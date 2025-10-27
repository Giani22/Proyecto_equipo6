package ventana;

public class Persona {

	int ci;
	String nombre;
	String apellido;
	String grupo;
	String materia;
	
	
	 public Persona(int ci,String nombre, String apellido,String grupo, String materia) {
	      this.ci = ci;
		 this.nombre = nombre;
	        this.apellido = apellido;
	        this.grupo=grupo;
	        this.materia=materia;
	       
	
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
	 public String getGrupo() {
		 return grupo;
	 }

	 public void setGrupo(String grupo) {
		 this.grupo = grupo;
	 }

	 public String getMateria() {
		 return materia;
	 }

	 public void setMateria(String materia) {
		 this.materia = materia;
	 }

	
	 
}
	

