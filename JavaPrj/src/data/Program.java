package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
//		String sql = "SELECT * FROM NOTICE";
		String sql = "SELECT * FROM NOTICE WHERE TITLE LIKE '%A%'";
		
		
		// jdbc ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// ���� /����
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		// ����
		Statement st = con.createStatement();
		// ��� ��������
		ResultSet rs = st.executeQuery(sql);
		// �������ϱ�

//		while (rs.next()) {
//			String title = rs.getString("title");
//			// if(title.contains("A"))
//			if (title.indexOf("A") != -1)
//				System.out.println(title);
//		}

		
		
//		while(rs.next())
//			System.out.println(id+" :"+title);
		
		while(rs.next())
			System.out.println(rs.getString("title"));
		rs.close();
		st.close();
		con.close();

	}

}
