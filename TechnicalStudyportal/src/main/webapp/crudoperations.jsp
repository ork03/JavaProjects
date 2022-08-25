<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="icon" href="data:,">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Access Courses</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
  <div class="container">

   <h2>Welcome to The portal Admin</h2>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item active">
          <a href="/" type="button"  class="btn btn-outline-danger" >Logout</a>
        </li>
       
      </ul>
    </div>
  </div>
</nav><br><br><br>
<div class="row">
            	<div class="container">
            		<h2 class="text-center"> List of Courses</h2>
            		<hr>
            		
           			 <table class=table >
           			 <caption></caption>
            			<thead>
            				<tr>
             					<th>ID</th>
                                <th>CourseName</th>
                                <th>Url</th>
                                <th>Actions</th>
                             </tr>
                          </thead>
                          <tbody>
                          <c:forEach var="user" items="${details}">
                          	<tr>
                          	<td>
                          	<c:out value="${user.id}" />
                          	</td>
                          	
                          	<td>
                          	<c:out value="${user.courseName}" />
                          	</td>
                          	<td>
                          	<c:out value="${user.url} "  />
                          	</td>
                          <td><a href="${user.id}"><button type="button" class="btn btn-outline-secondary">Edit</button></a> &nbsp;&nbsp;&nbsp;&nbsp; 
                          <a href="deletebyid/${user.id}" ><button type="button" class="btn btn-outline-danger">Delete</button></a></td>
                         
                          	</tr>
                          </c:forEach>
                          </tbody>      
                             
            		</table>
            		 <br><br>  
            		<div class="container text-center">
            			<a href="addnew" class="btn btn-outline-success">Add new Course</a>
            
            </div>
            </div>
            </div>
           
</body>
</html>