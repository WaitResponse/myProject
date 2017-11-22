<%@page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
	<head>
		<base href="${pageContext.request.contextPath}/">
		<title></title>
		<style type="text/css">
			#ID1{
				
				position:absolute;
				font-size: 20px;
				float: left; 
				left: 380px;
				top: 720px;
				background-color: #ed4040;
				color: white;
				width: 180px;
				height:50px ;
				border-radius: 15px;
			}
			.red{
				color: red;
				font-weight: bolder;
				font-size: 20px;
				margin-left: 5px;
				display: none;
			} 
			
			
			}
			
			
		</style>
		
		
		<style type="text/css">
				*{
				margin: 0;
				padding: 0;
				}
				#upBox{
				text-align: center;
				width:500px;
				padding: 20px;
				border: 1px solid #666;
				margin: auto;
				margin-top: -55px;
				margin-bottom: 200px;
				position: relative;
				border-radius: 10px;
				}
				#inputBox{
				width: 100%;
				height: 40px;
				border: 1px solid cornflowerblue;
				color: cornflowerblue;
				border-radius: 20px;
				position: relative;
				text-align: center;
				line-height: 40px;
				overflow: hidden;
				font-size: 16px;
				}
				#inputBox input{
				width: 114%;
				height: 40px;
				opacity: 0;
				cursor: pointer;
				position: absolute;
				top: 0;
				left: -14%;
				}
				#imgBox{
				text-align: left;
				}
				.imgContainer{
				display: inline-block;
				width: 32%;
				height: 150px;
				margin-left: 1%;
				border: 1px solid #666666;
				position: relative;
				margin-top: 30px;
				box-sizing: border-box;
				}
				.imgContainer img{
				width: 100%;
				height: 150px;
				cursor: pointer;
				}
				.imgContainer p{
				position: absolute;
				bottom: -1px;
				left: 0;
				width: 100%;
				height: 30px;
				background: black;
				text-align: center;
				line-height: 30px;
				color: white;
				font-size: 16px;
				font-weight: bold;
				cursor: pointer;
				display: none;
				}
				.imgContainer:hover p{
				display: block;
				}
				#btn{
				outline: none;
				width: 100px;
				height: 30px;
				background: cornflowerblue;
				border: 1px solid cornflowerblue;
				color: white;
				cursor: pointer;
				margin-top: 30px;
				border-radius: 5px;
				}
				</style>
				<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	</head>
	<body>
		
		<div style="margin-top: 20px;margin-left: 22px;">
			涉嫌侵权人
			<input type="text" style="width: 78%;height: 35px;border-radius:5px;margin-left: 78px;"placeholder="请输入名字"/>
		</div>
		<div>
			<div style="margin-left: 25px;margin-top: 30px;">
				<span style="">侵权分类</span>
				<span style="margin-left: 90px;">
					<input type="radio"name="分类" checked=""/>冒充他人/占用头条号名称
					<input type="radio"name="分类" />内容涉嫌抄袭
					<input type="radio"name="分类" />内容涉嫌侵犯名誉/肖像/隐私权
					<input type="radio"name="分类" />其他 	
				</span>
					
				
			</div>
		</div>
		
		<div style="margin-top: 30px;margin-left: 22px;">
			<span style="position: absolute;top: 150px; ">投诉描述</span>
				<textarea  style="width: 78%;height: 110px;text-align: left; border-radius:5px;margin-left: 165px;font-size: 18px;"placeholder="请输入内容"></textarea>
				<span id="name" class="red">*</span>
		</div>
		
		<div style="width: 95%;border: 0px solid lightgrey;margin-left: 3%;margin-top: 100px;background-color:lightgrey;">
				<div style="width: 100px;border: 1px solid red;">
				</div>
		</div>
		<div style="margin-top: 25px;margin-left: 35px;font-size: 22px;color: #ed4040">
			证明材料
		</div>
		<div style="margin-top: 35px;margin-left: 35px;font-size: 18px;">
			材料证明
			
			<!--<form enctype="multipart/form-data" id="uploadForm" style="position: absolute;top: 450px; margin-left: 200px;">
				
	       	<input type="file" name="uploadFile" id="upload_file" style="margin-bottom:10px;">
	       
	        <!--<input type="button" id="uploadPicButton" value="上传" onclick="uploadPic()">
			</form>-->
			
				<div style="width: 100%;height: 100vh;position: relative;">
				<div id="upBox">
				<div id="inputBox"><input type="file" title="请选择图片" id="file" multiple accept="image/png,image/jpg,image/gif,image/JPEG"/>点击选择图片</div>
				<div style="font-size:10px ;color: #C0C0C0;">不多于三张图片</div>
				<div id="imgBox">
				</div>
				<!--<button id="btn">上传</button>-->
				</div>
				</div>
				<script src="js/uploadImg.js" type="text/javascript" charset="utf-8"></script>
				<script type="text/javascript">
				imgUpload({
				inputId:'file', //input框id
				imgBox:'imgBox', //图片容器id
				buttonId:'btn', //提交按钮id
				upUrl:'', //提交地址
				data:'file1' //参数名
				})
				</script>			
			
			
			<br />
				<!--<div style="font-size: 16px;color: #999;margin-left: 200px;margin-top: 10px;">个人证明，及侵权证明。</div>-->
		</div>
			
			<input type="button" id="ID1" value="提交" />
	</body>
</html>
