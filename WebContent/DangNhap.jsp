<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
	<link rel='stylesheet' href='style.css'>	
    <meta charset="utf-8">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
  <link rel="stylesheet" media="screen" href="//netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <title>Insert title here</title>
</head>

<body>

    <% 	
    String Alert = request.getParameter("Alert");
    String loi =(String) request.getAttribute("Loi");
    String txtUser=request.getParameter("txtUser");
    String txtPass=request.getParameter("txtPass");
    %>
    <%@include file="Header.jsp" %>
    <div class="container">
        
        <div class="row mt-50">
            
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    
            </div>
            <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 mt-10">
              <div class="text-center">
              <img src="image_sach/login.jpg" width="200px" >
              </div>
                <form action="DangnhapController" method="get" role="form">
                    <div class="form-group">
                        <label >Đăng nhập</label>
                        <input  type="text" class="form-control" value="<%=txtUser!=null?txtUser:"" %>" required="required" name="txtUser" placeholder="Tên Đăng nhập...">
                        <label >Mật khẩu</label>
                        <input type="password" required="required" value="<%=txtPass!=null?txtPass: ""%>" class="form-control"  name="txtPass"  placeholder="Mật khẩu...">
                    </div>
                    <button type="submit" name="btn" value=1 style="width: 100%" class="btn btn-success">Submit</button>
               		<label>
               		<input type="checkbox" checked="checked" name="remember"> Remember me
               		</label>
               		
               		<h5> <b>didn't have account?</b>
               			<a href="DangKyController">Đăng ký</a>
               		</h5>
               		
               		<%
               			if(loi!=null){
               				out.print("<h6 style='color: red;' >"+loi+"</h6>");
               			}
               			if(Alert!=null){
               				out.print("<h6 style='color: red;' >"+Alert+"</h6>");
               			}
               	
               		%>
                </form>
                
            </div>
          
        </div>
        
    </div>
    
   
	
</body>

</html>