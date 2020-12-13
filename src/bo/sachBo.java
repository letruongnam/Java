package bo;
import dao.DungChung;
import dao.sachDao;
import bean.sachBean;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class sachBo {
	DungChung dc = new DungChung();
	sachDao sdao = new sachDao();
	ArrayList<sachBean> ds;
	public ArrayList<sachBean>  getsach() throws Exception{
		ds = sdao.getsach();
		return ds;
	}
	public ArrayList<sachBean> timMa(String maloai) throws Exception{
		ArrayList<sachBean> tam = new ArrayList<sachBean>();
		if(maloai.equals("all")) {
			tam =sdao.getsach();
			return tam;
		}
		for(sachBean s : ds)
			if(s.getLoai().equalsIgnoreCase(maloai))
				tam.add(s);
		
		return tam;
	}
	public ArrayList<sachBean> Timkiem(String key){
		ArrayList<sachBean> tam = new ArrayList<sachBean>();
	
		for(sachBean s : ds)
			if(s.getTenSach().toLowerCase().contains(key.toLowerCase())||
				s.getTacGia().toLowerCase().contains(key.toLowerCase()))
				tam.add(s);
		
		return tam;
	}
	public void DeleleSach(String maSach) throws Exception {
		sachDao sdao = new sachDao();
		sdao.XoaSach(maSach);
		

		

	}
	public int SuaSach(String maSach, String tenSach,int  soLuong,long gia,String  loai,int  soTap, String anh,String tacGia) throws Exception{
		sachDao sdao = new sachDao();
		return sdao.SuaSach(maSach, tenSach, soLuong, gia, loai, soTap, anh, tacGia);
	}
	public int SuaSach(String maSach, String tenSach,int  soLuong,long gia,String  loai,int  soTap,String tacGia) throws Exception{
		sachDao sdao = new sachDao();
		return sdao.SuaSach(maSach, tenSach, soLuong, gia, loai, soTap, tacGia);
	}
	public String layTenTuMa(String Ma) throws Exception {
		sachDao sDao = new sachDao();
		return sDao.LayTenTuMa(Ma);
	}
	public int ThemSach(String maSach, String tenSach, int SoLuong, long Gia, String maLoai, int SoTap, String Anh, String TacGia) throws Exception{
		sachDao sDao = new sachDao();
		return sDao.ThemSach(maSach, tenSach, SoLuong, Gia, maLoai, SoTap, Anh, TacGia);
	}
	
}	
