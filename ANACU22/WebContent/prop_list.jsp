<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>propertis List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
			 <form action="SeqController"> 
			 <input type="submit" name="btn_new" value="New"/></form>
			</th>
			<th>Id</th>
			<th>Seq_Id</th>
			<th>Property_Key</th>
			<th>Property_Val</th>
			<th>Description</th>
		</tr>
		<c:forEach var="prop" items="${props}">
			<tr>
				<td>
					<form action="SeqController">
						<input type="hidden" name="id" value="${prop.id}"/>
						<input type="submit" name="btn_edit" value="Edit"/>
						<input type="submit" name="btn_delete" value="Delete"/>
					</form>
				</td>
				<td>${prop.id}</td>
				<td>${prop.seq}</td>
				<td>${prop.pk}</td>
				<td>${prop.pv}</td>
				<td>${prop.desc}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>