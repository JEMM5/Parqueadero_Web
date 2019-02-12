package web.parqueadero.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import modelo.Usuario;
import modelo.Precio;

import service.parqueadero.ParkingServicios;
import service.parqueadero.ParkingServiciosImpl;

/**
 *
 * @author JUAN
 */
public class IngresoPreciosAction extends Action{
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, 
                HttpServletRequest request, HttpServletResponse response){
        
        int id =((Usuario)request.getSession().getAttribute("usuarioIngresado")).getIdUsuario();
        ParkingServicios metodos = new ParkingServiciosImpl();
        
        //
        for(Precio precio : metodos.recuperarPreciosPorId(id)){
            //System.out.println("****" + precio.getPrecio()+ "++++" );
            
            if(precio.getTipoVehiculo().equals("Carro")){
                request.getSession().setAttribute(precio.getTipoVehiculo(),precio);
            }
            if(precio.getTipoVehiculo().equals("Moto")){
                request.getSession().setAttribute(precio.getTipoVehiculo(),precio);
            }  
            if(precio.getTipoVehiculo().equals("Vehiculo Pesado")){
                request.getSession().setAttribute(precio.getTipoVehiculo(),precio);
            }          
            
        }

         return mapping.findForward("devuelve");
    }
}
