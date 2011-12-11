<%@ include file="/header.jsp" %> 

<table>
	<tr>		
		<th>Nome</th>
	</tr>
	<c:forEach items="${linhasdepesquisa}" var="linhapesquisa">
		<tr>
			<td><a href="/SIGP/linhadepesquisa/ver/${linhapesquisa.idPesquisa}">${linhapesquisa.nome}</a></td>
			<td>${linhapesquisa.nome}</td>
		</tr>
	</c:forEach>
</table>
<p>
	<a href="/SIGP/linhadepesquisa/novo">Novo</a>
</p>

<hr />
<p><a href="/SIGP/">Voltar à página principal</a></p>
<%@ include file="/footer.jsp" %> 
