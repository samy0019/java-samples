<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Edit Existing Credit Card</h1>

<c:url var="saveUrl" value="/joedayz/main/creditcard/edit?id=${creditCardAttribute.id}" />
<form:form modelAttribute="creditCardAttribute" method="POST" action="${saveUrl}">
	<table>
	
		<tr>
			<td>Person Id:</td>
			<td><input type="text" value="${personId}" disabled="true"/>
		</tr>
		
		<tr>
			<td><form:label path="type">Type:</form:label></td>
			<td><form:input path="type"/></td>
		</tr>

		<tr>
			<td><form:label path="number">Number:</form:label></td>
			<td><form:input path="number"/></td>
		</tr>
	</table>
	
	<input type="submit" value="Save" />
</form:form>

</body>
</html>