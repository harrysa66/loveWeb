$(document).ready(function(){

				// EXAMPLE 1:
				$('#example1').timeliner();
			});

			// Callback function examples:
			function start_callback(id){
				if(id=='example1'){
					$('#callback_log').html('Timeliner "'+id+'" started');
				}
			}
			function newslide_callback(id, slide){
				if(id=='example1'){
					$('#callback_log').html('Timeliner "'+id+'" changed to slide '+slide);
				}
			}
			function end_callback(id){
				if(id=='example1'){
					$('#callback_log').html('Timeliner "'+id+'" ended');
				}
			}
			function paused_callback(id, slide){
				if(id=='example1'){
					$('#callback_log').html('Timeliner "'+id+'" paused at slide '+slide);
				}
			}
			function resumed_callback(id, slide){
				if(id=='example1'){
					$('#callback_log').html('Timeliner "'+id+'" resumed at slide '+slide);
				}
			}
			function click_callback(id, slide){
				if(id=='example1'){
					$('#callback_log').html('Clicked on slide '+slide+' of Timeliner "'+id+'"');
				}
			}