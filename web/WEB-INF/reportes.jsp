<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>Reportes | Parqueadero Web</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="../estilos/estilos.css">
  </head>
  
  <body>

	<img src="../imgs/cintaP.png" width="100%" height="40">

	<div class="barra"> 
	<div id="header">
		<ul class="nav">
			<li><a href="${pageContext.request.contextPath}/panel.do">Inicio</a></li>
			<li><a href="">Configuraciones</a>
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
	<span>Usuario: <bean:write name="usuarioIngresado" property="nombre" /></span>
	<p style="text-align:center">__________________________________________________________________________________________________________________________________________</p>
	<h3 style="text-align:center">Reportes</h3>

	<form action="../buscaYear.do">
		<table>
			<tr>
				<td>
					Buscar:
				</td>
				<td>
					<input type="text" value=""  name="year"/>
				</td>
				<td>
					<input type="submit" value="Buscar" />  
				</td>
				<td>
					<logic:notEmpty name="mensaje">
						<bean:write name="mensaje" />
					</logic:notEmpty>
				</td>
			</tr>
		</table>
	</form>
	
	<ul>
	<logic:notEmpty name="diciembre">
				<h3>Diciembre</h3>		
			<logic:iterate id="dic" name="diciembre">
				<li>
					<img src="../imgs/excel.png"  width="30">
					<bean:write name="dic"  />
				</li>
			</logic:iterate>
	</logic:notEmpty>
	
	<logic:notEmpty name="noviembre">
		<h3>Noviembre</h3>
			<logic:iterate id="nov" name="noviembre">				
				<li>
					<img src="../imgs/excel.png"  width="30">
					<bean:write name="nov"  />
				</li>
			</logic:iterate>
	</logic:notEmpty>
	
		<logic:notEmpty name="octubre">
		<h3>Octubre</h3>
			<logic:iterate id="oct" name="octubre">				
				<li>
					<img src="../imgs/excel.png"  width="30">
					<bean:write name="oct"  />
				</li>
			</logic:iterate>
	</logic:notEmpty>		
	
	<logic:notEmpty name="septiembre">
	<h3>Septiembre</h3>
			<logic:iterate id="sep" name="septiembre">				
				<li>
					<img src="../imgs/excel.png"  width="30">
					<bean:write name="sep"  />
				</li>
			</logic:iterate>
	</logic:notEmpty>	

	<logic:notEmpty name="agosto">
	<h3>Agosto</h3>
			<logic:iterate id="ago" name="agosto">				
				<li>
					<img src="../imgs/excel.png"  width="30">
					<bean:write name="ago"  />
				</li>
			</logic:iterate>
	</logic:notEmpty>	

	<logic:notEmpty name="julio">
	<h3>Julio</h3>
			<logic:iterate id="jul" name="julio">				
				<li>
					<img src="../imgs/excel.png"  width="30">
					<bean:write name="jul"  />
				</li>
			</logic:iterate>
	</logic:notEmpty>	
	
	<logic:notEmpty name="junio">
	<h3>Junio</h3>
			<logic:iterate id="jun" name="junio">				
				<li>
					<img src="../imgs/excel.png"  width="30">
					<bean:write name="jun"  />
				</li>
			</logic:iterate>
	</logic:notEmpty>		

	<logic:notEmpty name="mayo">
	<h3>Mayo</h3>
			<logic:iterate id="may" name="mayo">				
				<li>
					<img src="../imgs/excel.png"  width="30">
					<bean:write name="may"  />
				</li>
			</logic:iterate>
	</logic:notEmpty>	

	<logic:notEmpty name="abril">
	<h3>Abril</h3>
			<logic:iterate id="abr" name="abril">				
				<li>
					<img src="../imgs/excel.png"  width="30">
					<bean:write name="abr"  />
				</li>
			</logic:iterate>
	</logic:notEmpty>	

	<logic:notEmpty name="marzo">
	<h3>Marzo</h3>
			<logic:iterate id="mar" name="marzo">				
				<li>
					<img src="../imgs/excel.png"  width="30">
					<bean:write name="mar"  />
				</li>
			</logic:iterate>
	</logic:notEmpty>	

	<logic:notEmpty name="febrero">
	<h3>Febrero</h3>
			<logic:iterate id="feb" name="febrero">				
				<li>
					<img src="../imgs/excel.png"  width="30">
					<bean:write name="feb"  />
				</li>
			</logic:iterate>
	</logic:notEmpty>	

	<logic:notEmpty name="enero">
	<h3>Enero</h3>
			<logic:iterate id="ene" name="enero">				
				<li>
					<img src="../imgs/excel.png"  width="30">
					<bean:write name="ene"  />
				</li>
			</logic:iterate>
	</logic:notEmpty>	

		</ul>	
		
	<form action="../panel.do">
		<div style="float:right">
				<input type="submit" value="<|" style="width:100px;height:30px" />
		</div>
	</form>
	<br/><br/>
	<br/><br/>

  </body>

	<footer>
		Parqueadero Sistemas 2019 | Jonathan Macias
		<img src="../imgs/cintaP.png" width="100%" height="40">
	</footer>
  
</html:html>
