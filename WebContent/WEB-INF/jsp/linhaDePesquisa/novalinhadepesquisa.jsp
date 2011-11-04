<%@ include file="/header.jsp" %> 

<h1>Adicionar Nova Linha de Pesquisa...</h1>
<br />
<form method ="post" action="/SIGP/linhadepesquisa/salva">
	<table>
	 	<!-- idPesquisa, nome, sublinha, projetos, contribuintes -->
	 	<tr>
			<td>Nome:</td>
			<td><input type="text" name="linhapesquisa.nome" /></td>
		</tr>
		<tr>
			<td>Sublinha:</td>
			<td><textarea name="linhapesquisa.sublinha"></textarea></td>
		</tr>		
	<tr><td>
	<input type="submit" value="Adicionar Linha de Pesquisa" />
	</td>
	</tr>
	</table>	
</form>
<%@ include file="/footer.jsp" %> 
