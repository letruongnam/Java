<%@page import="bean.CTHDBean"%>
<%@page import="bean.HoaDonBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.HoaDonBo"%>
<%@page import="bean.gioHangBean"%>
<%@page import="bo.GioHangBo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>





<link rel="stylesheet" media="screen"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel='stylesheet' href='style.css'>

<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body style="background-color: #96ffff">
	<%
		request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	ArrayList<CTHDBean> dsHoaDon = (ArrayList<CTHDBean>) request.getAttribute("dsHoaDon");
	%>
	<%@include file="Header.jsp" %>
	<div class="container ">

		<div class="row mt-50">
			<div class="text-center">
				<h1>HÓA ĐƠN THANH TOÁN</h1>
				<h1>---------oOo---------</h1>

			</div>


			<table class="table table-condensed table-hover" >
				<thead style="background-color: black;width: 100%">
					<tr style="color: white;">
						<th>Mã hóa đơn</th>
						<th>Họ tên</th>
						<th>Tên Sách</th>
						<th>Số lượng</th>
						<th>Giá</th>
						<th>Thành tiền</th>
						<th>Trạng thái</th>
					</tr>
				</thead>
				<tbody style="background-color: white;">
					<%	int check =0;
						int Sum = 0;
					for (CTHDBean item : dsHoaDon) {
					%>
					<tr>

						<td><%=item.getMaChiTietHD()%></td>
						<td><%=item.getHoTen()%></td>
						<td><%=item.getTenSach()%></td>
						<td><%=item.getSoLuongMua()%></td>
						<td><%=item.getGia()%>VNĐ</td>
						<td><%=item.getThanhTien()%>VNĐ</td>
							<td style="background-color: <%=item.getDaMua()==1 ? "#ff6186":"#f9ff87"%>"><%=item.getDaMua() == 1 ? "Đang giao hàng" : "Đang chờ duyệt"%></td>
						
					</tr>
					<%
						if(item.getDaMua()==1) check=1;
						Sum += item.getThanhTien();
					}
					%>
					<tr align="right" ><td colspan="7">Tổng tiền: <%=Sum %>VNĐ</td></tr>
				</tbody>
			</table>


			<a class="btn btn-success" href="SachController">Quay về trang
				chủ</a>
				<%if(check==1){%>
				<a href="HienThiHD?compelete=1" class="btn btn-success">Đã nhận hàng</a>
				<%} %>
		</div>

	</div>
	<script src="//code.jquery.com/jquery.js"></script>
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>