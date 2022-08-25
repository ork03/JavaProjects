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
<title>Edit Course</title>
</head>
<body>
<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <div class="mb-md-5 mt-md-4 pb-5">

              <h2 class="fw-bold mb-2 text-uppercase">Add New Courses</h2>
              <p class="text-white-50 mb-5">Please enter the courses!</p>

			<form method="post" action="updatesave/${details.id}" autocomplete="off">
			<div class="form-outline form-white mb-4">
              <label class="form-label" >Course Id</label>
                <input type="text" name="courseName" id="courseName" class="form-control form-control-lg" value="${details.id}"disabled/>
                
              </div>
              <div class="form-outline form-white mb-4">
              <label class="form-label" >Course Name</label>
                <input type="text" name="courseName" id="courseName" class="form-control form-control-lg" value="${details.courseName}"/>
                
              </div>

				  <div class="form-outline form-white mb-4">
				   <label class="form-label" >Url</label>
                <input type="url" name="url" id="url" class="form-control form-control-lg" value="${details.url}"/>
               
              </div>
              
               
              <button class="btn btn-outline-light btn-lg px-5" type="submit">Create</button>

              </form>

            </div>

            

          </div>
        </div>
      </div>
    </div>
  </div>
</section> 
</body>
</html>