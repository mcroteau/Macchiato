<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Macchiato : Posts</title>
</head>
<body>

    <h1>Latest Posts</h1>

    <div id="latest-posts">
        <c:forEach var="post" items="${posts}">
            <div class="post-container">
                <h2>${post.title}</h2>
                <span class="tiny">${post.date}</span>
                <div>${post.content}</div>
            </div>
        </c:forEach>
    </div>

</body>
</html>
