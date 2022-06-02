<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%--Used to get conetxt path of the current file--%>
<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8"/>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Log in</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  </head>

  <body>
      <form method="POST" action="${contextPath}/login">
          <%--Specifies that the form action will be a login link and that the method is POST--%>
        <h3>Log in</h3>
        <div${error != null ? 'has-error' : ''}">
              <%--If there is any error, this will putput it in the form itself--%>
            <span>${message}<br></span>
            <input name="username" type="text" placeholder="Username" autofocus="true"/><br>
            <input name="password" type="password" placeholder="Password"/><br>
            <span>${error}<br></span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <%--CSRF - Cross Site Request Forgery - Unpredicted value generated in server side--%>
            <button type="submit">Log In</button>
            <br><br><a href="${contextPath}/registration">Create an account</a>
        </div>
      </form>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
              integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>
