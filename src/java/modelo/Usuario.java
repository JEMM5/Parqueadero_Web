package modelo;

public class Usuario {
	
        private int idUsuario;
	private String nombre;
	private String correo;
	private String nombreParqueadero;
	private String contrasena;
	private String tipoUsuario;
        
        public Usuario(){}
	
	public Usuario(String nombre,String correo,String nombreParqueadero, String contrasena, String tipoUsuario){
		this.nombre = nombre;
		this.correo = correo;
		this.nombreParqueadero = nombreParqueadero;
		this.contrasena = contrasena;
		this.tipoUsuario = tipoUsuario;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getCorreo(){
		return this.correo;
	}
	public void setCorreo(String correo){
		this.correo = correo;
	}
	
	public String getNombreParqueadero(){
		return this.nombreParqueadero;
	}
	public void setNombreParqueadero(String nombreParqueadero){
		this.nombreParqueadero = nombreParqueadero;
	}
	
	public String getContrasena(){
		return this.contrasena;
	}
	public void setContrasena(String contrasena){
		this.contrasena = contrasena;
	}
	
	public String getTipoUsuario(){
		return this.tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario){
		this.tipoUsuario = tipoUsuario;
	}
        
        public int getIdUsuario(){
            return this.idUsuario;
        }
        public void setIdUsuario(int idUsuario){
            this.idUsuario =  idUsuario;
        }

}
