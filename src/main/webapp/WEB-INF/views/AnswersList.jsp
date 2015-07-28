<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HOME</title>
</head>
<body>
<div align="center">
	        <h1>Answers List</h1>
	        <h2><a href="new">New User</a></h2>
	        
        	<table border="1">
	        	<th>Id</th>
	        	<th>Answer</th>
	        	<th>Score</th>
	        	
	        	
				<c:forEach var="answer" items="${answersList}" varStatus="status">
	        	<tr>
	        		<td>${answer.id}</td>
					<td>${answer.answer}</td>
					<td>${answer.score}</td>
					<th>Actions</th>
					<td>
						<a href="edit?id=${answers.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="delete?id=${answers.id}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>
</body>
</html>