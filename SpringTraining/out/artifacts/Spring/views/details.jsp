<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dkazakov
  Date: 01.06.12
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details for ${application.name}</title>
</head>
<body>
   <div>
       <p>${application.name}</p>
       <form:form method="post" modelAttribute="uploadItem" enctype="multipart/form-data">
           <table>
               <tr>
                   <td><img src="/images/${application.id}" align="left" alt="no image"></td>
                   <td>${application.description}</td>
               </tr>
               <tr>
                   <td colspan="2">
                       <input type="submit" value="download">
                      <%-- <form:label for="fileData" path="fileData">Archive</form:label><br/>--%>
                      <%-- <form:input path="fileData" type="file"/>--%>
                   </td>
               </tr>
           </table>
       </form:form>
   </div>


<%--    <h1>Description</h1>

    <p>${descriptionOfApplication}</p>--%>
</body>
</html>