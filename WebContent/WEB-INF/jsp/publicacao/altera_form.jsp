<%@ include file="/header.jsp" %> 

<form method="post" action="/SIGP/publicacao/altera">
	<table>
		<tr>
			<td><fmt:message key="publicacao.titulo" /></td>
			<td><input type="text" name="publicacao.titulo"
				value="${publicacao.titulo}" /></td>
		</tr>
		<tr>
			<td><fmt:message key="publicacao.veiculo" /></td>
			<td><select name="publicacao.veiculo">
					<c:forEach items="${veiculos}" var="veiculo">
						<option value="${veiculo}"
							<c:if test="${publicacao.veiculo == veiculo}">selected="selected"</c:if>>
							${veiculo}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><fmt:message key="publicacao.data" /></td>
			<td><input type="text" name="publicacao.data"
				value="${publicacao.data}" /> <fmt:message key="publicacao.modifique_formato_data" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="hidden"
				name="publicacao.idPublicacao" value="${publicacao.idPublicacao}" />
				<input type="submit" value="Alterar" /></td>
		</tr>
	</table>
</form>

<%@ include file="/errors.jsp" %>

<p>
	<a href="/SIGP/publicacao/"><fmt:message key="voltar" /></a>
</p>

<%@ include file="/footer.jsp" %> 
