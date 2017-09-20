<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
 <%@ page import = "java.sql.*, bean.*, java.util.*" %>
 <jsp:useBean id="memMgr" class="dao.MemberMgr" />
 
 <%
	request.setCharacterEncoding("UTF-8");
 	String plan_code = (String)session.getAttribute("plan_code");
 //	 String plan_code = request.getParameter("plan_code");
 %>
<!DOCTYPE html>
<html lang="en"> 

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Plan list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="css/planbootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <link id="theme-style" rel="stylesheet" href="css/styles.css">
    <style>
 #cnt1 {            
     background-color:rgb(245, 245, 220);
     width:90%;
     margin-bottom:70px;
 }
  
 .feature{
     padding: 20px 0;
    text-align: center;
 }
 .feature > div > div{
    padding: 10px;
    border: 1px solid transparent;
    border-radius: 4px;
    transition: 0.2s;
 }
 .feature > div:hover > div{
    margin-top: -10px;
    border: 1px solid rgb(128, 128, 128);
    box-shadow: rgba(0, 0, 0, 0.1) 0px 5px 5px 5px;
    background: rgba(232, 215, 215, 0.10);
    transition: 0.3s;
 }
 
 #new{
 position: relative;
 z-index:99999;
 margin-left:80%;
 bottom: 10px;
 background-color: rgb(216, 191, 216);
 border-color: rgb(216, 191, 216);
 color: rgb(0, 0, 0);
 
 font-size: 15px;
 }
</style>
</head>
<body>
  <%
         	 String member_id = (String)session.getAttribute("idKey");
            if(member_id != null){
               RegisterBean regBean = memMgr.memberMyRead(member_id);
               //String member_pw = regBean.getMember_pw();
               String member_name = regBean.getMember_name();
       %>
<header id="header" class="header"> 
    <div class="navbar navbar-default navbar-fixed-top">
        <div class="container">
        <h1 class="logo pull-left">
                <a class="scrollto" href="firstpage.jsp">
                    <span class="logo-title">backpacker</span>
                </a>
        </h1>
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
            </div>
            <div class="navbar-collapse collapse navbar-right scroll-me">
                <ul class="nav navbar-nav ">
        
           		<li class="nav-item"><a class="scrollto"><%=member_name %></a></li>
                <li class="nav-item"><a class="scrollto" href="logout.jsp">logout</a></li>
                      
                </ul>
            </div>

        </div>
    </div>
     </header>
 <%
Class.forName("com.mysql.jdbc.Driver");
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;   
try {
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/backpackers?autoReconnect=true", "root", "7790");
	stmt = conn.createStatement();
	rs = stmt.executeQuery("select * from plan where member_id='" + member_id + "' order by plan_code ");
	
%>
	
    	
<div class="container">
<div class="page-header">
   	<br><h1>Plan List <small>Backpacker Plan List</small></h1>   
</div>
<!-- Feature List - START -->
<a href="plan.jsp" id="new" class="btn btn-success lower">plan your new trip</a>
<div class="container" id="cnt1">
    <div class="row feature">
    
    <%
    while(rs.next()) {
    	String plan_title = rs.getString("plan_title");
    	String plan_st = rs.getString("plan_st");
    	String plan_period = rs.getString("plan_period");
   	 
    %><!-- planyourtrip.jsp?plan_code="+ plan_code +" -->
    <form name="frm" method="post" action='planmodifyok.jsp?plan_code=<%=rs.getString("plan_code") %> '>
        <div class="col-md-4">
            <div>
                <img src="img/ad.jpg" <%--art="<%= rs.getString("plan_code") %>" --%> class=" img-circle img-thumbnail" >
                <h2>TITLE <%= rs.getString("plan_title") %></h2>
                <h4>start day: <%= rs.getString("plan_st") %></h4>
               <h4><%= rs.getString("plan_period") %> DAY TRIP</h4>
                 <input type="hidden" name="plan_code" value="<%= rs.getString("plan_code") %>">
            <%--  <a href='./planyourtrip.jsp?plan_code=<%=plan_code %>' class="btn btn-success lower">Plan modify</a> --%>
       			<input type="submit" name="frm" class="btn btn-success lower" value="Plan modify" >
            </div>
        </div>
        <%session.setAttribute("plan_code", plan_code);%>
        </form>
        <%
       
	
}

}
catch (SQLException e) {%>
SQLException
<%
} finally {
	if(rs!= null)
		try {
			rs.close();
		} catch(SQLException e) {}
	
	if(stmt!= null)
		try {
			stmt.close();
		} catch(SQLException e) {}
	
	if(conn!= null)
		try {
			conn.close();
		} catch(SQLException e) {}
}}else{
    %>
    <script type="text/javascript">
		alert("session out. please login.");
		location.href = 'firstpage.jsp';
	</script>
  <%
    }
 %>            
    </div>
   
</div>

 




<!-- Feature List - END -->

</div>

</body>
</html>