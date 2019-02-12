package service.parqueadero;

import modelo.Usuario;
import data.parqueadero.usuarios.dto.UsuarioDTO;
import data.parqueadero.usuarios.jdbc.UsuarioDao;
import data.parqueadero.usuarios.jdbc.UsuarioDaoJDBC;
import data.parqueadero.usuarios.jdbc.Conexion;

import java.util.List;
import java.util.ArrayList;

import modelo.Precio;
import data.parqueadero.precios.dto.PrecioDTO;
import data.parqueadero.precios.jdbc.PrecioDao;
import data.parqueadero.precios.jdbc.PrecioDaoJDBC;

import modelo.Vehiculo;
import data.parqueadero.parqueos.dto.ParqueoDTO;
import data.parqueadero.parqueos.jdbc.ParqueoDao;
import data.parqueadero.parqueos.jdbc.ParqueoDaoJDBC;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParkingServiciosImpl implements ParkingServicios{
    
    public ParkingServiciosImpl(){
    
    }
    @Override
    public void registrarUsuario(Usuario u){
        UsuarioDTO usuarioRegistrar = new UsuarioDTO();
        usuarioRegistrar.setNombre(u.getNombre());
        usuarioRegistrar.setCorreo(u.getCorreo());
        usuarioRegistrar.setNombreParqueadero(u.getNombreParqueadero());
        usuarioRegistrar.setContrasena(u.getContrasena());
        usuarioRegistrar.setTipoUsuario(u.getTipoUsuario());
        
        UsuarioDao metodos = new UsuarioDaoJDBC();
        metodos.insert(usuarioRegistrar);        
    }
    
    @Override
    public Usuario verificarUsuario(Usuario u){
        UsuarioDao metodos = new UsuarioDaoJDBC();        
        List<UsuarioDTO> usuarios = metodos.select();
        Usuario usuarioEnviar = null;
        //boolean banderaUsuario = false;
        
        for(UsuarioDTO uDTO : usuarios){
            System.out.println("---" + u.getNombre() + "***" + uDTO.getNombre());
            
            if(u.getNombre().equals(uDTO.getNombre()) && 
               u.getContrasena().equals(uDTO.getContrasena()) && 
               u.getTipoUsuario().equals(uDTO.getTipoUsuario())){
                //banderaUsuario = true;
                usuarioEnviar = new Usuario();
                usuarioEnviar.setIdUsuario(uDTO.getIdUsuario());
                usuarioEnviar.setNombre(uDTO.getNombre());
                usuarioEnviar.setCorreo(uDTO.getCorreo());
                usuarioEnviar.setNombreParqueadero(uDTO.getNombreParqueadero());
                usuarioEnviar.setContrasena(uDTO.getContrasena());
                usuarioEnviar.setTipoUsuario(uDTO.getTipoUsuario());
                
                         
            }
        }      
        return usuarioEnviar;
        
    }
    
    
    
    //
    @Override
    public boolean registrarPrecios(Precio p){
        PrecioDTO precioDTO = new PrecioDTO();
        precioDTO.setIdPrecio(p.getIdPrecio());
        precioDTO.setTipoVehiculo(p.getTipoVehiculo());
        precioDTO.setPrecio(p.getPrecio());
        
        PrecioDao metodosP = new PrecioDaoJDBC();
        boolean banderaConexion = metodosP.insert(precioDTO);
        
        return banderaConexion;

    }
    @Override
    public List<Precio> recuperarPreciosPorId(int id){
        List<Precio> precios = new ArrayList<Precio>();
        PrecioDao metodos = new PrecioDaoJDBC();
        List<PrecioDTO> preciosDTO = metodos.select(Integer.toString(id));
        
        for(PrecioDTO precioDTO : preciosDTO){
            precios.add(new Precio(precioDTO.getIdPrecio(),precioDTO.getTipoVehiculo(),precioDTO.getPrecio()));
        }
        
        return precios;
    }
    @Override
    public boolean modificarPrecios(Precio p){
        PrecioDTO precioDTO = new PrecioDTO();
        precioDTO.setIdPrecio(p.getIdPrecio());
        precioDTO.setTipoVehiculo(p.getIdPrecio());
        precioDTO.setPrecio(p.getPrecio());
        
        PrecioDao metodos = new PrecioDaoJDBC();
        boolean banderaConexion = metodos.update(precioDTO);
        return banderaConexion;
    }
    
    //
    @Override
    public void registrarParqueo(Vehiculo parqueo){
        ParqueoDTO parqueoDTO = new ParqueoDTO();
        //parqueoDTO.setIdParqueo(parqueo.getId());
        parqueoDTO.setTipoVehiculo(parqueo.getTipoVehiculo());
        parqueoDTO.setPlaca(parqueo.getPlaca());
        parqueoDTO.setHoraEntrada(parqueo.getHoraEntrada());
        parqueoDTO.setIdResponsable(parqueo.getIdResponsable());
        parqueoDTO.setResponsable(parqueo.getResponsable());
        
        ParqueoDao metodos = new ParqueoDaoJDBC();
        metodos.insert(parqueoDTO);
    }
    @Override
    public List<Vehiculo> listarParqueosPendientes(int idResponsable){
        List<Vehiculo> parqueos = new ArrayList<Vehiculo>();
        ParqueoDao metodos = new ParqueoDaoJDBC();
        
        for(ParqueoDTO pDTO : metodos.select(idResponsable)){
            Vehiculo p = new Vehiculo();
            p.setId(pDTO.getIdParqueo());
            p.setTipoVehiculo(pDTO.getTipoVehiculo());
            p.setPlaca(pDTO.getPlaca());
            p.setHoraEntrada(pDTO.getHoraEntrada());
            parqueos.add(p);
        }
        
        return parqueos;
    }
    
    @Override
    public void finalizarParqueo(Vehiculo parqueo){
        ParqueoDTO parqueoDTO = new ParqueoDTO();
        parqueoDTO.setIdParqueo(parqueo.getId());
        parqueoDTO.setHoraSalida(parqueo.getHoraSalida());
        parqueoDTO.setTiempo(parqueo.getTiempo());
        parqueoDTO.setValorPagar(parqueo.getValorPagar());
        
        ParqueoDao metodos = new ParqueoDaoJDBC();
        metodos.update(parqueoDTO);
    }
    
    //
    @Override
    public int conocerTiempo(String hEntrada){
        int minutosACobrar = 0;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String fechaHora = dateFormat.format(date);     
        
        String horaSalida = hEntrada;
        try {
            Date horasalida = dateFormat.parse(horaSalida);
            minutosACobrar = (int) (date.getTime()-horasalida.getTime())/60000;
        } catch (ParseException ex) {
            Logger.getLogger(ParkingServiciosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return minutosACobrar;
    }
    
    @Override
    public double generarValorParqueo(int tiempoMinutos, double precioHora){
        return tiempoMinutos * (precioHora/60);
    }
}
