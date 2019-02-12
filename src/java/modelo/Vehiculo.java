package modelo;

public class Vehiculo {

	private int id;
	private String tipoVehiculo;
	private String placa;
	private String horaEntrada;
	private String horaSalida;
	private int tiempo;
	private double valorPagar;
        private int idResponsable;
	private String responsable;
	
	public Vehiculo(){
		
	}
	public Vehiculo(int id, String tipoVehiculo, String placa, String horaEntrada, String horaSalida, int tiempo, double valorPagar, String responsable){
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.tiempo = tiempo;
		this.valorPagar = valorPagar;
		this.responsable = responsable;
	}
	
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	public String getTipoVehiculo(){
		return this.tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo){
		this.tipoVehiculo = tipoVehiculo;
	}
	
	public String getPlaca(){
		return this.placa;
	}
	public void setPlaca(String placa){
		this.placa = placa;
	}
	
	public String getHoraEntrada(){
		return this.horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada){
		this.horaEntrada = horaEntrada;
	}
	
	public String getHoraSalida(){
		return this.horaSalida;
	}
	public void setHoraSalida(String horaSalida){
		this.horaSalida = horaSalida;
	}
	
	public int getTiempo(){
		return this.tiempo;
	}
	public void setTiempo(int tiempo){
		this.tiempo = tiempo;
	}
	
	public double getValorPagar(){
		return this.valorPagar;
	}
	public void setValorPagar(double valorPagar){
		this.valorPagar = valorPagar;
	}
	
        public int getIdResponsable(){
            return this.idResponsable;
        }
        public void setIdResponsable(int idResponsable){
            this.idResponsable = idResponsable;
        }
        
	public String getResponsable(){
		return this.responsable;
	}
	public void setResponsable(String responsable){
		this.responsable = responsable;
	}
}