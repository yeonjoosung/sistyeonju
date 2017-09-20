import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/hello")
public class Nana extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		OutputStream os = response.getOutputStream();
		PrintStream out = new PrintStream(os);

		String sql = "SELECT *FROM Notice";

		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// ���� / ����
			Connection con = DriverManager.getConnection(url, "sist", "cclass");

			// ����
			Statement st = con.createStatement();

			// ��� ��������
			ResultSet rs = st.executeQuery(sql);

			// Model
			List<Notice> list = new ArrayList<>();

			// ��� ����ϱ�
			while (rs.next()) {
				Notice n = new Notice();
				n.setId(rs.getString("ID"));
				n.setTitle(rs.getString("TITLE"));
				// ..

				list.add(n);
			}
			rs.close();
			st.close();
			con.close();

			System.out.println(list.get(0).getTitle());
		} catch (Exception e) {
		}
		
		
	}
}