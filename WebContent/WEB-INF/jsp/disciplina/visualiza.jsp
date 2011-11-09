<%@ include file="/header.jsp" %> 

<p>
	<b><fmt:message key="disciplina" />:</b> ${disciplina.nome} (${disciplina.sigla})
</p>
<p>
	<b><fmt:message key="disciplina.ementa" /></b> <br /> ${disciplina.ementa}
</p>
<table>
	<tr>
		<th><fmt:message key="disciplina.grupos_que_oferecem" /></th>
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
	<a href="/SIGP/disciplina/"><fmt:message key="voltar" /></a>
</p>

<%@ include file="/footer.jsp" %> 
