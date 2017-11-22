<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<style type="text/css">
			.div0{
				/*float: left;*/
				padding: 0;
				margin: 0;
				border: 0px solid red;
				width: 100%;
				height: 100%;
				
			}
			.div1{
				margin-left: 300px;			
			}
			.div1 textarea{
				font-size: 25px;
				border: 1px solid royalblue;
				font-family: "微软雅黑";
			}
			.div6{
				width: 77px;
				height: 40px;
				font-size: 16px;
				margin-left: 450px;
				border-radius: 5px;
				margin-top: 10px;
			}
			.div7{
				width: 77px;
				height: 40px;
				font-size: 16px;
				border-radius: 5px;
				margin-left: 100px;
			}
		</style>
	</head>
	<body>
		<div class="div0">
				<div class="div1">
					<textarea rows="2" cols="45">${news2.title}</textarea>
				</div>
				<div style="margin-left: 300px;color: #808080;margin-top: 15px;">
					<h4>${news2.author.nickName }  ${news2.date }</h4>
				</div>
				<div style="margin-left: 300px;margin-top: 15px;">
					<textarea rows="40" cols="84"">
						
					</textarea>
				</div>
				<div>
					<input class="div6" type="button" value="通过审核"/>
					<input class="div7" type="button" value="返回"/>
					<hr style="margin-left: 300px;width: 620px;" />
				</div>
					<div style="margin-left: 320px;color: red;font-size: 20px; ">
					${news2.discussCount } <span style="color:teal;">条评论</span>
					<br />
					<br />
					<div>
						<a href=""><img src="img/h10.jpg"style="width: 30px;border-radius: 50px;float: left;" /></a>
						<a href="#"><span style="border: 0px solid red; float: left;margin-top: 5px; margin-left: 10px;color: #406599;">F222222</span></a>
						<span style="float: left;margin-top: 5px;color: #777;margin-left: 10px;">1天前</span>
						
					</div>
					
					<div style="border: 0px solid red;margin-left: 50px;margin-top: 50px;color: black;font-size:16px ;">花钱去看一群韩国人在中国鸟巢打比赛?</div><br />
					<div class="panel-group" id="accordion">
						<div class="panel panel-default"style="border: 0px solid red;width: 550px;margin-left: 38px;margin-top: -30px;">
						<div class="panel-heading"style=" border: 0px solid green;background-color: white;color: #406599;">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" 
								   href="#collapseTwo"style="text-decoration: none;">
									20条回复
								</a>
							</h4>
						</div>
					<div id="collapseTwo" class="panel-collapse collapse">
						<div class="panel-body">
							<a href="#"><img src="img/h11.jpg" style="width: 30px;border-radius:50px ;float: left;" /></a>	
							<a href="#" style="margin-left: 5px;text-decoration: none;float: left;">gao123</a>
							<span style="float: left;margin-top: 5px;color: #777;margin-left: 10px;font-size: 14px;">1天前</span>
							</div>
							<div style="margin-left: 20px;color: black;font-size: 16px;">
								就服丑开花了大钱买了辆私人公交车
							</div>
							<br />
							<div>
								<a href="#"><img src="img/h11.jpg" style="width: 30px;border-radius:50px ;margin-left: 15px;float: left;" /></a>
								<a href="#" style="margin-left: 5px;text-decoration: none;float: left;">gao123</a>
								<span style="float: left;margin-top: 5px;color: #777;margin-left: 10px;font-size: 14px;">1天前</span>
							</div>
							
							<div style="margin-left: 20px;color: black;font-size: 16px;margin-top: 50px;">
								就服丑开花了大钱买了辆私人公交车
							</div>
							<br />
							<div>
								<a href="#"><img src="img/h6.jpg" style="width: 30px;border-radius:50px ;margin-left: 15px;float: left;" /></a>
								<a href="#" style="margin-left: 5px;text-decoration: none;float: left;">1144123</a>
								<span style="float: left;margin-top: 5px;color: #777;margin-left: 10px;font-size: 14px;">48分钟前</span>
							</div>
							<div style="margin-left: 20px;color: black;font-size: 16px;margin-top: 50px;">
								是滴//@<a href="#"style="color: black;">gao123:</a> 就服丑开花了大钱买了辆私人公交车
							</div>
							<br />
							<div>
								<a href="#"><img src="img/h11.jpg" style="width: 30px;border-radius:50px ;margin-left: 15px;float: left;" /></a>
								<a href="#" style="margin-left: 5px;text-decoration: none;float: left;">gao123</a>
								<span style="float: left;margin-top: 5px;color: #777;margin-left: 10px;font-size: 14px;">1天前</span>
							</div>
							<div style="margin-left: 20px;color: black;font-size: 16px;margin-top: 50px;">
								就服丑开花了大钱买了辆私人公交车
							</div>
						</div>
						
					</div>
					
						<div>
						<a href=""><img src="img/h10.jpg"style="width: 30px;border-radius: 50px;float: left;" /></a>
						<a href="#"><span style="border: 0px solid red; float: left;margin-top: 5px; margin-left: 10px;color: #406599;">F1111</span></a>
						<span style="float: left;margin-top: 5px;color: #777;margin-left: 10px;">6小时前</span>
						</div>
						<div style="border: 0px solid red;margin-left: -125px;margin-top: 50px;color: black;font-size:16px ;float: left;">
							花钱去看一群韩国人在中国鸟巢打比赛?
						</div>
						<br />
					<div class="panel panel-default" style="border: 0px solid red;margin-top: 40px;margin-left: 38px;width: 550px;">
						<div class="panel-heading"style="border: 0px solid royalblue;background-color: white;text-decoration: none;color: #406599;">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" 
								   href="#collapseThree">
									48条回复
								</a>
							</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse">
							<div class="panel-body">
								
							<a href="#"><img src="img/h11.jpg" style="width: 30px;border-radius:50px ;float: left;" /></a>	
							<a href="#" style="margin-left: 5px;text-decoration: none;float: left;">gao123</a>
							<span style="float: left;margin-top: 5px;color: #777;margin-left: 10px;font-size: 14px;">1天前</span>
							</div>
							<div style="margin-left: 20px;color: black;font-size: 16px;">
								就服丑开花了大钱买了辆私人公交车
							</div>
							<br />
								
							</div>
						</div>
					</div>
						
					</div>
				</div>	
		</div>
		<div style="border: 0px solid red;width: 100%;height: 400px;"></div>
	</body>
</html>
