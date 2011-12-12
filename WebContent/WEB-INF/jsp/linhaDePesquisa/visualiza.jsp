<%@ include file="/header.jsp" %> 

<p>
	<b>Linha de Pesquisa:</b> ${linhapesquisa.nome}
</p>
<p>
	<b>SubLinha:</b>
	<c:choose>
		<c:when test="${linhapesquisa.subLinha != null}">${linhapesquisa.subLinha.nome}</c:when>
		<c:otherwise> - </c:otherwise>
	</c:choose>
</p>
<p>Projetos:</p>
<ul>
	<c:forEach items="${linhapesquisa.projetos}" var="projeto">
		<li><a href="/SIGP/projeto/ver/${projeto.idProjeto}">${projeto.nome}</a>
		</li>
	</c:forEach>
</ul>
<!-- <p>Contribuintes:</p> -->
<%-- <ul><c:forEach items="${linhapesquisa.contribuintes}" var="contribuinte"> --%>
<%-- 	<li><a href="/SIGP/contribuinte/ver/${contribuinte.idContribuinte}">${contribuinte.nome}</a></li> --%>
<%-- </c:forEach></ul> --%>
<p>
<a href="/SIGP/linhadepesquisa/alterar/${linhapesquisa.idPesquisa}">Alterar</a>
<a href="/SIGP/linhadepesquisa/apagar/${linhapesquisa.idPesquisa}">Apagar</a>
</p>

<hr />
<p>
	<a href="/SIGP/linhadepesquisa/"><fmt:message key="linha.voltar" /></a>
</p>

<%@ include file="/footer.jsp" %> 
