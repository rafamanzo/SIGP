<%@ include file="/header.jsp" %> 
	<form action="alterar">
		<fieldset>
			<legend>Editar Linha de Pesquisa</legend>
			<input type="hidden" name="linhapesquisa.idlinhapesquisa" value="${linhapesquisa.idlinhapesquisa}" /> 
			<label for="nome"><span>Nome:</span> </label> 			
			<input id="nome" type="text" name="linhapesquisa.nome" value="${linhapesquisa.nome}" /> 
			
			<label for="sublinha"><span>Sublinha:</span></label>
			<input id="sublinha" type="text" name="linhapesquisa.sublinha" value="${linhapesquisa.sublinha}" /> 
			
			<button type="submit">Enviar</button>
		</fieldset>
	</form>
<%@ include file="/footer.jsp" %> 