<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/projetos.css">
<title>SIGP - Projeto Novo</title>
</head>
<body>
	<h1>Adicionar Projeto Novo...</h1>
	<br />
	<form action="salva">
		<table>
		 	<!-- idProjeto, nome, descricao, financiamento, grupos, membros -->
		 	<tr>
				<td>Nome:</td>
				<td><input type="text" name="projeto.nome" /></td>
			</tr>
			<tr>
				<td>Descricao:</td>
				<td><textarea name="projeto.descricao"></textarea></td>
			</tr>
			<tr>
				<td>Financiamento:</td>
				<td><input type="text" name="projeto.financiamento" />
				</td>
			</tr>
		</table>
		<br /> <input type="submit" value="Adicionar Projeto" />
	</form>
</body>
</html>