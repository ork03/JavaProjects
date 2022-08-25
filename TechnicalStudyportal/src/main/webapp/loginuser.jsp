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
<title>User Login</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
  <div class="container">

   <h1>Login Page</h1>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item active">
          <a href="/" type="button"  class="btn btn-outline-info" >Back</a>
        </li>
       
      </ul>
    </div>
  </div>
</nav><br><br><br>
<div class="container">
 	<c:if test="${!empty param.ans}" >
      <div class="alert alert-danger">Invalid email or
       password.</div>
     </c:if>
     <c:if test="${!empty param.ans1}" >
      <div class="alert alert-success" >Logout Successfully Done.</div>
     </c:if>
     
  <div class="row">
   <div class="col-md-6 col-md-offset-3">
    
    <br>
     
     <%--  <c:if test="${param.error}" >
      <div class="alert alert-info">You have been logged out.</div>
     </c:if>  --%>
    <form action="/validatedetails" method="post" autocomplete="off">
     
     <div class="form-group">
      <label for="username">Email</label>: <input type="email"
       id="email" name="email" class="form-control"
       autofocus="autofocus" placeholder="email" />
     </div>
     <br><br>
     <div class="form-group">
      <label for="password">Password</label>: <input type="password"
       id="password" name="password" class="form-control"
       placeholder="Password" />
     </div>
     <br><br>
     <div class="form-group">
      <div class="row">
       <div class="col-sm-6 col-sm-offset-3">
        <input type="submit" name="login-submit" id="login-submit"
         class="form-control btn btn-primary" value="Log In" />
       </div>
      </div>
     </div>
     <br>
     <div class="form-group">
      <span>New user? <a href="/registration">Register
        here</a></span>
     </div>
    </form>
   </div>
  </div>


 </div>
 
 
</body>
</html>