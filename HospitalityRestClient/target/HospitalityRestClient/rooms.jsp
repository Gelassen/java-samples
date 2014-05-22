<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="css/rooms.css" />" />
</head>
<body>

<div align="center">

    <div id="hotel_block">
        <div class="row">
            <c:out value="${hotel}" />
            <c:out value="${region}" />
        </div>
        <div class="row">
            <c:out value="${description}" />
        </div>
    </div>

    <table>
        <c:forEach items="${inventories}" var="inventory">
            <form method="post" action="book?id_inventory=<c:out value = "${inventory.idInventory}"/>" >
            <div>
                <tr>
                    <td>
                        <img  src="<c:out value = "${inventory.room.photo}"/>" height="128" width="128">
                    </td>
                    <td>
                        <div class="row">
                            <label>Room type: </label>
                            <span>${inventory.room.roomType}</span>
                        </div>

                        <div class="row">
                            <label>People: </label>
                            <span>${inventory.room.peopleCapacity}</span>
                        </div>

                        <div class="row">
                            <label>Room has: </label>
                            <c:if test="${inventory.room.getRoomProperty().hasTv}"> TV </c:if>
                            <c:if test="${inventory.room.getRoomProperty().hasBalcony}"> Balcony </c:if>
                            <c:if test="${inventory.room.getRoomProperty().hasConditioner}"> Conditioner </c:if>
                            <c:if test="${inventory.room.getRoomProperty().niceViewOnSea}"> Window on the sea </c:if>
                            <c:if test="${inventory.room.getRoomProperty().niceViewOnPool}"> Window on the pool </c:if>
                        </div>

                        <div class="row">
                            <label>Service: </label>
                            <c:if test="${inventory.ammenities.hasBreakfast}}"> breakfast </c:if>
                        </div>

                        <div class="row">
                            <%--price for period ot time per room--%>
                            <label>Price: </label>
                            <c:out value="${inventory.price * days}" /> for <c:out value="${days}" /> days
                        </div>

                        <input type="submit" name="order" >
                    </td>
                </tr>
            </div>
            </form>
        </c:forEach>
    </table>
</div>

</body>
</html>