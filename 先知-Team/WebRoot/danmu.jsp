<%@page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/">
<title>Insert title here</title>
<link rel="stylesheet" href="css/common1.css" />
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript">
var w,h,className;
function getSrceenWH(){
	w = $(window).width();
	h = $(window).height();
	$('#dialogBg').width(w).height(h);
}

window.onresize = function(){  
	getSrceenWH();
}  
$(window).resize();  

$(function(){
	getSrceenWH();
	
	//显示弹框
	$('.box1 a').click(function(){
		className = $(this).attr('class');
		$('#dialogBg').fadeIn(300);
		$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
	});
	
	//关闭弹窗
	$('.claseDialogBtn').click(function(){
		$('#dialogBg').fadeOut(300,function(){
			$('#dialog').addClass('bounceOutUp').fadeOut();
		});
	});
});
</script>
<style type="text/css">
	
	iframe{
		
		background-color:white;
	}
</style>
</head>
<body>
<div id="wrapper">
	
	<div class="box1">
		<div class="demo">
			<a href="javascript:;" class="bounceIn" style="background-color: ghostwhite;color: gray;float: left;margin-left: 200px;margin-top: 190px;">编辑个人资料</a>
		</div>
				<div id="dialogBg"></div>
							<div id="dialog" class="animated">
								<img class="dialogIco" width="50" height="50" src="images/ico.png" alt="" />
								<div class="dialogTop">
									<a href="javascript:;" class="claseDialogBtn">关闭</a>
								</div>
								<form action="" method="post" id="editForm">
									<ul class="editInfos">
										<li><label style="margin-left: -130px;"><font color="#ff0000">* </font>头像：<img src="" style="width: 50px;height: 40px;" /></label></li>
										<li><label><font color="#ff0000">* </font>昵称：<input type="text" name="" required value="" class="ipt" /></label></li>
										<li><label><font color="#ff0000">* </font>性别：<input type="text" name="" required value="" class="ipt" /></label></li>
										<li><label><font color="#ff0000">* </font>年龄：<input type="text" name="" required value="" class="ipt" /></label></li>
										<li><label><font color="#ff0000">* </font>手机：<input type="text" name="" required value="" class="ipt" /></label></li>
										<li><label><font color="#ff0000">* </font>邮箱： <input type="text" name="" required value="" class="ipt" /></label></li>
										<li><input type="submit" value="确认提交" class="submitBtn" /></li>
									</ul>
								</form>
						</div>
					</div>
				</div>
		<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>
</body>
</html>