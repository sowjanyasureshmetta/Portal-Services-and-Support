<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${header}</title>
</head>
<body>
<table>
<form:form action="" method="post" modelAttribute="policy">
<tr>
<td><form:label path="policyNo"></form:label></td>
<td><form:input path="policyNo"/></td>
</tr>
<tr>
<td><form:label path="policyHolderName"></form:label></td>
<td><form:input path="policyHolderName"/></td>
</tr>
</form:form>
</table>
</body>
</html>