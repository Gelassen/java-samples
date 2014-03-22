<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                   </td>
               </tr>
           </table>
       </form:form>
   </div>

</body>
</html>