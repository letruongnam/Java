package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import bean.HoaDonBean;
import bean.gioHangBean;
import bo.GioHangBo;
import bo.HoaDonBo;

public class HoaDonDao {
	DungChung dc = new DungChung();
	ArrayList<HoaDonBean> ds = new ArrayList<>();
	public ArrayList<HoaDonBean> getHoaDon()throws Exception{
		dc.Ketnoi();
		
		String sql ="select hoadon.MaHoaDon,makh,NgayMua,damua,MaChiTietHD,MaSach,SoLuongMua from hoadon inner join ChiTietHoaDon on hoadon.MaHoaDon = ChiTietHoaDon.MaHoaDon";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String maHoaDon = rs.getString("MaHoaDon");
			String maKH = rs.getString("makh");
			String ngayMua = rs.getString("NgayMua");
			int daMua = rs.getInt("damua");
			String maChiTietHD = rs.getString("MaChiTietHD");
			String maSach = rs.getString("MaSach");
			int soLuongMua = rs.getInt("SoLuongMua");
			
			
			HoaDonBean HDB=new	HoaDonBean(maHoaDon,  maKH,  ngayMua,  daMua,  maChiTietHD,  maSach,
					 soLuongMua);
			ds.add(HDB);
			
		}
		rs.close();
		dc.cn.close();
		return ds;
	}
	public int ThemHoaDon( String maKH,GioHangBo gh)throws Exception {
		int kq=0;
		if(gh != null) {
			dc.Ketnoi();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			String sql = "insert into hoadon(makh,NgayMua,damua) values('"+maKH+"','"+dtf.format(now)+"','0')";
			PreparedStatement cmd = dc.cn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			System.out.print(sql+"\n");
			kq=	cmd.executeUpdate();
			ResultSet rs = cmd.getGeneratedKeys();
			if(rs.next()) {
				int Ma= rs.getInt(1);
				if(gh.size()>0) {
					for(gioHangBean ds : gh.ds) {
						sql = "insert into ChiTietHoaDon(MaSach,SoLuongMua,MaHoaDon) values('"+ds.getMaSach()+"','"+ds.getSoLuong()+"','"+Ma+"')";
						cmd = dc.cn.prepareStatement(sql);
						kq=	cmd.executeUpdate();
						System.out.print(sql+"\n");
					}
				}
			
			}
			dc.cn.close();
			cmd.close();
			
		}
	
		return kq;
	}
}
