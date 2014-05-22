
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

    <div align="center">
        <table>
            <c:forEach items="${hotels}" var="hotel">
                <div>
                    <tr>
                        <td>
                            <div class="row">
                                <a href="inventory?hotel_id=<c:out value="${hotel.idHotel}"/>&hotel=<c:out value="${hotel.name}" />&region=<c:out value="${hotel.region}" />&description=<c:out value="${hotel.description}" />">
                                    <img  src="<c:out value="${hotel.photo}"/>" height="128" width="128">
                                </a>
                            </div>
                        </td>
                        <td>
                            <div class="row">
                                <c:out value="${hotel.name}" />
                            </div>
                            <div class="row">
                                <c:out value="${hotel.region}" />
                            </div>
                            <div class="row">
                                <c:out value="${hotel.description}" />
                            </div>
                        </td>
                    </tr>
                </div>
            </c:forEach>
        </table>
    </div>

</body>
</html>