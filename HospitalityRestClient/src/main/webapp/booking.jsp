<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="css/intro.css" />" />

</head>
<body>

<div class="formWrap">

    <form method="post" action="book" class="standardForm">
        <div class="row">
            <label for="name">Name: </label> <input type="text" name="customer_name" id="name">
            <c:if test="${error.isNameError()}">
                <div class="error"><span>Name can contain symbols, points and commas</span></div>
            </c:if>
        </div>

        <div class="row">
            <label for="phone">Phone: </label> <input type="text" name="customer_phone" id="phone"/>
            <c:if test="${error.isPhoneError()}">
                <div class="error"><span>Phone should contain digits and dashes</span></div>
            </c:if>
        </div>

        <input type="submit" name="submit" align="left"/>
    </form>

</div>

</body>
</html>