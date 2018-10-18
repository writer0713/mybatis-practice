<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>
    Login PAGE
</h1>

<form action="/login" method="post">

    <input type="text" name="username" id="username" />
    <input type="text" name="password" id="password" />

    <button type="submit">login</button>
</form>

</body>
</html>
