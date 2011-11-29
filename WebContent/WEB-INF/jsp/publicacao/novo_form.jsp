<%@ include file="/header.jsp" %> 

<form method="post" action="/SIGP/publicacao/cria">
	<table>
		<tr>
			<td>Título:</td>
			<td><input type="text" name="publicacao.titulo" /></td>
		</tr>
		<tr>
			<td>Veículo:</td>
			<td><select name="publicacao.veiculo">
					<c:forEach items="${veiculos}" var="veiculo">
						<option value="${veiculo}">${veiculo}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Data:</td>
			<td><input type="text" name="publicacao.data" /></td>
		</tr>
		
		<tr>
			<td>Projetos. Use CTRL para seleção múltipla.</td>
			<td><select name="idsProjetos[]" size="4" multiple>
					<option value="0">Nenhum</option>
					<c:forEach items="${todosprojetos}" var="projeto">
						<option value="${projeto.idProjeto}">${projeto.nome}</option>
					</c:forEach>
			</select></td>
		</tr>		
		
		<tr>
			<td colspan="2"><input type="submit" value="Criar" /></td>
		</tr>
	</table>
</form>

<%@ include file="/errors.jsp" %>

<p>
	<a href="/SIGP/publicacao/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
