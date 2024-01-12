%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="icon" href="data:,">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Admin Login</title>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
  <div class="container">

   <h1>Admin Login</h1>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item active">
          <a href="/" type="button"  class="btn btn-outline-info" >Back</a>
        </li>
       
      </ul>
    </div>
  </div>
</nav><br><br><br>
<c:if test="${!empty param.ans}">
    	<div class="alert alert-danger" >Invalid username or
       password for admin to access.</div>
    </c:if>
<form method="post" action="validateAdmin" autocomplete="off">

<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <div class="mb-md-5 mt-md-4 pb-5">

              <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
              <p class="text-white-50 mb-5">Please enter your username and password!</p>

              <div class="form-outline form-white mb-4">
              <label class="form-label" for="username">Username</label>
                <input type="password" id="username" name="username" class="form-control form-control-lg" placeholder="username"/>
                
              </div>

              <div class="form-outline form-white mb-4">
              <label class="form-label" for="password">Password</label>
                <input type="password" name="password" id="password" class="form-control form-control-lg" placeholder="password" />
                
              </div>

			<button  class="btn btn-outline-light btn-lg px-5"type="submit">Login</button>
			
              

            </div>

            

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</form>
</body>
</html>