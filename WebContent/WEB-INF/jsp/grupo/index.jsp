<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SIGP</title>
</head>
<body>
	<table>
	<c:forEach items="${grupos}" var="grupo">
		<tr>
			<td><a href="ver/${grupo.idGrupo}">${grupo.nome}</a></td>
		</tr>
	</c:forEach>
	</table>
	<p><a href="novo">Novo</a></p>
</body>
</html>