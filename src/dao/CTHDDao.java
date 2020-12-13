package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.CTHDBean;


public class CTHDDao {
	DungChung dc = new DungChung();
	ArrayList<CTHDBean> ds = new ArrayList<>();
	public ArrayList<CTHDBean> getCTHD() throws Exception{
		dc.Ketnoi();
		String sql ="SELECT ChiTietHoaDon.MaChiTietHD, KhachHang.makh, sach.tensach, KhachHang.hoten, KhachHang.diachi,  ChiTietHoaDon.SoLuongMua,sach.gia, gia*SoLuongMua as thanhtien, damua " + 
				"FROM     ChiTietHoaDon INNER JOIN " + 
				"                  hoadon ON ChiTietHoaDon.MaHoaDon = hoadon.MaHoaDon INNER JOIN " + 
				"                  KhachHang ON hoadon.makh = KhachHang.makh INNER JOIN " + 
				"                  sach ON ChiTietHoaDon.MaSach = sach.masach ";
		System.out.print(sql);
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String MaChiTietHD = rs.getString("MaChiTietHD");
			String maKH = rs.getString("maKH");
			String tenSach = rs.getString("tenSach");
			String hoTen = rs.getString("hoTen");
			String diaChi = rs.getString("diaChi");
			int soLuongMua = rs.getInt("soLuongMua");
			int gia = rs.getInt("gia");
			int Damua = rs.getInt("damua");
		CTHDBean cthdBean= new	CTHDBean(MaChiTietHD, maKH,  tenSach,  hoTen,  diaChi,  soLuongMua,  gia, Damua);
		ds.add(cthdBean);
			
		}
		dc.cn.close();
		return ds;
	}
	public int Duyet(String MaCTHD) throws Exception {
		dc.Ketnoi();
		String sql=null;
		if(MaCTHD.equals("all")) {
			sql = "update hoadon  set damua='1'";
		}else {
			sql = "update hoadon  set damua='1' where MaHoaDon = (select MaHoaDon from ChiTietHoaDon where MaChiTietHD ='"+MaCTHD+"')";
		}
		
		System.out.println(sql);
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}
	public int Xoa(String MaKH) throws Exception {
		
		dc.Ketnoi();
		String sql="delete from hoadon where makh='"+MaKH+"'";
		System.out.println(sql);
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}
}
