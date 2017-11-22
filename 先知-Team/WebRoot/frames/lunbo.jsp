<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <base href="${pageContext.request.contextPath}/">
    <title></title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=0">
</head>
<style type="text/css">
    body{max-width: 660px;margin: 0 auto;}
    #lunbo ul li{width:100%;list-style: none;width:660px; height:300px;background-color: whitesmoke;text-align: center;}
    #lunbo ul li:not(:first-child){display: none;}
    .banner .img img{width:660px; height:300px;}
    .d-lb{
    	position:relative;
    	width:100px;
    	height:100px;
    }
    .d-zt{
    	position:absolute;
    	width:100px;
    	height:100px;z-indent:2;
    	left:20px;
    	top:240px;
    	color: white;
    	font-weight:900;
    	white-space:nowrap;
    	font-size:20px;
    }
    
</style>

<body>
<div class="banner" id="lunbo">
    <ul class="img">
    	<div>
    		<li>
    			<div class="d-lb">
    				<a href="getNewsDetail_preIndexAction?news.id=11" target="_blank"><img src="img/lunbo01.jpg" alt="" /></a>
    				<div class="d-zt">快讯：我国采取“一箭双星”方式首次发射北斗三号组网卫星</div>
    	 		</div>   
    		</li>
    	
		<li>
			<div class="d-lb">
	   		<a href="getNewsDetail_preIndexAction?news.id=10" target="_blank"><img src="img/lunbo02.jpg" alt="" /></a>
	  		  	<div class="d-zt">四川首次拍到四只雪豹同框画面 三只小的约3个月</div>
	        </div>
	    </li>

		<li>
			<div class="d-lb">
			<a href="getNewsDetail_preIndexAction?news.id=9" target="_blank"><img src="img/lunbo03.jpg" alt="" /></a>
					<div class="d-zt">马云王菲合唱细节曝光：曾两度被王菲拒绝；喝了二两酒才进录音室</div>
			</div>
		</li>

		<li>
			<div class="d-lb">
	  		 <a href="getNewsDetail_preIndexAction?news.id=8" target="_blank"><img src="img/lunbo04.jpg" alt="" /></a>
	   		 <div class="d-zt">霍金WE大会演讲：地球变得太小了，最好的方法就是移民太空</div>
	   	 	</div>
	    </li>
	    
	   <li>
			<div class="d-lb">
	  		 <a href="getNewsDetail_preIndexAction?news.id=7" target="_blank"><img src="img/lunbo05.jpg" alt="" /></a>
	   		 <div class="d-zt">日本刮起“伊万卡”旋风，安倍竭力讨好获欢心</div>
	   	 	</div>
	    </li>
    
    </ul>
    
		</div>
<script type="text/javascript">
    //因为使用了document，所以js需要放在需要执行的代码下面生效才能生效
    var li=document.getElementById('lunbo').getElementsByTagName("li");
    var num=0;
    var len=li.length;

    setInterval(function(){
        li[num].style.display="none";
        num=++num==len?0:num;
        li[num].style.display="inline-block";

    },3000);//切换时间
    
</script>
</body>
</html>