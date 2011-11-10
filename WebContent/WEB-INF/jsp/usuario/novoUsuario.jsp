<%@ include file="/header.jsp"%>

<div id=header>
	<h1>SIGP</h1>
</div>
<div id=cadastra>
	<form action="salva" method="post">
		<p>
			Nome de Usuario <input type="text" value="" name="usuario.login">
		</p>
		<p>
			Tipo de Usuario: <input type="radio" value="USUARIO"
				name="usuario.tipoUsuario" checked="checked"> Usuario <input
				type="radio" value="ADMINISTRADOR" name="usuario.tipoUsuario">
			Administrador

		</p>
		<p>
			Senha <input type="password" name="usuario.senha">
		</p>
		<p>
			Confime a Senha <input type="password" name="confirma">
		</p>
		<p>
			<input type="submit" value="Registrar">
		</p>
	</form>
</div>

<%@ include file="/errors.jsp"%>

<div id=erro></div>

<%@ include file="/footer.jsp"%>
