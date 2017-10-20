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
<title>Student Score Details</title>
</head>
<body>
<center>
<h1>Add Assessmesnt Details</h1>
<hr color="black" size="5" width="400">

<form class="pure-form pure-form-aligned" action="studentinfo.obj" align="center">
	
		<tr><td>Select Trainee ID:</td>
		<td><select name="traineeId">
		<c:forEach items="${sessionScope.list}" var="lists">
		<option><c:out value="${lists}"/></option>
		</c:forEach>
		</select></td>
		</tr>
		<br>
	
		<tr>
		<td>Select Subject:</td>
		<td><select name ="moduleName">
			<option value="Module1">Module1</option>
  			<option value="Module2">Module2</option>
  			<option value="Module3">Module3</option>
 			<option value="Module4">Module4</option>
	 		<option value="Module5">Module5</option>
		</select></td>
		</tr>
		<br>
		<tr>
			<td>MPT Marks:</td>
			<td><input type="number" placeholder ="MPT Marks" name="practicleTest" min="0" max="70"/></td>
		</tr><br>
		<tr>
			<td>MTT Marks:</td>
			<td><input type="number" placeholder ="MTT Marks"  name="theoryTest" min="0" max="15"/></td>
		</tr><br>
		<tr>
			<td>Assignment:</td>
			<td><input type="number" placeholder ="Assignment Marks" name="assignment" min="0" max="15"/></td>
		</tr><br>
		<br>
		<tr><td><input text-align="center" class="pure-button pure-button-primary" type="submit" value="submitDetails"/></td></tr>
	
</form>	

</center>
</body>
</html>