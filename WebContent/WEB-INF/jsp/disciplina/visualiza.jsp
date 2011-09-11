<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SIGP</title>
</head>
<body>
	<p>
		<b>Disciplina:</b> ${disciplina.nome} (${disciplina.sigla})
	</p>
	<p>
		<b>Ementa:</b> <br /> ${disciplina.ementa}
	</p>
	<table>
		<tr>
			<th>Grupos que oferecem:</th>
		</tr>
		<c:forEach items="${disciplina.grupos}" var="grupo">
			<tr>
				<td><a href="/SIGP/grupo/ver/${grupo.idGrupo}">${grupo.nome}</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="/SIGP/disciplina/alterar/${disciplina.idDisciplina}">Alterar</a>
		- <a href="/SIGP/disciplina/apagar/${disciplina.idDisciplina}">Apagar</a>
	</p>
	<hr></hr>
	<p>
		<a href="/SIGP/disciplina/">Voltar</a>
	</p>
</body>
</html>