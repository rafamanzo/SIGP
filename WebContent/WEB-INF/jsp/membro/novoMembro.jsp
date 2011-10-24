<%@ include file="/header.jsp" %> 

<h1>Adicionar Membro Novo...</h1>
<br />
<form action="salva">
	<table>
	 <!-- idMembro, avatar, nusp, senha, login, tipo -->
		<tr>
			<td>Avatar:</td>
			<td><input type="text" name="membro.avatar" /></td>
		</tr>
		<tr>
			<td>NUSP:</td>
			<td><input type="text" name="membro.nusp" />
			</td>
		</tr>
		<tr>
			<td>Login:</td>
			<td><input type="text" name="membro.login" />
			</td>
		</tr>
		<tr>
			<td>Senha:</td>
			<td><input type="text" name="membro.senha" />
			</td>
		</tr>
		<tr>
			<td>Tipo:</td>
			<td><input type="text" name="membro.tipo" />
			</td>
		</tr>
	</table>
	<br /> <input type="submit" value="Adicionar Membro" />
</form>

<%@ include file="/footer.jsp" %> 
