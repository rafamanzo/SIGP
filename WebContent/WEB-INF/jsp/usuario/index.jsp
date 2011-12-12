<%@ include file="/header.jsp" %> 

<div id=login>
	<form action="verifica" method="post">
		<p>
			<fmt:message key="usuario.nomeusuario" /> <input type="text" name="login">
		</p>
		<p>
			<fmt:message key="usuario.senha" /> <input type="password" name="senha">
		</p>	
		<p>
			<input type="submit" value="Login">
		</p>
		<p>
			<a href="/SIGP/login/novoUsuario"> <fmt:message key="usuario.registrar" /></a>
		</p>
	</form>
</div>

<%@ include file="/errors.jsp" %>

<div id=erro>
	${logado}
</div>

<%@ include file="/footer.jsp" %> 
