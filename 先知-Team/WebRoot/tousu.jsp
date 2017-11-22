<%@page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
	<head>
		<base href="${pageContext.request.contextPath}/">
		<title>侵权投诉-先知</title>
		
			<style>
			.show{ position:relative; width:100px; height:20px; background:#000000; text-align:center; line-height:20px; margin-left: 1075px;margin-top: -9px;}
			.show a{ color:white;}
			.hidden{ position:absolute; top:21px; left:0; background:#C0C0C0 ; border: 1px solid #C0C0C0;}
			.hidden a{ display:inline-block; }
			 </style>
		<script>
				function showhid(id) {
					document.getElementById(id).style.display = 'block';
				}
			
				function showhid2(id) {
					document.getElementById(id).style.display = 'none';
				}
        </script>
			<style>
			/*body{ font-size:12px;}*/
			.show1{ position:relative; width:100px; height:20px;  text-align:center; line-height:20px; margin-left: 650px;margin-top: -12px;}
			.show1 a{ color:white;}
			.hidden1{ position:absolute; top:24px; left:30px; background:#C0C0C0 ; border: 1px solid #C0C0C0;}
			.hidden1 a{ display:inline-block; ;}
			 </style>
			<script>
			function showhid3(id){
			 document.getElementById(id).style.display ='block';
			}
			function showhid4(id){
			 document.getElementById(id).style.display ='none';
			}
			
			</script>
		
		
		<style type="text/css">
			body{
				margin: 0;
				padding: 0;
			}
			.div1{
				width:100%;
				height: 1300px;
				background-color: lightgrey;
			}
			.div2{
				float: left;
				width:80%;
				height:1100px ;
				margin-left: 10%;
				margin-top: 40px;
				background-color: white;
			}
			.div3{
				background-color: white;
				font-size: 45px;
				width: 100%;
				height: 60px;
				color:#ed4040;
				margin-top: -8px;
			}
			.a-img{
				width: 40px;
				height: 35px;
				margin-left: 0px;
			}
			#d-img{
				margin-left: -50px;
				margin-top: 10px;
			}
			.l-img{
				float: left;
				margin-left: 100px;
				width: 200px;
				height: 50px;
			}
		</style>
	</head>
	<body>
	
		<div class="div1">
			<hr style="background-color:#ed4040;width: 100%;height: 5px;margin-top: 3px;"/>
			<div class="div3"><a href="#"><img src="images/logo-33.png" class="l-img" /></a>
						
				<a class="c1" href="?"style="text-decoration: none;position: absolute;left: 1005px;">
				<div style="position: absolute;top:18px;background-color: white;" class="show" onmouseover="showhid('downmenu1')" onmouseout="showhid2('downmenu1')">
                <div id="d-img"><a><img src="images/21.jpg" class="a-img"/></a></div>
                <a class="div4" style="text-decoration: none;font-size: 20px;color: #000000;position: absolute;top: 18px;width: 100px;" href="#" class="add" onclick="showhid('downmenu1');">${currUser.nickName }</a>
                <div class="hidden" id="downmenu1" style=" display:none;font-size: 18px;margin-top: 33px;margin-left: 50px;width: 100px;background-color: black;">
				        <span style="color:#C0C0C0 ;">
				          <a name="a"href="#"style="text-decoration: none;">个人中心</a>
				          <a name="d"href="#" style="text-decoration: none;">退出</a>
				        </span>
				          
         			</div>
    				</div>
				
				
			</div>
			<div class="div2">
				
				<div style="width: 80%;margin-left:10%;margin-top:60px;font-size: 16px; border: 0px solid red;">&#8195;&#8195;&#8195;先知为中立的网络平台服务提供者，收到符合要求的投诉通知后， 将按照相关法律法规的规定及时受理，
					请您务必完整、准确、真实填写以下信息，以提高投诉被受理的成功率。
				</div>
					
					<div style="width: 85%;border: 0px solid lightgrey;margin-left: 7.5%;margin-top: 100px;background-color:lightgrey;">
						<div style="width: 100px;border: 1px solid red;">
							
						</div>
					</div>
					<div style="margin-left: 7.5%;margin-top: 20px;color: #ed4040;font-size: 23px;">投诉内容
					</div>
					<div>
						<!--<div style="font-size: 18px;margin-top: 20px;margin-left: 7.9%;">投诉分类
							<!--<a href="6.html" style="text-decoration: none;color: #000000; margin-left: 100px;" target="main">冒充他人/占用头条号名称</a>-->
							<!--<a href="7.html" style="text-decoration: none;color: #000000;margin-left: 100px;" target="main">其它</a>
						</div>-->
						 <div style="width: 90%;margin-left:5%;height:700px;background-color: white;border: 0 px solid red;">
		 					<iframe scrolling="no" name="main" src="tousunr.jsp"style="width: 100%; margin-left:0%;height: 800px;border: 0px solid red;"frameborder="no">
		 						
		 					</iframe>
		 				</div>
					</div>
				</div>
				
		</div>
		
		
	</body>
</html>
