<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/membros.css">
<title>SIGP - Membros</title>
</head>
<body>
	<h1>Membros</h1>
	<br />
	<a href="/SIGP/membros/novoMembro">Adicionar Novo Membro...</a>
	<br />
	<table>
	    <!-- idMembro, avatar, nusp, senha, login, tipo -->
		<tr class="header">
			<td style="width: 180px">Nome</td>
			<td style="width: 100px">Avatar</td>
			<td style="width: 100px">Numero USP</td>
			<td style="width: 100px">Login</td>
			<td>Tipo</td>
		</tr>
		<c:forEach items="${membros}" var="membro">
			<tr>
				<td><a href="<c:url value="/membros/infoMembro"/>?id=${membro.idMembro}">Membro ${membro.idMembro}</a>
				</td>
				<td><center>${membro.avatar}</center>
				</td>
				<td><center>${membro.nusp}</center>
				</td>
				<td><center>${membro.login}</center>
				</td>
				<td><center>${membro.tipo}</center>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="/SIGP">Voltar para Pagina Principal</a>
</body>
</html>