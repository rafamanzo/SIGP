<%@ include file="/header.jsp" %> 

<h1>Projetos - Informacoes do Projeto</h1>

<br />
<p>
	<b>Nome:</b> ${projeto.nome}
</p>
<p>
	<b>Descricao:</b> <br /> ${projeto.descricao}
</p>
<p>
	<b>Financiamento:</b> ${projeto.financiamento}
</p>

<!-- 	<p> -->
<!-- 		<b>Grupo Coordenador: </b>  -->
<%-- 		<a href="/SIGP/grupo/ver/${projeto.coordenador.idGrupo}">${projeto.coordenador.nome}</a> --%>
<!-- 	</p> -->


<a href="<c:url value="/projeto/editProjeto"/>?id=${projeto.idProjeto}">Alterar Projeto</a>
<hr/>
<a href="/SIGP/projeto/">Voltar</a>

<%@ include file="/footer.jsp" %> 
