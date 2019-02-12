package data.parqueadero.usuarios.jdbc;
import java.sql.*;
import data.parqueadero.usuarios.dto.UsuarioDTO;
import java.util.*;

public class UsuarioDaoJDBC implements UsuarioDao{
	private Connection userConn = null;
	private final String SQL_INSERT = "INSERT usuario(nombre,correo,nombre_parqueadero,contrasena,tipo_usuario) VALUES(?,?,?,?,?)";
	private final String SQL_UPDATE = "UPDATE usuario SET nombre=?, correo=?, nombre_parqueadero=?, contrasena=? WHERE id_usuario=?";
	private final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario=?";
	private final String SQL_SELECT = "SELECT id_usuario, nombre, correo, nombre_parqueadero, contrasena, tipo_usuario FROM usuario ORDER BY id_usuario";
	
	public UsuarioDaoJDBC(){}
	
	public UsuarioDaoJDBC(Connection cn){
		this.userConn = cn;
	}
	

	public int insert(UsuarioDTO usuario){
		Connection cn = null;
		PreparedStatement pst = null;
		int rows = 0;
		try{
			cn = (userConn == null) ? Conexion.getConnection() : userConn;
			//cn = Conexion.getConnection();
			pst = cn.prepareStatement(SQL_INSERT);
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getCorreo());
			pst.setString(3, usuario.getNombreParqueadero());
			pst.setString(4, usuario.getContrasena());
			pst.setString(5, usuario.getTipoUsuario());
			System.out.println("Ejecutando Query: " + SQL_INSERT);
			rows = pst.executeUpdate();
			System.out.println("Registros Ingresados: " + rows);
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			Conexion.close(pst);
			if(cn == null){
				Conexion.close(cn);
			}
		}
		return rows;
	}
	
	public int update(UsuarioDTO usuario){
            Connection cn = null;
            PreparedStatement pst = null;
            int rows = 0;
            try{
                cn = (userConn == null) ? Conexion.getConnection() : userConn;
                pst = cn.prepareStatement(SQL_UPDATE);
                pst.setString(1, usuario.getNombre());
                pst.setString(2, usuario.getCorreo());
                pst.setString(3, usuario.getNombreParqueadero());
                pst.setString(4, usuario.getContrasena());
                
                pst.setInt(5, usuario.getIdUsuario());
                System.out.println("Ejecutando Query: " + SQL_UPDATE);
                rows = pst.executeUpdate();
                System.out.println("Registros actualizados: " + rows);            
            }catch(SQLException ex){
                ex.printStackTrace();
            }finally{
                Conexion.close(pst);
                if(cn == null){
                    Conexion.close(cn);
                }
            }
            return rows;
	}
	public int delete(UsuarioDTO usuario){
            Connection cn = null;
            PreparedStatement pst = null;
            int rows = 0;
            try{
                cn = (userConn == null) ? Conexion.getConnection() : userConn;
                pst = cn.prepareStatement(SQL_DELETE);
                pst.setInt(1, usuario.getIdUsuario());
                System.out.println("Ejecutando Query: " + SQL_DELETE);
                rows = pst.executeUpdate();
                System.out.println("Registros Eliminados: " + rows);
            }catch(SQLException ex){
                ex.printStackTrace();
            }finally{
                Conexion.close(pst);
                if(cn == null){
                    Conexion.close(cn);
                }
            }
            return rows;
	}
	public List<UsuarioDTO> select(){
            Connection cn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            UsuarioDTO usuarioDTO = null;
            List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
            
            try{
                cn = (userConn==null) ? Conexion.getConnection() : userConn;
                pst = cn.prepareStatement(SQL_SELECT);
                rs = pst.executeQuery();
                System.out.println("+++++++++++");
                while(rs.next()){
                    
                    int idUsuarioTemp = rs.getInt(1);
                    String nombreTemp = rs.getString(2);
                    String correoTemp = rs.getString(3);
                    String nombreParqueaderoTemp = rs.getString(4);
                    String contrasena = rs.getString(5);
                    String tipoUsuario = rs.getString(6);
                    System.out.println(idUsuarioTemp + "+++" + nombreTemp);
                    
                    usuarioDTO = new UsuarioDTO();
                    usuarioDTO.setIdUsuario(idUsuarioTemp);
                    usuarioDTO.setNombre(nombreTemp);
                    usuarioDTO.setCorreo(correoTemp);
                    usuarioDTO.setNombreParqueadero(nombreParqueaderoTemp);
                    usuarioDTO.setContrasena(contrasena);
                    usuarioDTO.setTipoUsuario(tipoUsuario);
                    
                    usuarios.add(usuarioDTO);
                }
            }catch(SQLException ex){
                System.out.println("**************************************************");
                ex.printStackTrace();
            }finally{
                Conexion.close(rs);
                Conexion.close(pst);
                if(cn == null){
                    Conexion.close(cn);
                }
            }
            return usuarios;
	}

}
