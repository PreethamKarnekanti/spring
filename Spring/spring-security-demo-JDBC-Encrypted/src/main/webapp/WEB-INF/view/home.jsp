
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<title>Zemoso Technologies</title>
</head>
<body>
<h1>Zemoso Technologies</h1>
<hr>
<h2> Welcome to ZemosoLabs!! ${pageContext.request.contextPath}</h2>
<hr>
<p>
   <h3>User: <security:authentication property="principal.username" /></h3>
   <h3>Role(s): <security:authentication property="principal.authorities" /></h3>
</p>
<hr>
<security:authorize access="hasRole('MANAGER')">
<p>
<a href="${pageContext.request.contextPath}/managers">Annual Meetings</a> (Restricted Access for Managers Only)
</p>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">
<p>
<a href="${pageContext.request.contextPath}/admins">IT Systems</a> (Restricted Access for Admins Only)
</p>
</security:authorize>
<hr>
<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
			   <input type="submit" value="Logout"/>
</form:form>
</body>
</html>