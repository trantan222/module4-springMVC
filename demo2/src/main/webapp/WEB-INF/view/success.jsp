<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Sandwich : </h3>
<c:forEach items="${condiment}" var="condiment">
${condiment}
</c:forEach>
</body>
</html>
