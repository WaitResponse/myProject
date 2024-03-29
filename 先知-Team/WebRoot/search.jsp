<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
      <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="css/common.css"/>
    <link rel="stylesheet" href="css/index.css"/>
    <link rel="stylesheet" href="css/templatePic.css"/>
    <script src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript"> 
    	
	function tijiao(){
	var keyword = document.getElementById("keyword").value;
		window.location.href="search_NewsAction?keyword="+keyword;
	}		
    </script>
</head>
<body>
<div class="g-container" style="width: 100%;height: auto;">
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
				<c:when test="${empty currUser}">
					<a href="login.jsp">登录</a>
				</c:when> 
				<c:otherwise>
					 <c:if test="${empty currUser.headImg}">
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
            <li class="a-header3"><a>退出</a></li>
        </ul>
       
    </header>
    <div class="midbar-wrapper">
        <div class="midbar-inner g-c">
            <a href="index.jsp"><img src="images/logo.png" class="inner-logo left" style="margin-left: -20px;"/></a>
            <!--搜索框-->
            <div class="s-form left">
                <div class="s-form-center">
                    <form action="search_NewsAction" method="post">
	                        <input type="text" placeholder="请输入关键字" class="s-input" id="keyword" name="keyword"/>
	                        <img src="images/ic_serach_pub.png" class="s-search"  onclick="tijiao()"/>
                    </form>
                </div>
            </div>
        </div>
        
    </div>
    
    <div class="news-nav" style="width: 1000px;margin: 15px auto">
        <ul class="g-c">
            <li class="news-li-active">新闻</li>
            <li><a href="frames/personSearch.jsp">用户</a></li>
            <li><a href="frames/videoSearch.jsp">视频</a></li>
        	
        </ul>
    </div>
    <!--新闻-->
    
  <div class="list-news-container" style="margin-left: 180px;">
       <ul class="news-list">
       
		<c:choose>
			<c:when test="${empty newsList2 }">
				<li>暂无新闻</li>
			</c:when>
			<c:otherwise>
				<c:forEach items="${newsList2 }" var="news3">
						<div class="item-inner-img sc-tr">
                             <a href="getNewsDetail_preIndexAction?news.id=${news3.id }" target="_blank">
                                 <img src="${news3.img }"/>
                             </a>
                        </div>
                        <div class="item-inner-title">
							<span class="item-inner-center">
                                <a class="it-news-tl" href="getNewsDetail_preIndexAction?news.id=${news3.id }" target="_blank">
                                ${news3.title }</a>
                                <p class="it-news-footer">
                                <a class="item-news-same">${news3.author.nickName}</a> 
                                <a class="item-news-same" href="#"><font color="blue">${news3.discussCount }</font>&nbsp;评论</a>
                                <span class="item-news-same">${news3.date }</span>
                                </p>
                            </span>
						</div> 
				</c:forEach>
			</c:otherwise>
		</c:choose> 
           			</ul>     
                </div>  
                        
</div>
<script src="js/index.js"></script>
<script src="js/templatePic.js"></script>
<script>
    let $newsNav = $('.news-nav');
    let $newsNavTop = $newsNav.offset().top;
    let $newsNavHeight = $newsNav.outerHeight(true);
    let $newsNavZhanWei = $('.news-nav-zhanwei');
    let windowBarTop;
    $(window).scroll(function (e) {
      windowBarTop = $(document).scrollTop();
      if(windowBarTop >= $newsNavTop+$newsNavHeight){
        $newsNavZhanWei.css({'display':'block','position':'fixed','top':'0'});
      }else{
        $newsNavZhanWei.css('display','none');
      }
    });
</script>
</body>
</html>
