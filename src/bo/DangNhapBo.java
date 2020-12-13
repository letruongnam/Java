package bo;

import java.util.ArrayList;

import bean.DangNhapBean;
import dao.DangNhapDao;

public class DangNhapBo {

	ArrayList<DangNhapBean> ds = new ArrayList<>();
	public int KiemTraDN(String un, String pass) throws Exception{
		DangNhapDao dnDao = new DangNhapDao();
		ds = dnDao.getAcc();
		for(DangNhapBean d : ds) {
			if(d.getUserName().equals(un)&& d.getPassWord().equals(pass)) {
				return d.getQuyen();
			}
		}
		
		return -1;
	}
	
	/// 1 là đã trùng tk 0 là chưa trùng
	public int KiemTraTK(String un) throws Exception{
		DangNhapDao dnDao = new DangNhapDao();
		ds = dnDao.getAcc();
		for(DangNhapBean d : ds) {
			if(d.getUserName().equals(un)) {
				return 1;
			}
		}
		
		return 0;
	}
}
