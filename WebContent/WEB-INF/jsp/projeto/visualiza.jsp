<%@ include file="/header.jsp" %> 

<p>
	<b><fmt:message key="projeto.projeto" /></b> ${projeto.nome}
</p>
<p>
	<b><fmt:message key="projeto.financiamento" /></b> <br /> ${projeto.financiamento}
</p>
<p>
	<b><fmt:message key="projeto.descricao" /></b> <br /> ${projeto.descricao}
</p>

<!-- LinhaPesquisa -->
<table>
	<tr>
		<th><fmt:message key="projeto.linhas_de_pesquisa" /></th>
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
		<th><fmt:message key="projeto.contribuintes" /></th>
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
		<th><fmt:message key="projeto.publicacoes" /></th>
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

<hr />
<p>
	<a href="/SIGP/projeto/"><fmt:message key="projeto.voltar" /></a>
</p>

<%@ include file="/footer.jsp" %> 
