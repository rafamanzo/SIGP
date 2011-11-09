<%@ include file="/header.jsp" %> 

<table>
	<tr>
		<th>Nome</th>
		<th>Financiamento</th>
		<th>Descricao</th>
	</tr>
	<c:forEach items="${projetos}" var="projeto">
		<tr>
			<td><a href="/SIGP/projeto/ver/${projeto.idProjeto}">${projeto.nome}</a></td>
			<td>${projeto.financiamento}</td>
			<td>${projeto.descricao}</td>
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
