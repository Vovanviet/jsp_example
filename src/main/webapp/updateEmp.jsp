<%--
  Created by IntelliJ IDEA.
  User: vietn
  Date: 6/6/2023
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<form class="form" action="employee" method="post" accept-charset="UTF-8">
    <input type="hidden" value="<%= request.getParameter("id")%>">
    <div class="form-input">
        <label class="label-text" for="fullname">Full Name:</label>
        <input class="form input" type="text" id="fullname" name="fullname" value="<%= request.getParameter("fullname")%>>
    </div>
    <div class="form-input">
        <label class="label-text" for="address">Address:</label>
        <input class="form input" type="text" id="address" name="address" value="<%= request.getParameter("address")%>>
    </div>
    <div class="form-input">
        <label class="label-text" for="department">Department:</label>
        <input class="form input" type="text" id="department" name="department" value="<%= request.getParameter("department")%>>
    </div>
    <div class="form-input">
        <label class="label-text" for="position">Position:</label>
        <input class="form input" type="text" id="position" name="position"value="<%= request.getParameter("position")%>>
    </div>
    </div>
    <button class="submit-btn" type="submit" name="method" value="update"> Update</button>
    <a class="form-input" href="student">Cancel</a>
</form>
</body>
</html>
