<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, bean.*, java.util.*"%>
<jsp:useBean id="memMgr" class="dao.MemberMgr" />
<%  request.setCharacterEncoding("UTF-8");
	String mapx = request.getParameter("mapx");
	String mapy = request.getParameter("mapy");
	
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Custom CSS -->
    <link href="css/3-col-portfolio.css" rel="stylesheet">
    
   
    <title>Back packers</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
                 <%-- <% 
         
		            String member_id = (String)session.getAttribute("idKey");
		         
		            if(member_id != null){
		               RegisterBean regBean = memMgr.memberMyRead(member_id);
		               
		               //String member_pw = regBean.getMember_pw();
		               String member_name = regBean.getMember_name();
		         %>
         
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <%=member_name %><b class="caret"></b></a>
                     <%
				         }else{
				     %>
                    <script type="text/javascript">
						alert("logout...");
						location.href = 'logout.jsp';
					</script>
                  <%
		            }
		         %>  
		                     --%>
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
                            <a href="logout.jsp"><i class="fa fa-fw fa-power-off"></i>Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
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
                    <li >
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
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"> Plan your trip <small>Detail Route</small>
                </h1>
                    </div>
                </div>
       <!-- <iframe src="http://maps.google.com/maps?f=d&saddr=37.498574101481246,127.02582418912881&daddr=37.58018596118851,126.9767235747301&hl=ko&hl=ko" width="600" height="450" style="border:0"></iframe>
        --><!--  <iframe src="http://maps.google.com/maps?f=d&saddr=37.498574101481246,127.02582418912881&daddr=37.58018596118851,126.9767235747301" width="600" height="450" style="border:0"></iframe>
      -->
<iframe src="https://www.google.com/maps/embed?pb=!1m24!1m12!1m3!1d50618.67335603573!2d126.96584721026866!3d37.53934433020177!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m9!3e6!4m3!3m2!1d37.4985741!2d127.02582419999999!4m3!3m2!1d37.580186!2d126.9767236!5e0!3m2!1sko!2s!4v1432757550183" width="600" height="450" frameborder="0" style="border:0"></iframe>
<iframe src="http://map.naver.com/?menu=route&mapMode=0&lat=37.562774&lng=126.9511777&dlevel=9&slng=126.9766116&slat=37.5688366&elng=126.9256967&elat=37.5633721&pathType=1&dtPathType=0&sText=7IS47KKF66Gc7YyM7Lac7IaM&eText=7ZWY66qo64uI66eI7Yq4&enc=b64" width="600" height="450" frameborder="0" style="border:0"></iframe>
<iframe src="https://www.google.com/maps/dir/37.4985741,127.0258242/37.580186,126.9767236/@37.5439721,126.9668772&output=embed" width="600" height="450" frameborder="0" style="border:0"></iframe>
                <iframe src="https://www.google.com/maps/dir//47.620506,-122.349277/@47.6204771,-122.3471527,16z?hl=ko-KR" width="600" height="450" frameborder="0" style="border:0"></iframe>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
