<%@ include file="/header.jsp" %> 

<form method="post" action="/SIGP/linhadepesquisa/inserir">
	<table>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="linhapesquisa.nome" />
			</td>
		</tr>
		<tr>
			<td>Sublinha de Pesquisa</td>
			<td><select name="subLinha">
					<option value="0">Nenhum</option>
					<c:forEach items="${linhasdepesquisa}" var="linhapesquisa">
						<option value="${linhapesquisa.idPesquisa}">${linhapesquisa.nome}</option>
					</c:forEach>
			</select>
			</td>
		</tr>
		
			<tr>
			<td>Projetos</td>
			<td><select name="projeto">
					<option value="0">Nenhum</option>
					 <c:set var="list" value="${projetos}," scope="session" />
					<c:forEach items="${projetos}" var="projeto">
						<option value="${projeto.idProjeto}">${projeto.nome}</option>
						<c:set var="list" value="${projetos}${param.item}" scope="session" />
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
	<a href="/SIGP/linhadepesquisa/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 
