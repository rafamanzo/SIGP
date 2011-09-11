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
	<h1>Membros - Informacoes de Membro</h1>

	<br />
	<!-- idMembro, avatar, nusp, senha, login, tipo -->
	<p>
		<b>Nome:</b> Membro ${membro.idMembro}
	</p>
	<p>
		<b>Avatar:</b> ${membro.avatar}
	</p>
	<p>
		<b>NUSP:</b> ${membro.nusp}
	</p>
	<p>
		<b>Login:</b> ${membro.login}
	</p>
	<p>
		<b>Tipo:</b> ${membro.tipo}
	</p>
	
	
	<a href="<c:url value="/membros/editMembro"/>?id=${membro.idMembro}">Alterar Membro</a>
	<hr/>
	<a href="/SIGP/membros">Voltar</a>
</body>
</html>