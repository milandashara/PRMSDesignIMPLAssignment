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

        <script>
            $(document).ready(function() {
                $("#annualScheduleYear").change(function() {
              
                    var year = $("#annualScheduleYear option:selected").text();
                    var url = "scheduleScreen/loadAllWeeklySchedule?year=" + year;
                    $.get(url, function(data, status) {
                        var listItems = "";

                        var i=0;
                        var array=JSON.parse(data);
                        for (var i = 0; i < array.length; i++) {
                            listItems += "<option value='" + array[i].startDate + "'>" + array[i].startDate + "</option>";
                        }

                        $("#weeklySchedule").html(listItems);
                        


                    });
                });
            });
        </script>



    </head>
    <body>
        <h1>Maintain Schedule</h1>
        <div>
            <span> Year :   </span>
            <select id="annualScheduleYear" name='annualScheduleYear' >
                
                <c:forEach items="${annualScheduleList}" var="annualSchedule">

                    <option value="${annualSchedule.year}">${annualSchedule.year}</option>

                </c:forEach>
            </select>

            
        </div>

        <div>
            <span> Week :   </span>
            <select id="weeklySchedule">
            </select>   
        </div>
         
        

    </body>
</html>
