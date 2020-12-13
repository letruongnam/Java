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

	String loai= request.getParameter("loai");
	//out.print(MaSach + "*" + TenSach+ "*" +TacGia+ "*" +SoLuong+ "*" +Gia+ "*" +Anh+ "*" +SoTap+"*+"+btnDs);
	%>
	
	<div class="container">
		<div class="row">
			<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
				<form method="post" action="Them" method="POST"  enctype= "multipart/form-data">
				<table class="table mt-50">
					<thead style="background-color: black;">
						<tr>
							<th style="color: white" colspan="2">Sửa Sách</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><label>Mã Sách</label> 
							<input  type="text" 
							name="ms" readonly="readonly"   value="<%=(MaSach != null) ? MaSach : ""%>" class="form-control" placeholder="Mã Sách"> 
								
							<label>Tên Sách</label>
							<input type="text"  name="ts" value="<%=(TenSach != null) ? TenSach : ""%>" class="form-control" placeholder="Tên Sách..."> 
								
							<label>Tác Giả</label> 
							<input type="text" name="tg"  value="<%=(TacGia != null) ? TacGia : ""%>" class="form-control" placeholder="Tác Giả...">
							
							<label>Số lượng</label> 
					
							<input type="number" min="0" name="sl" value="<%=(SoLuong != null) ? SoLuong : "0"%>" class="form-control" placeholder="Số lượng"> 
							</td>
							
							<td>
							<label>Giá</label> 
							<input type="number" min="0" name="gia" value="<%=(request.getParameter("gia") != null) ? request.getParameter("gia") : "0"%>"  class="form-control" placeholder="Giá..."> 
							
							<label>Ảnh</label>
							
							file: <input type="file"   name="txtfile"><br>
  							 
							
							<label>Số tập</label>
							<input type="number" value="<%=(SoTap != null) ? SoTap : ""%>" name ="st" class="form-control" value="" placeholder="Số tập">
							
							<label >Loại</label>
							<br>
							
								
									<select name="loai">
									
										<%
											if (dsLoai != null)
											for (loaiBean l : dsLoai) {
										%>
										
										<option value="<%=l.getMaloai()%>"> <%=l.getTenloai() %>
										</option>
										<%
											}
										%>

									</select>
								
								
								</td>
						</tr>
					</tbody>
				</table>
			
				<button type="submit"  class="btn btn-success"> Sửa</button>
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