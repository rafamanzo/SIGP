<%@ include file="/header.jsp" %> 

<form method="post" action="/SIGP/projeto/altera">
	<table>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="projeto.nome" value="${projeto.nome}" /></td>
		</tr>
		<tr>
			<td>Financiamento:</td>
			<td><input type="text" name="projeto.financiamento"  value="${projeto.financiamento}"/></td>
		</tr>
		<tr>
			<td>Descricao:</td>
			<td><textarea name="projeto.descricao">${projeto.descricao}</textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="hidden" name="projeto.idProjeto"
				value="${projeto.idProjeto}" /> <input type="submit" value="Alterar" />
			</td>
		</tr>
	</table>
</form>

<%@ include file="/errors.jsp" %> 

<p>
	<a href="/SIGP/projeto/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
