<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/">
<title>Insert title here</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/personal.css"/>
<script src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
/* 	let $newsNavLi = $('.news-nav li');
		  $newsNavLi.on('click',function () {
		    let nowIndex = $newsNavLi.index(this);
		    $newsNavLi.removeClass('news-li-active').eq(nowIndex).addClass('news-li-active');
		  });
		
		  let $newsNav = $('.news-nav');
		  let $navNewsZhanWei = $('.news-nav-zhanwei');
		  let newsNavTop = $newsNav.offset().top + 50;
		  let scrollHeight;

		  $(document).scroll(function () {
		        scrollHeight = $(window).scrollTop();
		        if(scrollHeight >= newsNavTop){
		          $newsNav.css({'position':'fixed', 'top':0});
		          $navNewsZhanWei.css('display','block');
		        }else{
		          $newsNav.css({'position':'relative'});
		          $navNewsZhanWei.css('display','none');
		        }
		    }); */
$(document).ready(function(){
	$("#tanchuangInput").click(
		function(){
		$("#tanchuang").toggle(200);
		}
	);
	$("#tanchuang1").click(
		function(){
			$("#tanchuang").toggle(200);
		}
	);
});
</script>
<style type="text/css">
	#tanchuang1{
		margin-left:160px;
		font-size:12px;
		font-weight: 100;
		margin-top:5px;
		position: absolute;
	}
	#tanchuang{
		margin-left:300px;
		margin-top:-170px;
		width:300px;
		height:250px;
		display:none;
		position: absolute;
	}
	#userEdit tr{
		width:350px;
		height:40px;
	}
	#userEdit tr td{
		
	}
	#userEdit th{
		width:100px;
		text-align: center;
		font-weight: 100;
	}
	#userEdit textarea{
		width:200px;
		height:25px;
		margin-left:20px;
		overflow:hidden;
		text-align: center;
	}
	#tanchuangInput{
		width:80px;
		height:30px;
		margin-left:135px;
		border-radius: 10px；
	}
	.sex{
		width:25px;
		height:25px;
		position: absolute;
		margin-left:270px;
		margin-top:-30px;
	}
