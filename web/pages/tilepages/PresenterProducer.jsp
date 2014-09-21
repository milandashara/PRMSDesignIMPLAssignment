<%-- 
    Document   : PresenterProducer
    Created on : 17 Sep, 2014, 7:48:26 PM
    Author     : sakthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
        <!--<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>-->
        <!-- Load jQuery UI CSS  -->
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

        <!-- Load jQuery JS -->
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <!-- Load jQuery UI Main JS  -->
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <fmt:setBundle basename="ApplicationResources" />
        <title> <fmt:message key="title.PresenterProducer"/> </title>

        <script type ="text/javascript">
            $(document).ready(function() {
                $('#submit').click(function() {

                    data = $('.password').val();
                    var len = data.length;

                    if (len < 1) {
                        alert("Password cannot be blank");
                    }

                    else if ($('.password').val() !== $('.confpass').val()) {
                        alert("Password and Confirm Password don't match");
                    }

                    var txtVal = $('.date1').val();
                    alert(txtVal);
                    if (isDate(txtVal))
                        alert('Valid Date');
                    else
                        alert('Invalid Date');
                });

                function isDate(txtDate)
                {
                    //var newDate = dateFormat(txtDate, "mm/dd/yyyy");
                    var currVal = txtDate;
                    if (currVal === '')
                        return false;

                    var rxDatePattern = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/; //Declare Regex
                    var dtArray = currVal.match(rxDatePattern); // is format OK?

                    if (dtArray === null)
                        return false;

                    //Checks for mm/dd/yyyy format.
                    dtMonth = dtArray[1];
                    dtDay = dtArray[3];
                    dtYear = dtArray[5];

                    if (dtMonth < 1 || dtMonth > 12)
                        return false;
                    else if (dtDay < 1 || dtDay > 31)
                        return false;
                    else if ((dtMonth === 4 || dtMonth === 6 || dtMonth === 9 || dtMonth === 11) && dtDay === 31)
                        return false;
                    else if (dtMonth === 2)
                    {
                        var isleap = (dtYear % 4 === 0 && (dtYear % 100 !== 0 || dtYear % 400 === 0));
                        if (dtDay > 29 || (dtDay === 29 && !isleap))
                            return false;
                    }
                    return true;
                };

                $("table tr td input").click(function() {

                    // alert($(this).attr("id"));

                    // Get the values from the URL using the jquery.query plug-in
                    var id = $("#roleId").val();
                     
                    // Get the values from the drop down
                    var userID = $(this).attr("id");
                    //var newPartyName = $("#ddlMatchingParties option:selected").text();

                    // Set them to the parent window
                    
                    // alert(window.location.href);
                     
                   //  alert(id.toString());
                    window.opener.$('#'+id).val(userID);
                   // alert("userID");
                    window.close();
                    //window.opener.$("#" + name).val(newPartyName);
                });});
        </script>
    </head>
    <body>
        <br/><br/>
        <table id="selectTable" class="borderAll">
            <tr>
                <th><fmt:message key="label.PresenterProducer.id"/></th>
                <th><fmt:message key="label.PresenterProducer.name"/></th>
                <th><fmt:message key="label.PresenterProducer.role"/></th>
                <th><fmt:message key="label.PresenterProducer.select"/></th> 
            </tr>     
            <c:forEach var="presenterproducer" items="${PresenterProducer}" varStatus="status">
                <tr class="${status.index%2==0?'even':'odd'}">
                    <td class="nowrap">${presenterproducer.id}</td>
                    <td class="nowrap">${presenterproducer.name}</td>
                    <td class="nowrap">${presenterproducer.role}</td>
                    <td class="nowrap">


                        <input type="button" id='${presenterproducer.id}' name="selectPresenterProducer" value="<fmt:message key="label.PresenterProducer.select"/>" />
                        <input type="hidden" id="${presenterproducer.name}" />
                        <input type="hidden" id="role" value="${role}"/>
                        <input type="hidden" id="roleId" value="${id}"/>
                    </td>
                </tr>

            </c:forEach>
        </table>

    </body>

