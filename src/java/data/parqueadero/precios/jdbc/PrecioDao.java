package data.parqueadero.precios.jdbc;
import java.util.List;
import data.parqueadero.precios.dto.PrecioDTO;
/**
 *
 * @author JUAN
 */
public interface PrecioDao {
    
    public boolean insert(PrecioDTO precioDTO);
    public boolean update(PrecioDTO precioDTO);
    //public void delete(PrecioDTO precioDTO);
    public List<PrecioDTO> select(String idInicial);
    
}
