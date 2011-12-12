<%@ include file="/header.jsp" %> 

<table>
	<tr>
		<th><fmt:message key="disciplina.sigla" /></th>
		<th><fmt:message key="disciplina.nome" /></th>
	</tr>
	<c:forEach items="${disciplinas}" var="disciplina">
		<tr>
			<td><a href="/SIGP/disciplina/ver/${disciplina.idDisciplina}">${disciplina.sigla}</a></td>
			<td>${disciplina.nome}</td>
		</tr>
	</c:forEach>
</table>
<p>
	<a href="novo"><fmt:message key="novo" /></a>
</p>

<hr />
<p><a href="/SIGP/"><fmt:message key="voltar_a_home" /></a></p>
<%@ include file="/footer.jsp" %> 
