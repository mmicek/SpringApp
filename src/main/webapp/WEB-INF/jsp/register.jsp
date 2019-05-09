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
    <sf:form autocomplete="new-password" method="POST" modelAttribute="user">
      <div class="form-groups">
        <div class="col" style="margin-bottom:3%">
            <sf:input path="username" type="text" class="form-control" placeholder="Login"/>
        </div>
        <div class="col" style="margin-bottom:3%">
            <sf:input id="pass" oninput="validatePassword()" path="password" type="password" class="form-control" placeholder="Password"/>
        </div>
        <div class="col" style="margin-bottom:3%">
             <input id="conf" oninput="validatePassword()" type="password" class="form-control" placeholder="Confirm password" >
        </div>
        <input id="button" class="btn btn-info" style="margin-left:5%" value="Zarejestruj" type="submit"/>
      </div>
    </sf:form>
    </div>

    <script>
        document.getElementById("button").disabled = true;
        function validatePassword() {
            var pass = document.getElementById("pass").value;
            var conf = document.getElementById("conf").value;
            if(pass == conf){
                document.getElementById("button").disabled = false;
                document.getElementById("conf").style.borderColor = "LightGrey";
                document.getElementById("pass").style.borderColor = "LightGrey";
            } else {
                document.getElementById("button").disabled = true;
                document.getElementById("conf").style.borderColor = "Maroon";
                document.getElementById("pass").style.borderColor = "Maroon";
            }
        }
    </script>
</body>
</html>