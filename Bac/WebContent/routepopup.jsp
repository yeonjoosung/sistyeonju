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
String sql = "select * from clipboard where plan_code = '" + plan_code +"' order by length(clip_code) asc, clip_code asc;";
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
                         		<!--  <input type="hidden" name="clip_seq" list="clip_code"> -->
                              <!--   <select name="clip_seq" style="width:100%"> -->
                              <select name="clip_code" list="clip_code" style="width:100%">
                              <datalist id="clip_code">
							<%
							  while(rs.next()){
							  String clip_seq = rs.getString("clip_seq");
							  String clip_code =rs.getString("clip_code");
							  String contentid2 = rs.getString("contentid");
							%>
								<option id="<%=clip_code%>" value="<%=clip_code%>"></option>
								<script>
							  	xmlhttp.open("GET","http://api.visitkorea.or.kr/openapi/service/rest/EngService/detailCommon?ServiceKey=qh2McdZOlG3qxtQW7450Y%2FLYjFyFiLNWMopxvypDi8u7k1NiwoDVywy2OjhzmXmOYA7DuKs1x5mRH7pKtTFvqQ%3D%3D&contentId=<%=contentid2%>&defaultYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide",false);
								xmlhttp.send();
								xmlDoc=xmlhttp.responseXML;
								document.getElementById("<%=clip_code%>").innerHTML=xmlDoc.getElementsByTagName("title")[0].childNodes[0].nodeValue;
								</script> 
								<%
							  } 
								%> 
								</datalist></select>
							
							  </div>
							<%
							String sql3 = "select plan_period from plan where plan_code = '" + plan_code +"'";
							Statement stmt3 = conn.prepareStatement(sql3);
							 ResultSet rs3 = stmt3.executeQuery(sql3);
							  rs3.next();
							  String plan_period = rs3.getString("plan_period");
							  
							  int period = Integer.parseInt(plan_period);
							  for(int i = 0; i < period; i++){
							%>
							 <div class="form-group" >
                        	<%=i+1%> DAY END PLACE:
                             <select name="<%=i%>" list="end place" style="width:100%" >
                              <datalist id="end place">
							<%
							String sql2 = "select * from clipboard where plan_code = '" + plan_code +"'";
							Statement stmt2 = conn.prepareStatement(sql2);
							 ResultSet rs2 = stmt2.executeQuery(sql2);
							  while(rs2.next()){
							 // String clip_code =rs2.getString("clip_code");
							 String contentid = rs2.getString("contentid");
							 String clip_map = rs2.getString("clip_map");
								%> 
								<option id="<%=clip_map%><%=i%>" value="<%=contentid%>"></option>
								
								<script>
							  	xmlhttp.open("GET","http://api.visitkorea.or.kr/openapi/service/rest/EngService/detailCommon?ServiceKey=qh2McdZOlG3qxtQW7450Y%2FLYjFyFiLNWMopxvypDi8u7k1NiwoDVywy2OjhzmXmOYA7DuKs1x5mRH7pKtTFvqQ%3D%3D&contentId=<%=contentid%>&defaultYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide",false);
								xmlhttp.send();
								xmlDoc=xmlhttp.responseXML;
								document.getElementById("<%=clip_map%><%=i%>").innerHTML=xmlDoc.getElementsByTagName("title")[0].childNodes[0].nodeValue;
								</script> 	
								<%
						
								}rs2.close();
							    stmt2.close();
							    
								%>
								</datalist></select>
                            </div> 
                            
                            <%
                            }
                            %>
                            
                            
                            
                            
                            <div class="form-group">
                            <label>First DAY Start Time</label>
					    <br><p></p> 
                            <input type="time" name="plan_forward" placeholder="hrs:mins" value="10:00" required>
                            
                            
                        	</div>
                            <input type="submit" value="ok" class="btn btn-info btn-block" onclick="wincl()">
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
						rs3.close();
					    stmt3.close();
						conn.close();
                        %>  

</body>
</html>

<!-- 
    <form name="f1">
    
        staytime <input type="text" name="time"><br>
        <!-- 
        timewindow <input type="text" name="timewindow"><br>
       <input type="radio" value="1" name="day" value="1 day">1 day&nbsp
        <input type="radio" value="2" name="day" value="2 day">2 day&nbsp
       
        <input type="button" value="ok" onclick="wincl()">
    </form>


</body>
</html>
 -->

<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>place check</title>

<script>

   
    
    function wincl(){        // 팝업창 닫기 함수
        window.close();
    }
    
</script>

 
</head>
<body>
 -->
