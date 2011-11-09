<%@ include file="/header.jsp" %> 

<form method="post" action="/SIGP/projeto/cria">
	<table>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="projeto.nome" /></td>
		</tr>
		<tr>
			<td>Financiamento:</td>
			<td><input type="text" name="projeto.financiamento" /></td>
		</tr>
		<tr>
			<td>Descricao:</td>
			<td><textarea name="projeto.descricao"></textarea></td>
		</tr>
			
		<tr>
			<td colspan="2"><input type="submit" value="Criar" /></td>
		</tr>
	</table>
</form>

<%@ include file="/errors.jsp" %> 

<p>
	<a href="/SIGP/projeto/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
