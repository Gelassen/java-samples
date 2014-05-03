
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<%--<jsp:forward page="/redirect"/>--%>

<div align="center">

    <c:forEach items="${hotels}" var="hotel">

        <table>
            <tr>
                <td>
                    <img src="http://q-ec.bstatic.com/images/hotel/square128/216/21646823.jpg" alt="Adagio Paris Tour Eiffel, Париж" height="128" width="128">
                </td>
                <td>
                    <p>${hotel.name}</p>
                    <p>${hotel.region}</p>
                    <p>${hotel.description}</p>
                </td>
            </tr>
        </table>

    </c:forEach>

</div>


<h2>Hello World!</h2>
</body>
</html>