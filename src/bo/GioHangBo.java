package bo;

import java.util.ArrayList;

import bean.gioHangBean;

public class GioHangBo {

	public ArrayList<gioHangBean> ds = new ArrayList<gioHangBean>();
	public void Them(String maSach, String tenSach, long gia, long soLuong) {
		for(gioHangBean s : ds) {//kiem tra trung sach
			if(s.getMaSach().equals(maSach)) {
				if(s.getSoLuong()+soLuong >=1)
				s.setSoLuong(s.getSoLuong() + soLuong);//tang sl
				return;
			}
		}
		gioHangBean h = new gioHangBean(maSach,tenSach,gia,soLuong);
		ds.add(h);
	}
	public void Xoa(String maSach) {
		for(gioHangBean s : ds) {//kiem tra trung sach
			if(s.getMaSach().equals(maSach)) {
				ds.remove(s);
				return;
			}
		}
	}
	public long Tong() {
		long Tong=0;
		for(gioHangBean s : ds) {
			Tong+=s.getThanhTien();
		}
		return Tong;
	}
	public int size() {
		return ds.size();
	}
}
