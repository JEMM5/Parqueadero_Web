package data.parqueadero.usuarios.jdbc;
import java.util.List;
import data.parqueadero.usuarios.dto.UsuarioDTO;

public interface UsuarioDao {
	
	public int insert(UsuarioDTO usuario);
	public int update(UsuarioDTO usuario);
	public int delete(UsuarioDTO usuario);
	public List<UsuarioDTO> select();
}
