<%@ include file="/header.jsp" %> 

<script type="text/javascript">
$(function(){
	$("#ministranteBusca").autocomplete({
		minLength: 1, // Precisa digitar pelo menos 1 letra para o autocompletar come�ar. 
		source: function( request, response ) {
			$.ajax({
				url: "/SIGP/grupo/procura/" + request.term,
				dataType: "json",
				success: function( data ) {
					// response � uma fun��o que se passar uma lista de structs com campos id e value, 
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

<form method="post" action="/SIGP/disciplina/cria">
	<table>
		<tr>
			<td>Sigla:</td>
			<td><input type="text" name="disciplina.sigla" /></td>
		</tr>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="disciplina.nome" /></td>
		</tr>
		<tr>
			<td>Ementa:</td>
			<td><textarea name="disciplina.ementa"></textarea></td>
		</tr>
		<tr>
			<td>Grupo ministrante:</td>
			<td><input type="text" id="ministranteBusca" name="ministrante" /></td>
		</tr>
						
		<tr>
			<td colspan="2"><input type="submit" value="Criar" /></td>
		</tr>
	</table>
</form>

<%@ include file="/errors.jsp" %> 

<p>
	<a href="/SIGP/disciplina/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
