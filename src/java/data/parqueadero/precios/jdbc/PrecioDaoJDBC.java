package data.parqueadero.precios.jdbc;
import java.sql.*;
import data.parqueadero.precios.dto.PrecioDTO;
import java.util.*;
//la conexion
import data.parqueadero.usuarios.dto.UsuarioDTO;
import data.parqueadero.usuarios.jdbc.Conexion;

/**
 *
 * @author JUAN
 */
public class PrecioDaoJDBC implements PrecioDao{
    private Connection userConn = null;
    //aca insertamos la id tambien, por que la genera la DB sino nosotros
    private final String SQL_INSERT = "INSERT precio (id_precio, tipoVehiculo, precio) VALUES(?,?,?)";
    private final String SQL_UPDATE = "UPDATE precio SET precio=? WHERE id_precio=?";
    //private final String SQL_DELETE = "DELETE FROM precio WHERE id_precio=?";
    //este se debe modificar para que filtre los precios por usuario/cod filtrar en el proyecto de parqueadero/
    private final String SQL_SELECT = "SELECT id_precio, tipoVehiculo, precio FROM precio WHERE id_precio LIKE ";
    
    public PrecioDaoJDBC(){}
    
    public PrecioDaoJDBC(Connection cn){
        userConn = cn;
    }
    
    public boolean insert(PrecioDTO precioDTO){
        Connection cn = null;
        PreparedStatement pst = null;
        
        try{
            cn = (userConn==null) ? Conexion.getConnection() : userConn;
            pst = cn.prepareStatement(SQL_INSERT);
            pst.setString(1, precioDTO.getIdPrecio());
            pst.setString(2, precioDTO.getTipoVehiculo());
            pst.setDouble(3, precioDTO.getPrecio());
            System.out.println("Ejecutando Query: " + SQL_INSERT);
            pst.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }finally{
            Conexion.close(pst);
            if(cn == null){
                Conexion.close(cn);
            }
        }
        return true;
    }
    
    public boolean update(PrecioDTO precioDTO){
        Connection cn = null;
        PreparedStatement pst = null;
        try{
            cn = (userConn == null) ? Conexion.getConnection() : userConn;
            pst = cn.prepareStatement(SQL_UPDATE);
            pst.setDouble(1, precioDTO.getPrecio());
            
            pst.setString(2, precioDTO.getIdPrecio());
            System.out.println("Ejecutando Query: " + SQL_UPDATE);
            pst.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }finally{
            Conexion.close(pst);
            if(cn == null){
                Conexion.close(cn);
            }
        }
        
        return true;
    }
    
    //DE MOMENTO NO NECESITAMO METODO ELIMINAR
    
    public List<PrecioDTO> select(String idInicial){
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        PrecioDTO precioDTO = null;
        List<PrecioDTO> precios = new ArrayList<PrecioDTO>();
        try{
            cn = (userConn==null) ? Conexion.getConnection() : userConn;
            pst = cn.prepareStatement(SQL_SELECT + "'%" + idInicial + "%'");
            rs = pst.executeQuery();
            //el filtro q generamos en SQL_SELECT nos genera los precios de c/u de vehiclos
            while(rs.next()){
                String idPrecio = rs.getString(1);
                String tipoVehiculo = rs.getString(2);
                double precio = rs.getDouble(3);
                
                precioDTO = new PrecioDTO();
                precioDTO.setIdPrecio(idPrecio);
                precioDTO.setTipoVehiculo(tipoVehiculo);
                precioDTO.setPrecio(precio);
                
                precios.add(precioDTO);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(pst);
            if(cn == null){
                Conexion.close(cn);
            }
        }
        return precios;
    }
    
}
