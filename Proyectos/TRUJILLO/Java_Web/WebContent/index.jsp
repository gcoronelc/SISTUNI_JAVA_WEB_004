<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title>Login_Empleado</title>
<style type="text/css">
	/*.body{
  height: 150px;
  display: flex;
  justify-content: center;
  align-items: center;
	}*/
	#FonLogin{
	 	width: 400px;
	 	height:200px;
	 	margin:0 auto;
	 	margin-top:50px;
	 	background-color: white;
	 	text-align: center;
	 	border-radius: 29px 29px 29px 29px;
		-moz-border-radius: 29px 29px 29px 29px;
		-webkit-border-radius: 29px 29px 29px 29px;
		border: 0px solid #000000;
		-webkit-box-shadow: 2px 10px 35px 3px rgba(0,0,0,0.75);
		-moz-box-shadow: 2px 10px 35px 3px rgba(0,0,0,0.75);
		box-shadow: 2px 10px 35px 3px rgba(0,0,0,0.75);
	}
	
	#margint{
		padding-left: 10px;
		padding-right: 10px;
		padding-top: 20px;	
	}
	#spaceimage{
		padding-left: 20px;
		padding-right: 20px;
		padding-top: 20px;
	
	}

</style>
</head>
<body bgcolor="#A4C7C9">
<div id="FonLogin" align="center" border=2>
	<form action="ServletValidacion" method="post" >
		<table >
			<tr>
			<td id="spaceimage">
				<img width="150px" height="150px" src="img/login.png"/>
			</td>
			<td id="margint">
			<input width="100px" type="text" name="email" placeholder="Usuario"	/><br/><br/>
			<input type="password" name="pass" 	placeholder="Contrase�a" ><br/><br/>
			<input type="submit" value="Iniciar Sesi�n">
			<p>${error}</p>
			</td>
			</tr>
		</table>		
	</form>
</div>
</body>	
</html>