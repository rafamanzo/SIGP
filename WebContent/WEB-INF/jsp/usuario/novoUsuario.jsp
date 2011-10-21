<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo Membro</title>
</head>
<body>
	<div id=header>
		<h1>SIGP</h1>
	</div>
	<div id=cadastra>
		<form action="salva" method="post">
			<p>
				Nome de Usuario <input type="text" value="" name="usuario.login">
			</p>
			<p>
				Tipo de Usuario: 
				<input type="radio" value="USUARIO" name="usuario.tipoUsuario"> Usuario
				<input type="radio" value="ADMINISTRADOR" name="usuario.tipoUsuario"> Administrador
				
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
	<div id=erro>
		${usuarioJaExistente}
		${senhaIvalida}
		${senhasDiferentes}
	</div>
</body>
</html>