<%@page import="bo.GioHangBo"%>
<%@page import="bean.loaiBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
  <link rel="stylesheet" media="screen" href="//netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
<%
	ArrayList<loaiBean> dsloai = (ArrayList<loaiBean>) request.getAttribute("dsloai");
	GioHangBo Gh = (GioHangBo) session.getAttribute("gh");
	String txtUn =(String) session.getAttribute("txtUser");
 	String active=(String)	request.getAttribute("active");
%>
	<div style="position: fixed; width: 100%;z-index: 1">
	<nav class="navbar navbar-inverse" >
		
		<ul class="nav navbar-nav">
			<li class=<%=active!=null?(active.equals("htsach")?"active":""):""%>><a  href="SachController" ><i class="fas fa-home"></i>Trang chủ</a></li>
			<li  class=<%=active!=null? (active.equals("htgio")?"active":""):""%>>
			<a href="DatmuaController" ><i class="fa fa-cart-plus"></i>Giỏ hàng(<%=Gh!=null?Gh.size():0 %>)
			</a>
			</li>
			<li class=<%=active!=null?(active.equals("cthd")?"active":""):""%>><a  href="HienThiHD" ><i class="fas fa-money-bill"></i>Hóa đơn</a></li>
			
			<li>
				<div class="dropdown mt-10">
					<button class=" dropdown-toggle" type="button"
						data-toggle="dropdown">
						Thể loại <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<%
						if(dsloai!=null)
							for (loaiBean l : dsloai) {
						%>
						<li><a href="SachController?ml=<%=l.getMaloai()%>"><%=l.getTenloai()%></a></li>
						<%
							}
						%>
						<li><a href="SachController?ml=all">Tất cả</a></li>
					</ul>
				</div>
			</li>
			<li>
				<form class="mt-10" method="POST" >
					<input type="search" name="txttk" id="input" required="required" placeholder="Nhập tên sách,tg...">
					<button type="submit" ><i class="fas fa-search"></i></button>
				</form>
			</li>
		</ul >
		<div   align="right" class="mt-10">
					<%if(txtUn==null){ %>
					<a href="DangnhapController" style="color: red">Đăng nhập<span>
					<i class="fas fa-user"></i>
					</span>
					</a>
					<%}else{ %>
					
					<a href="DangXuatController?value=log_out" style="color: red" onclick="showMessage()">Xin chào (<%=txtUn %>)  Đăng Xuất<span>
					<i class="fas fa-user"></i>
					</span>
					</a>
					<%}%>
					
					<a href="DangKyController"><span>
					<i class="fas fa-user-plus">Đăng ký</i>
					</span>
					</a>
			</div>
	</nav>
	</div>
		<script>
			function showMessage(){
				if(confirm("bạn có muốn đăng xuất")){
					
				}else{
					event.preventDefault();
				}
			
			}
		</script>
	<script src="//code.jquery.com/jquery.js"></script>
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>