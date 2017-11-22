<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <base href="${pageContext.request.contextPath}/">
        <title>用户登录</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/supersized.css">
        <link rel="stylesheet" href="css/login.css">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript">
        	function toRegist(){
        		window.location.href="regist.jsp";
        	}
        	$(document).ready(function(){
			var msg =""+ '${request.Msg }';
			if(msg!=''){
				alert(msg);		
			}
		});
        </script>
    </head>
    <body>
        <div class="page-container">
            <h1>先知</h1>
            <form action="login_UserAction" method="post">
                <input type="text" name="user.loginId" class="username" placeholder="账号">
                <input type="password" name="user.pwd" class="password" placeholder="密码">
                <button type="submit">登录</button>
                <button type="button" onclick="toRegist()">还没账号？前往注册</button>
                <div class="error"><span>+</span></div>
            </form>
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/supersized.3.2.7.min.js"></script>
        <script src="js/supersized-init.js"></script>
        <script src="js/login.js"></script>
    </body>
</html>
