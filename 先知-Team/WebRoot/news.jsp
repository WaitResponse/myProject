<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.Date" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">
<head>
  <base href="${pageContext.request.contextPath}/">
    <title>${news.title }</title> 
    <link rel="stylesheet" href="css/common.css"/>
    <link  rel="stylesheet" href="css/main.css" />
    <link  rel="stylesheet" href="css/news.css" />
	<link rel="stylesheet" type="text/css" href="css/sinaFaceAndEffec.css" />	   
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/jquery.timeago.js"></script>
	<script type="text/javascript"> 
    $(function(){
	  		$('.timeago').timeago();
			});
    </script>
    <style type="text/css"></style>
</head>
<body>

	<div class="g-container">
	    <header title="头部导航条" class="g-minwidth" id="header" name="header">
	        <ul>
	            <li class="h-tianqi">
	               <a class="a-header">
	                    <iframe  width="150" scrolling="no" height="70" frameborder="0" allowtransparency="true" style="margin-top: 5px;"
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
	        </ul>
	    </header>
	 </div>
	<div class="a_top">   
		<a href="index.jsp"><p class="a-xianzhi">首页</p></a>
		<a href="getNewsListByType_preIndexAction?classify.id=${news.classify.id }"><p class="a-sy">${news.classify.name }</p></a>
		<p class="a-zw">/正文</p>
		<hr class="a-hr"/>
	</div>     

	<div id="div_right">
		<iframe class="user-context" frameborder="0" scrolling="no" marginwidth="0" marginheight="0"  width="330px" height="auto" src="userRelease.jsp" style="float: right;">
		</iframe>
	</div> 
    
       <div class="n-title">${news.title }</div>
       <span style="width:50px;height:15px;margin-left:170px;font-size:15px;">浏览量:${news.visitCount}</span>
       <div class="news-jieshao-cont">
    	<!-- <iframe src="frames/newsDetail.jsp" style="width:716px;height:auto;overflow:hidden;"></iframe> -->
      	${news.content }
       </div>
       	
       	
       <c:choose>
				<c:when test="${empty collectNews}">				  
					<a href="collectionNews_UserAction?news.id=${news.id}"> 

				<span class="s-sc">收藏</span>
					</a>
				</c:when>
				<c:otherwise>
					<c:forEach items="${collectNews}" var="collectNews">
						<c:choose>
							<c:when test="${news.id == collectNews.id}">
								<c:set var="flag" value="1"/>	
							</c:when>
						</c:choose>
					</c:forEach>
				</c:otherwise>
			</c:choose>
       
   <div class="div_bottom">   
      <div id="div2" style="margin-left: 20px;">
			<p style="color:red ;font-size: 18px;">${news.discussCount }</p><p style="font-size: 18px;color: darkslategray;margin-left: 15px;margin-top: -24px;">条评论</p>
	  </div>
	  
		<div id="content" style="width: 700px; height: auto;margin-top:30px;">
			<div class="wrap">
				<div class="comment">
					<div class="head-face">
						<img src="${currUser.headImg }" / >
						<p>${currUser.nickName }</p>
					</div>
					<div class="content">
					<form actinon="addDiscuss_preIndexAciton" method="post">
						<div class="cont-box">
							<textarea class="text" name="discuss.content" placeholder="请输入..."></textarea>
						</div>
						<div class="tools-box">
							<div class="operator-box-btn"><span class="face-icon">☺</span><span class="img-icon">▧</span></div>
							<div class="submit-btn"><input type="button" value="提交评论" onClick="out()" /></div>
						</div>
						</form>
					</div>
				</div>
				<div id="info-show">
					<ul>
						<c:choose>
							<c:when test="${ empty discussSet }">
								<li>暂无评论</li>				
							</c:when>
							<c:otherwise>
							<c:forEach items="${discussSet }" var="discuss">
								<li>
									<div class="head-face">
										<img src="${discuss.author.headImg}" />
									</div>
									<div class="reply-cont">
										<p class="username">${discuss.author.nickName}</p>
										<p class="comment-body">${discuss.content }</p>
										<p class="comment-footer">
										<time class="timeago" datetime="${discuss.date }"></time>
										&nbsp;&nbsp;&nbsp;
										<span>${discuss.replyCount }回复　点赞0</span>　
										</p>								
									</div>
								</li>
							</c:forEach>
							</c:otherwise>
						</c:choose>					
					</ul>
				</div>
			</div>
		</div>
		
   </div> 
</body>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/sinaFaceAndEffec.js"></script>
	<script type="text/javascript">
		// 绑定表情
		$('.face-icon').SinaEmotion($('.text'));
		// 测试本地解析
		function out() {
			var inputText = $('.text').val();
			$('#info-show ul').append(reply(AnalyticEmotion(inputText)));
		}		
		var html;
		function reply(content){
			html  = '<li>';
			html += '<div class="head-face">';
			html += '<img src="${currUser.headImg}" / >';
			html += '</div>';
			html += '<div class="reply-cont">';
			html += '<p class="username">${currUser.nickName}</p>';
			html += '<p class="comment-body">'+content+'</p>';			
			html += '<p class="comment-footer"><span><% out.print(new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())); %></span>　0回复　点赞0　</p>';
			html += '</div>';
			html += '</li>';
			return html;
		}
	</script>
</html>
