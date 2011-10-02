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
		<b>Publicação:</b> ${publicacao.titulo}
	</p>
	<p>
		<b>Data:</b> <br /> ${publicacao.data}
	</p>
	<p>
		<b>Veículo:</b> <br /> ${publicacao.veiculo}
	</p>
	<p>
		<b>Autores:</b>
	</p>
	<ul>
		<c:forEach items="${publicacao.contribuintes}" var="contribuinte">
			<li><a
				href="/SIGP/contribuinte/ver/${contribuinte.idContribuinte}">${contribuinte.nome}</a>
			</li>
		</c:forEach>
	</ul>
	<p>
		<a href="/SIGP/publicacao/alterar/${publicacao.idPublicacao}">Alterar</a>
		- <a href="/SIGP/publicacao/apagar/${publicacao.idPublicacao}">Apagar</a>
	</p>
	<hr />
	<p>
		<a href="/SIGP/publicacao/">Voltar</a>
	</p>
</body>
</html>