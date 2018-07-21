<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<br/>
<label for="nome"> Nome </label>
<input type="text" name="nome" id="nome" value="${pessoa.nome}" />
<form:errors path="pessoa.nome"/>

<br/>
<label for="cpf"> CPF </label>
<input type="text" name="cpf" id="cpf" value="${pessoa.cpf}" />
<form:errors path="pessoa.cpf"/>

<br/>
<label for="naturalidade"> Naturalidade </label>
<select id="naturalidade" name="naturalidade.codigo">

	<option></option>
	<c:forEach items="${cidades}" var="cidade">
	
		<c:set var="selecionado" value=""/>
	
		<c:if test="${cidade.codigo eq pessoa.naturalidade.codigo}">
			<c:set var="selecionado" value="selected"/>
		</c:if>
			
		<option value="${cidade.codigo}" ${selecionado}>${cidade.nome}</option>
		
	</c:forEach>
	
</select>
