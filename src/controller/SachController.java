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
import bo.GioHangBo;
import bo.loaiBo;
import bo.sachBo;

/**
 * Servlet implementation class SachController
 */
@WebServlet("/SachController")
public class SachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		sachBo sbo = new sachBo();
		ArrayList<sachBean> ds = sbo.getsach();
		String ml = request.getParameter("ml");
		String key = request.getParameter("txttk");
		request.setAttribute("active", "htsach");
		if (ml != null)
			ds = sbo.timMa(ml);
		if (key != null)
			ds = sbo.Timkiem(key);
		int n = ds.size();
		loaiBo lbo = new loaiBo();
		ArrayList<loaiBean> dsloai = lbo.getloai();
		HttpSession session = request.getSession();
		GioHangBo Gh = (GioHangBo) session.getAttribute("gh");
		request.setAttribute("n", n);
		request.setAttribute("gh", Gh);
		request.setAttribute("dssach", ds);
		request.setAttribute("dsloai", dsloai);
		RequestDispatcher rd = request.getRequestDispatcher("htSach.jsp");
		rd.forward(request, response);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
