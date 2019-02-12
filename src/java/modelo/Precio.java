package modelo;

public class Precio {
        private String idPrecio;
	private String tipoVehiculo;
	private double precio;
	
	public Precio(){
		
	}
	
	public Precio(String idPrecio, String tipoVehiculo, double precio){
		this.idPrecio = idPrecio;
                this.tipoVehiculo = tipoVehiculo;
		this.precio = precio;
	}
        
        public String getIdPrecio(){
            return this.idPrecio;
        }
        
        public void setIdPrecio(String idPrecio){
            this.idPrecio = idPrecio;
        }
	
	public String getTipoVehiculo(){
		return this.tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo){
		this.tipoVehiculo = tipoVehiculo;
	}
	
	public double getPrecio(){
		return this.precio;
	}
	public void setPrecio(double precio){
		this.precio = precio;
	}
	
	public double getPrecioMinuto(){
		return this.precio/60;
	}

}
