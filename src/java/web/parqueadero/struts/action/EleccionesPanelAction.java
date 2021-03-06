/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package web.parqueadero.struts.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Precio;
import modelo.Usuario;
import modelo.Vehiculo;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import service.parqueadero.ParkingServicios;
import service.parqueadero.ParkingServiciosImpl;

/** 
 * MyEclipse Struts
 * Creation date: 02-02-2019
 * 
 * XDoclet definition:
 * @struts.action
 */
public class EleccionesPanelAction extends DispatchAction {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward registrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
            //RECUPERAR LOS PRECIOS PARA PODER REGISTRAR
        int id =((Usuario)request.getSession().getAttribute("usuarioIngresado")).getIdUsuario();
        ParkingServicios metodos = new ParkingServiciosImpl();
        
        boolean bCar = false;
        boolean bMot = false;
        boolean bVP = false;
        //
        for(Precio precio : metodos.recuperarPreciosPorId(id)){
            //System.out.println("****" + precio.getPrecio()+ "++++" );
            
            if(precio.getTipoVehiculo().equals("Carro")){
                request.getSession().setAttribute(precio.getTipoVehiculo(),precio);
                bCar = true;
            }
            if(precio.getTipoVehiculo().equals("Moto")){
                request.getSession().setAttribute(precio.getTipoVehiculo(),precio);
                bMot = true;
            }  
            if(precio.getTipoVehiculo().equals("Vehiculo Pesado")){
                request.getSession().setAttribute(precio.getTipoVehiculo(),precio);
                bVP = true;
            } 
        }


            if(bCar && bMot && bVP){
                int idResponsable = ((Usuario)request.getSession().getAttribute("usuarioIngresado")).getIdUsuario();
                ParkingServicios servicios = new ParkingServiciosImpl();
                
                List<Vehiculo> parqueos = servicios.listarParqueosPendientes(idResponsable);
                HttpSession sesion = request.getSession();
                sesion.setAttribute("parqueos", parqueos);                
		return mapping.findForward("registra");            
            }else{
                request.setAttribute("mensaje","Por favor ingresa el Valor de Parqueo para cada tipo de vehiculo");
                return mapping.findForward("sinprecios");
            }                         
                

	}
	public ActionForward reportes(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		return mapping.findForward("reporta");
	}
	public ActionForward acercaDeNosotros(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		return mapping.findForward("acerca");
	}
}