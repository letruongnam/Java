package bo;

import java.util.ArrayList;

import bean.HoaDonBean;
import dao.HoaDonDao;

public class HoaDonBo {
	public ArrayList<HoaDonBean> ds = new ArrayList<>();
	public ArrayList<HoaDonBean> getHoaDon() throws Exception{
		HoaDonDao hdd = new HoaDonDao();
		ds = hdd.getHoaDon();
		return ds;
	}
	public int ThemHoaDon(String maKH,GioHangBo gh)throws Exception {
		HoaDonDao hdd = new HoaDonDao();
		return hdd.ThemHoaDon( maKH, gh);
	}
}
