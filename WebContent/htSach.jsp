<%@page import="bo.GioHangBo"%>
<%@page import="bean.loaiBean"%>
<%@page import="bo.loaiBo"%>
<%@page import="bean.sachBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.sachBo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<link rel='stylesheet' href='style.css'>
<link rel="stylesheet" media="screen"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">

<title>Cửa hàng sách</title>
</head>
<body>
	<%
		response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");
	int n = (int) request.getAttribute("n");
	ArrayList<sachBean> ds = (ArrayList<sachBean>) request.getAttribute("dssach");
	%>
	<%@include file="Header.jsp" %>
	
	<div class="container">
	<div class="row">
		
		<%
			if (n == 0) {
		%>
		<div class="col-md-12 mt-50	">
			<h2>Không tìm thấy sách</h2>
		</div>
		<%
			} else
		%>
		<div class="col-md-12 mt-30">
			<%
				for (int i = 0; i < n; i++) {
			%>
				<div class="col-md-3 mt-30 ">
			<div class="card " style="width: 20em; height: 29em;">
			  
				<%
					sachBean s = ds.get(i);
				%>
				<a href="GioHangController"><img src="<%=s.getAnh()%>"
					style="height: 300px; width: 200px"></img></a>
					<div  >
						<a href="DatmuaController?ms=<%=s.getMaSach()%>&ts=<%=s.getTenSach()%>&tg=<%=s.getTacGia()%>&gia=<%=s.getGia()%>">
					<img src="image_sach/buynow.jpg"></img></a>
					<br>
					Tên:<%=s.getTenSach()%>
					</div>
				<h5>
					Tác Giả:
					<%=s.getTacGia()%></h5>
				<h5>
					Giá:
					<%=s.getGia()%>
					$
				</h5>
			
			</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
	</div>
	
</body>


</html>