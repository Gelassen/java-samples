<%--
  Created by IntelliJ IDEA.
  User: dkazakov
  Date: 08.04.14
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/globalCSS.css" />

<body>
<div id="content">
    <jsp:useBean id="hotel" class="com.example.model.HotelBean" scope="session"></jsp:useBean>

    <c:forEach var="hotelItem" items="${hotels}">
        <div id="hotelContent">
            <div id="hotelImage" class="hotel_img">
                <img src="hotels.jsp" alt="foto of hotel">
            </div>
            <div id="hotelDescription" class="hotel_content">
                <h3>${hotelItem.name}</h3>
                ${hotelItem.region}
            </div>
        </div>
    </c:forEach>

</div>
</body>
</html>