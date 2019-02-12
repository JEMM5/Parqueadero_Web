<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>Bienvenido a Parqueadero Web</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="estilos/estilos.css">
  </head>
  
  <body> 
	<img src="imgs/cintaP.png" width="100%" height="40">


	<!--la barra de opciones-->
	<div class="barra"> 
	<div id="header">
		<ul class="nav">
			<li><a href="">Inicio</a></li>
			<li><a href="registroServ.do">Registrarse</a>
			</li>
		</ul>
	</div>

	<br/>
	<br/>
	</div>

	<h1 style="text-align:center">
		<img src="imgs/parkingC.png" width="100">ARQUEADERO
	</h1>
	<br/>

	<logic:notEmpty name="mensaje">
		<div id="mensaje">
			<bean:write name="mensaje" />
		</div>
	</logic:notEmpty>

	<html:form action="ingresaUsuario">
	<div>
		<table style="margin: 0 auto">
			<tr>
				<td>
					Nombre:
				</td>
				<td>
					<html:text property="nombre" />
				</td>
			</tr>
			<tr>
				<td>
					Contrase&ntilde;a:
				</td>
				<td>
					<html:text property="contrasena"  />
				</td>
			</tr>
			<tr>
				<td>
					Tipo Usuario:
				</td>
				<td>
					<select name="tipoUsuario">
						<option value="SuperUsuario">Super Usuario</option>
						<option value="2">Usuario</option>						
					</select>
				</td>
			</tr>
		 </table>
		<br/>
		<div style="text-align:center">
			<html:submit>Ingresar</html:submit>
		</div>
	</div>
	<br/>
	</html:form>


  </body>
	<footer>
		Parqueadero Sistemas 2019 | Jonathan Macias
		<img src="imgs/cintaP.png" width="100%" height="40">
	</footer>  
</html:html>
