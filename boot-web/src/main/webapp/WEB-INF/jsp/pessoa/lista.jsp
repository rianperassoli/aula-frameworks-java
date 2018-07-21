<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Pessoas</title>
</head>
<body>

	<a href="/pessoa/novo">Cadastrar Pessoa</a>

	<hr/>

	<table>
		<thead>
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Naturalidade</th>
			</tr>
		</thead>
	
		<tbody>
			<c:forEach items="${pessoas}" var="pessoa">
				<tr>
					<td><a href="/pessoa/visualiza/${pessoa.codigo}">  ${pessoa.codigo} </a></td>
					<td>${pessoa.nome}</td>
					<td>${pessoa.cpf}</td>
					<td>${pessoa.naturalidade.nome}</td>
				</tr>	
			</c:forEach>
		</tbody>
		
	</table>
		
		
		
</body>
</html>