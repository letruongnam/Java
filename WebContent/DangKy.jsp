<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    
    <!-- Latest compiled and minified CSS & JS -->
    <link rel="stylesheet" media="screen" href="//netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
 
    
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

    
    <div class="container">
        
        <div class="row">
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                
            </div>
            
            <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                
                <form action="DangKyController" method="post" role="form">
                   
                
                    <div class="form-group ">
                    <h1 class="text-center">Đăng ký tài khoản mới</h1>
                       
                   		 <label for="">Tên Khách hàng</label>
                        <input required="required" name="hoten" type="text" class="form-control" id="" placeholder="Tên Khách hàng">
                   		<label for="">Địa chỉ</label>
                        <input  name="diachi" type="text" class="form-control" id="" placeholder="Địa chỉ">
                    	<label for="">Số điện thoại</label>
                        <input  name="sodt"  class="form-control" id="" placeholder="Số điện thoại">
                   		<label for="">Email</label>
                        <input name="email" type="email"  class="form-control"  placeholder="Email">
                    	<label for="">Tên đăng nhập</label>
                        <input name="tendn"  class="form-control" required="required" id="" placeholder="Tên đăng nhập">
                        <label for="">Mật khẩu</label>
                        <input name="pass" type="password" required="required" class="form-control" id="" placeholder="Mật khẩu">
                    </div>
                    <button type="submit" name="btn" value=1 class="btn btn-primary">Submit</button>
                	 <a href="SachController" class="btn btn-danger">Quay lại</a>
                </form>
                
            </div>
            
        </div>
        
    </div>
    

    <script src="//code.jquery.com/jquery.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>