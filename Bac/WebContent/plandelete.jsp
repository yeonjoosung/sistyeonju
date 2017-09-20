<%@ page contentType="text/html;charset=utf-8" import="java.sql.*" %>

<%
	request.setCharacterEncoding("utf-8");
	String clip_code = request.getParameter("clip_code");

	try{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/backpackers?autoReconnect=true";
		Connection conn = DriverManager.getConnection(url, "root", "7790");
		String sql = "DELETE FROM clipboard WHERE clip_code=?";
		
		
		PreparedStatement pstmt = conn.prepareStatement(sql); // 쿼리를 이용해 delete 실행!!
		
		pstmt.setString(1, clip_code);
		
		
		pstmt.executeUpdate();
		

		pstmt.close();

		
		conn.close();
	}
	catch(ClassNotFoundException e)
	{
		out.println(e);
	}
	catch(SQLException e)
	{
		out.println(e);
	}
	response.sendRedirect("planyourtrip.jsp");
%>
