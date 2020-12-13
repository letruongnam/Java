package bean;

public class KhachHangBean {
	private String MaKH;
	private String TenKH;
	private String DiaChi;
	private String SoDT;
	private String Email;
	private String UserName;
	private String Password;
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSoDT() {
		return SoDT;
	}
	public void setSoDT(String soDT) {
		SoDT = soDT;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public KhachHangBean(String maKH, String tenKH, String diaChi, String soDT, String email, String userName,
			String password) {
		super();
		MaKH = maKH;
		TenKH = tenKH;
		DiaChi = diaChi;
		SoDT = soDT;
		Email = email;
		UserName = userName;
		Password = password;
	}
	public KhachHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
