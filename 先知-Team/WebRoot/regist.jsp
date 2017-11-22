<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <base href="${pageContext.request.contextPath}/">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <!-- 重置文件 -->
  <link rel="stylesheet" href="css/normalize.css">
  <link rel="stylesheet" href="css/regist.css">
  <title>用户注册</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function toLogin(){
		window.location.href="login.jsp";
	};
	$(document).ready(function(){
		var msg =""+ '${request.Msg }';
		if(msg!=''){
			alert(msg);		
		}
	});
</script>
</head>

<body>
   <div class="reg_div">
    <p>注册</p>
    <form action="regist_UserAction" method="post" id="regist">
   <ul class="reg_ul">
      <li>
          <span>账号：</span>
          <input type="email" name="user.loginId" value="" placeholder="字母开头(只能包含字母和数字)" class="reg_loginId">
          <span class="tip loginId_hint"></span>
      </li>
       <li>
          <span>昵称：</span>
          <input type="text" name="user.nickName" value="" placeholder="中文或字母(不能包含特殊字符)" class="reg_user">
          <span class="tip user_hint"></span>
      </li>
      <li>
          <span>密码：</span>
          <input type="password" name="user.pwd" value="" placeholder="6-16位密码" class="reg_password">
          <span class="tip password_hint"></span>
      </li>
      <li>
          <span>确认密码：</span>
          <input type="password" name="" value="" placeholder="确认密码" class="reg_confirm">
          <span class="tip confirm_hint"></span>
      </li>
 	  <li>
          <span>邮箱：</span>
          <input type="text" name="userDetail.mailbox" value="" placeholder="邮箱" class="reg_email">
          <span class="tip email_hint"></span>
      </li> 
      <li>
          <span>手机号码：</span>
          <input type="email" name="userDetail.tel" value="" placeholder="手机号" class="reg_mobile">
          <span class="tip mobile_hint"></span>
      </li>
      <li>
      <button type="button" name="button" class="red_button" onclick="regist(this.form)">注册</button>
      <button type="button" name="button" class="button" onclick="toLogin()">已有账号，返回登录</button>
      </li>
    </ul>
  </form>
   <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/regist.js"></script>

  </div> 

</body>
</html>

