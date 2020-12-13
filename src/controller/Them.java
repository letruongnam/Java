package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.sachBean;
import bo.sachBo;

/**
 * Servlet implementation class Them
 */
@WebServlet("/Them")
public class Them extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Them() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String maSach = null, tenSach = null, loai = null, anh = null, ngayNhap, tacGia = "",btnThem=null;
		Long gia = (long) 0;
		int soTap = 0, soLuong = 0;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "files";
		// response.getWriter().println(dirUrl1);

		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					anh = "image_sach/" + nameimg;
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "files";

						int vt = dirUrl.indexOf(".metadata");
						dirUrl = dirUrl.substring(0, vt - 1) + "\\TrenLop\\WebContent\\image_sach";
						// response.getWriter().println("<hr>"+dirUrl);
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// tạo file
						try {
							fileItem.write(file);// lưu file
							//System.out.println("UPLOAD THÀNH CÔNG...!");
							//System.out.println("Đường dẫn lưu file là: " + dirUrl);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String tentk = fileItem.getFieldName();
					if (tentk.equals("ms"))
						maSach = fileItem.getString("utf-8");

					if (tentk.equals("ts"))
						tenSach = fileItem.getString("utf-8");

					if (tentk.equals("loai")) {
						loai = fileItem.getString("utf-8");
					}
					if (tentk.equals("gia")) {
						gia = Long.parseLong(fileItem.getString("utf-8"));
					}
					if (tentk.equals("anh")) {
						anh = fileItem.getString("utf-8");
					}
					if (tentk.equals("tg")) {
						tacGia = fileItem.getString("utf-8");
					}
					if (tentk.equals("sl")) {
						soLuong = Integer.parseInt(fileItem.getString("utf-8"));
					}
					if (tentk.equals("st")) {
						soTap = Integer.parseInt(fileItem.getString("utf-8"));
					}
					if (tentk.equals("btnThem")) {
						btnThem = fileItem.getString("utf-8");
					}

				}

			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		// System.out.print(maSach+tenSach+soTap+loai+soLuong+tacGia+gia+anh);
		sachBo sBo = new sachBo();
		System.out.println(btnThem);
		try {
			
			if (btnThem!=null) {
				if (sBo.ThemSach(maSach, tenSach, soLuong, gia, loai, soTap, anh, tacGia) == 1)
					response.sendRedirect("QuanLyController");
			} else {
				if (anh.equals("image_sach/"))
					sBo.SuaSach(maSach, tenSach, soLuong, gia, loai, soTap, tacGia);
				else
					sBo.SuaSach(maSach, tenSach, soLuong, gia, loai, soTap, anh, tacGia);

			}
			response.sendRedirect("QuanLyController");

		} catch (Exception e) {
			e.printStackTrace();
		}

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
