<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring-Boot-MVC</title>
</head>
<body>
	Resultado: ${valor} 
	
	<br/>
	<p>GET</p>
	<form action="/parametros">
	
		Nome: <input type="text" name="nome" value="${nome}">
		Sobrenome: <input type="text" name="sobrenome" value="${sobrenome}">
		
		<input type="submit" value="enviar">
	</form>
	
	<br/>
	<p>POST</p>
	<form action="/enviar" method="post">
	
		Nome: <input type="text" name="nome" value="${nome}">
		Sobrenome: <input type="text" name="sobrenome" value="${sobrenome}">
		
		<input type="submit" value="enviar">
	</form>
	
</body>
</html>