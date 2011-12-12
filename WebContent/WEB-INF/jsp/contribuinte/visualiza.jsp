<%@ include file="/header.jsp" %> 

<p>
	<b>Contribuinte:</b> ${contribuinte.nome} (${contribuinte.usuario.login})
</p>

<!-- Projetos -->
<table>
	<tr>
		<th><fmt:message key="contribuinte.projetosparticipou" /></th>
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
		<th><fmt:message key="contribuinte.publicacoesfeitas" /></th>
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
		<th><fmt:message key="contribuintes.gruposfiliado" /></th>
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
		<th><fmt:message key="contribuinte.linhaspesquisou" /></th>
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
	<a href="/SIGP/contribuinte/alterar/${contribuinte.idContribuinte}"><fmt:message key="alterar" /></a>
	- <a href="/SIGP/contribuinte/apagar/${contribuinte.idContribuinte}"><fmt:message key="apagar" /></a>
</p>

<hr />
<p>
	<a href="/SIGP/contribuinte/"><fmt:message key="voltar" /></a>
</p>

<%@ include file="/footer.jsp" %> 
