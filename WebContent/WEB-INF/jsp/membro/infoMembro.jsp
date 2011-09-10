<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>Membro ${membro.idMembro}</h1>
	<form action="updateMembro">
		<input type="hidden" name="membro.idMembro" value="${membro.idMembro}" />
		<!-- idMembro, avatar, nusp, senha, login, tipo -->
		<table>
			<tr>
				<td>Avatar:</td>
				<td><input type="text" name="membro.avatar" value="${membro.avatar}" />
				</td>
			</tr>
			<tr>
				<td>NUSP: 
			</td>
			<td><input type="text" name="membro.nusp"
				value="${membro.nusp}" />
			</td>
			</tr>
			<tr>
				<td>Login: 
			</td>
			<td><input type="text" name="membro.login"
				value="${membro.login}" />
			</td>
			</tr>
			<tr>
				<td>Senha:
			</td>
			<td><input type="text" name="membro.senha"
				value="${membro.senha}" />
			</td>
			</tr>
			<tr>
				<td>Tipo:
			</td>
			<td><input type="text" name="membro.tipo"
				value="${membro.tipo}" />
			</td>
			</tr>
			</table>
		<br />
		<input type="submit" name="oQueFazer" value="${editSaveTitle}" />
		<input type="submit" name="oQueFazer" value="${editDelTitle}" />
		<br />
		<input type="submit" name="oQueFazer" value="Voltar" />
		<br />
	</form>
</body>
</html>