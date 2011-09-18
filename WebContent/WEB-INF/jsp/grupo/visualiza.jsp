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
	<p>
		<b>Grupo:</b> ${grupo.nome}
	</p>
	<p>
		<b>Responsável:</b>
		<c:choose>
			<c:when test="${grupo.responsavel != null}">${grupo.responsavel.nome}</c:when>
			<c:otherwise> - </c:otherwise>
		</c:choose>
	</p>
	<table>
		<tr>
			<th>Pesquisas:</th>
		</tr>
		<c:forEach items="${grupo.pesquisas}" var="pesquisa">
			<tr>
				<td>
					<!--<a href="/SIGP/pesquisa/ver/${pesquisa.idPesquisa}">-->${pesquisa.nome}</td>
			</tr>
		</c:forEach>
	</table>
	<table>
		<tr>
			<th>Disciplinas:</th>
		</tr>
		<c:forEach items="${grupo.disciplinas}" var="disciplina">
			<tr>
				<td><a href="/SIGP/disciplina/ver/${disciplina.idDisciplina}">${disciplina.nome}</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="/SIGP/grupo/">Voltar</a>
	</p>
</body>
</html>