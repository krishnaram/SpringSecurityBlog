<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="_csrf" content="${_csrf.token}"/>
	<!-- default header name is X-CSRF-TOKEN -->
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	<!-- ... -->
  <title>Home</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.5 -->
  <!--Favicon Image -->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<sec:authorize access="hasRole('ANONYMOUS')">
	<c:redirect url="/loginPage"/>
</sec:authorize>
<p>Welcome, <sec:authentication property="principal.employeeUserName"/></p><br/>
<c:url value="/logout" var="Signout" />
	<form id="logout" action="${Signout}" method="post" >
		 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a class="btn btn-default btn-flat" href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>
</body>
</html>
