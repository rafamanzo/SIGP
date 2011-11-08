<%@ include file="/header.jsp" %> 

<form method="post" action="/SIGP/contribuinte/cria">
	<table>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="contribuinte.nome" /></td>
		</tr>

		<tr>
			<td>Usuario Correspondente:</td>
			<td><select name="contribuinte.usuario.idUsuario">
					<option value="0">Nenhum</option>
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
	<a href="/SIGP/contribuinte/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
