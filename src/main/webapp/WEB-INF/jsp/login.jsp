<!DOCTYPE html>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous">
</head>
<body>

    <div style="max-width:20%; margin-top: 10%; margin-left: auto; margin-right: auto;">
    <sf:form method="POST" modelAttribute="user">
      <div class="form-groups">
        <div class="col text-danger font-weight-bold" style="margin-bottom:3%; text-align:center;">
            <c:out value="${error}"/>
        </div>
        <div class="col" style="margin-bottom:3%">
            <sf:input path="username" type="text" class="form-control" placeholder="Login"/>
        </div>
        <div class="col" style="margin-bottom:3%">
            <sf:input path="password" type="password" class="form-control" placeholder="Password"/>
        </div>
        <input class="btn btn-info" style="margin-left:5%" value="Zaloguj" type="submit"/>
        <a href="<c:url value="/register"/>">
            <button class="btn btn-info" type="button">
                Zarejestruj
            </button>
        </a>
      </div>
    </sf:form>
    </div>

</body>

</html>