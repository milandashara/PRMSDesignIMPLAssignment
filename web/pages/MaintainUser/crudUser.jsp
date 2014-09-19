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
        <h1><fmt:message key="label.crudu"/></h1>
        <c:url var="url" scope="page" value="/pages/setupUser.jsp">
            <c:param name="Id" value=""/>
            <c:param name="Name" value=""/>
            <c:param name="Password" value=""/>
            <%--<c:param name="allRoles" value=""/>--%>
            <%--<c:param name="userRoles" value=""/>--%>
            <c:param name="roles" value=""/>
            <c:param name="insert" value="true"/>
        </c:url>
        <a href="${url}"><fmt:message key="label.crudu.add"/></a>
        <br/><br/>
        <table class="borderAll">
            <tr>
                <th><fmt:message key="label.crudu.id"/></th>
                <th><fmt:message key="label.crudu.name"/></th>
                <!--<th><fmt:message key="label.crudu.password"/></th>-->
                <th><fmt:message key="label.crudu.roles"/></th>
                <th><fmt:message key="label.crudu.edit"/> <fmt:message key="label.crudu.delete"/></th>
            </tr>
            <c:forEach var="crudu" items="${userlist}" varStatus="status">
                <tr class="${status.index%2==0?'even':'odd'}">
                    <td class="nowrap">${crudu.id}</td>
                    <td class="nowrap">${crudu.name}</td>
                    <!--<td class="nowrap">${crudu.password}</td>-->

                    <td>
                        <c:forEach items="${crudu.roles}" var="roleObject" varStatus="stat">
                            <c:set var="roleVal" value="${stat.first ? '':roleVal} ${roleObject.role}" />
                        </c:forEach>
                        <c:out value="${roleVal}"/>

                    </td>
                    <td class="nowrap">
                        <c:url var="updurl" scope="page" value="/pages/setupUser.jsp">
                            <c:param name="id" value="${crudu.id}"/>
                            <c:param name="name" value="${crudu.name}"/>
                            <c:param name="password" value="${crudu.password}"/>
                            <c:param name="roles"  value="${roleVal}"/>
                       <!-- <select>
                                <c:forEach var="roleObject"  items="${crudu.roles}">
                                    <option><c:out value="roleObject.role"></c:out></option>  
                                </c:forEach>
                            </select>-->


                                <c:param name="insert" value="false"/>
                        </c:url>

                        <a href="${updurl}"><fmt:message key="label.crudu.edit"/></a>
                        &nbsp;&nbsp;&nbsp;
                        <c:url var="delurl" scope="page" value="/controller/deleteUser">
                            <c:param name="id" value="${crudu.id}"/>
                        </c:url>
                        <a href="${delurl}"><fmt:message key="label.crudu.delete"/></a>

                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>