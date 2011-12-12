<%@ include file="/header.jsp" %> 

<form method="post" action="/SIGP/linhadepesquisa/altera">
	<div></div>
	<table>
		<tr>
			<td><fmt:message key="linha.nome" /></td>
			<td><input type="text" name="linhapesquisa.nome" value="${linhapesquisa.nome}" />
			</td>
		</tr>
		<tr>
			<td><fmt:message key="linha.sublinha" /></td>
			<td><select name="subLinha">
					<option value="0">Nenhum</option>
					<c:forEach items="${linhasdepesquisa}" var="linhaslista">
						<c:if test="${linhaslista.idPesquisa != linhapesquisa.idPesquisa}">
							<option value="${linhaslista.idPesquisa}"
								<c:if test="${linhapesquisa.subLinha.idPesquisa == linhaslista.idPesquisa}">selected="selected"</c:if>>${linhaslista.nome}</option>
						</c:if>
					</c:forEach>
			</select></td>
		</tr>

		<tr>
			<td><fmt:message key="linha.projetos" /></td>
			<td><select name="projetos" size="2" multiple>
					<option value="0">Nenhum</option>
					<c:forEach items="${todosprojetos}" var="projeto">
						<option value="${projeto.idProjeto}">${projeto.nome}</option>
					</c:forEach>
			</select>
			</td>
		</tr>

		<tr>
			<td colspan="2"><input type="hidden" name="linhapesquisa.idPesquisa"
				value="${linhapesquisa.idPesquisa}" /> <input type="submit" value="Alterar" />
			</td>
		</tr>
	</table>
</form>

<%@ include file="/errors.jsp" %>

<p>
	<a href="/SIGP/linhaDePesquisa/"><fmt:message key="voltar" /></a>
</p>

<%@ include file="/footer.jsp" %> 