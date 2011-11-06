<%@ include file="/header.jsp" %> 

<h1>Adicionar Projeto Novo...</h1>
<br />
<form method ="post" action="/SIGP/projeto/salva">
	<table>
	 	<!-- idProjeto, nome, descricao, financiamento, grupos, membros -->
	 	<tr>
			<td>Nome:</td>
			<td><input type="text" name="projeto.nome" /></td>
		</tr>
		<tr>
			<td>Descricao:</td>
			<td><textarea name="projeto.descricao"></textarea></td>
		</tr>
		<tr>
			<td>Financiamento:</td>
			<td><input type="text" name="projeto.financiamento" />
			</td>
		</tr>
	</table>
	<br /> <input type="submit" value="Adicionar Projeto" />
</form>

<%@ include file="/errors.jsp" %> 

<%@ include file="/footer.jsp" %> 
