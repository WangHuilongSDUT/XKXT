<%@page import="sdut.wsl.model.Student"%>
<%@page import="sdut.wsl.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=Utf8"
    pageEncoding="Utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="Utf8">
<title>Insert title here</title>
</head>
<body>
<%
	StudentDao sd=new StudentDao();
	Student s=sd.find("160506001");
	out.println("姓名："+s.getSname()+"\n性别："+s.getSsex()+"\n年龄："+s.getSage()+"\n专业："+s.getSdept());
%>
</body>
</html>