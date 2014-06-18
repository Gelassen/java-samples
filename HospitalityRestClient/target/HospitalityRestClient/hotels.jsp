
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <%--<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>--%>
    <link type="text/css" rel="stylesheet" href="<c:url value="css/rooms.css" />" />
</head>
<body>

    <div align="center">
        <form action="inventory" method="get">
            <table>
                <c:forEach items="${hotels}" var="hotel">
                    <div>
                        <tr>
                            <td>
                                <div class="row">
                                    <input type="image" src="<c:out value="${hotel.photo}"/>" />
                                    <input type="hidden" name="hotel_id" value="<c:out value="${hotel.idHotel}"/>"/>
                                    <input type="hidden" name="hotel" value="<c:out value="${hotel.name}"/>"/>
                                    <input type="hidden" name="region" value="<c:out value="${hotel.region}"/>"/>
                                    <input type="hidden" name="description" value="<c:out value="${hotel.description}"/>"/>
         <%--                           <a href="?&hotel=<c:out value="${hotel.name}" />&region=<c:out value="${hotel.region}" />&description=<c:out value="${hotel.description}" />">
                                        <img  src="" height="128" width="128">
                                    </a>--%>
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
                                <div >
                                    <c:if test="${not empty hotel.reservationDates}">
                                        <h5>
                                            <span>This hotel doesn't support booking by dates. You can book rooms only for a date range. Please choose one:</span>
                                        </h5>

                                        <div class="row">
                                            <select name="days" onchange="submit()">
                                                <c:forEach items="${hotel.reservationDates}" var="trip">
                                                    <option value="${trip.checkIn}-${trip.checkOut}">${trip.checkInFormated} - ${trip.checkOutFormated}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </c:if>
                                </div>
                            </td>
                        </tr>
                    </div>
                </c:forEach>
            </table>
        </form>
    </div>

</body>
</html>