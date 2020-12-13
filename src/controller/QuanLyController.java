package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaiBean;
import bean.sachBean;
import bo.loaiBo;
import bo.sachBo;

/**
 * Servlet implementation class QuanLyController
 */
@WebServlet("/QuanLyController")
public class QuanLyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			loaiBo lbo = new loaiBo();
			sachBo sBo = new sachBo();
			String msDelete = request.getParameter("Delete");
			if(msDelete!=null) {
				 sBo.DeleleSach(msDelete);
			}
			ArrayList<loaiBean> dsloai = lbo.getloai();
			
			ArrayList<sachBean> ds = sBo.getsach();
			request.setAttribute("dssach",ds);
			request.setAttribute("dsloai",dsloai);
			
			
			//System.out.print(request.getParameter("Delete"));
			RequestDispatcher rd = request.getRequestDispatcher("QuanLy.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
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
