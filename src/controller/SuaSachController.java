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
import bo.loaiBo;
import bo.sachBo;

/**
 * Servlet implementation class SuaSachController
 */
@WebServlet("/SuaSachController")
public class SuaSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaSachController() {
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
			if(request.getParameter("btnSua")!=null) {
				sachBo sBo = new sachBo();
				String MaSach = request.getParameter("ms");
				String TenSach = request.getParameter("ts");
				String TacGia = request.getParameter("tg");
				Long gia =Long.parseLong(request.getParameter("gia")) ;
				int soLuong =Integer.parseInt(request.getParameter("sl")) ;
				String anh = request.getParameter("anh");
				int soTap =Integer.parseInt(request.getParameter("st")) ;
				String loai =(String) session.getAttribute("loai");
				sBo.SuaSach( MaSach,  TenSach,  soLuong, gia,  loai,  soTap,  anh, TacGia);
				response.sendRedirect("QuanLyController");
			
				
			}
		
		
			RequestDispatcher rd = request.getRequestDispatcher("SuaSach.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
