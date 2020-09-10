<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Macchiato : Signin</title>
</head>
<body>

<h1>Signin</h1>

<form action="/${pageContext.request.contextPath}/auth" method="post">

    <label>Username</label>
    <input type="text" name="username" placeholder="Username"/>

    <br/>

    <label>Password</label>
    <input type="text" name="password" placeholder="Password ***"/>

    <br/>
    <br/>

    <input type="submit" value="Signin"/>
</form>

</body>
</html>
