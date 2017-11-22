<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>先知</title>
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="css/common.css"/>
    <link rel="stylesheet" href="css/index.css"/>
    <script src="js/jquery-3.2.1.js"></script>
	<script src="js/jquery.timeago.js"></script>   
    <script type="text/javascript"> 
    	$(function() {
	  	$('.timeago').timeago();
		});
		function tijiao(){
		var keyword = document.getElementById("keyword").value;
		window.location.href="search_NewsAction?keyword="+keyword;
		}
    </script>
    <style type="text/css">
    	.timeago{
    		font-size:14px;
    		color:gray;
    	}
    	.s-name{
    	margin-left:10px;
    	}
    #lunbo ul li{width:100%;list-style: none;width:500px; height:300px;background-color: whitesmoke;text-align: center;}
    #lunbo ul li:not(:first-child){display: none;}
    .banner .img img{width:500px; height:300px;}
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
    	top:270px;
    	color: white;
    	font-weight:900;
    	white-space:nowrap;
    }
    
    </style>

</head>
<body>
<div class="g-container">
    <header title="头部导航条" class="g-minwidth" id="header" name="header">    
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
            <li><a>联系我们</a></li>
            <li class="a-header3"><a href="login.jsp">退出</a></li>
        </ul>      
    </header>
    <div class="g-content">
        <div class="g-context g-c">
            <div class="index-lf-zhanwei"></div>
            <div class="index-lf">
                <a href="#">
                <p style="font-weight:800;font-size: 35px;color: #ED4040;margin-left: 0px;">先知</p>
                </a>
                <ul>
					<c:choose>
						<c:when test="${empty classifyList }">
							<li>加载失败</li>
						</c:when>
						<c:otherwise>
						<li>
							<a <c:if test="${empty currClassify }">class="i-active"</c:if>
							 href="Index_preIndexAction">全部</a>
						</li>
					 	<li><a href="getVideoList_preIndexAction">视频</a></li>
							<c:forEach items="${classifyList }" var="classify">
							<li>
							<a <c:if test="${currClassify.id == classify.id }">class="i-active"</c:if>
							 href="getNewsListByType_preIndexAction?classify.id=${classify.id }">${classify.name }</a>
							</li>								
							</c:forEach>
						</c:otherwise>
					</c:choose>                                   
                </ul>
            </div>
            <div class="index-md">
                  <!--轮播-->
                <div class="bar-container">
                	<iframe src="frames/lunbo.jsp" style="width:750px;height:330px;margin-left:-85px;" scrolling="no" frameborder="no"></iframe>
                </div>

                <!--列表新闻-->
                <div class="list-news-container">               
                    <ul class="news-list">
                    	<c:choose>
                    		<c:when test="${empty newsList }">
                    			<li>暂无新闻</li>
                    		</c:when>
                    		<c:otherwise>
                    			<c:forEach items="${newsList}" var="news">
                    				 <li style='padding-top: 0'>
                          		  <div class="item-inner-one item-inner-same g-c">
                          	     <div>
                                    <div class="item-inner-img sc-tr">
                                        <a href="getNewsDetail_preIndexAction?news.id=${news.id }" target="_blank">
                                            <img src="${news.img }"/>
                                        </a>
                                    </div>
                                    <div class="item-inner-title">
                                        <span class="item-inner-center">
                                            <a class="it-news-tl" href="getNewsDetail_preIndexAction?news.id=${news.id }" target="_blank">${news.title }</a>
                                            <p class="it-news-footer">
                                                <a class="item-news-type item-news-same" href="getNewsListByType_preIndexAction?classify.id=${news.classify.id }" >${news.classify.name }</a>                                              
                                                <a href="loadCollectNews_UserCenterAction?user.id=${news.author.id }" class="item-news-same item-news-name">${news.author.nickName }</a>
                                                <span class="item-news-same" href="#"><font color="blue">${news.discussCount }</font>&nbsp;评论</span>
                                                &nbsp;
                                                <time class="timeago" datetime="${news.date }"></time>                 
                                            </p>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </li>                      
                    			</c:forEach>
                    		</c:otherwise>
                    	</c:choose>                      
                        <li>
                            <div class="r-hist">
                                <a href="#">点击加载更多</a>
                            </div>
                        </li>

                    </ul>
                </div>
            </div>
            <div class="index-rg">
                <!--搜索框-->
                <div class="s-form">
                   <div class="s-form-center">
                    <form action="search_NewsAction" method="post">
	                        <input type="text" placeholder="请输入关键字" class="s-input" id="keyword" name="keyword"/>
	                        <img src="images/ic_serach_pub.png" class="s-search"  onclick="tijiao()"/>
                    </form>
                    </div>
                 
                    <ul class="s-search-lianxiang">
                    <c:choose>
                    	<c:when test="${empty hotNewsList }">
                    		 <li class="search-item">
                            <a href="#">
                                <i class="search-no search-no-1"></i>
                                <span class="search-txt">暂无热词</span>
                            </a>
                        </li>
                    	</c:when>
                    	<c:otherwise>
                    		<c:set var="index" value="0"/>
                    		<c:forEach items="${hotNewsList }" var="hotNews">
                    		<c:set var="index" value="${index+1}"/>
                    			  <li class="search-item">
                            		<a href="getNewsDetail_preIndexAction?news.id=${hotNews.id }" target="_blank">
                               			 <i class="search-no search-no-1">${index }</i>
                                		<span class="search-txt">${hotNews.title }</span>
                           			</a>
                       			 </li>                   		
                    		</c:forEach>
                    	</c:otherwise>
                    </c:choose>
                   </ul>
                </div>

               

                <!--热门视频-->
                <div class="r-news-list">
                    <div class="r-list-lf">
                        <b>热门视频</b>
                        <ul class="video-list">
                        <c:choose>
                        	<c:when test="${ empty hotVideoList }">
                        		<li>暂无热门视频</li>
                        	</c:when>
                        	<c:otherwise>
                        		<c:forEach items="${hotVideoList }" var="hotVideo">
                        			<li>
                                <div class="video-item g-c">
                                    <div class="video-item-lf">
                                        <div class="cell">
                                             <a href="getVideoDetail_preIndexAction?video.id=${hotVideo.id }" target="_blank">
                                            <h4>${hotVideo.title }</h4></a>
                                            <p>
                                                <span>${hotVideo.clickCount }次播放&nbsp;</span> <span>⋅&nbsp;${hotVideo.discussCount }评论</span>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="video-item-rg">
                                        <a class="sc-tr v-pic" href="getVideoDetail_preIndexAction?video.id=${hotVideo.id }" target="_blank">
                                            <img src="${hotVideo.picture }"/>
                                            <div class="stop_video">
                                                <img src="img/bofang.png"/>
                                                <!-- <span>06:24</span> -->
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </li>                           
                        		</c:forEach>
                        	</c:otherwise>
                        </c:choose>          
                        </ul>
                    </div>
                </div>
            </div>
            <div class="back-top">
                <span class="top-sam">刷新</span>
                <a class="top-sam" href="#header">向上</a>
            </div>
        </div>
    </div>
</div>
</body>
<script src="js/indexScrollControll.js"></script>
<script src="js/index.js"></script>
</html>