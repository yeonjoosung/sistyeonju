<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%-- <%@ page import="java.sql.*, bean.*, java.util.*"%>
<%@ include file="dbconnector.jsp" %>
 <jsp:useBean id="memMgr" class="dao.MemberMgr" /> --%>
<%-- <%
String plan_code = (String)session.getAttribute("plan_code");
%> --%>
<!DOCTYPE script PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>plan your trip</title>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Button -->
    <link href="button.css" rel="stylesheet" type="text/css">
    
 <style>
  #sortable1 { list-style-type: none; margin: 0; float: left; margin-right: 10px; background: #eee; padding: 5px; width: 30%;}
  #sortable3 { list-style-type: none; margin: 0; float: left; margin-right: 10px; background: #eee; padding: 5px; width: 30%;}
  #sortable1 li, #sortable2 li, #sortable3 li { margin: 5px; padding: 5px; font-size: 1.2em; width: 95%; }
  #sortable3 ul { margin: 0px; padding: 10px; font-size: 1.2em; width: 110%; }
  </style>
  <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=geometry"></script>
<!-- 드래그앤드롭 -->
<script type="text/javascript">
/*   $(function() {
   $( "#sortable3" ).accordion({
         heightStyle: "content"
       });

    $( "ul.droptrue" ).sortable({
      connectWith: "ul"
    });
    $( "ul.dropfalse" ).sortable({
      connectWith: "ul",
      dropOnEmpty: false
    });
    $( "#sortable1, #sortable3" ).ableSelection();
  });
   */
   $(function() {
	    $( "#sortable1" ).sortable({
	  
	    }).disableSelection();
	  });

	function save_order(){
	   var idsInOrder = $("#sortable2").sortable("toArray");
	   /* $("ul#sortable1 li").each(function() { idsInOrder.push($(this).text()) });
	alert(idsInOrder.join('\n'));
	document.form.action='tripseq.jsp?clip_seq==idsInOrder&plan_code=plan_code';
	document.form.submit;
	 $sqlStmt  = ("update clipboard set clip_seq = '"+clip_seq+"' where plan_code='"+plan_code+"' order by clip_seq");
	
	 */
	}
  </script>
