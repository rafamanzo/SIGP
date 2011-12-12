<%@ include file="/header.jsp"%>

<div id=cadastra>
	<form action="salva" method="post">
		<p>
			<fmt:message key="usuario.nomeusuario" /> <input type="text" value="" name="usuario.login">
		</p>
		<p>
			<fmt:message key="usuario.tipousuario" /> <input type="radio" value="USUARIO"
				name="usuario.tipoUsuario" checked="checked"> <fmt:message key="usuario.usuario" /> <input
				type="radio" value="ADMINISTRADOR" name="usuario.tipoUsuario">
			<fmt:message key="usuario.admin" />

		</p>
		<p>
			<fmt:message key="usuario.senha" /> <input type="password" name="usuario.senha">
		</p>
		<p>
			<fmt:message key="usuario.confirmasenha" /> <input type="password" name="confirma">
		</p>
		<p>
			<input type="submit" value="Registrar">
		</p>
	</form>
</div>

<%@ include file="/errors.jsp"%>

<div id=erro></div>

<%@ include file="/footer.jsp"%>
