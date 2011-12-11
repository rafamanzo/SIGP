<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %><%@ 
    taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%@ 
    taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${locale}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
					  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SI para Grupos de Pesquisa</title>
	<link type="text/css" href="/SIGP/styles/ui-lightness/jquery-ui-1.8.16.custom.css" rel="stylesheet" />	
	<script type="text/javascript" src="/SIGP/js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="/SIGP/js/jquery-ui-1.8.16.custom.min.js"></script>

<style type="text/css">
#header_list a {
	float: left;
	padding: 5px;
	margin-left: 3px;
	margin-right: 3px;
	text-decoration: none;
	background-color: #e0e0e0;
	border-radius: 5px;
}
#header_list a:hover { text-decoration: underline; background-color: #f0f0f0; }
</style>

</head>
<body>
<h1>Prototipo do SIGP</h1>
<div id="header_list" style="height: 50px">
	<a href="/SIGP/contribuinte/">Contribuintes</a>
	<a href="/SIGP/linhadepesquisa/">Linhas de Pesquisa</a>
	<a href="/SIGP/grupo/">Grupos</a>
	<a href="/SIGP/disciplina/">Disciplinas</a>
	<a href="/SIGP/projeto/">Projetos</a>
	<a href="/SIGP/publicacao/">Publicações</a>
	<a href="/SIGP/login/" style="float: right">Login</a>
</div>
<hr />

<!-- Podemos incluir aqui as bandeirinhas pra mudar de idioma! -->