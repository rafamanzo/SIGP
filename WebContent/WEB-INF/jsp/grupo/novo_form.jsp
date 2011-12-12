<%@ include file="/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 

<script type="text/javascript">
$(function(){
	$("#responsavelBusca").autocomplete({
		minLength: 1, // Precisa digitar pelo menos 1 letra para o autocompletar começar. 
		source: function( request, response ) {
			$.ajax({
				url: "procura/" + request.term,
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

<form method="post" action="/SIGP/grupo/cria">
	<table>
		<tr>
			<td><fmt:message key="grupo.nome" /></td>
			<td><input type="text" name="grupo.nome" />
			</td>
		</tr>
		<tr>
			<td><fmt:message key="grupo.responsavel" /></td>
			<td>
				<input type="text" id="responsavelBusca" name="responsavel" />
			</td>
		</tr>
		
		<tr>


			<td><fmt:message key="grupo.selecionar_linhas_de_pesquisa" />
			<td><select name="idsLinhasdePesquisa[]" size="4" multiple>
					<option value="0"><fmt:message key="grupo.nenhum" /></option>
					<c:forEach items="${todaslinhasdepesquisa}" var="linha">
						<option value="${linha.idPesquisa}">${linha.nome}</option>
					</c:forEach>
			</select></td>
		</tr>
		
		
		
		
		<tr>
			<td colspan="2"><input type="submit" value="Criar" />
			</td>
		</tr>
	</table>
</form>

<%@ include file="/errors.jsp" %> 

<p>
	<a href="/SIGP/grupo/"><fmt:message key="voltar" /></a>
</p>

<%@ include file="/footer.jsp" %> 
