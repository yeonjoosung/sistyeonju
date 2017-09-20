package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String input;

		Scanner scan = new Scanner(System.in);
		System.out.print("검색어를 입력하세요(Title검색) : ");
		input = scan.nextLine();

		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String sql = "SELECT * FROM NOTICE WHERE TITLE LIKE '%" + input + "%'";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if (!rs.next())
			System.out.println("값이 없습니다.");
		else
			do {
				System.out.println("아이디: " + rs.getString("ID") + ", 타이틀: " + rs.getString("title"));
			} while (rs.next());
		rs.close();
		st.close();
		con.close();

	}
}
