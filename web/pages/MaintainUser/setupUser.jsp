<%-- 
    Document   : setupu
    Created on : Sep 14, 2014, 4:32:04 PM
    Author     : Siva
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <fmt:setBundle basename="ApplicationResources" />
        <title><fmt:message key="title.setupu" /></title>
    </head>

    <script type="text/javascript">
        function onLoadBody() {
            if (${insert} === true) {
                document.getElementById('id').readOnly = false; // Create User
            } else if (${insert} === false) {
                document.getElementById('id').readOnly = true;  // Modify User
            }
        }
        function AllowAlphabet() {
            if (!form.name.value.match(/^[a-zA-Z]+$/) && form.name.value !== "")
            {
                form.name.value = "";
                form.name.focus();
                alert("Please Enter only alphabets in text");
            }
        }
    </script>

    <body onload="onLoadBody();">
        <form id="form" action="${pageContext.request.contextPath}/controller/updateUser" method=post>
            <center>
                <table class="borderAll" cellpadding=10 cellspacing=1 border=1 width="60">
                    <center>
                        <tr>
                            <td><fmt:message key="label.crudu.id"/></td>
                            <td><input type="text" name="id" id="id"
                                       value="${sessionScope.edituser.id}" required size=20 maxlength=20></td>
                        </tr>
                        <tr>
                            <td><fmt:message key="label.crudu.name" /></td>
                            <td><input type="text" name="name" onblur="AllowAlphabet()"
                                       value="${sessionScope.edituser.name}" required size=20 maxlength=20></td>
                        </tr>
                        <tr>
                            <td><fmt:message key="label.crudu.password" /></td>
                            <td><input type="password" name="password"
                                       value="${sessionScope.edituser.password}" required size=20 maxlength=20></td>
                        </tr>
                        <tr>
                            <td><fmt:message key="label.crudu.roles" /></td>
                            <!--                                <td>
                                                                <ul>
                            <%--<c:forEach items="${param['allRoles']}" var="role" varStatus="status">--%>
                                <li><input type="checkbox" name="chkRole" value="${role}"/>
                                </li>
                            <%--</c:forEach>--%>
                        </ul>
                    </td>-->

                            <td><input type="text" name="roles"
                                       value="${sessionScope.edituser.roles}" required size=20 maxlength=20></td>
                        </tr>
                </table>
                <input type="hidden" name="insert" value="${sessionScope.insert}">
            </center>
            <br>&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" value="Submit" align="right"> &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" value="Reset" align="center">
        </form>

    </body>


</html>
