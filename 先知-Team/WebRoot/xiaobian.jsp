<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<base href="${pageContext.request.contextPath}/">
		<link rel="stylesheet" href="css/xiaobian.css">
		<link rel="stylesheet" href="css/bootstrap.min.css">	
		<script src="js/jquery-2.1.0.min.js"></script>
		<script src="js/bootstrap.min.js"></script>		
 <script type="text/javascript" charset="utf-8" src="kindeditor-4.1.10/kindeditor.js"></script>      
<script type="text/javascript" charset="utf-8" src="kindeditor-4.1.10/lang/zh_CN.js"></script> 
<script type="text/javascript">
    KindEditor.ready(function(K) {
      		 K.create('#pubcontent', {  
         		 uploadJson : 'kindeditor-4.1.10/jsp/upload_json.jsp',  
        		  fileManagerJson : 'kindeditor-4.1.10/jsp/file_manager_json.jsp',  
         			allowFileManager : true,
         			afterBlur: function(){this.sync();},
       			  afterCreate : function(){ //kindeditor创建后，将编辑器的内容设置到原来的textarea控件里
              	 this.sync();   
       		 },
     /*    		afterChange: function(){ //编辑器内容发生变化后，将编辑器的内容设置到原来的textarea控件里
               this.sync();   
       	 } */
      	 });  
 		}); 
 		$(document).ready(function(){
 			var msg =''+'${request.msg}';
 			if(msg!=''){
				alert(msg);		
			}
 		});  	
  </script> 
	</head>	
	<body>
		 <div class="head">	
		 	   <li class="tianqi">
               <a class="a-header">
                <iframe width="150" scrolling="no" height="70" frameborder="0" allowtransparency="true" style="margin-top: 5px;"
	    			src="http://i.tianqi.com/index.php?c=code&id=11&color=%230070C0&icon=1&site=15">
	    		</iframe>
                </a>
            </li>
            </div>
          <div class="user-nav">
          	<p><a href="personal.jsp"><img src="img/1.jpg"></a>
          	<span><a href="personal.jsp">${currUser.nickName }</a></span>
          	<span><a>投诉反馈</a></span>
          	<span><a href="login.jsp">退出</a></span>
          	</p>
          </div>		  
		 <div class="middle">
		 	<p>编辑新闻</p>
		 </div>
		 <hr style="height:2px;border:none;border-top:1px solid #555555;width:100%;"/>
	<div class="editNews" id="uploadVideo">
		<form role="form" action="upload_uploadNewsAction" enctype="multipart/form-data" method="post">
		<div class="form-group">
			<label for="name" style="font-size:18px;font-weight: normal;">标题</label>
			 <input type="text" class="form-control" id="name" name="news.title" placeholder="请输入标题">
		</div>
		<div class="form-group">
			<label for="inputfile"style="font-size:18px;font-weight: normal;">上传封面</label> <input type="file" id="inputfile" name="image">
		</div>
		<div class="form-group">
			<label for="name" style="font-size:18px;font-weight: normal;">选择分类</label>
    		<select class="form-control" id="newsClassify" name="classify.id">
		      <option>未选择</option>
		      <c:choose>
		      	<c:when test="${empty classifyList }">
		      		<option>加载失败</option>
		      	</c:when>
		      	<c:otherwise>
		      		<c:forEach items="${classifyList }" var="classify">
		      			<option value="${classify.id }" >${classify.name }</option>
		      		</c:forEach>
		      	</c:otherwise>
		      </c:choose>
		    </select>
		</div>
		<div class="form-group">
    		<label for="name" style="font-size:18px;font-weight: normal;">请输入内容</label>
    	<textarea class="form-control" rows="15" name="news.content" id="pubcontent"></textarea>
  		</div>
  		<div class="form-group" id="formgroup">
			<button type="submit" class="btn btn-primary">上传</button>
  			<button type="reset" class="btn btn-primary">重置</button>
  		</div> 	
	</form>
	 </div>
	</body>
</html>
