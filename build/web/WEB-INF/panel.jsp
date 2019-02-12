<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>Panel de Control | Parqueadero Web</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="../estilos/estilos.css" >
  </head>
  
  <body>


	<img src="../imgs/cintaP.png" width="100%" height="40">

	<div class="barra" > 
	<div id="header">
		<ul class="nav">
			<li><a href="${pageContext.request.contextPath}/panel.do">Inicio</a></li>
			<li><a >Configuraciones</a>
				<ul>
					<!--<li><a href="">Usuarios</a></li>-->
					<li><a href="${pageContext.request.contextPath}/regPrecios.do">Precios</a></li>
                                        
				</ul>
			</li>
		</ul>
	</div>

	<br/>
	<br/>
	</div>

	<h1 style="text-align:center">
		<img src="../imgs/parkingC.png" width="100">ARQUEADERO
	</h1>
	<br/>
	
	<html:form action="eleccionesPanel">
            <logic:notEmpty name="mensaje">
                <div id="mensaje"><bean:write name="mensaje" /></div>
            </logic:notEmpty>
	<div>
		<table style="margin: 0pt auto;" >
			<tr>
				<td>
					<!-- <input type="submit" value="Registrar"  style="width:150px;height:50px" />-->
					<html:submit property="eleccion" value="registrar" />
				</td>
				<td>
					<html:submit property="eleccion" value="reportes" />
				</td>
				<td>
					<!--<html:submit property="eleccion" value="acercaDeNosotros" />-->
                                        <a href="http://www.google.com" target="_blank" 
                                           style="background-color:yellow;color:black;border-style:solid;text-decoration:none;">
                                            Acerca de Nosotros
                                        </a>
					
				</td>
			</tr>			
		 </table>		 
		<br/>
	</div>
		</html:form>
	<br/>
	
	<form action="../cierreSesion.do">
		<input type="submit" value="Cerrar Sesion" />
	</form>

</body>

	<footer>

		Parqueadero Sistemas 2019 | Jonathan Macias

		<img src="../imgs/cintaP.png" width="100%" height="40">

	</footer>
</html:html>
