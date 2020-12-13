package bo;

import java.util.ArrayList;

import bean.loaiBean;
import dao.loaiDao;

public class loaiBo {
	public ArrayList<loaiBean> ds;
	loaiDao ldao = new loaiDao();
	public ArrayList<loaiBean> getloai() throws Exception{
		ds = ldao.getloai();
		return ds;
	}
}
