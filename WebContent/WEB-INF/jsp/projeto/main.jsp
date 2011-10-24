<%@ include file="/header.jsp" %> 

<h1>Projetos</h1>
<br />
<a href="/SIGP/projeto/novoProjeto">Adicionar Novo Projeto...</a>
<br />
<table>
    <!-- idProjeto, nome, descricao, financiamento, grupos, membros -->
	<tr class="header">
		<td style="width: 150px">Nome</td>
		<td style="width: 180px">Financiamento</td>
		<td>Descricao</td>
	</tr>
	<c:forEach items="${projetos}" var="projeto">
		<tr>
			<td><a href="<c:url value="/projetos/infoProjeto"/>?id=${projeto.idProjeto}">${projeto.nome}</a>
			</td>
			<td><center>${projeto.financiamento}</center>
			</td>
			<td><center>${projeto.descricao}</center>
			</td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="/SIGP">Voltar para Pagina Principal</a>

<%@ include file="/footer.jsp" %> 
