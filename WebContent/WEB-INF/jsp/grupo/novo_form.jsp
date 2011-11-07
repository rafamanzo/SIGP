<%@ include file="/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 

<script>
$(function(){
	$("#responsavelBusca").autocomplete({
		source: function( request, response ) {
			$.ajax({
				url: "procura/" + request.term,
				dataType: "json",
				success: function( data ) {
					response($.map(data.list, function(item) {
						return { id: item.idGrupo, 
								 value: item.nome };
					}));
				}
			});
		},
		minLength: 2
	});
});
</script>

<form method="post" action="/SIGP/grupo/cria">
	<table>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="grupo.nome" />
			</td>
		</tr>
		<tr>
			<td>Responsável:</td>
			<td>
				<input type="text" id="responsavelBusca" name="responsavel" />
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Criar" />
			</td>
		</tr>
	</table>
</form>

<%@ include file="/errors.jsp" %> 

<p>
	<a href="/SIGP/grupo/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
