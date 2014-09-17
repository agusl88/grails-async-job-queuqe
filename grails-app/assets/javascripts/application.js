// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require_self

$(function(){
    //Create task
    $('#newTask').click(function(){
        $.getJSON( "newTask", function( data ) {
            $('#log').val($('#log').val() + '\n' + "Task Created - ID: " + data.taskID);
        });
    });

    //Check task status
    $('#checkTask').click(function(){
        var taskID = $('#taskID').val();
        $.post( "checkTaskStatus", { id : taskID}, function( data ) {
            $('#log').val($('#log').val() + '\n' + "Task ID " + taskID + " Status: " + data.status);
        });
    });

    //Clear textarea
    $('#clear').click(function(){
        $('#log').val("");
    });
});


