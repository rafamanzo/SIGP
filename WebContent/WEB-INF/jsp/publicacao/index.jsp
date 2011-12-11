<%@ include file="/header.jsp" %> 

<table>
	<tr>
		<th>Titulo</th>
		<th>Data</th>
		<th>Ve√≠culo</th>
	</tr>
	<c:forEach items="${publicacoes}" var="publicacao">
		<tr>
			<td><a href="/SIGP/publicacao/ver/${publicacao.idPublicacao}">${publicacao.titulo}</a></td>
<%-- 			<td>${publicacao.data}</td> --%>
<%-- 			<td>${publicacao.veiculo}</td> --%>
		</tr>
	</c:forEach>
</table>
<p>
	<a href="novo">Novo</a>
</p>

<hr />
<p><a href="/SIGP/">Voltar ‡ p·gina principal</a></p>
<%@ include file="/footer.jsp" %> 
