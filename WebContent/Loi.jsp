<%@page import="controller.Loi"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<% 
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String loi = request.getParameter("loi");
%>	
	<%if(loi!=null){ 
		switch(loi){
		case("trungTK"):
			out.print("<h2 >Bạn đã nhập trùng tài khoản, xin mời nhập lại<h2>");
			break;
		default:
			out.print("<h2 >Có lỗi xảy ra xin thử lại sau<h2>");
			break;
		}
	}
	%>
	
	
	
</body>
</html>