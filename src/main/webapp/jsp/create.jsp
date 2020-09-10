<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Macchiato : Create Post</title>
</head>
<body>
<h1>Create Post</h1>

<form action="${pageContext.request.contextPath}/save" method="post">

    <label>Title</label>
    <input type="text" name="username" placeholder="Username"/>

    <br/>

    <label>Content</label>
    <textarea name="content"></textarea>

    <br/>
    <br/>

    <input type="submit" value="Signin"/>
</form>

</body>
</html>
