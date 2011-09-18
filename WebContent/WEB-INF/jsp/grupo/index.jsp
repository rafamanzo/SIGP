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
			<th>Nome</th>
			<th>Responsável</th>
			<th colspan="2">&nbsp;</th>
		</tr>
		<c:forEach items="${grupos}" var="grupo">
			<tr>
				<td><a href="/SIGP/grupo/ver/${grupo.idGrupo}">${grupo.nome}</a></td>
				<td><c:choose>
						<c:when test="${grupo.responsavel != null}">${grupo.responsavel.nome}</c:when>
						<c:otherwise> - </c:otherwise>
					</c:choose></td>
				<td><a href="/SIGP/grupo/alterar/${grupo.idGrupo}">Alterar</a></td>
				<td><a href="/SIGP/grupo/apagar/${grupo.idGrupo}">Apagar</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="novo">Novo</a>
	</p>
	<p>
		<a href="/SIGP">Voltar para Pagina Principal</a>
	</p>
</body>
</html>