package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.DangNhapBean;

public class DangNhapDao {
	DungChung dc = new DungChung();
	ArrayList<DangNhapBean> ds = new ArrayList<DangNhapBean>();
	public ArrayList<DangNhapBean>  getAcc() throws Exception {
		dc.Ketnoi();
		///lấy tài khoản admin
		String sql ="select * from DangNhap";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String userName = rs.getString("TenDangNhap");
			String PassWord = rs.getString("MatKhau");
			int Quyen = rs.getInt("Quyen");
			DangNhapBean dn = new DangNhapBean( userName,  PassWord,  Quyen);
			ds.add(dn);
		}
		// lấy tài khoản khách hàng
		String sql2 ="select * from KhachHang";
		PreparedStatement cmd2 = dc.cn.prepareStatement(sql2);
		ResultSet rs2 = cmd2.executeQuery();
		while(rs2.next()) {
			String userName = rs2.getString("tendn");
			String PassWord = rs2.getString("pass");
			DangNhapBean dn = new DangNhapBean( userName,  PassWord,  1);
			ds.add(dn);
		}
		rs.close();
		rs2.close();
		dc.cn.close();
		return ds;
		
	}
}
