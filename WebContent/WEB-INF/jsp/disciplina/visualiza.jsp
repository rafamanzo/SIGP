<%@ include file="/header.jsp" %> 

<p>
	<b>Disciplina:</b> ${disciplina.nome} (${disciplina.sigla})
</p>
<p>
	<b>Ementa:</b> <br /> ${disciplina.ementa}
</p>
<p>
	<b>Grupo ministrante: </b> <a href="/SIGP/grupo/ver/${disciplina.grupo.idGrupo}">${disciplina.grupo.nome}</a>
</p>
<p>
	<a href="/SIGP/disciplina/alterar/${disciplina.idDisciplina}">Alterar</a>
	- <a href="/SIGP/disciplina/apagar/${disciplina.idDisciplina}">Apagar</a>
</p>

<hr />
<p>
	<a href="/SIGP/disciplina/"><fmt:message key="disciplina.voltar" /></a>
</p>

<%@ include file="/footer.jsp" %> 
