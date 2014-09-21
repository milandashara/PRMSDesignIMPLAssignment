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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRMS</title>


        <!--<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>-->
        <!-- Load jQuery UI CSS  -->
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

        <!-- Load jQuery JS -->
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <!-- Load jQuery UI Main JS  -->
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        
        
        
        <script src="/PRMS/js/ModifySchedule.js"></script>
     

    </head>
    <body>
        <h1>Modify/Copy Schedule</h1>
        <form action="/PRMS/controller/scheduleScreen/modifyScheduleSubmit">
            <div>
                <div>
                    <span>Year :</span>
                    <input type="hidden" id="programSlotId" name="programSlotId" value="${programSlotId}" />

                    <input type="text"  id="annualScheduleYear" name="annualScheduleYear" value="${annualScheduleYear}" readonly />
                </div>
                <div>
                    <span>Week :</span>
                    <input type="text"  id="weeklySchedule" name="weeklySchedule" value="${weeklySchedule}" readonly />                
                </div>

                <div id="ModifyScheduleForm" >
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
                            <td> <input id="modifyDateOfProgram" type="text" name="modifyDateOfProgram" value="${modifyDateOfProgram}"/></td></tr>

                        <tr> <td> Start Time : </td>
                            <td>

                                <select id="modifyStartTimeHr" name="modifyStartTimeHr">
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
                                <select id="modifyStartTimeMt" name="modifyStartTimeMt">
                                    <option>30mt</option>
                                    <option>60mt</option>

                                </select>

                            </td></tr>

                        <tr> <td> Program Name </td>
                            <td>  <select id="ModifyProgramName" name='modifyProgramName' >
                                    <option selected value="${radioProgramSelected.name}">${radioProgramSelected.name}</option>
                                    <c:forEach items="${radioProgramList}" var="radioProgram">
                                        <c:if test="${radioProgramSelected.name != radioProgram.name}" />
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
                            <td> <input id="createPresenter" name="createPresenter" value="${createPresenter}" readonly/></td></tr>
                        <tr><td> <span >Producer</span></td>
                            <td> <input id="createProducer"  name="createProducer" value="${createProducer}" readonly/></td></tr>
                    </table>
                </div>
                    <input type="hidden" name="insert" value="${param['insert']}"/>
                            <c:if test="${param['insert']=='false'}">
                                <input type="submit" value="Modify Schedule"/>
                            </c:if>
                                 <c:if test="${param['insert']=='true'}">
                                <input type="submit" value="Copy Schedule"/>
                            </c:if>
                   
                  
                 <span id="errorMessage" name="errorMessage" style="color: red;">${errorMessage}</span>
            </div>
            <td>
                    
              

                
        </form>
    </body>
</html>