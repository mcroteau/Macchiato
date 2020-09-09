<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Macchiato : Signin</title>
</head>
<body>

<h1>Signin</h1>

<form action="/b/auth" method="post">

    <label>Username</label>
    <input type="text" name="username" placeholder="Username" value="mockyah"/>

    <br/>

    <label>Password</label>
    <input type="text" name="password" placeholder="Password ***" value="birdyah"/>

    <br/>
    <br/>

    <input type="submit" value="Signin"/>
</form>

</body>
</html>
