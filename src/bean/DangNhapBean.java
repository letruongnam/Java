package bean;

public class DangNhapBean {
	public String UserName;
	public String PassWord;
	public int Quyen;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public int getQuyen() {
		return Quyen;
	}
	public void setQuyen(int quyen) {
		Quyen = quyen;
	}
	public DangNhapBean(String userName, String passWord, int quyen) {
		super();
		UserName = userName;
		PassWord = passWord;
		Quyen = quyen;
	}
	public DangNhapBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
