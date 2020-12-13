package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import bean.loaiBean;

public class loaiDao {
	DungChung dc = new DungChung();
	
	public ArrayList<loaiBean> getloai() throws Exception{
		ArrayList<loaiBean> ds = new ArrayList<loaiBean>();
		//kết nối
		dc.Ketnoi();
		//Lấy dữ liệu
		String sql = "select * from loai";
		//Thực hiện câu lệnh
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rsResultSet = cmd.executeQuery();
		while (rsResultSet.next()) {
			String maloai = rsResultSet.getString("maloai");
			String tenloai = rsResultSet.getString("tenloai");
			loaiBean loai = new loaiBean(maloai,tenloai);
			ds.add(loai);
		}
		rsResultSet.close();
		dc.cn.close();
		return ds;
	}
}
