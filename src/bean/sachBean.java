package bean;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class sachBean {
	
	private String maSach;
	private String tenSach;
	private Long soLuong;
	private long Gia;
	private String loai;
	private int SoTap;
	private String anh;
	private String ngayNhap;
	private String TacGia;
	public sachBean(String maSach, String tenSach, Long soLuong, long gia, String loai, int soTap, String anh,
			String ngayNhap, String tacGia) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.soLuong = soLuong;
		Gia = gia;
		this.loai = loai;
		SoTap = soTap;
		this.anh = anh;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		this.ngayNhap = dtf.format(now);
		TacGia = tacGia;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public Long getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(Long soLuong) {
		this.soLuong = soLuong;
	}
	public long getGia() {
		return Gia;
	}
	public void setGia(long gia) {
		Gia = gia;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public int getSoTap() {
		return SoTap;
	}
	public void setSoTap(int soTap) {
		SoTap = soTap;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public String getTacGia() {
		return TacGia;
	}
	public void setTacGia(String tacGia) {
		TacGia = tacGia;
	}
	public sachBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
