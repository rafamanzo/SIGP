<%@ include file="/header.jsp" %> 

<h1>Membros - Informacoes de Membro</h1>

<br />
<!-- idMembro, avatar, nusp, senha, login, tipo -->
<p>
	<b>Nome:</b> Membro ${membro.idMembro}
</p>
<p>
	<b>Avatar:</b> ${membro.avatar}
</p>
<p>
	<b>NUSP:</b> ${membro.nusp}
</p>
<p>
	<b>Login:</b> ${membro.login}
</p>
<p>
	<b>Tipo:</b> ${membro.tipo}
</p>


<a href="<c:url value="/membros/editMembro"/>?id=${membro.idMembro}">Alterar Membro</a>
<hr/>
<a href="/SIGP/membros">Voltar</a>

<%@ include file="/footer.jsp" %> 
