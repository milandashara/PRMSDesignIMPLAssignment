/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    
    var element1 = document.getElementById('createProgramDurationHr');
    element1.value = $(createProgramDurationHr);
    
     var element2 = document.getElementById('createProgramDurationMt');
    element2.value = $(createProgramDurationMt);
    
     var element3 = document.getElementById('modifyStartTimeHr');
    element3.value = $(modifyStartTimeHr);
    
     var element4 = document.getElementById('modifyStartTimeMt');
    element4.value = $(modifyStartTimeMt);
    
  //  var element5 = document.getElementById('ModifyProgramName');
   // element5.value = $(radioProgramSelected.name);
    
    
    
    $(function() {
        $("#modifyDateOfProgram").datepicker();
    });

    $("#selectPresent").click(function()
    {
        var url="/PRMS/controller/PresenterProducer?role=presenter&id=createPresenter";
        window.open(url,"Select Presenter","width=800, height=800");
    });
     $("#selectProducer").click(function()
    {
        window.open("/PRMS/controller/PresenterProducer?role=producer&id=createProducer","Select Producer","width=800, height=800");
    });
    
    $("#modifyDateOfProgram").change(function checkDate() {
            //var EnteredDate = document.getElementById(".date1").value; //for javascript

            var EnteredDate = $("#modifyDateOfProgram").val(); // For JQuery

            var date = EnteredDate.substring(3, 5);
            var month = EnteredDate.substring(0, 2);
            var year = EnteredDate.substring(6, 10);

            var myDate = new Date(year, month - 1, date);

            var today = new Date();

            if (myDate > today) {
               
            }
            else {
                var output = (today.getMonth()<10 ? '0' : '') + today.getMonth() + '/' +
                (today.getDate()()<10 ? '0' : '') + today.getDate() + '/'+today.getFullYear() ;
                $("#modifyDateOfProgram").val(output);
                alert("Entered date is less than today's date ");
            }
        });

});