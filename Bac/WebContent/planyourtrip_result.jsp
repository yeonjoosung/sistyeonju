<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, bean.*, java.util.*"%>
<%@ include file="dbconnector.jsp" %>
 <jsp:useBean id="memMgr" class="dao.MemberMgr" />
 <%
 request.setCharacterEncoding("UTF-8");
 %>
<!DOCTYPE script PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <!--Table style  -->
    <link rel="stylesheet" type="text/css" href="css/table-column-options.css" />
    <!--button style  -->
    <link rel="stylesheet" type="text/css" href="css/button.css" />
    
<!-- google map polygon -->
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=geometry"></script>
<!--script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script-->
  <style> /* ol style */
         ol{
            counter-reset: li;
            list-style: none;
            *list-style: decimal;
            font: 15px 'trebuchet MS', 'lucida sans';
            padding: 0;
            margin-bottom: 4em;
            text-shadow: 0 1px 0 rgba(255,255,255,.5);
         }
         ol ol{
            margin: 0 0 0 10em;
         }
         /* -------------------------------------- */
         .rectangle-list a{
            position: relative;
            display: block;
            padding: .4em .4em .4em .8em;
            *padding: .4em;
            margin: .5em 0 .5em 2.5em;
            background: #ddd;
            color: #444;
            text-decoration: none;
            -webkit-transition: all .3s ease-out;
            -moz-transition: all .3s ease-out;
            -ms-transition: all .3s ease-out;
            -o-transition: all .3s ease-out;
            transition: all .3s ease-out;   
         }
         .rectangle-list a:hover{
            background: #eee;
         }   
         .rectangle-list a:before{
            content: counter(li);
            counter-increment: li;
            position: absolute;   
            left: -2.5em;
            top: 50%;
            margin-top: -1em;
            background: #fa8072;
            height: 2em;
            width: 2em;
            line-height: 2em;
            text-align: center;
            font-weight: bold;
         }
         .rectangle-list a:after{
            position: absolute;   
            content: '';
            border: .5em solid transparent;
            left: -1em;
            top: 50%;
            margin-top: -.5em;
            -webkit-transition: all .3s ease-out;
            -moz-transition: all .3s ease-out;
            -ms-transition: all .3s ease-out;
            -o-transition: all .3s ease-out;
            transition: all .3s ease-out;            
         }
         .rectangle-list a:hover:after{
            left: -.5em;
            border-left-color: #fa8072;            
         }
      </style>   

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

    map = new google.maps.Map(document.getElementById('path_map'), mapOptions);
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
        path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW
    ,    scale: 2,
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
                    map: map,
                    icon : 'http://chart.apis.google.com/chart?chst=d_map_spin&chld=1|0|FF6C6C|20|b|' + (i+1)
                });
        }
         
      /*   // we have only one icon
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
                    <%}else{
                 %>
                      <script type="text/javascript">
                  alert("session out. please login.");
                  location.href = 'firstpage.jsp';
               </script>
                  <%
                  }
               %>
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
        <%
        try{
           String plan_code = (String)session.getAttribute("plan_code");
          //  String clip_code =rs.getString("clip_code");
          %>
        <div id="page-wrapper">
        <div class="container-fluid">
                <!-- Page Heading -->
                <div class="row">
                  <div class="col-lg-12"> 
                        <h1 class="page-header">
                            Plan your trip <small>Plan Recommendation route Detail
                            <input type="button" class="btn btn-primary btn-lg gradient" name="path delete" value="best path delete" onclick="javascript:location.href='pathdelete.jsp?plan_code=<%=plan_code%>'"; >      
                            </small>
                        </h1>
                       </div>  
</div>

<div id='path_map' style='width: 100%; height:500px; display: inline-block;'></div><br><p></p>
<%--    
<%
String sql2 = "select * from travel where plan_code='" + plan_code + "' and travel_day='1' ";
Statement stmt2 = conn.prepareStatement(sql2);
 ResultSet rs2 = stmt2.executeQuery(sql2);/*  order by travel_day */
 rs2.next();
 String travel_day = rs2.getString("travel_day");
 String travel_transtime = rs2.getString("travel_transtime");
 String travel_endtime = rs2.getString("travel_endtime");
 String travel_waiting = rs2.getString("travel_waiting");
%>
   <table class="column-options" style="display: inline-block" >
   <tr>
       <th><center><%=travel_day%>day</center></th>
   </tr>
    <tr>
       <td><strong>Total transportation time</strong></td>
    </tr>
    <tr class="odd">
       <td><%=travel_transtime%>minute</td>
    </tr>
    <tr>
       <td><strong>travel end time</strong></td>
    </tr>
    <tr class="odd">
       <td><%=travel_endtime%></td>
    </tr>
    <tr>
       <td><strong>Total waiting time</strong></td>
    </tr>
    <tr class="odd">
       <td><%=travel_waiting%></td>
    </tr>
<!--     <tr>
       <td><a href="" class="button">sign up now</a></td>
   </tr> -->
</table>
    --%>
    <table class="column-options" style='width: 100%;display: inline-block;'  >
