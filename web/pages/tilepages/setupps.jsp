<%-- 
    Document   : setupps
    Created on : Sep 19, 2014, 4:22:53 PM
    Author     : mani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <title><fmt:message key="title.setupps" /></title>
          <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>

        <script>
              $(document).ready(function() {
                    
                    var role = "presenter";
                    var url = "crudPsScreen/loadRoles?role=presenter";
                    $.get(url+role.toString(), function(data, status) {
                        var listItems = "";

                        var i=0;
                        var array=JSON.parse(data);
                        for (var i = 0; i < array.length; i++) {
//                            if($('#presenter').find(":selected").text()!=array[i])
                            listItems += "<option value='" + array[i].startDate + "'>" + array[i].startDate + "</option>";
                        }
                    }
//                        
//                       
//                        $("#presenter").html(listItems);
//                        
//                        role = "producer";
//                           $.get(url+role.toString(), function(data, status) {
//                        var listItems = "";
//
//                        var i=0;
//                        var array=JSON.parse(data);
//                        for (var i = 0; i < array.length; i++) {
//                            if($('#producer').find(":selected").text()!=array[i])
//                            listItems += "<option value='" + array[i]+ "'>" + array[i]+ "</option>";
//                        }
//                        
//                        $("#producer").html(listItems);
//
//                    })
//                });
            });

            </script>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/controller/setupps" method=post>
            <center>
                <table>
                    <tr>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.programslot.duration" /></td>
                        <td>	<input type="time" name="duration" value="${param['duration']}" size=15
                                    maxlength=20> </td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.programslot.dateOfProgram" /></td>
                        <td><input type="date" name="dateOfProgram"
                                   value="${param['dateOfProgram']}" size=45 maxlength=20></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.programslot.startTime" /></td>
                        <td><input type="time" name="startTime"
                                   value="${param['startTime']}" size=15 maxlength=20></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.programslot.programName" /></td>
                        <td><input type="text" name="programName"
                                   value="${param['programName']}" size=15 maxlength=20></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.programslot.presenter" /></td>
                        <td>  <select id="presenter" name="presenter">
                              <option value="${param['presenter']}">${param['presenter']}</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.programslot.producer" /></td>
                        <td>  <select id="producer" name="producer">
                                <option value="${param['producer']}">${param['producer']}</option>
                            </select>
                        </td>
                    </tr>
                    <tfoot>
                        <tr>
                            <td>
                                <c:if test="${param['insert']=='false'}">
                                    <input type="submit" value="Modify"> 
                                    <input type="hidden" name="insert" value="false" />
                                </c:if>
                                <c:if test="${param['insert']=='true'}">
                                    <input type="submit" value="Create"> 
                                    <input type="hidden" name="insert" value="true" />
                                </c:if>

                            </td>
                            <td> <input type="reset" value="Reset"></td>

                        </tr>
                    </tfoot>

                </table>
            </center>



        </form>

    </body>
</html>
