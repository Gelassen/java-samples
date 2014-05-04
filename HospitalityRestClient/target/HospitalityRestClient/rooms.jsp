<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<div align="center">

    <div id="hotel_block">
        <p>${hotel.name}</p>
        <p>${hotel.region}</p>
        <p>${hotel.description}</p>
    </div>

    <table>
        <c:forEach items="${hotels}" var="hotel">
            <div>
                <tr>
                    <td>
                        <a href="/intro.jsp">
                            <img  src="http://q-ec.bstatic.com/images/hotel/square128/216/21646823.jpg" alt="Adagio Paris Tour Eiffel, Париж" height="128" width="128">
                        </a>
                    </td>
                    <td>
                        <p>${hotel.name}</p>
                        <p>${hotel.region}</p>
                        <p>${hotel.description}</p>
                    </td>
                </tr>
            </div>
        </c:forEach>
    </table>
</div>

</body>
</html>