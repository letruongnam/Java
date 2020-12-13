<%@page import="bean.loaiBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.gioHangBean"%>
<%@page import="bo.GioHangBo"%>
<%@page import="bo.loaiBo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" media="screen"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">

<title>Insert title here</title>
</head>
<body>


	<%
	int ColorChange = 1;
	%>
	<%@include file="Header.jsp" %>
	<div class="container">
		<div class="row mt-50 ml-20">

			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<table class="table table-hover mt-30">
					<thead>
						<tr style="background-color: #404040;color: white">
							<th>Chọn</th>
							<th>Mã Sách</th>
							<th>Tên Sách</th>
							<th>Giá</th>
							<th>Số Lượng</th>
							<th>Thành tiền</th>
							<th>Xóa</th>
						</tr>
					</thead>
					<tbody>
						<%
							if (Gh == null || Gh.size() == 0) {
						%>
						<tr>
							<td colspan="7"><h2>Không có sản phẩm nào trong giỏ hàng</h2></td>
						</tr>
						<%
							} else
						for (gioHangBean s : Gh.ds) {
						%>
						<%if (ColorChange % 2 == 0) {%>
						<tr  style="background-color: #e6e6e6;">
						<%}else{ %>
						<tr  style="background-color: #cccccc;">
						<%} ColorChange++; %>
							<td><input type="checkbox" checked="checked"></td>
							<td><%=s.getMaSach()%></td>
							<td><%=s.getTenSach()%></td>
							<td><%=s.getGia()%> VNĐ</td>

							<td>
								<form 
									action="SuaController?ms=<%=s.getMaSach()%>&ts=<%=s.getTenSach()%>&gia=<%=s.getGia()%>&sl=<%=s.getSoLuong()%>"
									method="post">
									<label><%=s.getSoLuong()%></label>
									<input type="number" name="txtsl" value=0 width="10">
									<input name="but1" type="submit" value="Sửa">
								</form>
							</td>
							<td><%=s.getThanhTien()%> VNĐ</td>

							<td><a href="XoaController?ma=<%=s.getMaSach()%>" onclick="Delete()">Delete</a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<div align="right">
					Tổng tiền:<%=Gh != null ? Gh.Tong() : 0%> VNĐ
				
				<a type="button" class="btn btn-success" href="ThanhToanController" >Thanh toán</a>
				</div>
			
			</div>
			
		</div>
	</div>
	<script src="//code.jquery.com/jquery.js"></script>
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script>
		function Delete(){
			if(!confirm("Bạn có muốn xóa sản phẩm")){
				event.preventDefault();
			}
		}
	</script>
</body>
</html>