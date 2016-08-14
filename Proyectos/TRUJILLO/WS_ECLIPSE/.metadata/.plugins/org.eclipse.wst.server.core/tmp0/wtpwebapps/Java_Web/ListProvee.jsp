<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	<h1> Lista de Proveedores</h1>
	<form id="form2" action="ServletListaProveedores">
	<input type="button" id="btnMostrar" value="Mostrar">
	</form>
	</div>
	<div id="egcc_contenido_2">
		<h3>Aqu� se ver� la lista.</h3>
	</div>
	<script type="text/javascript">
	
	$("#btnMostrar").click(function(){
		var data=$("#form2").serialize();
		$.post("ServletListaProveedores",data,function(objJson){
			if(objJson.codigo==1){
				//$("#egcc_contenido_2").text("falta generar tabla");
				var varTabla = "<table>";
				varTabla += "<tr>";
				varTabla += "<th>IDPROVEEDOR</th>";
				varTabla += "<th>RAZON SOCIAL</th>";
				varTabla += "<th>DIRECCION</th>";
				varTabla += "<th>RUC</th>";
				varTabla += "<th>TELEFONO</th>";
				varTabla += "</tr>";
				
				// alert(objJson.texto);
				var jsonObj = $.parseJSON(objJson.texto);
				
				$.each(jsonObj,function(index,objCliente){
					varTabla += "<tr>";
					varTabla += "<td>" + objCliente.idproveedor+ "</td>";
					varTabla += "<td>" + objCliente.razonsocial + "</td>";
					varTabla += "<td>" + objCliente.direccion + "</td>";
					varTabla += "<td>" + objCliente.ruc + "</td>";
					varTabla += "<td>" + objCliente.telefono + "</td>";
					varTabla += "</tr>";
				});
				
				varTabla += "</table>";
				$("#egcc_contenido_2").html(varTabla);
			}
		});
	});
	
	</script>
</body>
</html>