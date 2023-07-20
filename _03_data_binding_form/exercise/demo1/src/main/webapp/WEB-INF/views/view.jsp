<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Information</h1>
<p>Languege : ${languege}</p>
<p>Page size : ${pageSize}</p>
<c:if test="${spamFilter == 1}">
<p>
    Spam Filter : Enable Filter
</p>
</c:if>
<c:if test="${spamFilter != 1}">
    <p>
        Spam Filter :Disable Filter
    </p>
</c:if>
<p>Signature : ${signnature}</p>
</body>
</html>
