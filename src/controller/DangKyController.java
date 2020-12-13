package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.DangNhapBo;
import bo.KhachHangBo;

/**
 * Servlet implementation class DangKyController
 */
@WebServlet("/DangKyController")
public class DangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKyController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		KhachHangBo khBo = new KhachHangBo();
		if (request.getParameter("btn") != null) {
			int n = 0;

			String hoten = request.getParameter("hoten");
			String diachi = request.getParameter("diachi");
			String sodt = request.getParameter("sodt");
			String email = request.getParameter("email");
			String tendn = request.getParameter("tendn");
			String pass = request.getParameter("pass");
			try {
				DangNhapBo dnBo = new DangNhapBo();
				n = dnBo.KiemTraTK(tendn);
				if (n == 1) {
					response.sendRedirect("Loi?loi=trungTK");
				} else {
					n = khBo.ThemKhachHang(hoten, diachi, sodt, email, tendn, pass);
					if (n == 1) {
						request.setAttribute("Loi", "Bạn đã đăng ký thành công, Xin mời đăng nhập");
						response.sendRedirect("DangnhapController?txtUser=" + tendn + "&txtPass=" + pass + "");
					}
					else {
						response.sendRedirect("Loi?loi=khong");
					}
				}
				System.out.print("n=" + n);

			} catch (Exception e) {

				System.out.print(e + "n=" + n);
			}

		}
		request.getRequestDispatcher("DangKy.jsp").include(request, response);
		// RequestDispatcher rd = request.getRequestDispatcher("DangKy.jsp");
		// rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
