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

import bean.CTHDBean;
import bo.CTHDBo;
import bo.HoaDonBo;

/**
 * Servlet implementation class HienThiHD
 */
@WebServlet("/HienThiHD")
public class HienThiHD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HienThiHD() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String MaKH = (String) session.getAttribute("MaKH");
		if (request.getParameter("compelete") != null && MaKH != null) {
			CTHDBo cthdBo = new CTHDBo();
			try {
				cthdBo.Xoa(MaKH);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		
		
		try {
			CTHDBo cthdBo = new CTHDBo();
			ArrayList<CTHDBean> ds = cthdBo.getCTHD();
			ArrayList<CTHDBean> temp = new ArrayList<>();

			if (MaKH != null)
				for (CTHDBean item : ds) {
					if (item.getMaKH().equals(MaKH)) {
						temp.add(item);
					}
				}
			request.setAttribute("dsHoaDon", temp);
			request.setAttribute("active", "cthd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		RequestDispatcher rd = request.getRequestDispatcher("datmua.jsp");
		rd.forward(request, response);

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