<script>
var myTrip= new Array();
var line;
var map;
var pointDistances;
function initialize() {
    var mapOptions = {
        center: new google.maps.LatLng(37.503050, 126.980347),
        zoom: 13,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    map = new google.maps.Map(document.getElementById('clip_map'), mapOptions);
//nodeclip
  
    map.setCenter(myTrip[0]);
    
    // point distances from beginning in %
    var sphericalLib = google.maps.geometry.spherical;

    pointDistances = [];
    var pointZero = myTrip[0];
    var wholeDist = sphericalLib.computeDistanceBetween(
                        pointZero,
                        myTrip[myTrip.length - 1]);
    
    for (var i = 0; i < myTrip.length; i++) {
        pointDistances[i] = 100 * sphericalLib.computeDistanceBetween(
        		myTrip[i], pointZero) / wholeDist;
        console.log('pointDistances[' + i + ']: ' + pointDistances[i]);
    }

    // define polyline
    var lineSymbol = {
     //   path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW ,
			scale: 2,
        strokeColor: '#FF0000'
    };

    line = new google.maps.Polyline({
        path: myTrip,
    //    strokeColor: '#FF0000',
        strokeOpacity: 1.0,
        strokeWeight: 2,
        icons: [{
            icon: lineSymbol,
            offset: '100px',
            repeat: '120px'
        }],
    //    map: map
    });

    animateCircle();
}
var id;
function animateCircle() {
    var count = 0;
    var offset;
    var sentiel = -1;
    id = window.setInterval(function () {
        count = (count + 1) % 200;
        offset = count /2;
        
        for (var i = pointDistances.length - 1; i > sentiel; i--) {
           
                var marker = new google.maps.Marker({
                  
                    position: line.getPath().getAt(i),
                    title: line.getPath().getAt(i).toUrlValue(6),
                    map: map
                 //,   icon : 'http://chart.apis.google.com/chart?chst=d_map_spin&chld=1|0|FF6C6C|20|b|' /* + (i+1) */
                });
        }
         
       /*  // we have only one icon
        var icons = line.get('icons');
        icons[0].offset = (offset) + '%';
        line.set('icons', icons);
        
        if (line.get('icons')[0].offset == "99.5%") {
            icons[0].offset = '100%';
            line.set('icons', icons);
            window.clearInterval(id);
        } */
    }, 20);
}

google.maps.event.addDomListener(window, 'load', initialize);
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
 <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="firstpage.jsp">Backpackers</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                
                <li class="dropdown">
                   <%--   <%
		            String member_id = (String)session.getAttribute("idKey");
			        if(member_id != null){
		               RegisterBean regBean = memMgr.memberMyRead(member_id);
				 		String member_name = regBean.getMember_name();
		         	%> --%>
         
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <%-- <%=member_name %> --%><b class="caret"></b></a>
                     
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i>Profile</a>
                        </li>
                        <li>
                            <a href="planmodify.jsp"><i class="fa fa-fw fa-gear"></i>plan change</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="logout.jsp"><i class="fa fa-fw fa-power-off"></i>Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                	<li class="active">
                        <a href="planyourtrip.jsp"><i class="fa fa-fw fa-dashboard"></i>Plan your trip</a>
                    </li>
                    <li>
                        <a href="attraction.jsp"><i class="fa fa-fw fa-bar-chart-o"></i>Attraction</a>
                    </li>
                    <li>
                        <a href="accommodation.jsp"><i class="fa fa-fw fa-table"></i>Accommodation</a>
                    </li>
                    <li>
                        <a href="shopping.jsp"><i class="fa fa-fw fa-edit"></i>Shopping</a>
                    </li>
                    <li>
                        <a href="food.jsp"><i class="fa fa-fw fa-desktop"></i>Food</a>
                    </li>
                    <li>
                        <a href="diary.jsp"><i class="fa fa-fw fa-wrench"></i>Diary</a>
                    </li>
                </ul>
            </div>
            </nav>
      	<%-- <%
      	String sql = "select * from clipboard where plan_code = '" + plan_code +"' order by length(clip_map) asc, clip_map asc;";
      	Statement stmt = conn.prepareStatement(sql);
 		 ResultSet rs = stmt.executeQuery(sql);
      	%> --%>
        <div id="page-wrapper">
        <div class="container-fluid">
                <div class="row">
                  <div class="col-lg-12">
                        <h1 class="page-header">
                            Backpackers <small>Plan your trip<p> </p>
                            <input type="submit" value="Recommend route" class="btn btn-primary btn-lg gradient" onclick="javascript:location.href='planyourtripalg.jsp'">
                       		<input type="submit" value="Storage route view" class="btn btn-primary btn-lg gradient" onclick="javascript:location.href='planyourtrip_result.jsp'">
                       		<input type="submit" value="Forward Route setting" class="btn btn-primary btn-lg gradient" onclick="javascript:location.href='routepopup.jsp'"></small> 
                       	</h1>
				 </div>
<ul id="sortable1" class="connectedSortable"> <!-- style="width: 33%"  -->
<%-- <%
  while(rs.next()){
  String clip_seq = rs.getString("clip_seq");
  String clip_map = rs.getString("clip_map");
  String clip_code =rs.getString("clip_code");
  String contentid = rs.getString("contentid");
  String clip_stay = rs.getString("clip_stay");
  String mapy = rs.getString("mapy");
  String mapx = rs.getString("mapx");
%>  --%>
	<form name="form" method="post" action="planchange.jsp">
	<div class="ui-state-default" <%-- id="<%=clip_seq%>" --%> style="text-align: center;" >
		<li <%-- id="<%=clip_code%>" --%>></li>
		staytime
		<input type="hidden" id="clip_code" name="clip_code" value="<%-- <%=clip_code%> --%>" size="2px" style="text-align: center;">
		<input type="text" id="clip_stay" name="clip_stay" value="<%-- <%=clip_stay%> --%>" size="2px" style="text-align: center;">
		<input type="submit" name="formbutton1" value="change" <%-- onclick="location.href='plandelete.jsp?clip_code=<%=clip_code%>&clip_seq=<%=clip_seq %>&clip_stay=<%=clip_stay%>'"  --%>>
		<input type="button" value="delete" onclick="location.href='plandelete.jsp?clip_code=<%-- <%=clip_code%>&clip_seq=<%=clip_seq %> --%>'" >
		</div>
		</form>
	<%-- <script type="text/javascript">
var node<%=clip_map%>=new google.maps.LatLng(<%=mapy%>,<%=mapx%>); 
myTrip[<%=clip_map%>-1]= node<%=clip_map%>;

/* 
myTrip[0]=node1;
myTrip[1]=node2;
myTrip[2]=node3;
myTrip[3]=node4;
myTrip[4]=node5;
myTrip[5]=node6;
myTrip[6]=node7;
 */
	</script> --%>
<%-- 
<%
}
%> --%>

</ul>

<div id='clip_map' style='width: 66%; height: 650px;'></div>



</div>
 </div>

<!-- <input type="submit" value="save_order" onclick="save_order()"> -->

 <br><Br>
 
 <!-- <input type="submit" value="plan route result" class="optimal route" onclick="javascript:location.href='planyourtrip_result.jsp'"> -->
<!-- <br style="clear:both">
 --> 
<%-- 
<%
	 					rs.close();
                        stmt.close();
                        conn.close();
                        %>  
<%}
else{
    %> --%>
   <!--  <script type="text/javascript">
		alert("session out. please login.");
		location.href = 'firstpage.jsp';
	</script> -->
<%--   <%
    }
 %>      
			 --%>			
                        
                        
<!-- 
<ul id="sortable2" class="dropfalse">
  <li class="ui-state-highlight">Cannot be dropped..</li>
  <li class="ui-state-highlight">..on an empty list</li>
  <li class="ui-state-highlight">Item 3</li>
  <li class="ui-state-highlight">Item 4</li>
  <li class="ui-state-highlight">Item 5</li>
</ul>
  -->
  
<!-- <input type="submit" value="optimal route" class="optimal route" onclick="planyourtripalg.jsp"> -->
                        
<!-- 
 <div id="sortable3">
    <h2><a href="#">Day1</a></h2>
    <div>
      <ul id="sortable3" class="droptrue" >
</ul>
    </div>
    
    <h2><a href="#">Day2</a></h2>
    <div>
      <ul id="sortable3" class="droptrue">
</ul>
    </div>
    <h2><a href="#">Day3</a></h2>
    <div>
      <ul id="sortable3" class="droptrue">
</ul>
    </div>
  
    <h2><a href="#">Day4</a></h2>
    <div>
      <ul id="sortable3" class="droptrue">
</ul>
    </div>
  </div> -->

</div>
</div>

 
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>