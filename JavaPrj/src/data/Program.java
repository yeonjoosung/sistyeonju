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
		
		
		// jdbc 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 연결 /인증
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		// 실행
		Statement st = con.createStatement();
		// 결과 가져오기
		ResultSet rs = st.executeQuery(sql);
		// 결과사용하기

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
