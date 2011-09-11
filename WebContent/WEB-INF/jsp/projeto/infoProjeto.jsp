<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/projetos.css">
<title>SIGP - Projeto</title>
</head>
<body>
	<p>
		<b>Nome:</b> ${projeto.nome}
	</p>
	<p>
		<b>Descricao:</b> <br /> ${projeto.descricao}
	</p>
	<p>
		<b>Financiamento:</b> ${projeto.financiamento}
	</p>
	
	<p>
		<b>Grupo Coordenador: </b> 
		<a href="/SIGP/grupo/ver/${projeto.coordenador.idGrupo}">${projeto.coordenador.nome}</a>
	</p>

	
	<a href="<c:url value="/projetos/editProjeto"/>?id=${projeto.idProjeto}">Alterar Projeto</a>
	<hr/>
	<a href="/SIGP/projetos">Voltar</a>
</body>
</html>