<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista_Productos</title>
</head>
<body>
<div>
	<h1> Lista de Productos</h1>
	<form id="form2" action="ServletListaProductos">
	<input type="button" id="btnMostrar" value="Mostrar">
	</form>
	</div>
	<div id="egcc_contenido_2">
		<h3>Aqu� se ver� la lista.</h3>
	</div>
	<script type="text/javascript">
	
	$("#btnMostrar").click(function(){
		var data=$("#form2").serialize();
		$.post("ServletListaProductos",data,function(objJson){
			if(objJson.codigo==1){
				//$("#egcc_contenido_2").text("falta generar tabla");
				var varTabla = "<table>";
				varTabla += "<tr>";
				varTabla += "<th>IDPRODUCTO</th>";
				varTabla += "<th>DESCRIPCION</th>";
				varTabla += "<th>PRECIO_VENTA</th>";
				varTabla += "<th>STOCK</th>";
				varTabla += "</tr>";
				
				// alert(objJson.texto);
				var jsonObj = $.parseJSON(objJson.texto);
				
				$.each(jsonObj,function(index,objCliente){
					varTabla += "<tr>";
					varTabla += "<td>" + objCliente.idproducto + "</td>";
					varTabla += "<td>" + objCliente.descripcion + "</td>";
					varTabla += "<td>" + objCliente.precioventa + "</td>";
					varTabla += "<td>" + objCliente.stock + "</td>";
					varTabla += "</tr>";
				});
				
				varTabla += "</table>";
				$("#egcc_contenido_2").html(varTabla);
			}else{$("#egcc_contenido_2").text(objJson.texto);	}
		});
	});
	
	</script>
	<!-- 
		<c:if test="${lista != null}">
		<h2>RESULTADO DE LA CONSULTA</h2>
		<table>
			<tr>
				<th>IDPRODUCTO</th>
				<th>DESCRIPCION</th>
				<th>PRECIO_COMPRA</th>
				<th>PRECIO_VENTA</th>
				<th>STOCK</th>
			</tr>	
			<c:forEach items="${lista}" var="r">
			<tr>
				<td>${r.idproducto}</td>
				<td>${r.descripcion}</td>
				<td>${r.preciocompra}</td>
				<td>${r.precioventa}</td>
				<td>${r.stock}</td>
			</tr>
			</c:forEach>
		</table>
	</c:if>-->
</body>
</html>