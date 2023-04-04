$("button[id=btn_voc]").click(function(){
    const params = {
        voc_no: document.getElementById('voc_no').value,
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
        c_voc_no: document.getElementById('c_voc_no').value,
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

$("button[id=btn_pen]").click(function(){
    const params = {
        p_voc_no: document.getElementById('p_voc_no').value,
        p_amount: document.getElementById('p_amount').value
    };

    $.ajax({
        url:'/pen',
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
