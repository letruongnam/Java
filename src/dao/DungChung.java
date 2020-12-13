package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DungChung {
	public Connection cn;
	
	public void Ketnoi() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://DESKTOP-ON05IVV\\SQLEXPRESS:1433;databaseName=QLSach;user=sa;password=123456789";
		cn = DriverManager.getConnection(url);
	}
}
