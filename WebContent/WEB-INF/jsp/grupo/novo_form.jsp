<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SIGP</title>
</head>
<body>
	<form method="post" action="cria">
		<table>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="grupo.nome" /></td>
			</tr>
			<tr>
				<td>Responsável:</td>
				<td><select name="responsavel">
					<option value="0">Nenhum</option>
					<c:forEach items="${grupos}" var="grupo">
						<option value="${grupo.idGrupo}">${grupo.nome}</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Criar" /></td>
			</tr>
		</table>
	</form>
	<p><a href="./">Voltar</a></p>
</body>
</html>