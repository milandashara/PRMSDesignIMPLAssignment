<%-- 
    Document   : maintainUserMenu
    Created on : Sep 7, 2014, 6:32:54 PM
    Author     : Siva
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
        <fmt:setBundle basename="ApplicationResources" />
        <title> <fmt:message key="title.crudu"/> </title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/controller/createUser" method=post>
            <input type="hidden" name="insert" value="false"/>
            <input type="submit" value="<fmt:message key="label.crudu.add"/>" align="center">
        </form>

        <br/>
        <center><span id="msg" class="error" >${msg}</span></center>
        <br>
        <table class="borderAll">
            <tr>
                <th align="right"><fmt:message key="label.crudu.id"/></th>
                <th align="center"><fmt:message key="label.crudu.name"/></th>
                <th align="center"><fmt:message key="label.crudu.roles"/></th>
                <th align="center"><fmt:message key="label.crudu.edit"/> </th>
                <th align="center"><fmt:message key="label.crudu.delete"/></th>
            </tr>

            <c:forEach var="crudu" items="${userlist}" varStatus="status">                
                <tr class="${status.index%2==0?'even':'odd'}">

                    <td class="nowrap">${crudu.id}</td>
                    <td class="nowrap">${crudu.name}</td>
                    <td>
                        <c:forEach items="${crudu.roles}" var="roleObject" varStatus="stat">
                            <c:set var="roleVal" 
                                   value="${stat.first ? '':roleVal}${roleObject.role}${stat.last ? '':', '}" />
                        </c:forEach>
                        <c:out value="${roleVal}"/>
                    </td>

                <form action="${pageContext.request.contextPath}/controller/modifyUser" method=post>
                    <input type="hidden" name="id" value="${crudu.id}">
                    <input type="hidden" name="insert" value="false"/>
                    <td><input type="submit" value="<fmt:message key="label.crudu.edit"/>" align="center"></td>
                    <td>
                </form>


                <c:url var="delurl" scope="page" value="/controller/deleteUser">
                    <c:param name="id" value="${crudu.id}"/>
                </c:url>
                <a href="${delurl}" class="button"><fmt:message key="label.crudu.delete"/></a>

            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>