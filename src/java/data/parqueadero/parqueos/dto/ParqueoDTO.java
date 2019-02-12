/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.parqueadero.parqueos.dto;

/**
 *
 * @author JUAN
 */
public class ParqueoDTO {


	private int id_parqueo;
	private String tipo_vehiculo;
	private String placa;
	private String hora_entrada;
	private String hora_salida;
	private int tiempo_minutos;
	private double valor_pagar;
	private int id_responsable;
        private String responsable;
	
	public ParqueoDTO(){
		
	}
	
	public int getIdParqueo(){
		return this.id_parqueo;
	}
	public void setIdParqueo(int id_parqueo){
		this.id_parqueo = id_parqueo;
	}
	
	public String getTipoVehiculo(){
		return this.tipo_vehiculo;
	}
	public void setTipoVehiculo(String tipo_vehiculo){
		this.tipo_vehiculo = tipo_vehiculo;
	}
	
	public String getPlaca(){
		return this.placa;
	}
	public void setPlaca(String placa){
		this.placa = placa;
	}
	
	public String getHoraEntrada(){
		return this.hora_entrada;
	}
	public void setHoraEntrada(String hora_entrada){
		this.hora_entrada = hora_entrada;
	}
	
	public String getHoraSalida(){
		return this.hora_salida;
	}
	public void setHoraSalida(String hora_salida){
		this.hora_salida = hora_salida;
	}
	
	public int getTiempo(){
		return this.tiempo_minutos;
	}
	public void setTiempo(int tiempo_minutos){
		this.tiempo_minutos = tiempo_minutos;
	}
	
	public double getValorPagar(){
		return this.valor_pagar;
	}
	public void setValorPagar(double valor_pagar){
		this.valor_pagar = valor_pagar;
	}
        
        public int getIdResponsable(){
            return this.id_responsable;
        }
        
        public void setIdResponsable(int id_responsable){
            this.id_responsable = id_responsable;
        }
	
	public String getResponsable(){
		return this.responsable;
	}
	public void setResponsable(String responsable){
		this.responsable = responsable;
	}    
}
