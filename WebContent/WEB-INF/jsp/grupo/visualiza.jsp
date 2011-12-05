<%@ include file="/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 

<p>
	<b>Grupo:</b> ${grupo.nome}
</p>
<p>
	<b>Responsável:</b>
	<c:choose>
		<c:when test="${grupo.responsavel != null}">${grupo.responsavel.nome}</c:when>
		<c:otherwise> - </c:otherwise>
	</c:choose>
</p>
<p>Pesquisas:</p>
<ul><c:forEach items="${grupo.pesquisas}" var="pesquisa">
	<li><a href="/SIGP/linhadepesquisa/ver/${pesquisa.idPesquisa}">${pesquisa.nome}</a></li>
</c:forEach></ul>
<p>Disciplinas:</p>
<ul><c:forEach items="${grupo.disciplinas}" var="disciplina">
	<li><a href="/SIGP/disciplina/ver/${disciplina.idDisciplina}">${disciplina.nome}</a></li>
</c:forEach></ul>
<p>Filiações:</p>
<ul><c:forEach items="${grupo.filiacoes}" var="filiacao">
	<li><a href="/SIGP/contribuinte/ver/${filiacao.contribuinte.idContribuinte}">${filiacao.contribuinte.nome}</a></li>
</c:forEach></ul>
<p>Projetos:</p>
<ul><c:forEach items="${grupo.projetos}" var="projeto">
	<li><a href="/SIGP/projeto/ver/${projeto.idProjeto}">${projeto.nome}</a></li>
</c:forEach></ul>
<p>Publicações:</p>
<ul><c:forEach items="${grupo.publicacoes}" var="publicacao">
	<li>${publicacao.titulo}</li>
</c:forEach></ul>	
<p>
			<a href="/SIGP/grupo/alterar/${grupo.idGrupo}">Alterar</a>
			<a href="/SIGP/grupo/apagar/${grupo.idGrupo}">Apagar</a>
</p>

<p>
	<a href="/SIGP/grupo/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
