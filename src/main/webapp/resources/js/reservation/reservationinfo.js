function imgclick(path,info){
	var url=path+'/'+savedir+'/room1';
	var name = 'roominfo';
	var option = 'width=430, height=500, location=no, status=no, scrollbars=yes';
	
	window.open(url,name, option);
}

$(function() {
	   $('.bxslider').bxSlider({
	      slideWidth: 600,
	      caption: true,
	      auto: true,
	      autoControl: true,
	      stopAutoOnclick: true,
	   });
	});