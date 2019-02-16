 $(function(){
            $(".content .wrapper .tab li").mouseenter(function(){
                var $this = $(this),
                   index = $this.index();
                $this.addClass("active").siblings("li").removeClass("active");
                $(".products div").eq(index).addClass("selected").siblings("div").removeClass("selected");
            });
        });