<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.min.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.0-beta.1/angular.min.js"></script>
</head>
<body ng-app='Login'  onload='document.loginForm.username.focus();'>
    <h3>TMS</h3>
 
    <c:if test="${not empty error}"><div>${error}</div></c:if>
    <c:if test="${not empty message}"><div>${message}</div></c:if>
 	
    <form name='login' action="<c:url value='/loginPage' />" method='POST'>
        <table>
            <tr>
                <td>UserName:</td>
                <td><input type='text' name='username' ng-model="login.username" value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' ng-model="login.password" /></td>
            </tr>
            <tr>
            
                <td colspan='2'><button type="submit">Submit</button></td>
            </tr>
        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</body>
</html>