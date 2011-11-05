<%@ include file="/header.jsp" %> 

<table>
	<tr>		
		<th>Nome</th>
	</tr>
	<c:forEach items="${linhasdepesquisa}" var="linhapesquisa">
		<tr>
			<td><a href="/SIGP/linhadepesquisa/ver/${linhapesquisa.idPesquisa}">${linhapesquisa.nome}</a></td>
			<td>${linhapesquisa.nome}</td>
			<td><a href="/SIGP/linhadePesquisa/alterar/${linhapesquisa.idPesquisa}">Alterar</a></td>
			<td><a href="/SIGP/linhadePesquisa/remover/${linhapesquisa.idPesquisa}">Apagar</a></td>
		</tr>
	</c:forEach>
</table>
<p>
	<a href="/SIGP/linhadepesquisa/novo">Novo</a>
</p>
<p>
	<a href="/SIGP">Voltar para Página Principal</a>
</p>

<%@ include file="/footer.jsp" %> 
