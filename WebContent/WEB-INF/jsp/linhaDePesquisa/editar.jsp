<%@ include file="/header.jsp" %> 

<form method="post" action="/SIGP/linhadepesquisa/altera">
	<div></div>
	<table>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="linhapesquisa.nome" value="${linhapesquisa.nome}" />
			</td>
		</tr>
		<tr>
			<td>SubLinha:</td>
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
			<td colspan="2"><input type="hidden" name="linhapesquisa.idPesquisa"
				value="${linhapesquisa.idPesquisa}" /> <input type="submit" value="Alterar" />
			</td>
		</tr>
	</table>
</form>
<p>
	<a href="/SIGP/grupo/">Voltar</a>
</p>

<%@ include file="/footer.jsp" %> 