package ventana;

public class PideCeibalita {

	String ci;
	String nombre;
	String apellido;
	String materia;
	String grupo;
	int id;
	
	 public PideCeibalita(String ci,String nombre, String apellido,String materia,String grupo, int id) {
		this.ci=ci;
		 this.nombre = nombre;
	        this.apellido = apellido;
	        this.materia=materia;
	        this.grupo=grupo;
	        this.id=id;
	
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
	 
	 public int getId() {
		 return id;
	 }

	 public void setId(int id) {
		 this.id = (int) id;
	 }
}

	

