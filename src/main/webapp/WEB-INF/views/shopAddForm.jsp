<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>
    Login PAGE
</h1>

<form action="/shop/add" method="post">

    <span>가게명</span><input type="text" name="shopName" id="shopName"/>
    <span>지역</span><input type="text" name="shopLocation" id="shopLocation"/>
    <span>상태</span>
    <select id="shopStatus" name="shopStatus">
        <option value="">선택</option>
        <option value="Y">Y</option>
        <option value="N">N</option>
    </select>

    <button type="submit">submit</button>
</form>

</body>
</html>
