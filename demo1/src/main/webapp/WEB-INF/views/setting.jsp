<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Setting</h2>
<form:form action="update" method="post" modelAttribute="setting">
    <table>
      <tr>
        <td><form:label path="languege">Langueges </form:label></td>
        <td>
          <form:select path="languege" >
            <form:option value="English">English</form:option>
            <form:option value="Vietnamese">Vietnamese</form:option>
            <form:option value="Japanese">Japanese</form:option>
            <form:option value="Chinese">Chinese</form:option>
          </form:select>

        </td>
      </tr>
      <tr>
        <td><form:label path="pageSize">Page Size : </form:label></td>
        <td>
          <form:select path="pageSize" >
          <span>Show</span>
          <form:option value="5">5</form:option>
          <form:option value="10">10</form:option>
          <form:option value="15">15</form:option>
          <form:option value="25">25</form:option>
          <form:option value="50">50</form:option>
          <form:option value="100">100</form:option>
          <span>email per page</span>
            </form:select>
        </td>
      </tr>
      <tr>
        <td><form:label path="spamFilter">Spam Filter :  </form:label></td>
        <td><form:checkbox path="spamFilter" value="1"/>Enable spams filter</td>
      </tr>
      <tr>
        <td><form:label path="signnature">Signature :  </form:label></td>
        <td><form:textarea path="signnature" /></td>
      </tr>
      <tr>
        <td><input type="submit" value="Submit"/></td>
        <td><button  value="/" />Cancel</td>
      </tr>
    </table>
</form:form>
</body>
</html>
