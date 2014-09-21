/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    $(function() {
        $("#createDateOfProgram").datepicker();
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

});

