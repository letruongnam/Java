<%@page import="bo.GioHangBo"%>
<%@page import="bean.loaiBean"%>
<%@page import="bean.sachBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel='stylesheet' href='css/manage.css'>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>


<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<nav class="navbar navbar-default" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="SachController">Cửa hàng Sách</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#">Link</a></li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">Action</a></li>
					<li><a href="#">Another action</a></li>
					<li><a href="#">Something else here</a></li>
					<li><a href="#">Separated link</a></li>
				</ul>
			</li>
		</ul>
	</div><!-- /.navbar-collapse -->
</nav>

    <div class="row profile">
		<div class="col-md-2">
			<div class="profile-sidebar">
			
				<div class="profile-userpic">
					<img src="http://keenthemes.com/preview/metronic/theme/assets/admin/pages/media/profile/profile_user.jpg" class="img-responsive" alt="">
				</div>
		
				<div class="profile-usermenu">
					<ul class="nav">
						<li class="active">
							<a href="QuanLyController">
							<i class="glyphicon glyphicon-home"></i>
							Quản lý sách </a>
						</li>
						<li>
							<a href="QLDHController">
							<i class="glyphicon glyphicon-user"></i>
							Quản lý đơn hàng </a>
						</li>
						<li>
							<a href="#" target="_blank">
							<i class="glyphicon glyphicon-ok"></i>
							Quản lý khách hàng </a>
						</li>
						<li>
							<a href="#">
							<i class="glyphicon glyphicon-flag"></i>
							Help </a>
						</li>
					</ul>
				</div>
			
			</div>
		</div>
		<div class="col-md-9">
         
	<%
	ArrayList<sachBean> ds = (ArrayList<sachBean>) request.getAttribute("dssach");
	%>
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			

					<table class="table table-bordered table-hover">
						<thead style="background-color: black;">
							<tr style="">
								<th colspan="7" style="color: white;">Quản lý sách</th>
								<th colspan="7" style="color: white;"><a
									class="btn btn-success" href="ThemSachController">Thêm</a></th>
							</tr>
							<tr style="background-color: #999999;">
								<th style="color: white;">Mã sách</th>
								<th style="color: white;">Tên Sách</th>
								<th style="color: white;">Tác Giả</th>
								<th style="color: white;">Giá</th>
								<th style="color: white;">Ảnh</th>
								<th style="color: white;">Loại</th>
								<th style="color: white;">Sửa</th>
								<th style="color: white;">Xóa</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (sachBean s : ds) {
							%>
							<tr>
								<td><%=s.getMaSach()%></td>
								<td><%=s.getTenSach()%></td>
								<td><%=s.getTacGia()%></td>
								<td><%=s.getGia()%></td>
								<td><%=s.getAnh()%></td>
								<td><%=s.getLoai()%></td>
								<td>
								<a href="SuaSachController?ms=<%=s.getMaSach()%>&ts=<%=s.getTenSach()%>&tg=<%=s.getTacGia()%>&gia=<%=s.getGia()%>&anh=<%=s.getAnh()%>&loai=<%=s.getLoai()%>&sl=<%=s.getSoLuong() %>&st=<%=s.getSoTap() %>" 
								class="btn btn-warning">Sửa</a></td>
								<td><a class="btn btn-danger" onclick="XoaSach()" href="QuanLyController?Delete=<%=s.getMaSach() %>"  >Xóa
									</a></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				
			</div>
		</div>
		<div align="right">
			<button onclick="topFunction()" id="myBtn" class="btn btn-primary"
				title="Go to top" class="btn btn-default">Quay về đầu trang</button>
		</div>

	</div>

	<script src="//code.jquery.com/jquery.js"></script>
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="js/button.js">
		
	</script>
	<script >
		function XoaSach(){
			if(!confirm("Bạn có muốn xóa")){
				event.preventDefault();
			}
		}
	</script>
            </div>

	


<br>
<br>

</body>
</html>