/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.parqueadero.precios.dto;

/**
 *
 * @author JUAN
 */
public class PrecioDTO {
    private String id_precio;
    //va a ser el id_usuario + car/mot/vp
    private String tipoVehiculo;
    private double precio;
    
    public PrecioDTO(){}
    
    public PrecioDTO(String id_precio){
        this.id_precio = id_precio;
    }
    
    public String getIdPrecio(){
        return this.id_precio;
    }
    public void setIdPrecio(String id_precio){
        this.id_precio = id_precio;
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
    
}
