<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<br/>
<label for="nome"> Nome </label>
<input type="text" name="nome" id="nome" value="${pessoa.nome}" />
<form:errors path="pessoa.nome"/>

<br/>
<label for="cpf"> CPF </label>
<input type="text" name="cpf" id="cpf" value="${pessoa.cpf}" />
<form:errors path="pessoa.cpf"/>