<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h1>Cliente Consulta</h1>
<form  action="ServletConsulta" id="form1">
	<table>
		<tr>
			<td>Ingrese Nombre : </td><br/>
			<td><input type="text" id="nomcliente" name="nomcliente"></td>
			<td rowspan="2" valign="bottom">
						<input type="button" id="btnConsultar" value="Consultar" />
						<input type="button" id="btnExcel" value="Exp. Excel" />
					</td>
		</tr>	
	</table>
</form>
</div>
<div id="egcc_contenido">
		<h3>Aqu� va el resultado.</h3>
	</div>
	<!-- 
	<c:if test="${lista != null}">
		<h2>RESULTADO DE LA CONSULTA</h2>
		<table>
			<tr>
				<th>CODIGO</th>
				<th>NOMBRE</th>
				<th>DIRECCION</th>
				<th>RUC/DNI</th>
				<th>TELEFONO</th>
			</tr>	
			<c:forEach items="${lista}" var="r">
			<tr>
				<td>${r.id_cliente}</td>
				<td>${r.nom_cliente}</td>
				<td>${r.dir_cliente}</td>
				<td>${r.rucdni_cliente }</td>
				<td>${r.telefon_cliente}</td>
			</tr>
			</c:forEach>
		</table>
	</c:if>-->
	<script type="text/javascript">
	$("#btnConsultar").click(function(){
		var data = $("#form1").serialize();
		$.post("ServletConsulta",data,function(objJson){
			if(objJson.codigo==1){
				//$("#egcc_contenido").text("falta genera tabla");
				var varTabla = "<table>";
				varTabla += "<tr>";
				varTabla += "<th>CODIGO</th>";
				varTabla += "<th>NOMBRE</th>";
				varTabla += "<th>DIRECCION</th>";
				varTabla += "<th>RUC/DNI</th>";
				varTabla += "<th>TELEFONO</th>";
				varTabla += "</tr>";
				
				// alert(objJson.texto);
				var jsonObj = $.parseJSON(objJson.texto);
				
				$.each(jsonObj,function(index,objCliente){
					varTabla += "<tr>";
					varTabla += "<td>" + objCliente.id_cliente + "</td>";
					varTabla += "<td>" + objCliente.nom_cliente + "</td>";
					varTabla += "<td>" + objCliente.dir_cliente + "</td>";
					varTabla += "<td>" + objCliente.rucdni_cliente + "</td>";
					varTabla += "<td>" + objCliente.telefon_cliente + "</td>";
					varTabla += "</tr>";
				});
				
				varTabla += "</table>";
				$("#egcc_contenido").html(varTabla);
			}else if(objJson.codigo==-50){
			$("#egcc_contenido").text("No hay coincidencias");
			}
		});
	});
	
	$("#btnExcel").click(function (e) {
	    window.open('data:application/vnd.ms-excel,' + $('#egcc_contenido').html());
	    e.preventDefault();
	});
	</script>
</body>
</html>