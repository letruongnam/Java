package bean;

public class HoaDonBean {
	private String MaHoaDon;
	private String MaKH;
	private String NgayMua;
	private int DaMua;
	private String MaChiTietHD;
	private String MaSach;
	private int SoLuongMua;
	public String getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public String getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(String ngayMua) {
		NgayMua = ngayMua;
	}
	public int getDaMua() {
		return DaMua;
	}
	public void setDaMua(int daMua) {
		DaMua = daMua;
	}
	public String getMaChiTietHD() {
		return MaChiTietHD;
	}
	public void setMaChiTietHD(String maChiTietHD) {
		MaChiTietHD = maChiTietHD;
	}
	public String getMaSach() {
		return MaSach;
	}
	public void setMaSach(String maSach) {
		MaSach = maSach;
	}
	public int getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public HoaDonBean(String maHoaDon, String maKH, String ngayMua, int daMua, String maChiTietHD, String maSach,
			int soLuongMua) {
		super();
		MaHoaDon = maHoaDon;
		MaKH = maKH;
		NgayMua = ngayMua;
		DaMua = daMua;
		MaChiTietHD = maChiTietHD;
		MaSach = maSach;
		SoLuongMua = soLuongMua;
	}
	public HoaDonBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
