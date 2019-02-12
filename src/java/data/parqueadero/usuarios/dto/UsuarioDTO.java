package data.parqueadero.usuarios.dto;

public class UsuarioDTO {
	private int id_usuario;
	private String nombre;
	private String correo;
	private String nombre_parqueadero;
	private String contrasena;
	private String tipo_usuario;
	
	public UsuarioDTO(){}
	
	public UsuarioDTO(int id_usuario){
		this.id_usuario = id_usuario;
	}
	
	public int getIdUsuario(){
		return this.id_usuario;
	}
	public void setIdUsuario(int id_usuario){
		this.id_usuario = id_usuario;
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
		return this.nombre_parqueadero;
	}
	public void setNombreParqueadero(String nombre_parqueadero){
		this.nombre_parqueadero = nombre_parqueadero;
	}
	
	public String getContrasena(){
		return this.contrasena;
	}
	public void setContrasena(String contrasena){
		this.contrasena = contrasena;
	}
	
	public String getTipoUsuario(){
		return this.tipo_usuario;
	}
	public void setTipoUsuario(String tipo_usuario){
		this.tipo_usuario = tipo_usuario;
	}

}
