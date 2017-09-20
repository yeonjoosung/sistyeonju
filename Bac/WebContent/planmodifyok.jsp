<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE script PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
</body>
<%  request.setCharacterEncoding("UTF-8");
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/backpackers?autoReconnect=true";
	String plan_code = request.getParameter("plan_code");
	
	try{
		Connection conn = DriverManager.getConnection(url, "root", "7790");
		Statement stmt = conn.createStatement();
			
		String sql = "select * from plan where plan_code='" + plan_code + "'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
	//	pstmt.setString(1,plan_code);
		session.setAttribute("plan_code", plan_code);
		response.sendRedirect("planyourtrip.jsp");
		%>
		<script>
		location.href="planyourtrip.jsp";
		</script>
		<%
		pstmt.execute();
		pstmt.close();
		conn.close();
	}
	catch(SQLException e){
		out.println(e.toString() ); 
		}
	%>		
</html>