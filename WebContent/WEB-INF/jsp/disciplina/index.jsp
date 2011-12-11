<%@ include file="/header.jsp" %> 

<table>
	<tr>
		<th>Sigla</th>
		<th>Nome</th>
	</tr>
	<c:forEach items="${disciplinas}" var="disciplina">
		<tr>
			<td><a href="/SIGP/disciplina/ver/${disciplina.idDisciplina}">${disciplina.sigla}</a></td>
			<td>${disciplina.nome}</td>
		</tr>
	</c:forEach>
</table>
<p>
	<a href="novo">Novo</a>
</p>

<hr />
<p><a href="/SIGP/">Voltar � p�gina principal</a></p>
<%@ include file="/footer.jsp" %> 
