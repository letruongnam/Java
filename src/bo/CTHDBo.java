package bo;

import java.util.ArrayList;

import bean.CTHDBean;
import dao.CTHDDao;

public class CTHDBo {

	public ArrayList<CTHDBean> ds = new ArrayList<>();
	public ArrayList<CTHDBean> getCTHD() throws Exception {
		CTHDDao cthdDao = new CTHDDao();
		return cthdDao.getCTHD();
	}
	public int Duyet(String MaCTHD) throws Exception {
		CTHDDao cthdDao = new CTHDDao();
		return cthdDao.Duyet(MaCTHD);
	}
	public int Xoa(String MaKH) throws Exception {
		CTHDDao cthdDao = new CTHDDao();
		return cthdDao.Xoa(MaKH);
	}
}
