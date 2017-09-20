<%@ page contentType="text/html;charset=utf-8" import="java.sql.*" %>

<%
	request.setCharacterEncoding("utf-8");
	String plan_code = request.getParameter("plan_code");
//	String path_code = request.getParameter("path_code");


	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/backpackers?autoReconnect=true";
		Connection conn = DriverManager.getConnection(url, "root", "7790");
		String sql = "DELETE FROM path WHERE plan_code='"+ plan_code +"'";
		String sql2 = "DELETE FROM travel WHERE plan_code='"+ plan_code +"'";
		System.out.println(sql);
		PreparedStatement pstmt = conn.prepareStatement(sql); // 쿼리를 이용해 delete 실행!!
		PreparedStatement pstmt2 = conn.prepareStatement(sql2); // 쿼리를 이용해 delete 실행!!
		//pstmt.setString(1, plan_code);
		pstmt.executeUpdate();
		pstmt2.executeUpdate();
		pstmt.close();
		pstmt2.close();
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
