<html>
<head>

    <%--<style type="text/css">--%>
        <%--label{--%>
            <%--/*display: inline-block;*/--%>
            <%--/*float: left;*/--%>
            <%--/*clear: left;*/--%>
            <%--/*width: 1280px;*/--%>
            <%--/*text-align: right;*/--%>
        <%--}--%>
        <%--input {--%>
            <%--/*display: inline-block;*/--%>
            <%--/*float: left;*/--%>
        <%--}--%>

    <%--</style>--%>

        <style>
            form label{
                display: inline-block;
                width: 100px;
                font-weight: bold;
                text-align: left;
                align-self: flex-start;
            }
        </style>

</head>
<body>

    <div align="center" width="600px">

        <form method="post" action="hotels" >
            <label align="left" width="300px">Region:</label>     <input type="text" name="region"> <br>
            <label>Start date:</label> <input type="date" name="checkin" /> <br>
            <label>End date:</label>   <input type="date" name="checkout" /> <br>
            <label>People:</label>     <input type="number" name="capacity" /> <br>
            <label>has pool</label> <input type="checkbox" name="hasPool" />       <br>
            <label>has tenis court</label> <input type="checkbox" name="hasTenisCourt" /> <br>
            <label>has waterslides</label> <input type="checkbox" name="hasWaterslides" /> <br>
            <input type="submit" name="submit" />
        </form>

    </div>

</body>
</html>
