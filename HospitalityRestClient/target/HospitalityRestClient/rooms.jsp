<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<div align="center">

    <div id="hotel_block">
        <p><c:out value="${inventories[0].room.getHotel().name}" /></p>
        <p><c:out value="${inventories[0].room.getHotel().region}" /></p>
        <p><c:out value="${inventories[0].room.getHotel().description}" /></p>
    </div>

    <table>
        <c:forEach items="${inventories}" var="inventory">
            <form method="post" action="book?id_inventory=<c:out value = "${inventory.idInventory}"/>" >
            <div>
                <tr>
                    <td>
                        <img  src="https://q.bstatic.com/images/hotel/square90/286/28647237.jpg" alt="Adagio Paris Tour Eiffel, Париж" height="128" width="128">
                    </td>
                    <td>
                        <p><label>Room type: </label>${inventory.room.roomType}</p>
                        <p><label>People: </label>${inventory.room.peopleCapacity}</p>
                        <p>
                            <label>Room has: </label>
                            <c:if test="${inventory.room.getRoom().hasTv}"> TV </c:if>
                            <c:if test="${inventory.room.getRoom().hasBalcony}"> Balcony </c:if>
                            <c:if test="${inventory.room.getRoom().hasConditioner}"> Conditioner </c:if>
                            <c:if test="${inventory.room.getRoom().niceViewOnSea}"> Window on the sea </c:if>
                            <c:if test="${inventory.room.getRoom().niceViewOnPool}"> Window on the pool </c:if>
                        </p>
                        <p><label>Service: </label><c:if test="${inventory.ammenities.hasBreakfast}}"> breakfast </c:if></p>
                        <label>Price: </label>
                        <div id="price">
                            <%--price for period ot time per room--%>
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