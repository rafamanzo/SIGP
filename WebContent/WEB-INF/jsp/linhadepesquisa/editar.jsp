<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html version="-//W3C//DTD XHTML 1.1//EN"
	xmlns="http://www.w3.org/1999/xhtml" xml:lang="en"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.w3.org/1999/xhtml
                          http://www.w3.org/MarkUp/SCHEMA/xhtml11.xsd">
<head>
<title>Editar Linha De Pesquisa</title>
</head>

<body>
	<c:import url="../header.jsp" />
	<form action="alterar">
		<fieldset>
			<legend>Editar Linha de Pesquisa</legend>
			<input type="hidden" name="linhapesquisa.idlinhapesquisa" value="${linhapesquisa.idlinhapesquisa}" /> 
			<label for="nome"><span>Nome:</span> </label> 			
			<input id="nome" type="text" name="linhapesquisa.nome" value="${linhapesquisa.nome}" /> 
			
			<label for="sublinha"><span>Sublinha:</span></label>
			<input id="sublinha" type="text" name="linhapesquisa.sublinha" value="${linhapesquisa.sublinha}" /> 
			
			<button type="submit">Enviar</button>
		</fieldset>
	</form>
	<c:import url="../footer.jsp" />
</body>
</html>