/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package web.parqueadero.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import service.ticket.Reporte;

/** 
 * MyEclipse Struts
 * Creation date: 02-03-2019
 * 
 * XDoclet definition:
 * @struts.action
 */
public class BuscaYearAction extends Action {
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
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		String year = request.getParameter("year");
		int ano = 0;
                int idResponsable = ((Usuario)request.getSession().getAttribute("usuarioIngresado")).getIdUsuario();
		boolean bandera = false;
		

		//
		try{
			ano = Integer.parseInt(year);
		}catch(Exception e){
			bandera = true;
		}
		
		if(bandera){
			request.setAttribute("mensaje", "Por favor ingresa un año valido");
			
		}else{
                    Reporte reporte = new Reporte(year, idResponsable);
                    reporte.GenerarReporteAnual();
                    /*
			//ejecutar metodo para buscar por ano
			
			//debe rerecibir como respuesta un listado de enlaces con ano y mes para clasificarlos
			List<String> enlaces = new ArrayList<String>();
			//ejemplo de recuperar el listado
			List<String> eP = new ArrayList<String>();
			eP.add("2019-02-03");
			eP.add("2019-05-12");
			eP.add("2019-12-03");
			eP.add("2019-12-06");
			eP.add("2019-12-08");
			//parte de� eje,plo
			enlaces = eP;
			
			List<String> enero = new ArrayList<String>();
			List<String> febrero = new ArrayList<String>();
			List<String> marzo = new ArrayList<String>();
			List<String> abril = new ArrayList<String>();
			List<String> mayo = new ArrayList<String>();
			List<String> junio = new ArrayList<String>();
			List<String> julio = new ArrayList<String>();
			List<String> agosto = new ArrayList<String>();
			List<String> septiembre = new ArrayList<String>();
			List<String> octubre = new ArrayList<String>();
			List<String> noviembre = new ArrayList<String>();
			List<String> diciembre = new ArrayList<String>();
			
			for(String e : enlaces){
				//2018-02-03.pdf
				if(e.substring(5, 7).equals("01")){
					enero.add(e);
				}else if(e.substring(5, 7).equals("02")){
					febrero.add(e);
				}else if(e.substring(5, 7).equals("03")){
					marzo.add(e);
				}else if(e.substring(5, 7).equals("04")){
					abril.add(e);
				}else if(e.substring(5, 7).equals("05")){
					mayo.add(e);
				}else if(e.substring(5, 7).equals("06")){
					junio.add(e);
				}else if(e.substring(5, 7).equals("07")){
					julio.add(e);
				}else if(e.substring(5, 7).equals("08")){
					agosto.add(e);
				}else if(e.substring(5, 7).equals("09")){
					septiembre.add(e);
				}else if(e.substring(5, 7).equals("10")){
					octubre.add(e);
				}else if(e.substring(5, 7).equals("11")){
					noviembre.add(e);
				}else if(e.substring(5, 7).equals("12")){
					diciembre.add(e);
				}
			}
			
			if(enero.size() != 0){
				request.setAttribute("enero", enero);
			}
			if(febrero.size() != 0){
				request.setAttribute("febrero", febrero);
			}
			if(marzo.size() != 0){
				request.setAttribute("marzo", marzo);
			}
			if(abril.size() != 0){
				request.setAttribute("abril", abril);
			}
			if(mayo.size() != 0){
				request.setAttribute("mayo", mayo);
			}
			if(junio.size() != 0){
				request.setAttribute("junio", junio);
			}
			if(julio.size() != 0){
				request.setAttribute("julio", julio);
			}
			if(agosto.size() != 0){
				request.setAttribute("agosto", agosto);
			}
			if(septiembre.size() != 0){
				request.setAttribute("septiembre", septiembre);
			}
			if(octubre.size() != 0){
				request.setAttribute("octubre", octubre);
			}
			if(noviembre.size() != 0){
				request.setAttribute("noviembre", noviembre);
			}
			if(diciembre.size() != 0){
				request.setAttribute("diciembre", diciembre);
			}	
                    */    
			
		}
		return mapping.findForward("respuesta");
		
	}
}