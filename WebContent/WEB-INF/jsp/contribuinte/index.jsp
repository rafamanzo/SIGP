<%@ include file="/header.jsp" %> 

<table>
	<tr>
		<th>Nome</th>
		<th>Login de Usuario</th>
	</tr>
	<c:forEach items="${contribuintes}" var="contrib">
		<tr>
			<td><a href="/SIGP/contribuinte/ver/${contrib.idContribuinte}">${contrib.nome}</a></td>
 			<td>$(${contribuinte.usuario.login})</td>
		</tr>
	</c:forEach>
</table>
<p>
	<a href="novo">Novo</a>
</p>
<p>
	<a href="/SIGP">Voltar para Página Principal</a>
</p>

<%@ include file="/footer.jsp" %> 
