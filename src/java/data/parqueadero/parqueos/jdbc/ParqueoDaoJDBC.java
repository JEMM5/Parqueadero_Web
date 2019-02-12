package data.parqueadero.parqueos.jdbc;
import java.sql.*;
import data.parqueadero.parqueos.dto.ParqueoDTO;
import java.util.*;
//la conexion
import data.parqueadero.usuarios.jdbc.Conexion;
/**
 *
 * @author JUAN
 */
public class ParqueoDaoJDBC implements ParqueoDao{
    private Connection userConn = null;
    private final String SQL_INSERT = "INSERT parqueo (tipo_vehiculo,placa,hora_entrada,id_responsable,responsable) VALUES(?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE parqueo SET hora_salida=?, tiempo_minutos=?, valor_pagar=? WHERE id_parqueo=?";
    private final String SQL_SELECT = "SELECT * FROM parqueo WHERE hora_salida IS NULL AND id_responsable LIKE '%";
    
    
    
    public ParqueoDaoJDBC(){}
    
    public ParqueoDaoJDBC(Connection cn){
        userConn = cn;
    }
    public void insert(ParqueoDTO parqueoDTO){
        Connection cn = null;
        PreparedStatement pst = null;        
        try{
            cn = (userConn==null) ? Conexion.getConnection() : userConn;
            pst = cn.prepareStatement(SQL_INSERT);
            //pst.setInt(1, parqueoDTO.getIdParqueo());
            pst.setString(1, parqueoDTO.getTipoVehiculo());
            pst.setString(2, parqueoDTO.getPlaca());
            pst.setString(3, parqueoDTO.getHoraEntrada());
            pst.setInt(4, parqueoDTO.getIdResponsable());
            pst.setString(5, parqueoDTO.getResponsable());
            
            System.out.println("Ejecutando Query: " + SQL_INSERT);
            pst.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(pst);
            if(cn == null){
                Conexion.close(cn);
            }
        }
    }
    
    public void update(ParqueoDTO parqueoDTO){
        Connection cn = null;
        PreparedStatement pst = null;
        try{
            cn = (userConn == null) ? Conexion.getConnection() : userConn;
            pst = cn.prepareStatement(SQL_UPDATE);
            pst.setString(1, parqueoDTO.getHoraSalida());
            pst.setInt(2, parqueoDTO.getTiempo());
            pst.setDouble(3, parqueoDTO.getValorPagar());
            
            pst.setInt(4, parqueoDTO.getIdParqueo());
            System.out.println("Ejecutando Query: " + SQL_UPDATE);
            pst.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            Conexion.close(pst);
            if(cn == null){
                Conexion.close(cn);
            }
        }
    }
    /*
    public int returnId(ParqueoDTO pDTO){
    String SQL_SELECT_ONE = "SELECT id_parqueo FROM parqueo WHERE tipo_vehiculo LIKE '%"
                    +pDTO.getTipoVehiculo()+"%' AND placa LIKE'%"+pDTO.getPlaca()+"%' AND hora_entrada LIKE '%"
                    +pDTO.getHoraEntrada()+"%'";
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int idRetornar = 0;
        //ParqueoDTO parqueoDTO = null;
        //List<ParqueoDTO> parqueos = new ArrayList<ParqueoDTO>();
        try{
            cn = (userConn == null) ? Conexion.getConnection() : userConn;
            pst = cn.prepareStatement(SQL_SELECT_ONE);
            rs = pst.executeQuery();
            System.out.println("Ejecutando Query: " + SQL_SELECT_ONE);
            if(rs.next()){
                idRetornar = rs.getInt(1);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            Conexion.close(pst);
            if(cn == null){
                Conexion.close(cn);
            }
        }
        return idRetornar;
    }
    */
    public List<ParqueoDTO> select(int idResponsable){
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        ParqueoDTO parqueoDTO = null;
        List<ParqueoDTO> parqueos = new ArrayList<ParqueoDTO>();
        try{
            cn = (userConn==null) ? Conexion.getConnection() : userConn;
            pst = cn.prepareStatement(SQL_SELECT +idResponsable+"%' ORDER BY id_parqueo");
            rs = pst.executeQuery();
            //el filtro q generamos en SQL_SELECT nos genera los precios de c/u de vehiclos
            while(rs.next()){
                int idParqueo = rs.getInt(1);
                String tipoVehiculo = rs.getString(2);
                String placa = rs.getString(3);
                String horaEntrada = rs.getString(4);
                
                parqueoDTO = new ParqueoDTO();
                parqueoDTO.setIdParqueo(idParqueo);
                parqueoDTO.setTipoVehiculo(tipoVehiculo);
                parqueoDTO.setPlaca(placa);
                parqueoDTO.setHoraEntrada(horaEntrada);

                parqueos.add(parqueoDTO);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(pst);
            if(cn == null){
                Conexion.close(cn);
            }
        }
        return parqueos;
    }    
    
}
