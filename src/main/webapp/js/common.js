function messageDialog(msg,callback){

}

function confirmDialog(msg,callback){

}

$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

function submitRequest(type,url,data,isAsync,doWhenSuccess,doWhenError){
    $.ajax({
        type: type,     //"POST","GET","DELETE"
        url: url,
        data: JSON.stringify(data),
        dataType: 'json',
        async:isAsync,
        contentType: "application/json; charset=utf-8",
        success:doWhenSuccess,
        error: doWhenError
    });
}

function validateInputNull(input){
	var value = $(input).val();
	if(value === ""){
		return false;
	}else{
		return true;
	}
}

//checkbox 点击事件
$(document).on("click",".checkbox",function () {
    if ($(this).attr("checked")) {
        $(this).attr("checked",false);
    }
    else {
        $(this).attr("checked",true);
    }
});
