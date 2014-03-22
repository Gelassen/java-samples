<%@ page import="java.util.Iterator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>App store</title>
</head>
<body>
	<h1>Popular</h1>

    <div>

        <table align="center">
            <tr>
                <c:forEach items="${popular}" var="popularApp">
                    <td><a href="/details/${popularApp.id}"><img src="/images/${popularApp.id}" alt="no image"></a></td>
                </c:forEach>
            </tr>
        </table>

        </p>
    </div>

    <table>
        <tr>
            <td>
                <%--define categories--%>
                <div align="left">
                    <hr width="200" align="left"/>
                    <c:forEach items="${categories}" var="category">
                        <p><a href="/category/${category}">${category}</a></p>
                        <hr width="200" align="left"/>
                    </c:forEach>
                    <a href="/upload">Upload new application</a>
                </div>
            </td>
            <td>
                <%--define app items--%>
                <div width="1300" align="right">
                    <table>
                        <c:forEach items="${applications}" var="application">
                            <tr>
                                <td>
                                    <p><img src="/images/preview/${application.id}" align="left" alt="no image"></p>
                                </td>
                                <td>
                                    <p><a href="/details/${application.id}">${application.name}</a></p>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </td>
        </tr>
    </table>
</body>
</html>
