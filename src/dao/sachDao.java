package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import bean.sachBean;

public class sachDao {
	DungChung dc = new DungChung();

	public ArrayList<sachBean> getsach() throws Exception {
		ArrayList<sachBean> ds = new ArrayList<sachBean>();

		dc.Ketnoi();
		// Lấy dữ liệu
		String sql = "select * from sach order by NgayNhap desc";
		// Thực hiện câu lệnh
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String maSach = rs.getString("masach");
			String tenSach = rs.getString("tensach");
			String tacGia = rs.getString("tacgia");
			long gia = (long) rs.getLong("gia");
			String anh = rs.getString("anh");
			String loai = rs.getString("maloai");
			long soLuong = rs.getInt("soluong");
			int soTap = Integer.parseInt(rs.getString("sotap"));
			String ngayNhap = rs.getString("NgayNhap");

			// String maSach = rs.getString("m");

			sachBean sach = new sachBean(maSach, tenSach, soLuong, gia, loai, soTap, anh, ngayNhap, tacGia);
			ds.add(sach);
		}
		rs.close();
		dc.cn.close();
		return ds;

	}

	public String LayTenTuMa(String Ma) throws Exception {
		dc.Ketnoi();
		String sql = "select tensach from sach where masach ='" + Ma + "' ";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			return rs.getString("tensach");
		}
		return null;
	}

	public void XoaSach(String maSach) throws Exception {
		dc.Ketnoi();
		String sql = "delete from sach where masach='" + maSach + "'";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.executeUpdate();
		dc.cn.close();

	}

	public int SuaSach(String maSach, String tenSach, int soLuong, long gia, String loai, int soTap, String anh,
			String tacGia) throws Exception {
		dc.Ketnoi();

		String sql = "update sach set tensach='" + tenSach + "', soluong='" + soLuong + "',anh ='"+anh+"', maloai='" + loai
				+ "', sotap='" + soTap + "', tacgia='" + tacGia + "' where masach='" + maSach + "'";
		System.out.println(sql);
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}
	public int SuaSach(String maSach, String tenSach, int soLuong, long gia, String loai, int soTap, 
			String tacGia) throws Exception {
		dc.Ketnoi();

		String sql = "update sach set tensach='" + tenSach + "', soluong='" + soLuong + "',maloai='" + loai
				+ "', sotap='" + soTap + "', tacgia='" + tacGia + "' where masach='" + maSach + "'";
		System.out.println(sql);
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}


	public int ThemSach(String maSach, String tenSach, int SoLuong, long Gia, String maLoai, int SoTap, String Anh,
			String TacGia) throws Exception {

		dc.Ketnoi();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String sql = "insert into sach values('" + maSach + "','" + tenSach + "','" + SoLuong + "','" + Gia + "','"
				+ maLoai + "','" + SoTap + "','" + Anh + "','" + dtf.format(now) + "','" + TacGia + "')";
		System.out.print(sql);

		PreparedStatement cmd = dc.cn.prepareStatement(sql);

		int kq = cmd.executeUpdate();
		dc.cn.close();

		return kq;
	}
}
