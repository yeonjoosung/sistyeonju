package data.jadbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import oracle.net.aso.n;

public class Program {
	private static NoticeService service;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EXIT: while (true) {
			switch (inputMenu()) {
			case 1: // 게시글 입력
				inputNotice();
				break;
			case 2: // 게시글 조회
				listNotice();
				break;
			case 3:
				break EXIT;
			}
		}

	}

	private static void listNotice() throws ClassNotFoundException, SQLException {
		System.out.println("        *게시글 조회          ");

		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";

		String sql = "SELECT ID,TITLE,HIT,REG_DATE FROM NOTICE";

		// jdbc 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 연결 /인증
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		// 실행
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);
/*
		List<Notice> list = new ArrayList<>();

		while (rs.next()) {
			Notice n = new Notice();
			n.setId(rs.getString("ID"));
			n.setTitle(rs.getString("TITLE"));
			n.setHit(rs.getInt("HIT"));
			n.setRegDate(rs.getDate("REG_DATE"));
			list.add(n);
		}

		rs.close();
		st.close();
		con.close();*/
		
		List<Notice> list = service.getList();
		
		
		
		// -------------------------------------view

		if (list.isEmpty())
			System.out.println("게시글이 존재하지 않습니다.");
		else
			for (Notice n : list) {
				System.out.println("아이디: " + n.getId() + "\n타이틀: " + n.getTitle() + "\t(날짜: " + n.getRegDate()
						+ ") 조회수: " + n.getHit());
				System.out.println("------------------------------------------------------");

			}
	}

	private static void inputNotice() throws ClassNotFoundException, SQLException {

		String id = null;
		String title = null;
		String content = null;
		int hit = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("        *게시글입력          ");
		System.out.println("id를 입력해주세요.");
		id = scan.nextLine();
		System.out.println("제목을 입력해주세요.");
		title = scan.nextLine();
		System.out.println("글내용를 입력해주세요.");
		content = scan.nextLine();

		
		
//		-----------------------------------------insert
		service.insert(id,title,content);
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";

		String sql = "INSERT INTO NOTICE(ID,TITLE,CONTENT,HIT) " + "VALUES('" + id + "','" + title + "','" + content
				+ "'," + hit + ")";

		// jdbc 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 연결 /인증
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		// 실행
		Statement st = con.createStatement();

		st.executeUpdate(sql);

		st.close();
		con.close();

	}

	private static int inputMenu() {
		System.out.println("		*메인메뉴   ");
		System.out.printf("1.게시글입력\t2.게시글출력\t3.종료\n");
		Scanner scan = new Scanner(System.in);
		int menu = scan.nextInt();

		return menu;
	}

}