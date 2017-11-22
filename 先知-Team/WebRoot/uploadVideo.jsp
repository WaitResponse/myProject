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
<script type="text/javascript">
	      
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
		 	<p>上传视频</p>
		 </div>
		 <hr style="height:2px;border:none;border-top:1px solid #555555;width:100%;"/>
		 	 
	<div class="editNews">
	 <form id="form1" action="upload_uploadVideoAction" method="post" enctype="multipart/form-data">
		 <div class="form-group">
			<label for="name" style="font-size:18px;font-weight: normal;">标题</label>
			 <input type="text" style="width:500px;" class="form-control" id="videoTitle" name="video.title" placeholder="请输入标题">
		</div>
		<div class="form-group">
			<label for="name" style="font-size:18px;font-weight: normal;">上传封面</label>
			<input type="file" name="picture">
		</div>
		<div class="form-group">
			<label for="name" style="font-size:18px;font-weight: normal;">视频描述</label>
			<span style="font-size:13px;font-weight:light;color:#6C6C6C">(100字以内)</span> 			
			 <textarea class="form-control" id="videoDetail" rows="3" style="width:500px;" name="video.detail"></textarea>
		</div>
		<div class="form-group">
			<label for="name" style="font-size:18px;font-weight: normal;">上传视频</label>
			<span style="font-size:13px;font-weight:light;color:#6C6C6C">(仅支持mp4,webm,ogg格式,大小限制为500M以内)</span> 
			<input type="file" name="file">
		</div>
      	<div class="form-group" id="formgroup1">
			<button type="submit" class="btn btn-primary" id="tijiao">上传</button>
  			<button type="reset" class="btn btn-primary" id="chongzhi">重置</button>
  		</div> 	
	</form> 		
	</div>
	 	<!-- <div class="form-group">
			<span id="spanButtonPlaceHolder"></span>
			<input id="btnCancel" type="button" value="取消上传" onclick="swfu.cancelQueue();" disabled="disabled" style="margin-left: 2px; font-size: 8pt; height: 29px;" />
	  </div> --> 
	</body>
</html>
