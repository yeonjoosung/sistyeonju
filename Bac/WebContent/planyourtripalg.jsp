<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.sql.*, bean.*, java.util.*, alg.xmlmapxy"%>
<%@ include file="dbconnector.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>plan your trip</title>


		<%
      	String plan_code = (String)session.getAttribute("plan_code");
		
		xmlmapxy.main(null, plan_code);
      	
		
		/* xmlmapxy a = new xmlmapxy();
      	xmlmapxy.setPlan_code(plan_code);
      	String[] arg;
      	xmlmapxy a = new xmlmapxy();
      	a.setPlan_code(plan_code);
      	a.setStay_time(int[] stay_time);
      	 */
      	
      	%>  
</head>
<body>

	<script type="text/javascript">
		alert("Recommendation route find.");
		location.href = 'planyourtrip_result.jsp';
	</script>
</body>
</html>