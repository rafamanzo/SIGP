<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/projetos.css">
<title>SIGP - Projetos</title>
</head>
<body>
	<h1>Projetos</h1>
	<br />
	<a href="/SIGP/projeto/novoProjeto">Adicionar Novo Projeto...</a>
	<br />
	<table>
	    <!-- idProjeto, nome, descricao, financiamento, grupos, membros -->
		<tr class="header">
			<td style="width: 150px">Nome</td>
			<td style="width: 180px">Financiamento</td>
			<td>Descricao</td>
		</tr>
		<c:forEach items="${projetos}" var="projeto">
			<tr>
				<td><a href="<c:url value="/projeto/infoProjeto"/>?id=${projeto.idProjeto}">${projeto.nome}</a>
				</td>
				<td><center>${projeto.financiamento}</center>
				</td>
				<td><center>${projeto.descricao}</center>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="/SIGP">Voltar para Pagina Principal</a>
</body>
</html>