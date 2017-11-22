// user
$(document).ready(function(){
	var user_Boolean = false;
	var user_loginId = false;
	var password_Boolean = false;
	var varconfirm_Boolean = false;
	var emaile_Boolean = false;
	var Mobile_Boolean = false;
	//用户昵称
	$('.reg_user').blur(function(){
	  if ((/^([\u4E00-\uFA29]*[a-z]*[A-Z]*)+$/).test($(".reg_user").val())){
	    $('.user_hint').html("✔").css("color","green");
	    user_Boolean = true;
	  }else {
	    $('.user_hint').html("×").css("color","red");
	    user_Boolean = false;
	  }
	});
	//loginId
	$('.reg_loginId').blur(function(){
		  if ((/(?!^\d+$)(?!^[a-zA-Z]+$)[0-9a-zA-Z]{4,23}/).test($(".reg_loginId").val())){
		    $('.loginId_hint').html("✔").css("color","green");
		    user_loginId = true;
		  }else {
		    $('.loginId_hint').html("×").css("color","red");
		    user_loginId = false;
		  }
		});
	// password
	$('.reg_password').blur(function(){
	  if ((/^[a-z0-9_-]{6,16}$/).test($(".reg_password").val())){
	    $('.password_hint').html("✔").css("color","green");
	    password_Boolean = true;
	  }else {
	    $('.password_hint').html("×").css("color","red");
	    password_Boolean = false;
	  }
	});


	// password_confirm
	$('.reg_confirm').blur(function(){
	  if (($(".reg_password").val())==($(".reg_confirm").val())){
	    $('.confirm_hint').html("✔").css("color","green");
	    varconfirm_Boolean = true;
	  }else {
	    $('.confirm_hint').html("×").css("color","red");
	    varconfirm_Boolean = false;
	  }
	});


	// Email
	$('.reg_email').blur(function(){
	  if ((/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/).test($(".reg_email").val())){
	    $('.email_hint').html("✔").css("color","green");
	    emaile_Boolean = true;
	  }else {
	    $('.email_hint').html("×").css("color","red");
	    emaile_Boolean = false;
	  }
	});


	// Mobile
	$('.reg_mobile').blur(function(){
	  if ((/^1[34578]\d{9}$/).test($(".reg_mobile").val())){
	    $('.mobile_hint').html("✔").css("color","green");
	    Mobile_Boolean = true;
	  }else {
	    $('.mobile_hint').html("×").css("color","red");
	    Mobile_Boolean = false;
	  }
	});

	$('.red_button').click(function(){
	  if(user_Boolean &&password_Boolean && varconfirm_Boolean && emaile_Boolean && Mobile_Boolean&&user_loginId==true){
	    $("#regist").submit();
	  }else {
	    alert("请完善信息");
	  }
	});

})
