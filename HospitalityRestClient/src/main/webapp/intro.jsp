<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <style>
        .formWrap {
            width: 800px;
            margin: 0 auto;
        }

        .standardForm .row label {
            display: inline-block;
            width: 200px;
            margin-right: 5px;
            font-weight: bold;
        }

        .standardForm .row .error {
            padding-left: 207px;
            color: red;
        }

        .row .hide {
            display: none;
        }
    </style>

</head>
<body>

<div class="formWrap">

    <form method="post" action="hotels" class="standardForm">
        <label style="display: none">Region:</label>
        <input style="display: none" type="text" name="region"> <br>

        <div class="row">
            <label for="startDate">Start date:</label><input type="date" name="checkin" id="startDate"/>
            <c:if test="${error.isCheckinError()}">
                <div class="error"><span>Date should be in dd/mm/yyyy format</span></div>
            </c:if>
        </div>

        <div class="row">
            <label for="endDate">End date:</label><input type="date" name="checkout" id="endDate"/>
            <c:if test="${error.isCheckoutError()}">
                <div class="error"><span>Date should be in dd/mm/yyyy format</span></div>
            </c:if>
        </div>

        <div class="row">
            <label for="capacity">People:</label><input type="number" name="capacity" id="capacity"/>
            <c:if test="${error.isPeopleError()}">
                <div class="error"><span>Amount of people should be positive</span></div>
            </c:if>
        </div>

        <div class="row">
            <label for="hasPool">Has pool:</label><input type="checkbox" name="hasPool" id="hasPool"/>
        </div>

        <div class="row">
            <label for="hasTenisCourt">Has tenis court:</label><input type="checkbox" name="hasTenisCourt" id="hasTenisCourt"/>
        </div>

        <div class="row">
            <label for="hasWaterslides">Has waterslides:</label><input type="checkbox" name="hasWaterslides" id="hasWaterslides"/>
        </div>

        <input type="submit" name="submit" />
    </form>

</div>

</body>
</html>
