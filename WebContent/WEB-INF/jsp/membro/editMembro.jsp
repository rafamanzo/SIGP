<%@ include file="/header.jsp" %> 

<h1>Membros - Editar Membro</h1>

<br />
<h1>Membro ${membro.idMembro}</h1>
<form action="updateMembro">
	<input type="hidden" name="membro.idMembro" value="${membro.idMembro}" />
	<!-- idMembro, avatar, nusp, senha, login, tipo -->
	<table>
		<tr>
			<td>Avatar:</td>
			<td><input type="text" name="membro.avatar" value="${membro.avatar}" />
			</td>
		</tr>
		<tr>
			<td>NUSP: 
		</td>
		<td><input type="text" name="membro.nusp"
			value="${membro.nusp}" />
		</td>
		</tr>
		<tr>
			<td>Login: 
		</td>
		<td><input type="text" name="membro.login"
			value="${membro.login}" />
		</td>
		</tr>
		<tr>
			<td>Senha:
		</td>
		<td><input type="text" name="membro.senha"
			value="${membro.senha}" />
		</td>
		</tr>
		<tr>
			<td>Tipo:
		</td>
		<td><input type="text" name="membro.tipo"
			value="${membro.tipo}" />
		</td>
		</tr>
		</table>
	<br />
	<input type="submit" name="oQueFazer" value="${editSaveTitle}" />
	<input type="submit" name="oQueFazer" value="${editDelTitle}" />
	<br />
	<input type="submit" name="oQueFazer" value="Voltar" />
	<br />
</form>

<%@ include file="/footer.jsp" %> 
