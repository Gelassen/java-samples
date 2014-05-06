<html>
<head>

    <style type="text/css">
        label{
            /*display: inline-block;*/
            /*float: left;*/
            /*clear: left;*/
            /*width: 1280px;*/
            /*text-align: right;*/
        }
        input {
            /*display: inline-block;*/
            /*float: left;*/
        }

    </style>

</head>
<body>

    <div align="center">

        <form method="post" action="hotels" >
            <label>Region:</label>     <input type="text" name="region"> <br>
            <label>Start date:</label> <input type="date" name="checkin" /> <br>
            <label>End date:</label>   <input type="date" name="checkout" /> <br>
            <label>People:</label>     <input type="number" name="capacity" /> <br>
            <input type="checkbox" name="has_pool" />  <label>has pool</label>     <br>
            <input type="checkbox" name="has_tenis_court" /> <label>has tenis court</label>     <br>
            <input type="checkbox" name="has_waterslides" /> <label>has waterslides</label>     <br>
            <input type="submit" name="submit" />
        </form>

    </div>

</body>
</html>
