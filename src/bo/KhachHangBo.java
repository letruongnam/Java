package bo;

import java.util.ArrayList;

import bean.KhachHangBean;
import dao.KhachHangDao;

public class KhachHangBo {
	ArrayList<KhachHangBean> ds = new ArrayList<>();
	public	ArrayList<KhachHangBean> getKhachHang() throws Exception{
		KhachHangDao khDao = new KhachHangDao();
		ds = khDao.getKhachHang();
		return ds;
	}
	
	public int ThemKhachHang(String hoten,String diachi,String sodt,String email,String tendn,String pass) throws Exception {
		KhachHangDao KHDAO = new KhachHangDao();
		return	KHDAO.ThemKhachHang( hoten, diachi, sodt, email, tendn, pass);
	}
}