</style>
</head>
<body>
<div class="g-container">
    <header title="头部导航条" class="g-minwidth" id="header" name="header">
        <ul>
        <li class="h-tianqi">
               <a class="a-header">
                    <iframe width="150" scrolling="no" height="70" frameborder="0" allowtransparency="true" style="margin-top: 5px;"
	    			src="http://i.tianqi.com/index.php?c=code&id=11&color=%230070C0&icon=1&site=15">
	    		</iframe>
                </a>
            </li>
        </ul>
        <ul class="h-right g-c">
            <li style="margin-right: 14px;" class="g-active">
                <div class="h-login">
			<c:choose>
				<c:when test="${empty currUser }">
					<a href="login.jsp">登录</a>
				</c:when>
				<c:otherwise>
					<c:if test="${empty currUser.headImg }">
						<a href="loadCollectNews_UserCenterAction?user.id=${currUser.id }"><img src="headImg/headimg02.png" class="head-img"/><span class="s-name">${currUser.nickName }</span></a>
					</c:if>
					<c:if test="${not empty currUser.headImg }">
						<a href="loadCollectNews_UserCenterAction?user.id=${currUser.id }"><img src="${currUser.headImg }" class="head-img"/><span class="s-name">${currUser.nickName }</span></a>
					</c:if>
				</c:otherwise>
			</c:choose>       
                </div>
            </li>
            <li><a>联系我们</a></li>
            <li class="a-header3"><a href="login.jsp">退出</a></li>
        </ul>
       
    </header>
    </div>
	    <div id="xz">
	    	<a href="index.jsp"><p style="font-weight:800;font-size: 35px;color: #ED4040;margin-left: 0px;">先知</p></a>
	    </div>
	    
	    <div id="x-down">
	    	<div id="x-down-1">
	    	
	    	<c:choose>
				<c:when test="${empty otherUser }">
					<a href="login.jsp">登录</a>
				</c:when>
				<c:otherwise>
					<c:if test="${empty otherUser.headImg }">
						<a href="personal.jsp"><img src="headImg/headimg02.png" class="a-img"/><span class="nc">${otherUser.nickName }</span></a>
					</c:if>
					<c:if test="${not empty otherUser.headImg }">
						<a href="personal.jsp"><img src="${otherUser.headImg }" class="a-img"/><span class="nc">${otherUser.nickName }</span></a>
					</c:if>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${not empty otherUser.userDetail.sex}">
					<c:if test="${otherUser.userDetail.sex eq '男' }">
						<img src="images/nanxing.png" class="sex"/>
					 </c:if>
					 <c:if test="${otherUser.userDetail.sex eq '女' }">
						<img src="images/nvxing.png" class="sex"/>
					 </c:if>
				</c:when>
			</c:choose>
			
			
				<c:if test="${currUser.id==otherUser.id }">
				<a id="tanchuang1">编辑个人资料</a>
				</c:if>

				<div id="tanchuang">
					<form action="updateUser_UserAction" method="post">
					<input type="text" name="user.id" value="${currUser.id }" style="display: none;">
						<table id="userEdit">
							<tr>
								<th>昵称</th>
								<td><textarea rows="1" cols="1" name="user.nickName">${currUser.nickName }</textarea></td>
							</tr>
							<tr>
								<th>性别</th>
								<td><textarea rows="1" cols="1" name="userDetail.sex">${currUser.userDetail.sex }</textarea></td>
							</tr>
							<tr>
								<th>年龄</th>
								<td><textarea rows="1" cols="1" name="userDetail.age">${currUser.userDetail.age }</textarea></td>
							</tr>
							<tr>
								<th>邮箱</th>
								<td><textarea rows="1" cols="1" name="userDetail.mailbox">${currUser.userDetail.mailbox }</textarea></td>
							</tr>
							<tr>
								<th>手机号</th>
								<td><textarea rows="1" cols="1" name="userDetail.tel">${currUser.userDetail.tel }</textarea></td>
							</tr>
						</table>
						<input type="submit" id="tanchuangInput" value="保存">
					</form>
					
				</div>
				
				
                <c:if test="${currUser.id==otherUser.id }">
	    			<a href="xiaobian.jsp"><input type="button" id="tian" value="发布新闻"/></a>
	    			<a href="uploadVideo.jsp"><input type="button" id="tian1" value="发布视频"/></a>
	    		</c:if>
	    	</div>
	    	
	    	<!-- <div id="x-down-2"> -->
	    		 <div class="news-nav" style="margin-left:138px;">
                    <ul class="g-c">
                        <li class="news-li-active"><a href="getCollectNews_UserCenterAction?user.id=${otherUser.id }" target="userZone">收藏</a></li>
                        <li><a href="getDongTai_UserCenterAction?user.id=${otherUser.id }" target="userZone">动态</a></li>
                    <c:if test="${currUser.id==otherUser.id }">
                        <li><a href="loadget">私信</a></li>
                        </c:if>                       
                    </ul>
                </div>        
	    	<!-- </div> -->
	    	
	    	<div id="x-down-3">
	    		<div>	    	
		    		<a href="loadFollowUser_UserCenterAction?user.id=${otherUser.id }" target="userZone">
		    		<li style="font-size: 22px;font-weight: bold;margin-left: 40px;">${followUserCount}</li>
		    		<span style="color: gray;margin-top: -25px;margin-left: 75px;display: block;">关注的人</span></a>
	    		</div>
	    		<hr style="width: 1px;height: 30px;margin-left: 170px;margin-top: -25px;" />	    		
	    		<div>
		    		<a href="loadFans_UserCenterAction?user.id=${otherUser.id }" target="userZone">
		    		<li style="font-size: 22px;font-weight: bold;margin-left: 200px;margin-top: -30px;">${fansCount}</li>
		    		<span style="color: gray;margin-top: -25px;margin-left: 240px;display: block;">粉丝</span></a>
	    		</div>
	    	</div>	    	
	    	<div id="x-down-4">
	    		<iframe name="userZone" src="frames/shoucang.jsp" style="width:688px;height:600px;" ></iframe>
	    	</div>
	    </div>
</div>
</body>
</html>
