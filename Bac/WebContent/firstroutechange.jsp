<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE script PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<%  
	request.setCharacterEncoding("utf-8");
	String clip_code = request.getParameter("clip_code");
	String clip_stay = request.getParameter("clip_stay");
	Class.forName("org.gjt.mm.mysql.Driver");
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	 int updateCount = 0;
	try{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/backpackers?autoReconnect=true", "root", "7790");
		stmt = conn.createStatement();
		updateCount = stmt.executeUpdate("update clipboard set clip_stay = '"+clip_stay+"' where clip_code='"+clip_code+"'"); 
		//System.out.println(updateCount);
	} finally {
		if(stmt != null)
			try{
				stmt.close();
			} catch (Exception e) {}
		
		if(rs != null)
			try {
				rs.close();
			} catch (Exception e) {}
		
		if(conn != null)
			try {
				conn.close();
			} catch (Exception e) {}
		
	}
	%>		
<% if(updateCount > 0) { 
response.sendRedirect("planyourtrip.jsp");
} else { %>
stay time change error.
<% } %>	
</body>		
</html>