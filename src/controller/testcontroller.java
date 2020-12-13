package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.DungChung;

/**
 * Servlet implementation class testcontroller
 */
@WebServlet("/testcontroller")
public class testcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//tạo ra đối tượng out
//		PrintWriter out = response.getWriter();
//		out.print("<html><body>haha</body></html>");
//		//tạo ra session
//		HttpSession session = request.getSession();
//		session.setAttribute("tam", "Chao Servelet");
//		response.sendRedirect("maytinh.jsp");
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		
		try {
			DungChung dChung = new DungChung();
			dChung.Ketnoi();
		} catch (Exception e) {
			// TODO: handle exception
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
