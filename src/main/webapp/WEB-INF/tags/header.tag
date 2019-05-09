<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
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

    <div style="max-width:60%; margin-left:auto; margin-right:auto">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <a class="navbar-brand" href="<c:url value="/shop" />">Sklep</a>

      <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
          <li class="nav-item active">
            <a class="nav-link" href="<c:url value="/user/account" />">Konto<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
        </ul>


        <div style="padding-right: 1%" class="form-inline my-2 my-lg-0">
            <c:url value="/search" var="link"/>
            <sf:form method="POST" class="form-inline" modelAttribute="search" action="${link}">
                <sf:input path="searchString" type="text" class="form-control" placeholder="Search term"/>
                <input id="button" class="btn btn-outline-success my-2 my-sm-0" style="margin-left:5%" value="Szukaj" type="submit"/>
            </sf:form>
        </div>
        <div class="form-inline my-2 my-lg-0">
          <a href="<c:url value="/user/basket" />">
             <button class="btn btn-outline-success my-2 my-sm-0">Moje produkty</button>
          </a>
        </div>
      </div>
    </nav>
    </div>


</body>
</html>