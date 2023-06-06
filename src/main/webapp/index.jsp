<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Manager</title>
    <script>window.onload = function() {
        // Gửi yêu cầu GET đến URL mặc định
        var xhr = new XMLHttpRequest();
        xhr.open('GET', '/employee', true);
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                // Xử lý phản hồi từ server (nếu cần)
            }
        };
        xhr.send();
    };</script>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Full Name</th>
                <th>Address</th>
                <th>Department</th>
                <th>Position</th>
            </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${listEmp.size() > 0}">
                <c:forEach items="${listEmp}" var="emp" varStatus="loop">
                    <tr>
                        <th>${loop.index +1}</th>
                        <td>${emp.fullname}</td>
                        <td>${emp.address}</td>
                        <td>${emp.department}</td>
                        <td>${emp.position}</td>
                        <td>
                            <form class="form" action="updateStudent.jsp" method="post" accept-charset="UTF-8">
                                <input type="hidden" name="studentId" value="${emp.id}"/>
                                <input type="hidden" name="studentName" value="${emp.fullname}"/>
                                <input type="hidden" name="studentAge" value="${emp.address}"/>
                                <input type="hidden" name="studentAddress" value="${emp.department}"/>
                                <input type="hidden" name="studentAddress" value="${emp.position}"/>
                                <button type="submit">UPDATE</button>
                            </form>
                        </td>
                        <td>
                            <form action="employee" method="post">
                                <input type="hidden" name="idEmp" value="${emp.id}">
                                <button type="submit" name="method" value="DELETE">DELETE</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <h1>Don't have employee</h1>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
    <h1 class="text-title">Add Employee</h1>
    <form action="employee" method="post">
        <div class="form-input">
            <label class="label-text" for="fullname">Full Name:</label>
            <input class="form input" type="text" id="fullname" name="fullname">
        </div>
        <div class="form-input">
            <label class="label-text" for="address">Address:</label>
            <input class="form input" type="text" id="address" name="address">
        </div>
        <div class="form-input">
            <label class="label-text" for="department">Department:</label>
            <input class="form input" type="text" id="department" name="department">
        </div>
        <div class="form-input">
            <label class="label-text" for="position">Position:</label>
            <input class="form input" type="text" id="position" name="position">
        </div>

        <input class=" submit-btn" type="submit" name="method" value="Submit">
    </form>
</body>
</html>
