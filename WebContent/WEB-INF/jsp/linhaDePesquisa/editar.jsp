<%@ include file="/header.jsp" %> 
	<form action="alterar">
		<fieldset>
			<legend>Editar Linha de Pesquisa</legend>
			<input type="hidden" name="linhapesquisa.idPesquisa" value="${linhapesquisa.idPesquisa}" /> 
			<label for="nome"><span>Nome:</span> </label> 			
			<input id="nome" type="text" name="linhapesquisa.nome" value="${linhapesquisa.nome}" /> 
			
			<label for="sublinha"><span>SubLinha:</span></label>
			<input id="sublinha" type="text" name="linhapesquisa.subLinha" value="${linhapesquisa.subLinha}" /> 
			
			<button type="submit">Enviar</button>
		</fieldset>
	</form>
<%@ include file="/footer.jsp" %> 