<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
   import = "java.io.IOException,java.io.PrintWriter,java.util.*, java.util.Iterator,
   javax.servlet.*,com.cg.scoreManagement.bean.*,com.cg.scoreManagement.service.*,com.sun.mail.iap.Response;"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" 
integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" 
crossorigin="anonymous">



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1> Result</h1>
<hr color="black" size="5" width="100"><br>

<%ScoreBean bean =(ScoreBean)session.getAttribute("sid");%>
<table class="pure-table pure-table-bordered" align="center">
	<thead>
        <tr>
            <th>Student Details</th>
            <th>Marks</th>
        
        </tr>
 </thead>
	<tr><td>Trainee Id:</td>
		<td><%=bean.getTraineeId()%></td>
	</tr>
	<tr>
		<td>Subject:</td>
		<td><%=bean.getModuleName()%></td>
	</tr>
	<tr>
		<td>Total Marks:</td>
		<td><%=bean.getTotal() %></td>
	</tr>
	<tr>
		<td>Grade:</td>
		<td><%=bean.getGrade() %></td>
	</tr>
</table>
<a href = "AddAssessment.jsp">Add Assessment Details </a>
</center>
</body>
</html>