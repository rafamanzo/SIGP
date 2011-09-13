<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SIGP</title>
</head>
<body>
	<form method="post" action="/SIGP/grupo/altera">
		<div></div>
		<table>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="grupo.nome" value="${grupo.nome}" />
				</td>
			</tr>
			<tr>
				<td>Responsável:</td>
				<td><select name="responsavel">
						<option value="0">Nenhum</option>
						<c:forEach items="${grupos}" var="grupolista">
							<c:if test="${grupolista.idGrupo != grupo.idGrupo}">
								<option value="${grupolista.idGrupo}"
									<c:if test="${grupo.responsavel.idGrupo == grupolista.idGrupo}">selected="selected"</c:if>>${grupolista.nome}</option>
							</c:if>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="grupo.idGrupo"
					value="${grupo.idGrupo}" /> <input type="submit" value="Alterar" />
				</td>
			</tr>
		</table>
	</form>
	<p>
		<a href="/SIGP/grupo/">Voltar</a>
	</p>
</body>
</html>