package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import bean.DangNhapBean;
import bean.KhachHangBean;
import bean.loaiBean;
import bo.DangNhapBo;
import bo.KhachHangBo;
import bo.loaiBo;

/**
 * Servlet implementation class DangnhapController
 */
@WebServlet("/DangnhapController")
public class DangnhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DangnhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String txtUser = request.getParameter("txtUser");
			String txtPass = request.getParameter("txtPass");
			String btn = request.getParameter("btn");
			DangNhapBo dnBo = new DangNhapBo();
			HttpSession session = request.getSession();
			loaiBo lbo = new loaiBo();
			ArrayList<loaiBean> dsloai = lbo.getloai();
			request.setAttribute("dsloai", dsloai);
		
			if(txtPass!=null && txtUser!=null&&btn!=null) {
	
				switch(dnBo.KiemTraDN(txtUser, txtPass)) {
				  case 1:
					  session.setAttribute("txtUser", txtUser);
					  KhachHangBo khbo = new KhachHangBo();
					  ArrayList<KhachHangBean> ds = khbo.getKhachHang();
					  for(KhachHangBean kh : ds) {
						  if(kh.getUserName().equals(txtUser)) {
							  session.setAttribute("MaKH", kh.getMaKH());
						  }
					  }
					  response.sendRedirect("SachController");
				    break;
				  case 0:
					  session.setAttribute("txtUser", txtUser);
					  response.sendRedirect("QuanLyController");
				    break;
				  case -1:
					  request.setAttribute("Loi", "Sai Tên Đăng nhập hoặc mật khẩu");
					 break;
					 default:
				}
			
			}
			
			request.getRequestDispatcher("DangNhap.jsp").include( request, response);
			
		} catch (Exception e) {

		}

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
