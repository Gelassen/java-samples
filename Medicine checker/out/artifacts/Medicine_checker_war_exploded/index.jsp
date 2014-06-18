<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="css/intro.css" />" />

</head>
<body>

<a href="/new_medicine.jsp">Add a new medicine</a>

<div class="formWrap">

    <form method="post" action="check" class="standardForm">
        <div class="row">
            <label for="name">Name: </label> <input type="text" name="name" id="name" value="${medicine.name}">
<%--            <c:if test="${error.isNameError()}">
                <div class="error"><span>Name can contain symbols, points and commas</span></div>
            </c:if>--%>
        </div>

        <div class="row">
            <label for="serial">Serial: </label> <input type="text" name="serial" id="serial" value="${medicine.serial}"/>
<%--            <c:if test="${error.isPhoneError()}">
                <div class="error"><span>Phone should contain digits and dashes</span></div>
            </c:if>--%>
        </div>

        <div class="row">
            <label for="factory">Factory: </label> <input type="text" name="factory" id="factory" value="${medicine.factory}"/>
<%--            <c:if test="${error.isPhoneError()}">
                <div class="error"><span>Phone should contain digits and dashes</span></div>
            </c:if>--%>
        </div>

        <c:if test="${not empty error}">
            <c:choose>
                <c:when test="${error.exists}">
                    <div class="error"><span>This medicine is forbidden</span></div>
                </c:when>

                <c:otherwise>
                    <div class="success"><span>The medicine is valid</span></div>
                </c:otherwise>
            </c:choose>
        </c:if>

        <input type="submit" name="submit" align="left" value="Check"/>
    </form>

</div>

</body>
</html>
