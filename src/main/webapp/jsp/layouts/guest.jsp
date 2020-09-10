<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="parakeet" uri="/META-INF/tags/parakeet.tld"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<html>
<head>
    <title>Macchiato : The only blog to visit.</title>
    <decorator:head />
</head>
<body>

    <parakeet:anonymous>
        <a href="${pageContext.request.contextPath}/signin">Signin</a>
    </parakeet:anonymous>

    <parakeet:isAuthenticated>
        <parakeet:username/> | <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </parakeet:isAuthenticated>

    <decorator:body />

</body>
</html>
