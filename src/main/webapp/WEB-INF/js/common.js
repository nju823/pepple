toastr.options = {
    "closeButton": false,
    "debug": false,
    "newestOnTop": false,
    "progressBar": false,
    "positionClass": "toast-top-center",
    "preventDuplicates": false,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "2500",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
}

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
