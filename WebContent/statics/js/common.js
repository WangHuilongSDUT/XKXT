window.servername="http://localhost:8080/XKXT/";
$(document).ready(function(){
	//若user存在 则修改标题
	if(null!=$.cookie("user"))
	{
		$("#header").text("学生选课系统（"+$.cookie("user")+"）");
	}
});