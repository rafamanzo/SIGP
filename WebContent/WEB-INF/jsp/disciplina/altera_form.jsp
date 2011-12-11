<%@ include file="/header.jsp" %>

<script type="text/javascript">
$(function(){
	$("#ministranteBusca").autocomplete({
		minLength: 1, // Precisa digitar pelo menos 1 letra para o autocompletar começar. 
		source: function( request, response ) {
			$.ajax({
				url: "/SIGP/grupo/procura/" + request.term,
				dataType: "json",
				success: function( data ) {
					// response é uma função que se passar uma lista de structs com campos id e value, 
					// cria o autocompletar. 
					response($.map(data.list, function(item) {
						return { id: item.idGrupo, 
								 value: item.nome };
					}));
				}
			});
		}
	});
});
</script> 

<form method="post" action="/SIGP/disciplina/altera">
	<table>
		<tr>
			<td>Sigla:</td>
			<td><input type="text" name="disciplina.sigla" value="${disciplina.sigla}" />
			</td>
		</tr>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="disciplina.nome" value="${disciplina.nome}" />
			</td>
		</tr>
		<tr>
			<td>Ementa:</td>
			<td><textarea name="disciplina.ementa">${disciplina.nome}</textarea>
			</td>
		</tr>
		<tr>
			<td>Grupo ministrante:</td>
			<td><input type="text" id="ministranteBusca" name="ministrante" value="${disciplina.grupo.nome}"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="hidden" name="disciplina.idDisciplina"
				value="${disciplina.idDisciplina}" /> <input type="submit" value="Alterar" />
			</td>
		</tr>
	</table>
</form>

<%@ include file="/errors.jsp" %> 

<p>
	<a href="/SIGP/disciplina/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
