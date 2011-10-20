<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SIGP</title>
</head>
<body>
	<table>
		<tr>
			<th>Sigla</th>
			<th>Nome</th>
		</tr>
		<c:forEach items="${disciplinas}" var="disciplina">
			<tr>
				<td><a href="/SIGP/disciplina/ver/${disciplina.idDisciplina}">${disciplina.sigla}</a></td>
				<td>${disciplina.nome}</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="novo">Novo</a>
	</p>
	<p>
		<a href="/SIGP">Voltar para Página Principal</a>
	</p>
</body>
</html>