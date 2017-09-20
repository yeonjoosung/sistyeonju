<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, bean.*, java.util.*, alg.xmlmapxy"%>
<%@ include file="dbconnector.jsp" %>
 <jsp:useBean id="memMgr" class="dao.MemberMgr" />
<!doctype html>

<html lang="en">

<head>
 <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
  <title>plan your trip optimal route</title>
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
<!-- google map polygon -->
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=geometry"></script>
<!--script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script-->
<script>
var myTrip= new Array();
</script>
<%
String plan_code = (String)session.getAttribute("plan_code");
String sql = "select * from path where plan_code = '" + plan_code +"'";
//String sql = "select * from path order by path_node";
 
Statement stmt = conn.prepareStatement(sql);
 ResultSet rs = stmt.executeQuery(sql);
  while(rs.next()){
	String path_node =rs.getString("path_node");
 //  String clip_code =rs.getString("clip_code");
   String mapx = rs.getString("mapx");
  String mapy = rs.getString("mapy");
  %>

<script type="text/javascript">
<%-- var node<%=path_node%>=new google.maps.LatLng(<%=mapy%>,<%=mapx%>); 
myTrip[<%=path_node%>-1]= node<%=path_node%>;
 --%>
var myTrip = [		   new google.maps.LatLng(37.55917730680376, 126.97754909369093),
                       new google.maps.LatLng(37.56256594911314, 126.98574269554896),
                       new google.maps.LatLng(37.497510368763315, 127.02761294596193),
                   /*     new google.maps.LatLng(37.58018596118851, 126.9767235747301),
                       new google.maps.LatLng(37.56355472874449, 126.98609541331068), */
                       new google.maps.LatLng(37.503050, 126.980347)
			 ];
<%-- var node<%=path_node%>=new google.maps.LatLng(<%=mapy%>,<%=mapx%>); 
myTrip[<%=path_node%>-1]= node<%=path_node%>;
 --%>
/*   
myTrip[0]=node1;
myTrip[1]=node2;
myTrip[2]=node3;
*/             
                   
</script>

<%
 } 
  /* xmlmapxy a = new xmlmapxy();
	a.main(plan_code); */
%>
<script>      
var line;
var map;
var pointDistances;
function initialize() {
    var mapOptions = {
        center: new google.maps.LatLng(37.503050, 126.980347),
        zoom: 12,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById('map'), mapOptions);
//nodeclip
    map.setCenter(myTrip[0]);
    
    //point distances from beginning in %
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
        path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW
      // , scale: 5,
    //    strokeColor: '#393'
    };
    line = new google.maps.Polyline({
        path: myTrip,
      //  strokeColor: '#FF0000',
        strokeOpacity: 1.0,
        strokeWeight: 2,
        icons: [{
            icon: lineSymbol,
            offset: '100%',
           repeat: '100px'
        }],
        map: map
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
                });
           
        }
        
    /*     // we have only one icon
        var icons = line.get('icons');
        icons[0].offset = (offset) + '%';
        line.set('icons', icons);
        
        if (line.get('icons')[0].offset == "99.5%") {
            icons[0].offset = '100%';
            line.set('icons', icons);
            window.clearInterval(id);
        }
         */
    }, 20);
}

google.maps.event.addDomListener(window, 'load', initialize);

</script>
						<%
                        rs.close();
                        stmt.close();
                        conn.close();
                        %>  
</head>
<body>
 <div id="wrapper" >
 
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
                     <%
		            String member_id = (String)session.getAttribute("idKey");
			        if(member_id != null){
		               RegisterBean regBean = memMgr.memberMyRead(member_id);
				 		String member_name = regBean.getMember_name();
		         	%>
         
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <%=member_name %><b class="caret"></b></a>
                     <%
				         }else{
				     %>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>null<b class="caret"></b></a>
                    
                  <%
		            }
		         %>  
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i>Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i>Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i>Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i>Log Out</a>
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
            

        <div id="page-wrapper">
        <div class="container-fluid">
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Backpackers <small>Plan your trip</small>
                        </h1>
                        </div>
                        <a><%=plan_code%></a>
               </div>
  				 <div id='map' style='width:1000px;height:800px;'></div>       
               <div></div>
        </div>
	  </div>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>
</html>