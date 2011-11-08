<%@ include file="/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
$(function(){
	$("#responsavelBusca").autocomplete({
		minLength: 1, // Precisa digitar pelo menos 1 letra para o autocompletar começar. 
		source: function( request, response ) {
			$.ajax({
				url: "../procura/" + request.term,
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

<form method="post" action="/SIGP/grupo/altera">
	<table>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="grupo.nome" value="${grupo.nome}" >
			</td>
		</tr>
		<tr>
			<td>Responsável:</td>
			<td>
				<input type="text" id="responsavelBusca" name="responsavel"
					value="<c:if test="${grupo.responsavel != null}">${grupo.responsavel.nome}</c:if>">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="hidden" name="grupo.idGrupo" value="${grupo.idGrupo}">
				<input type="submit" value="Alterar">
			</td>
		</tr>
	</table>
</form>


<%@ include file="/errors.jsp" %> 

<p>
	<a href="/SIGP/grupo/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
