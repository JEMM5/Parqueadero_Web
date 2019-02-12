<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>registroParqueos.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="../estilos/estilos.css" >
        <script type="text/javascript" src="../funciones/reloj.js"></script>
  </head>
  
  <body onload="reloj()">

	<img src="../imgs/cintaP.png" width="100%" height="40">

	<div class="barra"> 
	<div id="header">
		<ul class="nav">
			<li><a href="${pageContext.request.contextPath}/panel.do">Inicio</a></li>
			<li><a href="">Configuraciones</a>
				<ul>
					<li><a href="">Usuarios</a></li>
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
	<h3 style="text-align:center">Registro</h3>

	

	<html:form action="ingresaVehiculo">
	<div style="display:inline-block;width:30%;float:left">
		<table border="2" width="100%">
			<tr>
				<td>
					<b>Parqueo No.</b>
				</td>
				<td>
                                    <input type="hidden" name="id" value="${parqueoRecup.id}" id="idDef">
                                    <logic:notEmpty name="parqueoRecup">
					<bean:write name="parqueoRecup" property="id" />
                                    </logic:notEmpty>
				</td>
			</tr>
			<tr>
				<td>
					Tipo:
				</td>
				<td>
					<select name="tipoVehiculo">
                                            <logic:notEmpty name="parqueoRecup">
                                                <option value="${parqueoRecup.tipoVehiculo}">
                                                    <bean:write name="parqueoRecup" property="tipoVehiculo" />
                                                </option>
                                            </logic:notEmpty>
                                            <logic:empty name="parqueoRecup">
						<option value="Carro">Carro</option>
						<option value="Moto">Moto</option>
						<option value="Vehiculo Pesado">Vehiculo Pesado</option>
                                            </logic:empty>    
					</select>
				</td>
			</tr>
			<tr>
				<td>
					Placa:
				</td>
				<td>
					<input type="text" value="${parqueoRecup.placa}"  name="placa" />
				</td>
			</tr>
			<tr>
				<td>
					Hora de Entrada:
				</td>
				<td>
					<input type="text" value="${parqueoRecup.horaEntrada}" name="horaEntrada" id="hE"/>
				</td>
			</tr>
			<tr>
				<td>
					Hora de Salida:
				</td>
				<td>
					<input type="text" value="" name="horaSalida" id="hS"/>
				</td>
			</tr>
			<tr>
				<td>
					Tiempo:
				</td>
				<td>
					<input type="text" value="" name="tiempo" />	
				</td>
			</tr>
			<tr>
				<td>
					Valor a Pagar:
				</td>
				<td>
					<input type="text" value="" name="valorPagar" />
				</td>
			</tr>
		 </table>
		 <table border="2" width="100%" style="text-align:center">
		 	<tr>
		 		<td>
		 			<html:submit property="operacion" value="registrar"  />
		 		</td>
		 		<td>
		 			<html:submit property="operacion" value="generarTicket" />
		 		</td>
		 		<td>
		 			<input type="reset" value="Limpiar" />
		 		</td>
		 	</tr>
		 </table>
		<br/>
	</div>
	</html:form>
	
	
	
	<div style="display:inline-block;width:69%;float:right" >
            <form action="../desplegaParqueo.do">
		<table border="2" width="100%">
			<tr>
				<th>FACTURA No.</th>
				<th>PLACA</th>
				<th>TIPO DE VEHICULO</th>
				<th>ENTRADA</th>				
			</tr>
			<logic:notEmpty name="parqueos">
			<logic:iterate id="parqueo" name="parqueos">
			<tr>
				<td>
                                    <!--el name para recuperarlo como parametro-->
                                    <input type="radio" name="idRecuperar" value="${parqueo.id}" />
					<bean:write name="parqueo" property="id" />
                                        <!--${parqueo.id}-->
				</td>
				<td>
					<bean:write name="parqueo" property="placa" />
				</td>
				<td>
					<bean:write name="parqueo" property="tipoVehiculo" />
				</td>
				<td>
					<bean:write name="parqueo" property="horaEntrada" />
				</td>				
			</tr>
			</logic:iterate>
			</logic:notEmpty>
			<logic:empty name="parqueos">
				<p>No tienes vehiculos pendientes</p>
			</logic:empty>
		</table>
                <html:submit>CARGAR</html:submit>
            </form>    
	</div>
	
	<div style="float:right">
		<form action="../panel.do">
			<input type="submit" value="<|" style="width:100px;height:30px" />
		</form>
			
	</div>
	<br/>
	<br/>

  </body>
  
	<footer>
		Parqueadero Sistemas 2019 | Derechos Reservados
		<img src="../imgs/cintaP.png" width="100%" height="40">
	</footer>  
</html:html>
