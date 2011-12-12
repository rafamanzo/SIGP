<%@ include file="/header.jsp" %> 

<p>
	<b><fmt:message key="publicacao.publicacao" /></b> ${publicacao.titulo}
</p>
<p>
	<b><fmt:message key="publicacao.data" /></b> <br /> ${publicacao.data}
</p>
<p>
	<b><fmt:message key="publicacao.veiculo" /></b> <br /> ${publicacao.veiculo}
</p>
<p>
	<b><fmt:message key="publicacao.autores" /></b>
</p>
<!-- <ul> -->
<%-- 	<c:forEach items="${publicacao.contribuintes}" var="contribuinte"> --%>
<!-- 		<li><a -->
<%-- 			href="/SIGP/contribuinte/ver/${contribuinte.idContribuinte}">${contribuinte.nome}</a> --%>
<!-- 		</li> -->
<%-- 	</c:forEach> --%>
<!-- </ul> -->
<p><fmt:message key="publicacao.projetos" /></p>
<ul>
	<c:forEach items="${publicacao.projetos}" var="projeto">
		<li><a href="/SIGP/projeto/ver/${projeto.idProjeto}">${projeto.nome}</a>
		</li>
	</c:forEach>
</ul>

<p>
	<a href="/SIGP/publicacao/alterar/${publicacao.idPublicacao}"><fmt:message key="alterar" /></a>
	<a href="/SIGP/publicacao/apagar/${publicacao.idPublicacao}"><fmt:message key="apagar" /></a>
</p>

<hr />
<p>
	<a href="/SIGP/publicacao/"><fmt:message key="publicacao.voltar" /></a>
</p>

<%@ include file="/footer.jsp" %> 
