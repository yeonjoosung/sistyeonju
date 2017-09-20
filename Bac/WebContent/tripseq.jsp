<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>trip sequence</title>
</head>
<body>
<%  
	request.setCharacterEncoding("utf-8");
	String plan_code = request.getParameter("plan_code");
	System.out.println(plan_code);
	String clip_seq = request.getParameter("clip_seq");
	Class.forName("org.gjt.mm.mysql.Driver");
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	 int updateCount = 0;
	 
	try{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/backpackers?autoReconnect=true", "root", "7790");
		stmt = conn.createStatement();
		
		updateCount = stmt.executeUpdate("update clipboard set clip_seq = '"+clip_seq+"' where plan_code='"+plan_code+"'"); 
		System.out.println(updateCount);
	}
	 finally {
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
} else { %>
change error.
<% } %>	
</body>
</html>