<%@ include file="/header.jsp" %> 

<p>
	<b>PublicaÃ§Ã£o:</b> ${publicacao.titulo}
</p>
<p>
	<b>Data:</b> <br /> ${publicacao.data}
</p>
<p>
	<b>VeÃ­culo:</b> <br /> ${publicacao.veiculo}
</p>
<p>
	<b>Autores:</b>
</p>
<!-- <ul> -->
<%-- 	<c:forEach items="${publicacao.contribuintes}" var="contribuinte"> --%>
<!-- 		<li><a -->
<%-- 			href="/SIGP/contribuinte/ver/${contribuinte.idContribuinte}">${contribuinte.nome}</a> --%>
<!-- 		</li> -->
<%-- 	</c:forEach> --%>
<!-- </ul> -->
<p>Projetos:</p>
<ul>
	<c:forEach items="${publicacao.projetos}" var="projeto">
		<li><a href="/SIGP/projeto/ver/${projeto.idProjeto}">${projeto.nome}</a>
		</li>
	</c:forEach>
</ul>

<p>
	<a href="/SIGP/publicacao/alterar/${publicacao.idPublicacao}">Alterar</a>
	- <a href="/SIGP/publicacao/apagar/${publicacao.idPublicacao}">Apagar</a>
</p>

<hr />
<p>
	<a href="/SIGP/publicacao/">Voltar à lista de publicações</a>
</p>

<%@ include file="/footer.jsp" %> 
