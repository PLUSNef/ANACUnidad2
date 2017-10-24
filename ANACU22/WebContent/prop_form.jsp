<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>propertis Form</title>
</head>
<body>
	<form action="SeqController">
		<label>Seq_id:</label>
		<br />
		<input type="number" name="seq" value="${prop.seq}">
		<br />
		<label>Property_key:</label>
		<br />
		<input type="text" name="pk" value="${prop.pk}">
		<br />
		<label>Property_val:</label>
		<br/>
		<input type="text" name="pv" value="${prop.pv}">
		<br />
		<label>Description:</label>
		<br />
		<input type="text" name="desc" value="${prop.desc}">
		<br />
		<input type="submit" name="btn_save" value="Save"/>
	</form>
</body>
</html>