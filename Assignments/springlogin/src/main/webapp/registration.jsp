<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8"/>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Create an account</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  </head>
  <body>
        <f:form method="POST" modelAttribute="userForm">
            <%--The model attribute of the form is userForm, that is, this contains all the details entered here--%>
            <h3>Create your account</h3><br>
            <%--<spring:bind path="username">--%>
                <div${status.error ? 'has-error' : ''}">
                    <f:input type="text" path="username" placeholder="Username" autofocus="true"></f:input>
                    <f:errors path="username"></f:errors>
                </div>
            <%--</spring:bind>--%>
            <br>
            <%--<spring:bind path="password">--%>
                <div${status.error ? 'has-error' : ''}">
                    <f:input type="password" path="password" placeholder="Password"></f:input>
                    <f:errors path="password"></f:errors>
                </div>
            <%--</spring:bind>--%>
            <br>
            <%--<spring:bind path="passwordConfirm">--%>
                <div${status.error ? 'has-error' : ''}">
                    <f:input type="password" path="passwordConfirm" placeholder="Confirm your password"></f:input>
                    <f:errors path="passwordConfirm"></f:errors>
                </div>
            <%--</spring:bind>--%>
            <br><br>
            <button type="submit">Submit</button>
        </f:form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>
