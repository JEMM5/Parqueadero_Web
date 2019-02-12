<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>Registro de Usuarios | Parqueadero Web</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="estilos/estilos.css" >
  </head>
  
  <body>
	<img src="imgs/cintaP.png" width="100%" height="40">

	<div class="barra"> 
	<div id="header">
		<ul class="nav">
			<li><a href="${pageContext.request.contextPath}/inicio.do">Inicio</a></li>
			
		</ul>
	</div>

	<br/>
	<br/>
	</div>


	<h1 style="text-align:center">
		<img src="imgs/parkingC.png" width="100">ARQUEADERO
	</h1>

	<p style="text-align:center">__________________________________________________________________________________________________________________________________________</p>
	<h3 style="text-align:center">Registrate</h3>

	
	<html:form action="registraUsuario">	
	<div style="margin: 0 auto;width:500px" >
		<table border="2" width="100%">	
			<tr>
				<td>Nombre:</td>
				<td>
					<html:text property="nombre" />					
				</td>
				<td>
					<div id="mensaje"><html:errors property="errorNombre" /></div>
				</td>				
			</tr>
			<tr>
				<td>Correo:</td>
				<td>
					<html:text property="correo" />
				</td>
				<td>
					<div id="mensaje"><html:errors property="errorCorreo" /></div>
				</td>				
			</tr>
			<tr>
				<td>
					Nombre del Parqueadero:
				</td>
				<td>
					<html:text property="nombreParqueadero" />
				</td>
				<td>
					<div id="mensaje"><html:errors property="errorNombreParqueadero" /></div>
				</td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td>
					<html:text property="contrasena" />
				</td>
				<td>
					<div id="mensaje"><html:errors property="errorContrasena" /></div>
				</td>				
			</tr>
			<tr>
				<td>Tipo de Usuario:</td>
				<td>
					<select name="tipoUsuario">
						<option value="SuperUsuario">Super Usuario</option>
					<!--	<option value="2">Usuario</option>	-->
					</select>
				</td>
				
			</tr>	
		</table>
		<table border="2" style="margin:0 auto; text-align:center" width="40%">
		<tr>
			<td>
				<html:submit>Guardar</html:submit>
			</td>
			<td>
				<input type="reset" value="Limpiar" />
			</td>
		</tr>			
		</table>			
	</div>
	</html:form>

	<div style="float:right">	
				<form action="inicio.do">
					<html:submit value="cancelar  <|" />
				</form>
	</div>
	
	
	
	<div style="float:right">
			<!-- <input type="submit" value="<|" style="width:100px;height:30px" />-->
	</div>
	<br/>
	<br/>

  </body>

	<footer>
		Parqueadero Sistemas 2019 | Jonathan Macias
		<img src="imgs/cintaP.png" width="100%" height="40">
	</footer>  
</html:html>
