<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<c:set var = "p" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		var str=$(location).attr('pathname');
		var index = str.indexOf('/', 3);
		var res = str.substr(index+1);

		$("a[href*='"+res+"']").parents(".sub-menu").removeClass('hidden');
		$("a[href*='"+res+"']").addClass("on");
	});
</script>

<!-- LOGIN팝업  -->
 <script language="javascript">
	function showPopup() {
		window.open("${p}/member/sign", "로그인/회원가입",
				"resizable=no width=562, height=800, left=600, top=50");
			
	}
</script>
</head>


<body>
	<header id="header">
	<div class="content-container clearfix">
		<a href="${p}/index"><img src="${p}/images/1616.png" id="logo"
			alt="베품" /></a>
		<section id="menu-container"> 
		<nav class="menu-wrapper">

			<ul class="main-menu">
				<li><a href="">소개</a>
					<ul class="sub-menu hidden">
						<li><a href="${p}/index">서비스 소개</a></li>
						<li><a href="${p}/index">이용방법</a></li>
					</ul></li>
				<c:if test="${sessionScope.grade >= 0}">
					<li><a href="${p}/member/certification-progress">베푸미 되기</a><!-- 임시 -->
						<ul class="sub-menu hidden">
							<li><a href="${p}/member/certification-progress">진행 상황</a></li>
							<li><a href="${p}/member/certification-request">서류 인증</a></li>
						</ul></li>	
				</c:if>
				<c:if test="${sessionScope.grade > 0}">
					<li><a href="${p}/bepumi/profile">베푸미 활동 관리</a>
						<ul class="sub-menu hidden">
							<li><a href="${p}/bepumi/profile">프로필 관리</a></li>
							<li><a href="${p}/bepumi/matching-list">매칭 내역</a></li>
						</ul></li>
				</c:if>	
				<li><a href="${p}/searching/bepumi-list">베푸미 찾기</a>
					<ul class="sub-menu hidden">
						<li><a href="${p}/searching/bepumi-list">조건별 베푸미 찾기</a></li>
						<c:if test="${not empty sessionScope.id}">
							<li><a href="${p}/searching/matching-list">매칭 내역</a></li>
						</c:if>
					</ul></li>
				<li><a href="${p}/board/free">커뮤니티</a>
					<ul class="sub-menu hidden">
						<li><a href="${p}/board/free">자유게시판</a></li>
						<li><a href="${p}/board/review">후기게시판</a></li>
					</ul></li>
				<li><a href="${p}/board/question">문의/FAQ</a>
					<ul class="sub-menu hidden">
						<li><a href="${p}/board/question">문의게시판</a></li>
						<li><a href="${p}/board/report">신고게시판</a></li>
					</ul>
					</li>
			</ul>
		</nav> 
		
		
		<nav class="menu-wrapper">
		<ul id="login">
			<c:if test="${empty sessionScope.id}">
			<li><a href="" onclick="javascript:showPopup();" class="btn-border">Sign in</a></li>
			</c:if>
			<c:if test="${!empty sessionScope.id}">
			<li class="nav-item dropdown">
				<a href="#" class="btn-border nav-link">${name}님</a>
			<div class="submenu">
                <ul class="submenu-items">
                    <li class="submenu-item"><a href="" class="submenu-link">내 정보</a></li>
                    <li class="submenu-item"><a href="" class="submenu-link">메시지</a></li>
                    <li class="submenu-item"><a href="${p}/member/logout" class="submenu-link">로그아웃</a></li>
                </ul>
            </div>
			
			</li>
			</c:if>
		</ul>
		</nav>
		<div id="sub-bg"></div>
		</section>
	</div>
	</header>
	<script src="${p}/js/dropdown.js"></script>
</body>
</html>