<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld"%>
<html lang="en">
<head>
    <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
</head>
<body>
    <custom:header/>

    <c:out value="${product.name}"/></br>
    <c:out value="${product.price}"/></br>
    <c:out value="${product.quantity}"/></br>
    <c:out value="${product.used}"/></br>
    <c:out value="${product.contactNumber}"/></br>
    <c:forEach items="${product.additionalFields}" var="add">
        <!-- DOUBLE EVAL ONCE S[] AND NEXT ALL EXPRESSION LIKE ALL IN S[] -->
        <s:eval expression="product.${add}" var="prd" />
        <c:out value="${prd}"/></br>
    </c:forEach>
    <a href="<c:url value="/user/basket/add?name=${product.name}&productLink=${productLink}&returnUrl=${requestScope['javax.servlet.forward.request_uri']}" />">
        <button class="btn btn-outline-success my-2 my-sm-0">Dodaj do koszyka</button>
    </a>


</body>
</html>