package bean;

public class CTHDBean {
	private String MaChiTietHD;
	private String MaKH;
	private String TenSach;
	private String HoTen;
	private String DiaChi;
	private int SoLuongMua;
	private int Gia;
	private long ThanhTien;
	private int DaMua;
	public String getMaChiTietHD() {
		return MaChiTietHD;
	}
	public void setMaChiTietHD(String maChiTietHD) {
		MaChiTietHD = maChiTietHD;
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public String getTenSach() {
		return TenSach;
	}
	public void setTenSach(String tenSach) {
		TenSach = tenSach;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public int getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public int getGia() {
		return Gia;
	}
	public void setGia(int gia) {
		Gia = gia;
	}
	public long getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(long thanhTien) {
		ThanhTien = SoLuongMua*Gia;
	}
	public int getDaMua() {
		return DaMua;
	}
	public void setDaMua(int daMua) {
		DaMua = daMua;
	}
	public CTHDBean(String maChiTietHD, String maKH, String tenSach, String hoTen, String diaChi, int soLuongMua,
			int gia, int daMua) {
		super();
		MaChiTietHD = maChiTietHD;
		MaKH = maKH;
		TenSach = tenSach;
		HoTen = hoTen;
		DiaChi = diaChi;
		SoLuongMua = soLuongMua;
		Gia = gia;
		ThanhTien = soLuongMua*gia;
		DaMua = daMua;
	}
	public CTHDBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
