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

import bean.loaiBean;
import bean.sachBean;
import bo.loaiBo;
import bo.sachBo;

/**
 * Servlet implementation class ThemSachController
 */
@WebServlet("/ThemSachController")
public class ThemSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemSachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			loaiBo lBo= new loaiBo();
			ArrayList<loaiBean> dsLoai = lBo.getloai();
			request.setAttribute("dsLoai",dsLoai);
			if(request.getParameter("btnThem")!=null) {
				sachBo sBo = new sachBo();
				String MaSach = request.getParameter("ms");
				String TenSach = request.getParameter("ts");
				String TacGia = request.getParameter("tg");
				Long Gia =Long.parseLong(request.getParameter("gia")) ;
				int soLuong =Integer.parseInt(request.getParameter("sl")) ;
				String Anh = request.getParameter("anh");
				int SoTap =Integer.parseInt(request.getParameter("st")) ;
				String maLoai =(String) session.getAttribute("loaiThem");
				if(sBo.ThemSach(MaSach, TenSach, soLuong, Gia, maLoai, SoTap, Anh, TacGia)==1)
					response.sendRedirect("QuanLyController");
			}
		
		
			RequestDispatcher rd = request.getRequestDispatcher("ThemSach.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	}

}
