package bean;

public class gioHangBean {
	private String MaSach;
	private String tenSach;
	private long Gia;
	private long SoLuong;
	private long ThanhTien;
	public String getMaSach() {
		return MaSach;
	}
	public void setMaSach(String maSach) {
		MaSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public long getGia() {
		return Gia;
	}
	public void setGia(long gia) {
		Gia = gia;
	}
	public long getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(long soLuong) {
		SoLuong = soLuong;
	}
	public long getThanhTien() {
		return SoLuong*Gia;
	}
	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
	}
	public gioHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public gioHangBean(String maSach, String tenSach, long gia, long soLuong) {
		super();
		MaSach = maSach;
		this.tenSach = tenSach;
		Gia = gia;
		SoLuong = soLuong;
		ThanhTien = soLuong * gia;
	}
	
}
