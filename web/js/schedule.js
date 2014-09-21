/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



        $(document).ready(function() {

    $("#annualScheduleYear").change(function() {

        var year = $("#annualScheduleYear option:selected").text();
        var url = "scheduleScreen/loadAllWeeklySchedule?year=" + year;
        $.get(url, function(data, status) {
            var listItems = "";

            var i = 0;
            var array = JSON.parse(data);
            for (var i = 0; i < array.length; i++) {
                listItems += "<option value='" + array[i].startDate + "'>" + array[i].startDate + "</option>";
            }

            $("#weeklySchedule").html(listItems);

            if (array.length == 0 || array == null || array == undefined)
            {
                $("#createSchedule").prop("disabled", true);
                $("#programslottbl").find("tbody").html("");
            }
            else
            {
                $("#createSchedule").prop("disabled", false);
            }

            $("#weeklySchedule").val(array[0].startDate);

            $("#weeklySchedule").trigger('change');

        })
    }).change();

    $("#weeklySchedule").change(function() {

        var week = $("#weeklySchedule option:selected").text();
        if (week == null || week == "")
            return;
        var url = "scheduleScreen/loadAllProgramSlots?week=" + week;
        $.get(url, function(data, status) {
            var listItems = "";

            var i = 0;
            var arrayProgramSlots = JSON.parse(data);

            for (var i = 0; i < arrayProgramSlots.length; i++) {
                var arrayProgramSlotEncoded = $.param(arrayProgramSlots[i]);
//                            var radioProgramEncoded = $.param(arrayProgramSlots[i].radioProgram);
                listItems += "<tr class=" + (i % 2 == 0 ? "even" : "odd") + ">";
                listItems += "<td class=\"nowrap\">" + arrayProgramSlots[i].duration + "</td>"
                listItems += "<td class=\"nowrap\">" + arrayProgramSlots[i].dateOfProgram + "</td>";
                listItems += "<td class=\"nowrap\">" + arrayProgramSlots[i].startTime + "</td>";
                listItems += "<td class=\"nowrap\">" + arrayProgramSlots[i].radioProgram + "</td>";
                listItems += "<td class=\"nowrap\">" + arrayProgramSlots[i].presenter + "</td>";
                listItems += "<td class=\"nowrap\">" + arrayProgramSlots[i].producer + "</td>";
                listItems += "<td class=\"nowrap\"><a href='/PRMS/controller/scheduleScreen/modifyCopyProgramSlot?" + arrayProgramSlotEncoded + "&annualScheduleYear="+$("#annualScheduleYear").val()+"&weeklySchedule="+$("#weeklySchedule").val()+"&insert=false'</a>Modify</td>";
                listItems += "<td class=\"nowrap\"><a href='scheduleScreen/settupps?" + arrayProgramSlotEncoded + "&insert = true'</a>Copy</td>";
                listItems += "<td class=\"nowrap\"><a href='scheduleScreen/deleteScheduleps?id=" + arrayProgramSlots[i].id + "'</a>Delete</td>";
            }

            $("#programslottbl").find("tbody").html(listItems);

            if (arrayProgramSlots.length == 0 || arrayProgramSlots == null || arrayProgramSlots == undefined)
            {
                $("#createSchedule").prop("disabled", true);
                $("#programslottbl").find("tbody").html("");
            }
            else
            {
                $("#createSchedule").prop("disabled", false);
            }


        });
    });

    $("#createSchedule").click(function() {
     //   var createForm='';
      //  $("#createScheduleForm").css("visibility",'visible');
       // alert(createForm);
    });
    
    

});
     