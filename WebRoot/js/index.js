   $(function () {
   	var a=true;
   	var thisIndex=$(".content .wrapper ol li").eq(0);
            // 根据ol下li的索引号，匹配ul下相对应li的索引号
            $(".content .wrapper ol li").mouseenter(function () {
            	thisIndex=$(this);
                $(this).addClass("current").siblings().removeClass("current");
                $(".content .wrapper ul li").eq($(this).index()).fadeIn("fast").siblings().fadeOut(2000);
            });
            var move = function() {
		if(a) {
			var index = (thisIndex.index() + 1) % 3;
			$(".content .wrapper ol li").eq(index).mouseenter();
		}
		setTimeout(move, 5000);
	}
            setTimeout(move,5000);
        });