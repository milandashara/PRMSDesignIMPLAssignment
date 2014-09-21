<%-- 
    Document   : createSchedule.jsp
    Created on : Sep 21, 2014, 11:22:10 AM
    Author     : Milan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRMS</title>


        <!--<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>-->
        <!-- Load jQuery UI CSS  -->
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

        <!-- Load jQuery JS -->
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <!-- Load jQuery UI Main JS  -->
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <script src="/PRMS/js/createSchedule.js"></script> 

    </head>
    <body>
        <h1>Create Schedule</h1>
        <form action="/PRMS/controller/scheduleScreen/createScheduleSubmit">
            <div>
                <div>
                   <span>Year :</span>
                    <input type="text"  id="annualScheduleYear" name="annualScheduleYear" value="${annualScheduleYear}" readonly />
                </div>
                <div>
                    <span>Week :</span>
                    <input type="text"  id="weeklySchedule" name="weeklySchedule" value="${weeklySchedule}" readonly />                
                </div>

                <div id="createScheduleForm" >
                    <table> <tr> <td> Program Duration : </td>
                            <td> 
                                <select id="createProgramDurationHr" name="createProgramDurationHr">
                                    <option>0hr</option>
                                    <option>1hr</option>
                                    <option>2hr</option>
                                    <option>3hr</option>
                                    <option>4hr</option>
                                    <option>5hr</option>
                                    <option>6hr</option>
                                    <option>7hr</option>
                                    <option>8hr</option>
                                    <option>9hr</option> 
                                    <option>10hr</option> 
                                    <option>11hr</option>
                                    <option>12hr</option>
                                    <option>13hr</option> 
                                    <option>14hr</option> 
                                    <option>15hr</option>
                                    <option>16hr</option>
                                    <option>17hr</option>
                                    <option>18hr</option>
                                    <option>19hr</option>
                                    <option>20hr</option>
                                    <option>21hr</option>
                                    <option>22hr</option>
                                    <option>23hr</option>



                                </select>
                                <select id="createProgramDurationMt" name="createProgramDurationMt">
                                    <option>30mt</option>
                                    <option>60mt</option>

                                </select>
                            </td></tr>

                        <tr> <td> Date of Program : </td>
                            <td> <input id="createDateOfProgram" type="text" name="createDateOfProgram"/></td></tr>

                        <tr> <td> Start Time : </td>
                            <td> 
                            
                             <select id="createStartTimeHr" name="createStartTimeHr">
                                    <option>0hr</option>
                                    <option>1hr</option>
                                    <option>2hr</option>
                                    <option>3hr</option>
                                    <option>4hr</option>
                                    <option>5hr</option>
                                    <option>6hr</option>
                                    <option>7hr</option>
                                    <option>8hr</option>
                                    <option>9hr</option> 
                                    <option>10hr</option> 
                                    <option>11hr</option>
                                    <option>12hr</option>
                                    <option>13hr</option> 
                                    <option>14hr</option> 
                                    <option>15hr</option>
                                    <option>16hr</option>
                                    <option>17hr</option>
                                    <option>18hr</option>
                                    <option>19hr</option>
                                    <option>20hr</option>
                                    <option>21hr</option>
                                    <option>22hr</option>
                                    <option>23hr</option>



                                </select>
                                <select id="createStartTimeMt" name="createStartTimeMt">
                                    <option>30mt</option>
                                    <option>60mt</option>

                                </select>
                            
                            </td></tr>

                        <tr> <td> Program Name </td>
                            <td>  <select id="createProgramName" name='createProgramName' >

                                    <c:forEach items="${radioProgramList}" var="radioProgram">

                                        <option value="${radioProgram.name}">${radioProgram.name}</option>

                                    </c:forEach>
                                </select></tr>
                        <tr> <td> Select Presenter  </td> <td>
                                
                                <input  id="selectPresent" type="button" value="Select Presenter"/></td>
                        </tr>
                        <tr> <td> Select Producer  </td> <td>
                                
                                <input  id="selectProducer" type="button" value="Select  Producer"/></td>
                        </tr>

                        <tr><td> <span >Presenter</span></td>
                            <td> <input id="createPresenter"  name="createPresenter" readonly value="${createPresenter}"/></td></tr>
                        <tr><td> <span >Producer</span></td>
                            <td> <input id="createProducer"  name="createProducer" readonly value="${createProducer}"/></td></tr>
                    </table>
                </div>
            </div>

            <input type="submit" value="Create Schedule"/>
            <span id="errorMessage" name="errorMessage" style="color: red;">${errorMessage}</span>
        </form>
    </body>
</html>
