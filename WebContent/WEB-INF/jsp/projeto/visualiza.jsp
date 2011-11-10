<%@ include file="/header.jsp" %> 

<p>
	<b>Projeto:</b> ${projeto.nome}
</p>
<p>
	<b>Financiamento:</b> <br /> ${projeto.financiamento}
</p>
<p>
	<b>Descricao:</b> <br /> ${projeto.descricao}
</p>

<!-- LinhaPesquisa -->
<table>
	<tr>
		<th>Linhas de Pesquisa:</th>
	</tr>
	<c:forEach items="${projeto.linhasDePesquisa}" var="linha">
		<tr>
			<td><a href="/SIGP/linhadepesquisa/ver/${linha.idPesquisa}">${linha.nome}</a>
			</td>
		</tr>
	</c:forEach>
</table>
<!-- Participacoes -->
<table>
	<tr>
		<th>Contribuintes:</th>
	</tr>
	<c:forEach items="${projeto.participacoes}" var="participacao">
		<tr>
			<td><a href="/SIGP/contribuinte/ver/${participacao.contribuinte.idContribuinte}">${participacao.contribuinte.nome}</a>
			</td>
		</tr>
	</c:forEach>
</table>
<!-- Publicacao -->
<table>
	<tr>
		<th>Publicações:</th>
	</tr>
	<c:forEach items="${projeto.publicacoes}" var="publicacao">
		<tr>
			<td><a href="/SIGP/publicacoes/ver/${publicacao.idPublicacao}">${publicacao.titulo}</a>
			</td>
		</tr>
	</c:forEach>
</table>
<p>
	<a href="/SIGP/projeto/alterar/${projeto.idProjeto}">Alterar</a>
	- <a href="/SIGP/projeto/apagar/${projeto.idProjeto}">Apagar</a>
</p>
<hr></hr>
<p>
	<a href="/SIGP/projeto/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
