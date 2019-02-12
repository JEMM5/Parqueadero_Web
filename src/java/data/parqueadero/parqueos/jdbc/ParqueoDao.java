package data.parqueadero.parqueos.jdbc;
import java.util.List;
import data.parqueadero.parqueos.dto.ParqueoDTO;

/**
 *
 * @author JUAN
 */
public interface ParqueoDao {
    
    public void insert(ParqueoDTO parqueoDTO);
    public void update(ParqueoDTO parqueoDTO);
    
    public List<ParqueoDTO> select(int idResponsable);
    //public int returnId(ParqueoDTO pDTO);
}
