<%-- 
    Document   : schedule
    Created on : Sep 16, 2014, 5:22:07 PM
    Author     : Milan
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRMS</title>


        <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="/PRMS/js/schedule.js"></script>
    </head>
    <body>
        <h1>Maintain Schedule</h1>
        <form action="/PRMS/controller/scheduleScreen/createSchedule">
        <div>
            <span> Year :   </span>
            <select id="annualScheduleYear" name='annualScheduleYear' >

                <c:forEach items="${annualScheduleList}" var="annualSchedule">

                    <option value="${annualSchedule.year}">${annualSchedule.year}</option>

                </c:forEach>
            </select>
           

        </div>
        <input type='hidden' value='id'
               <div>
            <span> Week :   </span>
            <select id="weeklySchedule" name="weeklySchedule">
            </select>   
        </div>
               <div>
                   <input id="createSchedule" type="submit" value="Create Schedule" />
                   <span id="createSuccessMsg" name="createSuccessMsg" style="color: green;">${createSuccessMsg}</span>
        </div>
        </form>

        <div>
            <span> Program Slots :   </span>
            <table id='programslottbl' class="borderAll">
                <thead>
                    <tr>
                        <th><fmt:message key="label.programslot.duration" /></th>
                        <th><fmt:message key="label.programslot.dateOfProgram" /></th>
                        <th><fmt:message key="label.programslot.startTime" /></th>
                        <th><fmt:message key="label.programslot.programName" /></th>
                        <th><fmt:message key="label.programslot.presenter" /></th>
                        <th><fmt:message key="label.programslot.producer" /></th>
                        <th><fmt:message key="label.programslot.modify" /></th>
                        <th><fmt:message key="label.programslot.copy" /></th>
                        <th><fmt:message key="label.programslot.delete" /></th>
                    </tr>
                </thead>
                <tbody>


                </tbody>
            </table>
            

            
        </div>



    </body>
</html>
