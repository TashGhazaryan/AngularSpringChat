var receiverId;
var messageBar = $("#messageContainer");
var messageArea = $("#messageArea");


var showMessages = function () {
    $.ajax({
        type:'GET',
        url:'http://localhost:8080/history?receiverId='+receiverId,
        dataType:"json",
        success: function (data) {
           messageBar.html('');
            for (var i = 0; i < data.length; ++i) {
                if (data[i].sender.id == receiverId){
                    messageBar.append('<a class="list-group-item receiver"><b>' + data[i].message + "</b></a>");
                } else {
                    messageBar.append('<a class="list-group-item sender"><b>' + data[i].message + "</b></a>");

                }
            }
        },
        error: function () {
            alert("error ")
        }
    });
    messageArea.show();
};





$(document).ready(function(){
    $(".users").click(function () {
        receiverId = $(this).attr('id');
        showMessages();
    });


    $("#sendBtn").click( function () {
        var msg = $("#msg").val();
        var message = {
            receiverId:receiverId,
            message:msg
        };

        $.ajax({
            type:'POST',
            url:'http://localhost:8080/message',
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(message),
            success: function () {
                $("#msg").val("");
                console.log(JSON.stringify(message));
                showMessages();
            },
            error: function () {
                alert("error sending message")
            }
        });



    })

});
