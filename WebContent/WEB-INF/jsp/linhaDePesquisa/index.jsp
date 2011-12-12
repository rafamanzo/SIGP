<%@ include file="/header.jsp" %> 

<table>
	<tr>		
		<th><fmt:message key="linha.nome" /></th>
	</tr>
	<c:forEach items="${linhasdepesquisa}" var="linhapesquisa">
		<tr>
			<td><a href="/SIGP/linhadepesquisa/ver/${linhapesquisa.idPesquisa}">${linhapesquisa.nome}</a></td>
			<td>${linhapesquisa.nome}</td>
		</tr>
	</c:forEach>
</table>
<p>
	<a href="/SIGP/linhadepesquisa/novo">Novo</a>
</p>

<hr />
<p><a href="/SIGP/"><fmt:message key="voltar_a_home" /></a></p>
<%@ include file="/footer.jsp" %> 
