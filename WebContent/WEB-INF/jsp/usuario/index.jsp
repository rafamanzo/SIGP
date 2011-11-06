<%@ include file="/header.jsp" %> 

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
			<a href="/SIGP/login/novoUsuario"> Registrar usuario.</a>
		</p>
	</form>
</div>
<div id=erro>
	${usuarioNaoCadastrado}
	${logado}
	${usuarioOuSenhaIncorreta}
</div>

<%@ include file="/footer.jsp" %> 
