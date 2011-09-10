<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/membros.css">
<title>SIGP - Membro Novo</title>
</head>
<body>
	<h1>Adicionar Membro Novo...</h1>
	<br />
	<form action="salva">
		<table>
		 <!-- idMembro, avatar, nusp, senha, login, tipo -->
			<tr>
				<td>Avatar:</td>
				<td><input type="text" name="membro.avatar" /></td>
			</tr>
			<tr>
				<td>NUSP:</td>
				<td><input type="text" name="membro.nusp" />
				</td>
			</tr>
			<tr>
				<td>Login:</td>
				<td><input type="text" name="membro.login" />
				</td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="text" name="membro.senha" />
				</td>
			</tr>
			<tr>
				<td>Tipo:</td>
				<td><input type="text" name="membro.tipo" />
				</td>
			</tr>
		</table>
		<br /> <input type="submit" value="Adicionar Membro" />
	</form>
</body>
</html>