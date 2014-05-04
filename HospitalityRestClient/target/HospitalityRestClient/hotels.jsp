
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

    <div align="center">
        <table>
            <c:forEach items="${hotels}" var="hotel">
                <div>
                    <tr>
                        <td>
                            <a href="inventory?hotel_id=<c:out value="${hotel.idHotel}" />" >
                                <img  src="http://q-ec.bstatic.com/images/hotel/square128/216/21646823.jpg" alt="Adagio Paris Tour Eiffel, Париж" height="128" width="128">
                            </a>
                        </td>
                        <td>
                            <p><c:out value="${hotel.name}" /></p>
                            <p><c:out value="${hotel.region}" /></p>
                            <p><c:out value="${hotel.description}" /></p>
                        </td>
                    </tr>
                </div>
            </c:forEach>
        </table>
    </div>

</body>
</html>