<%@ include file="/header.jsp" %> 

<p>
	<b>Linha de Pesquisa:</b> ${linhapesquisa.nome}
</p>
<p>
	<b>Sublinha:</b>
	<c:choose>
		<c:when test="${linhapesquisa.sublinha != null}">${linhapesquisa.sublinha.nome}</c:when>
		<c:otherwise> - </c:otherwise>
	</c:choose>
</p>
<p>Projetos:</p>
<ul><c:forEach items="${linhapesquisa.projetos}" var="projeto">
	<li><!--<a href="/SIGP/pesquisa/ver/${pesquisa.idPesquisa}">-->${projeto.nome}</li>
</c:forEach></ul>
<p>Contribuintes:</p>
<ul><c:forEach items="${linhapesquisa.contribuintes}" var="contribuinte">
	<li><a href="/SIGP/contribuinte/ver/${contribuinte.idContribuinte}">${contribuinte.nome}</a></li>
</c:forEach></ul>
<p>
	<a href="/SIGP/linhapesquisa/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
