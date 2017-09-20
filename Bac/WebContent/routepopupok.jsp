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
	String plan_code = (String)session.getAttribute("plan_code");
	String clip_code = request.getParameter("clip_code");
	String contentid = request.getParameter("contentid");
	String plan_forward = request.getParameter("plan_forward");
	String a = request.getParameter("0");
	String b = request.getParameter("1");
	String c = request.getParameter("2");
	String d = request.getParameter("3");
	String f = request.getParameter("4");
	
	  

	
	//System.out.println(i);
	//System.out.println(contentid);
	
	//Integer.parseInt(request.getParameter("i"));
	
	
	
	Class.forName("org.gjt.mm.mysql.Driver");
	Connection conn = null;
	Statement stmt = null;
	Statement stmt2 = null;
	Statement stmt3 = null;
	Statement stmt4 = null;
	Statement stmt5 = null;
	Statement stmt6 = null;
	Statement stmt7 = null;
	
	ResultSet rs = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	ResultSet rs4 = null;
	ResultSet rs5 = null;
	ResultSet rs6 = null;
	ResultSet rs7 = null;
	
	
	int updateCount = 0;
	int updateCount2 = 0;
	int updateCount3 = 0;
	int updateCount4 = 0;
	int updateCount5 = 0;
	int updateCount6 = 0;
	int updateCount7 = 0;
	
	

	
	try{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/backpackers?autoReconnect=true", "root", "7790");
		stmt = conn.createStatement();
		stmt2 = conn.createStatement();
		stmt3 = conn.createStatement();
		stmt4 = conn.createStatement();
		stmt5 = conn.createStatement();
		stmt6 = conn.createStatement();
		stmt7 = conn.createStatement();
		
		
		
		updateCount = stmt.executeUpdate("update plan set plan_forward = '"+plan_forward+"' where plan_code='"+plan_code+"'"); 
		updateCount2 = stmt2.executeUpdate("update clipboard set clip_seq = '0' where clip_code='"+clip_code+"'"); 
		
		/* String sql = "update clipboard set clip_seq = '1000'+'"+ i +"' where contentid='"+contentid+"'";
		updateCount3 = stmt3.executeUpdate(sql);
		System.out.println(sql);
		 */
		System.out.println(updateCount);
		
		
		updateCount3 = stmt3.executeUpdate("update clipboard set clip_seq = '1000' where contentid='"+a+"'"); 
		updateCount4 = stmt4.executeUpdate("update clipboard set clip_seq = '1001' where contentid='"+b+"'"); 
	 	updateCount5 = stmt5.executeUpdate("update clipboard set clip_seq = '1002' where contentid='"+c+"'"); 
	 	/* updateCount6 = stmt6.executeUpdate("update clipboard set clip_seq = '1003' where contentid='"+d+"'"); 
	 	updateCount7 = stmt7.executeUpdate("update clipboard set clip_seq = '1004' where contentid='"+f+"'"); 
		 */
		
		
		
		

	} finally {
		if(stmt != null&stmt2 != null&stmt3 != null)
			try{
				stmt.close();
				stmt2.close();
				stmt3.close();
				
				
			} catch (Exception e) {}
		
		if(rs != null&rs2 != null&rs3 != null)
			try {
				rs.close();
				rs2.close();
				rs3.close();
				
				
			} catch (Exception e) {}
		
		if(conn != null)
			try {
				conn.close();
			} catch (Exception e) {}
		
	}
	%>		
<% if(updateCount > 0&updateCount2 > 0) {
response.sendRedirect("planyourtrip.jsp");
} else { %>
plan change or sequence error.
<% } %>	
</body>		
</html>