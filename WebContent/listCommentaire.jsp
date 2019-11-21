<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.List"%>
<%@page import="fr.cesi.commerce.doa.ProductDao"%> 
<%@page import="fr.cesi.commerce.model.Product"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>List Product</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</head>
	<body>
		<a href="/Test/index.jsp"><button class="btn btn-success" style="margin : 10px">Home</button></a>
		<table class="table">
			<tr>
				<th>ID</th>
				<th>Description</th>
				<th>Titre</th>
				<th>Employe</th>
				<th></th>
			</tr>
			<c:forEach items="${Commentaires}" var="comm">
				<c:set var="path" value="auth/removeProduct?id=${produit.id}" scope="page" />
	    		<tr>
	    			<td><c:out value="${comm.id}" /></td> 
	    			<td><c:out value="${comm.description}" /></td>
	    			<td><c:out value="${comm.titre}" /></td>
	    			<td><c:out value="${comm.employe}" /></td>
	    		</tr>
			</c:forEach>
		</table>
	</body>
</html>