<%
/* and travel_day > '1'  */
String sql3 = "select * from travel where plan_code='" + plan_code + "' ";
Statement stmt3 = conn.prepareStatement(sql3);
ResultSet rs3 = stmt3.executeQuery(sql3);/*  order by travel_day */





    while(rs3.next()) {
       String day = rs3.getString("travel_day");
       String transtime = rs3.getString("travel_transtime");
       String endtime = rs3.getString("travel_endtime");
       String waiting = rs3.getString("travel_waiting");
       
%><!-- style="display: inline-block" -->


   <tr>
       <th><center><%=day%> day</center></th>
   </tr>
   
    <!--     <tr>
       <td><a href="" class="button">sign up now</a></td>
   </tr> -->
   
   <tr><td><!--width:60%; width: 36%; -->
   
   
   <ol class="rectangle-list" style=" width: 100%; display: inline-block; vertical-align: top;" > 
<%
String sql = "select * from path where plan_code = '" + plan_code +"' and path_day='" + day + "' order by length(path_node) asc, path_node asc";
//String sql = "select * from path order by path_node";
Statement stmt = conn.prepareStatement(sql);
 ResultSet rs = stmt.executeQuery(sql);
 
 
 String sql2 = "select count(*) as COUNT from path where plan_code='" + plan_code + "' and path_day<'"+ day +"' ";
 Statement stmt2 = conn.prepareStatement(sql2);
 ResultSet rs2 = stmt2.executeQuery(sql2);/*  order by travel_day */
 rs2.next() ;
 String COUNT =rs2.getString("COUNT");
 

 
 while(rs.next()){
      String mapx = rs.getString("mapx");
      String mapy = rs.getString("mapy");
      String contentid = rs.getString("contentid");
      String path_node =rs.getString("path_node");
      String path_day =rs.getString("path_day");
      String arrive =rs.getString("arrive");
      
      
      int arrival= Integer.valueOf(arrive)/60;
      int arrivalminutes= Integer.valueOf(arrive)%60; 
      
  %>

      
      
 <!--   <div style="width:20%; display: inline-block;"> -->
 
   <div id="<%=path_node%><%= day%>" style="text-align: center;">
         <li><a id="<%=contentid%>"></a>  <%--<a href='attraction_view.jsp?contentid=<%contentid%>'></a> --%>
            <%-- <%=arrival%> Hour <%=arrivalminutes%> minutes --%>
             <strong>arrive time: </strong> <%=arrival%> Hour <%=arrivalminutes%> minutes
    
            <!-- <ol>
               <li><a href="">교통</a></li> 
            </ol> -->  
         </li>
       
            
          
      </div>      
   <script>
     xmlhttp.open("GET","http://api.visitkorea.or.kr/openapi/service/rest/EngService/detailCommon?ServiceKey=qh2McdZOlG3qxtQW7450Y%2FLYjFyFiLNWMopxvypDi8u7k1NiwoDVywy2OjhzmXmOYA7DuKs1x5mRH7pKtTFvqQ%3D%3D&contentId=<%=contentid%>&defaultYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide",false);
   xmlhttp.send();
   xmlDoc=xmlhttp.responseXML;
   document.getElementById("<%=contentid%>").innerHTML=xmlDoc.getElementsByTagName("title")[0].childNodes[0].nodeValue;
   </script>
   
   <script type="text/javascript">
   var node<%=path_node%>=new google.maps.LatLng(<%=mapy%>,<%=mapx%>); 
   myTrip[<%=path_node%>-1]= node<%=path_node%>;
   </script>
<%






  }rs.close();
  stmt.close();
  rs2.close();
  stmt2.close();
%>

<%
int time= Integer.valueOf(transtime)/60;
int minutes= Integer.valueOf(transtime)%60;
int etime= Integer.valueOf(endtime)/60;
int etimeminutes= Integer.valueOf(endtime)%60;
  
%>

</ol>   
</td>
</tr>
 <tr class="odd">
       <td><strong>Total transportation time: </strong><%=time%> Hour <%=minutes%> minutes (<%=transtime%> minutes )</td>
    </tr>
     <tr>
       <td><strong>travel end time: </strong><%=etime%> Hour <%=etimeminutes%> minutes</td>
    </tr>
     <tr class="odd">
       <td><strong>Total waiting time: </strong><%=waiting%> minute</td>
    </tr>
    

<%}

//rs2.close();
rs3.close();

//stmt2.close();
stmt3.close();
 conn.close();

}catch(SQLException e){
         out.println(e.toString() ); 
         }
   
%>
</table>
      
 

</div>      
  </div>
 
   
               

  </div>
  
  <%--  
var myTrip = [        new google.maps.LatLng(37.55917730680376, 126.97754909369093),
                       new google.maps.LatLng(37.56256594911314, 126.98574269554896),
                       new google.maps.LatLng(37.497510368763315, 127.02761294596193),
                                   ];  
myTrip[0]=node1;
myTrip[1]=node2;
myTrip[2]=node3;
--%>            
<!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>   
</html>