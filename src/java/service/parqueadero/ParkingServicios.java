package service.parqueadero;
import modelo.Usuario;
import modelo.Precio;
import modelo.Vehiculo;
import java.util.List;


public interface ParkingServicios {
    
    public void registrarUsuario(Usuario u);
    public Usuario verificarUsuario(Usuario u);
    
    
    
    //
    public boolean registrarPrecios (Precio p);
    
    public List<Precio> recuperarPreciosPorId(int id);
    
    public boolean modificarPrecios(Precio p);
    
    
    //
    public void registrarParqueo(Vehiculo parqueo);
    public List<Vehiculo> listarParqueosPendientes(int idResponsable);
    public void finalizarParqueo(Vehiculo parqueo);
    
    //
    public int conocerTiempo(String hEntrada);
    public double generarValorParqueo(int tiempoMinutos, double precioHora);
}
