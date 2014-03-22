<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Upload application</title>
</head>
<body>
<form:form modelAttribute="uploadItem" method="post" enctype="multipart/form-data">
    <fieldset>
        <legend>Upload application</legend>

        <p>
            <form:label for="name" path="name">Package</form:label><br/>
            <form:input path="name"/>
        </p>

        <p>
            <form:label for="description" path="description">Description</form:label><br/>
            <form:input path="description"/>
        </p>

        <p>
            <form:label for="fileData" path="fileData">Archive</form:label><br/>
            <form:input path="fileData" type="file"/>
        </p>

        <p>
            <input type="submit" />
        </p>

    </fieldset>
</form:form>
</body>
</html>