<!-- 
<style>
.in_modal_title_box {
  width: 100%;
  height: 60px;
  line-height: 60px;
  border-bottom: 1px solid #b3b3b3;
  font-size: 20px;
  color: #363636;
  padding-left: 13px;
  overflow: hidden;
}
.in_modal_btn_close {
  cursor: pointer;
  float: right;
}
.in_modal_footer{  width: 100%;  border-top: 1px solid #b3b3b3;  padding-top: 20px;  padding-bottom: 20px;  text-align: center;}
.in_modal_ok_btn{
  width: 145px;
  height: 42px;
  background: #ff9320;
  border: solid #f7870f 1px;
  cursor: pointer;
  line-height: 42px;
  color: #fff;
  font-size: 15px;
  font-weight: bold;
  margin: 0 auto;
}
.in_modal_content {
  width: 100%;
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 20px;
}


#opti_start_point{
  width: 318px;
  height: 31px;
  border: solid #c8c8ca 1px;
  color: #808080;
  font-size: 13px;
  padding-left: 12px;
  line-height: 31px;
  cursor: pointer;
  background: #fff url('/res/img/flight/drop_select_arrow_a.png') no-repeat 300px 12px;
}
#opti_start_point_box {
  position: absolute;
  width: 318px;
  padding: 10px;
  border: solid 1px #c8c8ca;
  background: #fff;
  padding-bottom: 3px;
  max-height: 252px;
  overflow-y: auto;
  display: none;
  margin-top: -1px;
  z-index: 9;
}
#opti_start_point_box .item {
  height: 18px;
  cursor: pointer;
  
  padding-left: 25px;
  line-height: 18px;
  margin-bottom: 7px;
}
#opti_start_point_box .item.on {
  
}

#opti_end_point{
  width: 318px;
  height: 31px;
  border: solid #c8c8ca 1px;
  color: #808080;
  font-size: 13px;
  padding-left: 12px;
  line-height: 31px;
  cursor: pointer;
  background: #fff url('/res/img/flight/drop_select_arrow_a.png') no-repeat 300px 12px;
}
#opti_end_point_box {
  position: absolute;
  width: 318px;
  padding: 10px;
  border: solid 1px #c8c8ca;
  background: #fff;
  padding-bottom: 3px;
  max-height: 252px;
  overflow-y: auto;
  display: none;
  margin-top: -1px;
  z-index: 9;
}
#opti_end_point_box .item {
  height: 18px;
  cursor: pointer;
  padding-left: 25px;
  line-height: 18px;
  margin-bottom: 7px;
}
#opti_end_point_box .item.on {
  
}

.in_modal_item_title{
  height:31px;
  line-height:31px;
  width:100px;
}
#in_modal_full_frame{width: 100%;  height: 2000px;  position: absolute;  top: 0px;  left: 0px;  background: url('/res/img/component/bg/bgb_70.png') repeat;  z-index: 999999999999;display:none;}
#in_modal_opti_a{width:468px;height:257px;background:#fff;margin:0 auto;margin-top:150px;display:none;}
#in_modal_opti_b{width:729px;min-height:534px;background:#fff;margin:0 auto;margin-top:150px;display:none;position:relative;}


</style>
  -->
  <!-- 
     star plce: <select name="place">
     
    <option id="pti_start_point" value="1" selected="selected">place1</option>
    <option value="2">place2</option>
    <option value="3">place3</option>
    <option value="4">place4</option>
    
     
</select>

<p> end plce: <select name="place">
     
    <option id="pti_start_point" value="1" >place1</option>
    <option value="2">place2</option>
    <option value="3">place3</option>
    <option value="4" selected="selected">place4</option>
    
     
</select>
 </p>
 <input type="button" value="ok" onclick="wincl()">
 
  <!-- 
<div id="in_modal_full_frame">
      <div id="in_modal_opti_a">
         
         <div class="in_modal_content">
              <div class="fl in_modal_item_title">첫번째 장소</div>
              <div class="fl" style="position:relative">
                  <div id="opti_start_point" data-is_open="0"></div>
                  <div id="opti_start_point_box" class="et_slide" style="display: none;">
               
                  </div>
                  <input type="hidden" id="opti_start_id">
              </div>
              <div class="clear" style="padding-top:10px;"></div>
              <div class="fl in_modal_item_title">마지막 장소</div>
              <div class="fl" style="position:relative">
                  <div id="opti_end_point" data-is_open="0"></div>
                  <div id="opti_end_point_box" class="et_slide" style="display: none;">

                  </div>
                  <input type="hidden" id="opti_end_id">
              </div>
              <div class="clear" style="padding-top:20px;"></div>
         </div>
         <div class="in_modal_footer">
            <div class="in_modal_ok_btn" onclick="optimize_route_go()">
             완료   </div>
          </div>
      </div>
      </div>
 <!--완료-->
<!-- 
</body>
</html>
 -->