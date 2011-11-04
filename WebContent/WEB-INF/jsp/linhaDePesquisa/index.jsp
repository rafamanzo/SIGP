<%@ include file="/header.jsp" %> 

<table>
	<tr>		
		<th>Nome</th>
	</tr>
	<c:forEach items="${linhasdepesquisa}" var="linhapesquisa">
		<tr>
			<td><a href="/SIGP/linhadepesquisa/ver/${linhapesquisa.idlinhapesquisa}">${linhapesquisa.nome}</a></td>
			<td>${linhapesquisa.nome}</td>
			<td><a href="/SIGP/linhaDePesquisa/alterar/${linhapesquisa.idlinhapesquisa}">Alterar</a></td>
			<td><a href="/SIGP/linhaDePesquisa/remover/${linhapesquisa.idlinhapesquisa}">Apagar</a></td>
		</tr>
	</c:forEach>
</table>
<p>
	<a href="novo">Novo</a>
</p>
<p>
	<a href="/SIGP">Voltar para Página Principal</a>
</p>

<%@ include file="/footer.jsp" %> 
