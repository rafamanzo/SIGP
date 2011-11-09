<%@ include file="/header.jsp" %> 

<p>
	<b>Contribuinte:</b> ${contribuinte.nome} (${contribuinte.usuario.login})
</p>

<!-- Projetos -->
<table>
	<tr>
		<th>Projetos que participa(ou):</th>
	</tr>
	<c:forEach items="${contribuinte.participacoes}" var="participacao">
		<tr>
			<td><a href="/SIGP/projeto/ver/${participacao.projeto.idProjeto}">${participacao.projeto.nome}</a>
			</td>
		</tr>
	</c:forEach>
</table>
<!-- Publicacao -->
<table>
	<tr>
		<th>Publicações de sua autoria:</th>
	</tr>
	<c:forEach items="${contribuinte.publicacoes}" var="publicacao">
		<tr>
			<td><a href="/SIGP/publicacoes/ver/${publicacao.idPublicacao}">${publicacao.titulo}</a>
			</td>
		</tr>
	</c:forEach>
</table>
<!-- Filiacoes -->
<table>
	<tr>
		<th>Grupos no qual é filiado:</th>
	</tr>
	<c:forEach items="${contribuinte.filiacoes}" var="filiacao">
		<tr>
			<td><a href="/SIGP/grupo/ver/${filiacao.grupo.idGrupo}">${filiacao.grupo.nome}</a>
			</td>
		</tr>
	</c:forEach>
</table>
<!-- LinhaPesquisa -->
<table>
	<tr>
		<th>Pesquisou nas linhas:</th>
	</tr>
	<c:forEach items="${contribuinte.relacoes}" var="relacao">
		<tr>
			<td><a href="/SIGP/linhadepesquisa/ver/${relacao.linha.idPesquisa}">${relacao.linha.nome}</a>
			</td>
		</tr>
	</c:forEach>
</table>
<!-- resto da pagina -->
<p>
	<a href="/SIGP/contribuinte/alterar/${contribuinte.idContribuinte}">Alterar</a>
	- <a href="/SIGP/contribuinte/apagar/${contribuinte.idContribuinte}">Apagar</a>
</p>
<hr></hr>
<p>
	<a href="/SIGP/contribuinte/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
