<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 style="text-align: center">Tờ Khai Y Tế</h2>
<h4 style="text-align: center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG,THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h4>
<h5 style="color: red;text-align: center">Khuyến Cáo : Khai Báo Thông Tin Sai Là Vi Phạm Pháp Luật Việt Nam Có Thể Xử Lí Theo Pháp Luật</h5>
<form:form method="post" modelAttribute="toKhai" action="up" cssStyle="display: flex">
          <div class="form-group" style="display: flex">
          <form:label path="name" cssStyle="display: block">Họ tên (ghi chữ IN HOA) (*)</form:label>
          <form:input path="name" ></form:input>
          </div>
    <div class="form-row">
        <div class="form-group col-md-4-">
        <form:label path="yearDate" cssStyle="display: block">Năm sinh (*)</form:label>
        <form:select path="yearDate">
            <form:option value="2005">2005</form:option>
            <form:option value="2004">2004</form:option>
            <form:option value="2003">2003</form:option>
            <form:option value="2002">2002</form:option>
            <form:option value="2001">2001</form:option>
            <form:option value="2000">2000</form:option>
            <form:option value="1999">1999</form:option>
            <form:option value="1998">1998</form:option>
            <form:option value="1997">1997</form:option>
            <form:option value="1996">1996</form:option>
            <form:option value="1995">1995</form:option>
            <form:option value="1994">1994</form:option>
            <form:option value="1993">1993</form:option>
            <form:option value="1992">1992</form:option>
            <form:option value="1991">1991</form:option>
            <form:option value="1990">1991</form:option>
            <form:option value="1989">1991</form:option>
            <form:option value="1988">1991</form:option>
            <form:option value="1987">1991</form:option>
        </form:select>
        </div>
        <div class="form-group col-md-4-">
            <form:label path="gender" cssStyle="display: block">Giới tính (*)</form:label>
            <form:select path="gender">
                <form:option value="1">Nam</form:option>
                <form:option value="0">Nữ</form:option>
                <form:option value="-1">Khác</form:option>
            </form:select>
        </div>
        <div class="form-group col-md-4-">
            <form:label path="country" cssStyle="display: block">Quốc tịch (*)</form:label>
            <form:select path="country">
                <form:option value="Việt Nam">Việt Nam</form:option>
                <form:option value="Mỹ">Mỹ</form:option>
                <form:option value="Trung Quốc">Trung Quốc</form:option>
                <form:option value="Pháp">Pháp</form:option>
                <form:option value="Lào">Lào</form:option>
                <form:option value="Han Quốc">Han Quốc</form:option>
                <form:option value="Nhật Bản">Nhật Bản</form:option>
                <form:option value="Anh">1998</form:option>
                <form:option value="Thái Lan">Thái Lan</form:option>
                <form:option value="Singapore">Singapore</form:option>
                <form:option value="MaLaysia">MaLaysia</form:option>
            </form:select>
        </div>
        <div class="form-group">
            <form:label path="id_card" cssStyle="display: block">Số Hộ Chiếu hoặc số CMND Hoặc Giấy Thông Hành Khác (*)</form:label>
            <form:input path="id_card" ></form:input>
        </div>



    </div>
</form:form>
</body>
</html>
