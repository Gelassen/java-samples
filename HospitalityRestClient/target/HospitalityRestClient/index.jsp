<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

    <%--<jsp:forward page="/redirect"/>--%>
<div align="center">
    <c:choose>
        <c:when test="${error.isNoSimilarRooms()}">
            <h1>Room is not booked!</h1><br>
            <h3>All rooms of this type have occupied already. Please choose another one</h3><br>
        </c:when>
        <c:otherwise>
            <h1>Congratulations!</h1><br>
            <h3>You successfully booked a room </h3><br>
        </c:otherwise>
    </c:choose>
    <a href="intro.jsp" > home </a>
</div>
</body>
</html>
