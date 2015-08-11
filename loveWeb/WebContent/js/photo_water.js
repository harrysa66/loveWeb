$(function(){ 
	$('.box01 li').hover(function() {
	    $(this).addClass('on');
	    var wl = $(this).find('img').attr('width');
	    if (wl < 190) {
	        $(this).find('.in').css('left', '0')
	    } else {
	        $(this).find('.in').css('left', -wl / 4)
	    }
	},
	function() {
	    $(this).animate({
	        height: "120px"
	    },
	    100).removeClass('on');
	    $(this).find('.in').css('left', '0')
	});
})