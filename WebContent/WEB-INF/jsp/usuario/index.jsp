<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div id=header>
		<h1>SIGP</h1>
	</div>
	<div id=login>
		<form action="verifica" method="post">
			<p>
				Login <input type="text" value="Login" name="login">
			</p>
			<p>
				Senha <input type="password" name="senha">
			</p>	
			<p>
				<input type="submit" value="Login">
			</p>
			<p>
				<a href="/SIGP/"> Registrar usuario.</a>
			</p>
		</form>
	</div>
	<div id=erro>
		${usuarioNaoCadastrado}
	</div>
	
</body>
</html>