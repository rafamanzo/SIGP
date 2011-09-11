<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/projetos.css">
<title>SIGP - Projetos</title>
</head>
<body>
	<h1>Projetos - Editar Projeto</h1>

	<br />
	<h1>${projeto.nome}</h1>
	<form action="updateProjeto">
		<input type="hidden" name="projeto.idProjeto" value="${projeto.idProjeto}" />
		<!-- idProjeto, nome, descricao, financiamento, grupos, membros -->
		<table>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="projeto.nome" value="${projeto.nome}"/></td>
			</tr>
			<tr>
				<td>Descricao</td>
				<td><textarea name="projeto.descricao">${projeto.descricao}</textarea></td>
			</tr>
			<tr>
				<td>Financiamento: </td>
			<td><input type="text" name="projeto.financiamento" value="${projeto.financiamento}" />
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