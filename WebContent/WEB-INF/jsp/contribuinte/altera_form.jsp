<%@ include file="/header.jsp" %> 

<form method="post" action="/SIGP/contribuinte/altera">
	<table>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="contribuinte.nome" value="${contribuinte.nome}" />
			</td>
		</tr>

		<tr>
			<td colspan="2"><input type="hidden" name="contribuinte.idContribuinte"
				value="${contribuinte.idContribuinte}" /> <input type="submit" value="Alterar" />
			</td>
		</tr>
	</table>
</form>

<%@ include file="/errors.jsp" %> 

<p>
	<a href="/SIGP/contribuinte/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
