$(function(){
	$(".movie-type ul li").on("click",function(){
		$(this).addClass(".bg").siblings().removeClass(".bg");
	});
});