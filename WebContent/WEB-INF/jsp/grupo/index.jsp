<%@ include file="/header.jsp" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table>
	<tr>
		<th>Nome</th>
		<th>Responsável</th>
		<th colspan="2">&nbsp;</th>
	</tr>
	<c:forEach items="${grupos}" var="grupo">
		<tr>
			<td><a href="/SIGP/grupo/ver/${grupo.idGrupo}">${grupo.nome}</a></td>
			<td><c:choose>
					<c:when test="${grupo.responsavel != null}">${grupo.responsavel.nome}</c:when>
					<c:otherwise> - </c:otherwise>
				</c:choose></td>
		</tr>
	</c:forEach>
</table>
<p>
	<a href="novo">Novo</a>
</p>

<hr />
<p><a href="/SIGP/">Voltar à página principal</a></p>
<%@ include file="/footer.jsp" %> 
