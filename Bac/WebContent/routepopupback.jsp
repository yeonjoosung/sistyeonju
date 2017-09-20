<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*, bean.*, java.util.*"%>
<%@ include file="dbconnector.jsp" %>
 <jsp:useBean id="memMgr" class="dao.MemberMgr" />
<%
String plan_code = (String)session.getAttribute("plan_code");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8" />
   <title>place select</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="css/register.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/register.min.js"></script>
    <style>
	#container1 {
	    background-size: cover;
	}
	.centered-form {
	    margin-top: 10px;
	    margin-bottom: 10px;
	}
	.centered-form .panel {
	    background: rgba(255, 255, 255, 0.8);
	    box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
	}
</style>
<script>
    function useId(){  // 중복체크하여 보여주는 함수(나중에 DB와 연동해야함)
        alert(document.f1.userId.value);
        opener.f1.userId.value = document.f1.userId.value;
        self.close();
    }
    function wincl(){        // 팝업창 닫기 함수
        window.close();
    }
</script>
<script>
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
</script>
</head>
<body>
<%
String sql = "select * from clipboard where plan_code = '" + plan_code +"'";
	Statement stmt = conn.prepareStatement(sql);
	 ResultSet rs = stmt.executeQuery(sql);
   	 %>
<div class="container">
 <div class="container" id="container1">
        <div class="row centered-form">
            <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title text-center"> Please select start - end place  <%-- <%=plan_code%> --%></h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" action="routepopupok.jsp" method="post">
                            <div class="form-group" >
                            START PLACE: 
                              <!--   <select name="clip_seq" style="width:100%"> -->
                              <select list="start place" style="width:100%">
                              <datalist id="start place">
							<%
							  while(rs.next()){
							  String clip_seq = rs.getString("clip_seq");
							 // String clip =rs.getString("clip_code");
							  String contentid = rs.getString("contentid");
							  String clip_stay = rs.getString("clip_stay");
							  String mapy = rs.getString("mapy");
							  String mapx = rs.getString("mapx");
							%>
								<option id="<%=clip_seq%>" value="0"></option>
								<%-- <input type="hidden" id="clip_seq" value="<%=clip_seq%>"> --%>
								<script>
							  	xmlhttp.open("GET","http://api.visitkorea.or.kr/openapi/service/rest/EngService/detailCommon?ServiceKey=vs3Y%2Fm4qc9WmDzyaJyRtihhpYfhEAMtgaZHZPOt1quhUS27jSkmk%2FSIF7ZnAtfy6NqzC1Gvw7BiWxVbJgnQ%2Bvw%3D%3D&contentId=<%=contentid%>&defaultYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide",false);
								xmlhttp.send();
								xmlDoc=xmlhttp.responseXML;
								document.getElementById("<%=clip_seq%>").innerHTML=xmlDoc.getElementsByTagName("title")[0].childNodes[0].nodeValue;
								</script> 
								<%
							  } 
								%> 
								</datalist></select>
							  </div>
							<%
								String sql2 = "select * from clipboard where plan_code = '" + plan_code +"'";
									Statement stmt2 = conn.prepareStatement(sql2);
									 ResultSet rs2 = stmt2.executeQuery(sql2);
							%>
							<div class="form-group" >
                        	 DAY END PLACE: 
                             <select list="end place" style="width:100%" >
                              <datalist id="end place">
							<%
							  while(rs2.next()){
							  String clip_code =rs2.getString("clip_code");
							  String contentid2 = rs2.getString("contentid");
								%> 	
								<option id="<%=clip_code%>" value="1000"></option>
								
								<script>
							  	xmlhttp.open("GET","http://api.visitkorea.or.kr/openapi/service/rest/EngService/detailCommon?ServiceKey=vs3Y%2Fm4qc9WmDzyaJyRtihhpYfhEAMtgaZHZPOt1quhUS27jSkmk%2FSIF7ZnAtfy6NqzC1Gvw7BiWxVbJgnQ%2Bvw%3D%3D&contentId=<%=contentid2%>&defaultYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide",false);
								xmlhttp.send();
								xmlDoc=xmlhttp.responseXML;
								document.getElementById("<%=clip_code%>").innerHTML=xmlDoc.getElementsByTagName("title")[0].childNodes[0].nodeValue;
								</script> 
								<%
								}
								%>
								</datalist></select>
                            </div>
                            <div class="form-group">
                            <label>LAST DAY END Time</label>
					    <br><p></p> 
                            <input type="time" name="plan_forward" placeholder="hrs:mins" value="22:00" min="09:00" max="22:00" required>
                            </div>
                            <input type="submit" value="ok" class="btn btn-info btn-block" onclick="wincl()">
                             <!-- 
                             <input type="button" value="ok" onclick="wincl()">
                              -->
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
	<%
						rs.close();
					    stmt.close();
					    rs2.close();
					    stmt2.close();
						conn.close();
                        %>  
</body>
</html>