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
			case 1: // �Խñ� �Է�
				inputNotice();
				break;
			case 2: // �Խñ� ��ȸ
				listNotice();
				break;
			case 3:
				break EXIT;
			}
		}

	}

	private static void listNotice() throws ClassNotFoundException, SQLException {
		System.out.println("        *�Խñ� ��ȸ          ");

		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";

		String sql = "SELECT ID,TITLE,HIT,REG_DATE FROM NOTICE";

		// jdbc ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// ���� /����
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		// ����
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
			System.out.println("�Խñ��� �������� �ʽ��ϴ�.");
		else
			for (Notice n : list) {
				System.out.println("���̵�: " + n.getId() + "\nŸ��Ʋ: " + n.getTitle() + "\t(��¥: " + n.getRegDate()
						+ ") ��ȸ��: " + n.getHit());
				System.out.println("------------------------------------------------------");

			}
	}

	private static void inputNotice() throws ClassNotFoundException, SQLException {

		String id = null;
		String title = null;
		String content = null;
		int hit = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("        *�Խñ��Է�          ");
		System.out.println("id�� �Է����ּ���.");
		id = scan.nextLine();
		System.out.println("������ �Է����ּ���.");
		title = scan.nextLine();
		System.out.println("�۳��븦 �Է����ּ���.");
		content = scan.nextLine();

		
		
//		-----------------------------------------insert
		service.insert(id,title,content);
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";

		String sql = "INSERT INTO NOTICE(ID,TITLE,CONTENT,HIT) " + "VALUES('" + id + "','" + title + "','" + content
				+ "'," + hit + ")";

		// jdbc ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// ���� /����
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		// ����
		Statement st = con.createStatement();

		st.executeUpdate(sql);

		st.close();
		con.close();

	}

	private static int inputMenu() {
		System.out.println("		*���θ޴�   ");
		System.out.printf("1.�Խñ��Է�\t2.�Խñ����\t3.����\n");
		Scanner scan = new Scanner(System.in);
		int menu = scan.nextInt();

		return menu;
	}

}