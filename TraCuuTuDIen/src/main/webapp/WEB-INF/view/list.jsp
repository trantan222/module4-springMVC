<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<h3 style="color:red">${message}</h3>

<a role="button" class="btn btn-primary" href="/show/create"> Create new Word</a>
<form action="/show/search" method="post">
    <input id="inputWord" name="word" placeholder="input word">
    <button>Search</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>Word</th>
        <th>Translate</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${map}" varStatus="status" var="map">
    <tr>
            <td>${status.count}</td>
            <td>${map.key}</td>
            <td>${map.value}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
