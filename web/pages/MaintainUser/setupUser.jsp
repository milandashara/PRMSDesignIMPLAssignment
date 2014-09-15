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
<body>
	<form action="${pageContext.request.contextPath}/ReviewSelectUserController" method=post>
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="30%"><fmt:message key="label.crudu.id" /></th>
					<th width="45%"><fmt:message key="label.crudu.name" /></th>
					<th width="25%"><fmt:message key="label.crudu.password" /></th>
                                        <th width="45%"><fmt:message key="label.crudu.roles" /></th>
				</tr>
				<tr>
					<td><fmt:message key="label.crudu.id" /></td>
					<td><input type="text" name="id"
						value="${param['id']}" size=45 maxlength=20></td>
				</tr>
				<tr>
					<td><fmt:message key="label.crudu.name" /></td>
					<td><input type="text" name="name"
						value="${param['name']}" size=45 maxlength=20></td>
				</tr>
				<tr>
					<td><fmt:message key="label.crudu.password" /></td>
					<td><input type="text" name="password"
						value="${param['password']}" size=15 maxlength=20></td>
				</tr>
                                <tr>
					<td><fmt:message key="label.crudu.roles" /></td>
                                        <td><input type="text" name="roles"
						value="${param['roles']}" size=15 maxlength=20></td>
                                </tr>
			</table>
		</center>
		<input type="submit" value="Submit"> <input type="reset"
			value="Reset">
	</form>

</body>
</html>
