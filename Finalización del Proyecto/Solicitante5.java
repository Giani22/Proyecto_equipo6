package ventana;

public class Solicitante5 {

	private int id;
	private int ci;
    private String nombre;
    private String apellido;
    private String materia;
    private String grupo;
    private String numero;

    
    

    public Solicitante5(int id, int ci,String nombre, String apellido, String materia, String grupo, String numero) {
    	this.id=id;
    	this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.materia = materia;
        this.grupo = grupo;
        this.numero=numero;
}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
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




	public String getNumero() {
		return numero;
	}




	public void setNumero(String numero) {
		this.numero = numero;
	}




	
	
}
