<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<base href="${pageContext.request.contextPath}/">
		<title></title>
		<link rel="stylesheet" href="css/common.css"/>
	    <script src="js/lib/jquery-3.2.1.js"></script>
	    <script type="text/javascript">
	    	
	    </script>
	</head>
	<style type="text/css">
		.a-header{
			margin-left: 25px;
		}
		.a-header1{
			margin-left: 0px;
		}
		.a-img{
			width: 30px;
			height: 30px;
			margin-left: 1230px;
			margin-top: 2px;
			border-radius: 50%;	
		}
		.a-img1{
			width: 50px;
			height: 50px;
			margin-left: 60px;
			margin-top: 100px;
		}
		.nc{
			display: block;
			margin-top: -40px;
			margin-left: 125px;
			font-weight: bold;
			font-size: 19px;
		}
		
		.l-1{
			float: left;
			margin-left: 40px;
			margin-top: 10px;
			font-size: 23px;
			font-weight: bold;
		}
		
		#xz{
			width: 100%;
			height: 70px;
			
		}
		#q-over{
			width: 100%;
			height: 100%;
			border: 0px solid red;
		}
		#x-down{
			width: 100%;
			height: 800px;
			background-color: #DCDCDC;
		}
		#x-down-1{
			width: 80%;
			height: 200px;
			border: 0px solid red;
			background-color: ghostwhite;
			margin: 0 auto;
			
		}
		#x-down-2{
			width: 80%;
			height: 50px;
			background-color: white;
			margin-top: 20px;
			margin-left: 150px;
		}
		#x-down-3{
			width: 80%;
			height: 500px;
			background-color: white;
			margin-top: 10px;
			margin-left: 150px;
			
			
		}
	
		.nr{
			width: 60%;
			height: 100px;
			margin-top: 50px;
			margin-left: 40px;
			
		}
		.bt1{
			font-size: 18px;
			font-weight: bold;
			padding-top: 40px;
			padding-left: 40px;
		}
		.scfm{
			font-size: 18px;
			font-weight: bold;
			padding-top: 40px;
			padding-left: 40px;
		} 
		.bt2{
			
			font-size: 18px;
			font-weight: bold;
			padding-top: 30px;
			padding-left: 40px;
		}
		
		.b-text{
			float: left;
			margin-left: 100px;
			margin-top: -27px;
			
		}
		.sctp{
			float: left;
			margin-left: 130px;
			top: -50px;
			
		}
		.fb{
			width:90px;
			height:30px;
			line-height:30px;
			font-family:"微软雅黑","microsoft yahei";
			cursor:pointer;
			margin-top:30px;
			margin-left: 300px;
			display:inline-block;
			border-radius:5px;
			-webkit-border-radius:5px;
			text-align:center;
			background-color:#428bca;
			color:#fff;
			box-shadow: 0 -3px 0 #2a6496 inset;
			-webkit-box-shadow: 0 -3px 0 #2a6496 inset;
		}
		.shuru{
			font-size: 18px;
			font-weight: bold;
			padding-top: 40px;
			padding-left: 40px;
		}
		.head-img1{
		width:60px;
		height:60px;
		margin-left:50px;
		margin-top:50px;
		border-radius:50%;
		}
		.s-name{
		font-size:20px;
		font-weight:bold;
		margin-left:130px;
		margin-top:-40px;
		display:block;
		}
	</style>
	<body>
<div id="q-over">
	<div class="g-container">
    <header title="头部导航条" class="g-minwidth" id="header" name="header">
        <ul class="g-c h-left">
            <li class="h-tianqi">
                <a class="a-header">
                    <iframe width="150" scrolling="no" height="70" frameborder="0" allowtransparency="true" style="margin-top: 5px;"
	    			src="http://i.tianqi.com/index.php?c=code&id=11&color=%230070C0&icon=1&site=15">
	    		</iframe>
                </a>
            </li>
        </ul>
        <ul class="h-right g-c" style="width: 100%;margin-top: -35px;">
        	
        	
            
			
            <li><a><img src="${currUser.headImg }" class="a-img"/></a></li>
            <li class="a-header1"><a href="#">${currUser.nickName }</a>
            	
            </li>
            <li class="a-header2"><a href="tousu.jsp">侵权投诉</a></li>
            <li class="a-header3"><a>退出</a></li>
            
        </ul>
    </header>
    </div>
	    <div id="xz">
	    	<a style="margin-left: 120px;" href="index.jsp"><img src="images/logo-33.png"/></a>
	    </div>
	    
	    <div id="x-down">
	    	<div id="x-down-1">
	    	<c:choose>
	    		<c:when test="${empty currUser.headImg }">
	    			<a href="personal.jsp"><img src="headImg/headimg02.png" class="head-img1"/><span class="s-name">${currUser.nickName }</span></a>
	    		</c:when>
	    		<c:otherwise>
	    			<a href="personal.jsp"><img src="${currUser.headImg }" class="head-img1"/><span class="s-name">${currUser.nickName }</span></a>
	    		</c:otherwise>
	    	</c:choose>
	    		<%-- <span class="nc">${currUser.nickName }</span>   --%>              
	    	</div>
	    	
	    	<div id="x-down-2">
	    		<a><li class="l-1">发布文章</li></a>
	    	</div>
	    	
	    	<div id="x-down-3">
	    		<div>
		    		<li class="bt1">标题:</li>
		    		<textarea rows="2" cols="30" class="b-text" name="news.title"></textarea>
	    		</div>
	    		<p class="scfm">上传封面:</p>
	    		
	    		<div style="height: 30px;width: 400px;margin-top: -25px;">
	    			<input type="file" name="fileUpload" class="sctp"/>
	    		</div>
	    	
	    		<p class="shuru">请输入内容：</p>
	    		<textarea rows="2" cols="30" class="nr" name="news.content"></textarea>
	    		<div>
 					<input type="submit" value="发布" class="fb"/>
	    		</div>
	    	</div>
	    	
	    	
	    </div>
</div>
	</body>
</html>
