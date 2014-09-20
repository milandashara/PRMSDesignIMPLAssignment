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

                         $("#weeklySchedule").val(array[0].startDate);
                            
                            $("#weeklySchedule").trigger('change') ;

                    })
                }).change();
                
                  $("#weeklySchedule").change(function() {
              
                    var week = $("#weeklySchedule option:selected").text();
                    if(week == null || week=="")
                        return;
                    var url = "scheduleScreen/loadAllProgramSlots?week=" + week;
                    $.get(url, function(data, status) {
                        var listItems = "";

                        var i=0;
                        var arrayProgramSlots=JSON.parse(data);
                        
                        for (var i = 0; i < arrayProgramSlots.length; i++) {
                            var arrayProgramSlotEncoded = $.param( arrayProgramSlots[i] );
//                            var radioProgramEncoded = $.param(arrayProgramSlots[i].radioProgram);
                            listItems += "<tr class="+(i%2==0?"even":"odd")+">";
                            listItems += "<td class=\"nowrap\">"+arrayProgramSlots[i].duration+"</td>"
                            listItems +="<td class=\"nowrap\">"+arrayProgramSlots[i].dateOfProgram+"</td>";
                            listItems +="<td class=\"nowrap\">"+arrayProgramSlots[i].startTime+"</td>";
                            listItems +="<td class=\"nowrap\">"+arrayProgramSlots[i].radioProgram+"</td>";
                            listItems +="<td class=\"nowrap\">"+arrayProgramSlots[i].presenter+"</td>";
                            listItems +="<td class=\"nowrap\">"+arrayProgramSlots[i].producer+"</td>";
                            listItems +="<td class=\"nowrap\"><a href='scheduleScreen/settupps?"+arrayProgramSlotEncoded+"&insert=false'</a>Modify</td>";
			    listItems +="<td class=\"nowrap\"><a href='scheduleScreen/settupps?"+arrayProgramSlotEncoded+"&insert = true'</a>Copy</td>";
                            listItems +="<td class=\"nowrap\"><a href='scheduleScreen/deleteScheduleps?id="+arrayProgramSlots[i].id+"'</a>Delete</td>";
                        }

                        $("#programslottbl").find("tbody").html(listItems);
                        


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
        <input type='hidden' value='id'
        <div>
            <span> Week :   </span>
            <select id="weeklySchedule">
            </select>   
        </div>
        
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
