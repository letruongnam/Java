<%@page import="java.util.ArrayList"%>
<%@page import="bean.loaiBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" media="screen"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">


<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<loaiBean> dsLoai = (ArrayList<loaiBean>) request.getAttribute("dsLoai");

	
	String MaSach = request.getParameter("ms");
	String TenSach = request.getParameter("ts");
	String TacGia = request.getParameter("tg");
	String Gia = request.getParameter("gia");
	String SoLuong = request.getParameter("sl");
	String Anh = request.getParameter("anh");
	String SoTap = request.getParameter("st");
	String btnDs = request.getParameter("btnDs");
	session.setAttribute("loaiThem", request.getParameter("loai")); 
	String loai= request.getParameter("loai");
	//out.print(MaSach + "*" + TenSach+ "*" +TacGia+ "*" +SoLuong+ "*" +Gia+ "*" +Anh+ "*" +SoTap+"*+"+btnDs);
	%>
	
	<div class="container">
		<div class="row">
			<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
				<form method="post" action="ThemSachController" method="POST" role="form" >
				<table class="table mt-50">
					<thead style="background-color: black;">
						<tr>
							<th style="color: white" colspan="2">Thêm Sách</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><label>Mã Sách</label> 
							<input  type="text" 
							name="ms"   value="<%=(MaSach != null) ? MaSach : ""%>" class="form-control" placeholder="Mã Sách"> 
								
							<label>Thêm Sách</label>
							<input type="text" name="ts" value="<%=(TenSach != null) ? TenSach : ""%>" class="form-control" placeholder="Tên Sách..."> 
								
							<label>Tác Giả</label> 
							<input type="text" name="tg" value="<%=(TacGia != null) ? TacGia : ""%>" class="form-control" placeholder="Tác Giả...">
							
							<label>Số lượng</label> 
					
							<input type="number" min="0" name="sl" value="<%=(SoLuong != null) ? SoLuong : "0"%>" class="form-control" placeholder="Số lượng"> 
							</td>
							
							<td>
							<label>Giá</label> 
							<input type="number" min="0" name="gia" value="<%=(request.getParameter("gia") != null) ? request.getParameter("gia") : "0"%>"  class="form-control" placeholder="Giá..."> 
							
							<label>Ảnh</label>
							<input type="text" name="anh" class="form-control" value="<%=(Anh != null) ? Anh : ""%>" placeholder="Ảnh...">
							
							<label>Số tập</label>
							<input type="number" max="3" min="0" value="<%=(SoTap != null) ? SoTap : ""%>" name ="st" class="form-control" value="" placeholder="Số tập">
							
							<label >Loại</label>
							
								<div class="dropdown mt-10">
									<button class=" dropdown-toggle" type="button"
										data-toggle="dropdown">
										<%= loai !=null ? loai : "Chọn loại"%>
										<span class="caret"></span>
									</button>
									<ul class="dropdown-menu" >
										<%
											if (dsLoai != null)
											for (loaiBean l : dsLoai) {
										%>
										<li><button style="width: 100%;" name="loai" value="<%=l.getMaloai() %>" ><%=l.getTenloai() %></button></li>
										<%
											}
										%>

									</ul>
									</div>
								
								</td>
						</tr>
					</tbody>
				</table>
				<% 
					session.setAttribute("loaiThem", request.getParameter("loai")); 
				%>
				<button name="btnThem" value="1" class="btn btn-success"> Thêm</button>
					<a  class="btn btn-danger" href="QuanLyController">Quay lại</a>
			</form>
			
			</div>

		</div>

	</div>



	<script src="//code.jquery.com/jquery.js"></script>
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>