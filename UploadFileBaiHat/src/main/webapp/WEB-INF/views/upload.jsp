<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="baiHat" action="upload">
    <table>
        <tr>
            <td><form:label path="ten"> Tên Bài Hát: </form:label></td>
            <td><form:input path="ten"/></td>
        </tr>
        <tr>
            <td><form:label path="ngheSi">Nghệ Sĩ Thể Hiện </form:label></td>
            <td><form:input path="ngheSi"/></td>
        </tr>
        <tr>
            <td><form:label path="theLoai">Thể Loại Nhạc: </form:label></td>
            <td><form:select path="theLoai">
                <form:option value="rock">Rock</form:option>
                <form:option value="auMy">Âu Mỹ</form:option>
                <form:option value="thieuNhi">Thiếu Nhi</form:option>
                <form:option value="nhacTre">Nhạc Trẻ</form:option>
                <form:option value="caiLuong">Cải Lương</form:option>
            </form:select></td>
        </tr>
        <tr>
            <td>
                <form action="/upload">
                    <label for="img">Upload File :</label>
                    <input type="file" id="img" name="img" accept="image/*,.mp3/*,.m4p/*,.wav/*,.ogg/*">
                    <input type="submit">
                </form>
            </td>
        </tr>
        <tr>
            <td><button type="submit" value="Submit"/>Submit</td>
        </tr>
    </table>
</form:form>
</body>
<script>

</script>
</html>

