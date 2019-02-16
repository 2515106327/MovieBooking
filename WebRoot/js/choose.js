var flag = false;
var count=0;
$(function () {
//             $(".content .seat .row span").on("click",function () {
//             if(flag == false)	
//             {
//             	$(this).addClass("seat-select");
//             	$(this).removeClass("selectable");
//             	flag = true;
//             	count++;
//             	//console.log(count);
//             	  //	var a=$(this).index(this)+1;
//             //	for(var i=0;i<a;i++){
//            // 	console.log($(this).index(this)+1+i);}
//        //   console.log($(this).map(function(){
//        //    	return $(this).attr("data-index");}).get());
//            	///////////////////////////
//            	$("p").append($(this).map(function(){
//                 return $(this).attr("data-index");}).get());
//            	$("#ceshi").val($(this).map(function(){
//            	return $(this).attr("data-index");}).get());
//            if(count!=1){
//             		alert("最多选一个座位");
//             		$(this).addClass("selectable");
//             	$(this).removeClass("seat-select");
//             	$("p").append("");
//             }
//             }
//           
//             else{
//         		$(this).addClass("selectable");
//             	$(this).removeClass("seat-select");
//             	count=0;
//             	flag = false;
//             	console.log(count);
//             	///////////////
//             	$("p").append("");
//            	$("#ceshi").val($(this).map(function(){
//            	return $(this).attr("data-index");}).get());
//            	return null;
//             }
//       });
	$(".content .seat .row span").on("click",function(){
       	$(this). toggleClass("seat-select");
       	$("#ceshi").val($(this).map(function(){
         	return $(this).attr("data-index");}).get());
       });
  }
);
$(function(){
	 var a=$(".b").text();
	 var n=$(".g").text();
	 var b=$(".content .seat .row span").eq(a-1).attr("data-id");
	 var c=$(".content .seat .row span").eq(a-1).attr("data-bo");
	 if(a==b && n==c){
	 	$("body").mouseenter(function(){
	       	$(".content .seat .row span").eq(b-1). addClass("select");
	       	$(".content .seat .row span").eq(b-1).removeClass("seat-select");
	 });
	 
	 }
	 });

