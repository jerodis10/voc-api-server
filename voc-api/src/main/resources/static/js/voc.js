$("button[id=btn_voc]").click(function(){
    const params = {
        party: document.getElementById('party').value,
        content: document.getElementById('content').value
    };

    $.ajax({
       url:'/voc',
       type:'POST',
       dataType: 'json',
       contentType : "application/json; charset=utf-8",
       data: JSON.stringify(params),
       success:function(data){
           console.log(data);
       },
       error : function(e){
           console.log(e);
       }
    });
});

$("button[id=btn_compen]").click(function(){
    const params = {
        amount: document.getElementById('amount').value
    };

    $.ajax({
        url:'/comp',
        type:'POST',
        dataType: 'json',
        contentType : "application/json; charset=utf-8",
        data: JSON.stringify(params),
        success:function(data){
            console.log(data);
        },
        error : function(e){
            console.log(e);
        }
    });
});
