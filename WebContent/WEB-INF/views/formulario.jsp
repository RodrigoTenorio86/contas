<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Adicionar Conta</h2>
	<form action="adicionaConta"  method="post">
		Descrição:<br/>
		<textarea name="descricao" rows="5" cols="100"></textarea>
		<form:errors path="conta.descricao"/>
	   <br/>
	   Valor:<br/>
	   <input type="text" name="valor">
	   Tipo: <br/>
	   <select name="tipo">
	   	<option value="ENTRADA">ENTRADA</option>
	   	<option value="SAIDA">Saida</option>
	   </select>
	   <br/><br/>
	   <input type="submit" value="Adicionar"/>
	
	
	</form>
</body>
</html>