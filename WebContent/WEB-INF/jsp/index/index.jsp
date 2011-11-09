<%@ include file="/header.jsp" %> 

<h1><fmt:message key="index.titulo_index" /></h1>
<p>
	<a href="/SIGP/login/">
	    <fmt:message key="login" />
	</a>
</p>
<p>
	<a href="/SIGP/linhaDePesquisa/">
	    <fmt:message key="linha_de_pesquisa" />
	</a>
</p>
<p>
	<a href="/SIGP/grupo/">
	    <fmt:message key="grupos" />
	</a>
</p>
<p>
	<a href="/SIGP/disciplina/">
	    <fmt:message key="disciplinas" />
	</a>
</p>
<p>
	<a href="/SIGP/projeto/">
	    <fmt:message key="projetos" />
	</a>
</p>
<p>
	<a href="/SIGP/publicacao/">
	    <fmt:message key="publicacoes" />
	</a>
</p>
<hr />
<p><a href="/SIGP/SIGP.zip"><fmt:message key="index.codigo_fonte" /></a></p>

<%@ include file="/footer.jsp" %>
