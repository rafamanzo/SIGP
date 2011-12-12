<%@ include file="/header.jsp" %> 

<form method="post" action="/SIGP/contribuinte/cria">
	<table>
		<tr>
			<td><fmt:message key="contribuinte.nome" /></td>
			<td><input type="text" name="contribuinte.nome" /></td>
		</tr>

		<tr>
			<td><fmt:message key="contribuinte.usuariocorrespondente" /></td>
			<td><select name="idUsuario">
					<option value="0"><fmt:message key="contribuinte.nenhum" /></option>
					<c:forEach items="${usuarios}" var="usuario">
						<option value="${usuario.idUsuario}">${usuario.login}</option>
					</c:forEach>
			</select>
			</td>
		</tr>
						
		<tr>
			<td colspan="2"><input type="submit" value="Criar" /></td>
		</tr>
	</table>
</form>

<%@ include file="/errors.jsp" %> 

<p>
	<a href="/SIGP/contribuinte/"><fmt:message key="voltar" /></a>
</p>

<%@ include file="/footer.jsp" %> 
