<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
      <style>
      .error{
      color:red;
      }
      </style>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">

  <div class="container">
   <h1>Registration Page</h1>
  </div>
</nav><br><br><br><br>
<div class="container">
	<c:if test="${!empty param.ans}">
    	<div class="alert alert-info">You've successfully registered Login to continue!</div>
    </c:if>
        <form:form method="POST" modelAttribute="userForm" class="form-signin" action="/registration" autocomplete="off" >
            
            <spring:bind path="firstName">
                <div class="form-group">
                    <form:input type="text" path="firstName" class="form-control" placeholder="firstName"
                                autofocus="true" ></form:input>
                    <form:errors path="firstName" cssClass="error"></form:errors>
                </div>
            </spring:bind>
            <br>
             <spring:bind path="lastName">
                <div class="form-group">
                    <form:input type="text" path="lastName" class="form-control" placeholder="lastName"
                                autofocus="true"></form:input>
                  	<form:errors path="lastName" cssClass="error"></form:errors>
                </div>
            </spring:bind><br>
            <spring:bind path="email">
                <div class="form-group ">
                    <form:input type="email" path="email" class="form-control" placeholder="email"></form:input>
                    <form:errors path="email" cssClass="error"></form:errors>
                </div>
            </spring:bind>
			<br>
            <spring:bind path="confirmEmail">
                <div class="form-group ">
                    <form:input type="email" path="confirmEmail" class="form-control"
                                placeholder="Confirm your Email"></form:input>
                    <form:errors path="confirmEmail" cssClass="error"></form:errors>
                </div>
            </spring:bind>
            <br>
             <spring:bind path="password">
                <div class="form-group">
                    <form:input type="password" path="password" class="form-control" placeholder="password"
                                autofocus="true"></form:input>
                    <form:errors path="password" cssClass="error"></form:errors>
                </div>
            </spring:bind><br>
             <spring:bind path="confirmPassword">
                <div class="form-group ">
                    <form:input type="password" path="confirmPassword" class="form-control" placeholder="confirmPassword"
                                autofocus="true"></form:input>
                    <form:errors path="confirmPassword" cssClass="error"></form:errors>
                </div>
            </spring:bind>
            

            <br>
			<div class="form-group">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
            <span>Already registered? <a href="/loginuser" ">Login here</a></span>
            </div>
        </form:form>

    </div>
    </div>
</body>
</html>