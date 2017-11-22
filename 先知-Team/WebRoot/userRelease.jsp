<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<base href="${pageContext.request.contextPath}/">
		<title></title>
		<link rel="stylesheet" href="css/common.css"/>
    	<link rel="stylesheet" href="css/index.css"/>
	</head>
	<body>
		<!--右边新闻列表-->
                <div class="r-news-list jincai-pic">
                    <div class="r-list-lf r-news-rg">
                    	<div>
	                       <a href="loadCollectNews_UserCenterAction?user.id=${news.author.id }" target="_blank">
	                       <img src="${news.author.headImg }" style="width: 50px;height: 50px;"/></a>
	                       <a><span style="font-weight: bold;">${news.author.nickName }</span></a>
	                       <span style="background-color: #208EDA;width: 75px;height: 25px;color: whitesmoke;font-size: 14px;">+ 关注</span>
                       </div>
                        <ul>
                        <c:choose>
                        	<c:when test="${empty fabuSet }">
                        		    <li>
                                <a class="r-item-container g-c">                                   
                                    <span class="r-news-context">
                                       		作者没有更多作品了
                                    </span>
                                </a>
                            </li>
                        	</c:when>
                        	<c:otherwise>
                        		<c:forEach items="${fabuSet }" var="fabuNews">
                        		 <li>
                                <a class="r-item-container g-c" href="getNewsDetail_preIndexAction?news.id=${fabuNews.id }" target="_blank">
                                    
                                    <span class="r-news-context">
                                        ${fabuNews.title}
                                    </span>
                                </a>
                            </li>
                        		
                        		</c:forEach>
                        	</c:otherwise>
                        </c:choose>
                           
                      
                            
                        </ul>
                    </div>
                </div>
	</body>
</html>
