<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>Registro de Precios | Parqueadero Web</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="../estilos/estilos.css"/>

  </head>
  
  <body>

	<img src="../imgs/cintaP.png" width="100%" height="40">


	<div class="barra"> 
	<div id="header">
		<ul class="nav">
			<li><a href="${pageContext.request.contextPath}/panel.do">inicio</a></li>
			<li><a href="">Configuraciones</a>
				<ul>
					<!--<li><a href="">Usuarios</a></li>-->
					<li><a href="${pageContext.request.contextPath}/regPrecios.do">Precios</a></li>
                                        <!--<li><html:link action="regPrecios">Precios2</html:link></li>-->
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
	<h3 style="text-align:center">Registro de Precios</h3>

	<html:form action="seleccionPrecios">
		<div style="display:inline-block;width:30%;float:left">
			<table border="2" width="100%">
				<tr>
					<td>
						Tipo:
					</td>
					<td>
						<select name="tipoVehiculo">
							<option value="Carro">Carro</option>
							<option value="Moto">Moto</option>
							<option value="Vehiculo Pesado">Vehiculo Pesado</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						Valor $:
					</td>
					<td>
						<html:text property="precio" />
					</td>
				</tr>
				
			 </table>
			 <table border="2" width="100%" style="text-align:center">
			 	<tr>
			 		<td>
			 			<html:submit>Guardar</html:submit>
			 		</td>
			 		<td>
			 			<input type="reset" value="Cancelar" />
			 		</td>
			 	</tr>
                                
			 </table>
                                <logic:notEmpty name="mensaje">
                                    <bean:write name="mensaje" />
                                </logic:notEmpty>
			<br/>
		</div>
	</html:form>
	
	<div style="display:inline-block;width:69%;" >
		<table border="2" width="100%">
			<tr>
				<th>TIPO VEHICULO</th>
				<th>VALOR POR HORA</th>
				<th>VALOR POR MINUTO</th>				
			</tr>
			<logic:notEmpty name="Carro">
			<tr>
				<td>
					<bean:write name="Carro" property="tipoVehiculo" />
				</td>
				<td>
					<bean:write name="Carro" property="precio" />
				</td>
				<td>
					<bean:write name="Carro" property="precioMinuto" />
				</td>				
			</tr>
			</logic:notEmpty>
                        <logic:empty name="Carro">
                            <tr>
                                <td>
                                    Carro
                                </td>
                                <td>
                                    Ingresa el valor
                                </td>
                                <td>
                                    Ingresa el valor
                                </td>
                            </tr>
                        </logic:empty>
			<logic:notEmpty name="Moto">
			<tr>
				<td>
					<bean:write name="Moto" property="tipoVehiculo" />
				</td>
				<td>
					<bean:write name="Moto" property="precio" />
				</td>
				<td>
					<bean:write name="Moto" property="precioMinuto" />
				</td>
			</tr>
			</logic:notEmpty>
                        <logic:empty name="Moto">
                            <tr>
                                <td>
                                    Moto
                                </td>
                                <td>
                                    Ingresa el valor
                                </td>
                                <td>
                                    Ingresa el valor
                                </td>
                            </tr>
                        </logic:empty>                        
			<logic:notEmpty name="Vehiculo Pesado">
			<tr>
				<td>
					<bean:write name="Vehiculo Pesado" property="tipoVehiculo" />
				</td>
				<td>
					<bean:write name="Vehiculo Pesado" property="precio" />
				</td>
				<td>
					<bean:write name="Vehiculo Pesado" property="precioMinuto" />
				</td>
			</tr>
			</logic:notEmpty>
                        <logic:empty name="Vehiculo Pesado">
                            <tr>
                                <td>
                                    Vehiculo Pesado
                                </td>
                                <td>
                                    Ingresa el valor
                                </td>
                                <td>
                                    Ingresa el valor
                                </td>
                            </tr>
                        </logic:empty>                        
		</table>
	</div>
	<br/><br/>
	
	<form action="../panel.do">
		<div style="float:right">
				<input type="submit" value="<|" style="width:100px;height:30px" />
		</div>
	</form>
	<br/>
	<br/>

  </body>
  
	<footer>
		Parqueadero Sistemas 2019 | Jonathan Macias
		<img src="../imgs/cintaP.png" width="100%" height="40">
	</footer>  
</html:html>
