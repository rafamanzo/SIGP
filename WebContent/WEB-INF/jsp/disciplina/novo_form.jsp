<%@ include file="/header.jsp" %> 

<form method="post" action="/SIGP/disciplina/cria">
	<table>
		<tr>
			<td>Sigla:</td>
			<td><input type="text" name="disciplina.sigla" /></td>
		</tr>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="disciplina.nome" /></td>
		</tr>
		<tr>
			<td>Ementa:</td>
			<td><textarea name="disciplina.ementa"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Criar" /></td>
		</tr>
	</table>
</form>
<p>
	<a href="/SIGP/disciplina/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
