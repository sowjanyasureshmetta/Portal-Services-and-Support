<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<head>
<title>
eAppointment
</title>
</head>
<body>
<h1 align="center">Welcome to eAppointment Process</h1>
<table>
<form:form action="/eappointment/addagent" modelAttribute="agentdetails">
<tr><td>
<form:label path="agentNo">Agent No :</form:label>
<form:input path="agentNo"/>
</td></tr>
<tr><td>
<form:label path="agentName">Agent Name :</form:label>
<form:input path="agentName"/>
</td></tr>
<tr><td>
<form:label path="agentGender">Agent Gender :</form:label>
<form:input path="agentGender"/>
</td></tr>
<tr><td>
<form:label path="agentNric">Agent Nric :</form:label>
<form:input path="agentNric"/>
</td></tr>
<tr><td>
<form:label path="agentMobile">Agent Mobile :</form:label>
<form:input path="agentMobile"/>
</td></tr>
<tr>
<td>
<form:label path="agentDob">Agent DOB :</form:label>
<form:input path="agentDob"/>
</td>
</tr>
<tr>
<td>
<form:button value="submit">submit</form:button>
</td>
</tr>
</form:form>
</table>

</body>
</html>
