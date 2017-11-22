<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <base href="${pageContext.request.contextPath}/">
 <title>用户注册</title>
<link rel="stylesheet" href="css/common.css"/>
 <link rel="stylesheet" href="css/index.css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<style type="text/css">
</style>
</head>
<body>
 	<!--列表新闻-->
                <div class="list-news-container">               
                    <ul class="news-list">
                    	<c:choose>
                    		<c:when test="${empty collectNews }">
                    			<li>暂无新闻</li>
                    		</c:when>
                    		<c:otherwise>
                    			<c:forEach items="${collectNews }" var="news4">
                    				 <li style='padding-top: 0'>
                          		  <div class="item-inner-one item-inner-same g-c">
                          	     <div>
                                    <div class="item-inner-img sc-tr">
                                        <a href="getNewsDetail_preIndexAction?news.id=${news4.id }" target="_blank">
                                            <img src="${news4.img }"/>
                                        </a>
                                    </div>
                                    <div class="item-inner-title">
                                        <span class="item-inner-center">
                                            <a class="it-news-tl" href="getNewsDetail_preIndexAction?news.id=${news4.id }" target="_blank">${news4.title }</a>
                                            <p class="it-news-footer">
                                                <a class="item-news-type item-news-same" href="getNewsListByType_preIndexAction" >${news4.classify.name }</a>
                                               
                                                <a href="#" class="item-news-same item-news-name">${news4.author.nickName }</a>
                                                <span class="item-news-same" href="#"><font color="blue">${news4.discussCount }</font>&nbsp;评论</span>
                                                &nbsp;
                                                <time class="timeago" datetime="${news4.date }"></time>                 
                                            </p>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </li>
                       
                    			</c:forEach>
                    		</c:otherwise>
                    	</c:choose>                      
                    <!--     <li>
                            <div class="r-hist">
                                <a href="#">点击加载更多</a>
                            </div>
                        </li> -->

                    </ul>
                </div>
            </div>
</body>
</html>