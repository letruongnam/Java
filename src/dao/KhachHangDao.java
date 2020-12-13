package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.KhachHangBean;

public class KhachHangDao {
	DungChung dc = new DungChung();
	ArrayList<KhachHangBean> ds = new ArrayList<KhachHangBean>();
	public ArrayList<KhachHangBean> getKhachHang() throws Exception{
		dc.Ketnoi();
		String sql = "select * from KhachHang";
		//Thực hiện câu lệnh
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rsResultSet = cmd.executeQuery();
		while (rsResultSet.next()) {
			String maKH = rsResultSet.getString("makh");
			String tenKH = rsResultSet.getString("hoten");
			String diaChi = rsResultSet.getString("diachi");
			String soDT = rsResultSet.getString("sodt");
			String email = rsResultSet.getString("email");
			String userName = rsResultSet.getString("tendn");
			String password = rsResultSet.getString("pass");
			
			ds.add(new KhachHangBean( maKH,  tenKH,  diaChi,  soDT,  email,  userName, password));
		}
		rsResultSet.close();
		dc.cn.close();
		return ds;
		
	}
	public int ThemKhachHang(String hoten,String diachi,String sodt,String email,String tendn,String pass)throws Exception {
		dc.Ketnoi();
		String sql = "insert into KhachHang(hoten,diachi,sodt,email,tendn,pass) values('"+hoten+"','"+diachi+"','"+sodt+"','"+email+"','"+tendn+"','"+pass+"')";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		int kq=	cmd.executeUpdate();
		cmd.close();
		return kq;
	}
}
