<%@ include file="/header.jsp" %> 

<form method="post" action="/SIGP/grupo/cria">
	<table>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="grupo.nome" />
			</td>
		</tr>
		<tr>
			<td>Responsável:</td>
			<td><select name="responsavel">
					<option value="0">Nenhum</option>
					<c:forEach items="${grupos}" var="grupo">
						<option value="${grupo.idGrupo}">${grupo.nome}</option>
					</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Criar" />
			</td>
		</tr>
	</table>
</form>
<p>
	<a href="/SIGP/grupo/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
