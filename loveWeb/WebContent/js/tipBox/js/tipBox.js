var tip = null;
function showTip(msg,timeOut,type){
		var tipHtml = '';
			if (type =='loading'){
				tipHtml = '<img alt="" src="images/loading.gif">'+(msg ? msg : '正在提交您的请求，请稍候...');
			} else if (type =='notice'){
				tipHtml = '<span class="gtl_ico_hits"></span>'+msg
			} else if (type =='error'){
				tipHtml = '<span class="gtl_ico_fail"></span>'+msg
			} else if (type =='succ'){
				tipHtml = '<span class="gtl_ico_succ"></span>'+msg
			}
			if ($('.msgbox_layer_wrap')) {
				$('.msgbox_layer_wrap').remove();
			}
			if (st){
				clearTimeout(st);
			}
			$("body").prepend("<div class='msgbox_layer_wrap'><span id='mode_tips_v2' style='z-index: 10000;' class='msgbox_layer'><span class='gtl_ico_clear'></span>"+tipHtml+"<span class='gtl_end'></span></span></div>");
			$(".msgbox_layer_wrap").show();
			var st = setTimeout(function (){
				$(".msgbox_layer_wrap").hide();
				clearTimeout(st);
				window.location.reload();
			},timeOut*1000);
}