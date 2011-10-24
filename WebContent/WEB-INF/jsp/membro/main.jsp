<%@ include file="/header.jsp" %> 

<h1>Membros</h1>
<br />
<a href="/SIGP/membros/novoMembro">Adicionar Novo Membro...</a>
<br />
<table>
    <!-- idMembro, avatar, nusp, senha, login, tipo -->
	<tr class="header">
		<td style="width: 180px">Nome</td>
		<td style="width: 100px">Avatar</td>
		<td style="width: 100px">Numero USP</td>
		<td style="width: 100px">Login</td>
		<td>Tipo</td>
	</tr>
	<c:forEach items="${membros}" var="membro">
		<tr>
			<td><a href="<c:url value="/membros/infoMembro"/>?id=${membro.idMembro}">Membro ${membro.idMembro}</a>
			</td>
			<td><center>${membro.avatar}</center>
			</td>
			<td><center>${membro.nusp}</center>
			</td>
			<td><center>${membro.login}</center>
			</td>
			<td><center>${membro.tipo}</center>
			</td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="/SIGP">Voltar para Pagina Principal</a>

<%@ include file="/footer.jsp" %> 
