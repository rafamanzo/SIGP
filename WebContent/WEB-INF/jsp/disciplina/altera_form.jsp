<%@ include file="/header.jsp" %> 

<form method="post" action="/SIGP/disciplina/altera">
	<table>
		<tr>
			<td><fmt:message key="disciplina.sigla" />:</td>
			<td><input type="text" name="disciplina.sigla" value="${disciplina.sigla}" />
			</td>
		</tr>
		<tr>
			<td><fmt:message key="disciplina.nome" />:</td>
			<td><input type="text" name="disciplina.nome" value="${disciplina.nome}" />
			</td>
		</tr>
		<tr>
			<td><fmt:message key="disciplina.ementa" />:</td>
			<td><textarea name="disciplina.ementa">${disciplina.nome}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="hidden" name="disciplina.idDisciplina"
				value="${disciplina.idDisciplina}" /> <input type="submit" value="Alterar" />
			</td>
		</tr>
	</table>
</form>
<p>
	<a href="/SIGP/disciplina/"><fmt:message key="voltar" /></a>
</p>

<%@ include file="/footer.jsp" %> 
