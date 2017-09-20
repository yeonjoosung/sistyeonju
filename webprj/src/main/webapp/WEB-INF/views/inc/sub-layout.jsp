<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
   
   <header id="header">
      <div class="content-container">
      
      <h1 id="logo">
         <a href="">            
            <img src="../images/logo.png" alt="뉴렉처사이트" />
         </a>
      </h1>
      <section>
         <h2 class="hidden">머릿말</h2>   

         <nav id="main-menu" class="main-menu">
            <h1 class="hidden">
               메인메뉴
            </h1>
            <ul class="">
               <li><a href="">학습가이드</a></li>
               <li><a href="">뉴렉과정</a></li>
               <li><a href="">강좌선택</a></li>
            </ul>
         </nav>
         
         <section id="search-form">
            <h1 class="hidden">강좌검색 폼</h1>
            <form>
               <label>과정검색</label>
               <input type="text" />
               <input class="btn-img btn-search" type="submit" value="검색" />
            </form>
         </section>
         
         <nav id="member-menu" class="hr-list member-menu">   
            <h1 class="hidden">회원메뉴</h1>
            <ul>
               <li><a href="">HOME</a></li>
               <li><a href="">로그인</a></li>
               <li><a href="">회원가입</a></li>
            </ul>   
         </nav>
            
         <nav id="customer-menu" class="hr-list">
            <h1 class="hidden">고객메뉴</h1>
            <ul>
               <li><a href=""><img src="../images/txt-mypage.png"  alt="마이페이지" /></a></li>
               <li><a href=""><img src="../images/txt-customer.png"  alt="고객센터" /></a></li>
            </ul>
         </nav>
      </section>
      </div>
   </header>
   <div id="visual">
      <div class="content-container">
      </div>
   </div>
   

   
   <div id="body" class="clearfix">
      <div class="content-container">      
      
      <aside id="aside">
         
         <!-- <h1>고객센터</h1>
         
         <nav>
            <h1>고객센터 메뉴</h1>
            <ul>
               <li><a href="">공지사항</a></li>
               <li><a href="">1:1고객문의</li>
               <li><a href="">학습안내</li>
            </ul>
         </nav>
      
         <nav>
            <h1>추천사이트</h1>
            <ul>
               <li>앤서이즈</li>
               <li>W3C</li>
               <li>마이크로소프트</li>
            </ul>
         </nav>
         
         <nav>
            <h1>구글광고</h1>
         </nav> -->
        </aside>
        
        <main id="main">
        <!--  <h2>공지사항</h2>
         
         <div>
            <h3>경로</h3>
            <ol>
               <li>home</li>
               <li>고객센터</li>
               <li>공지사항</li>
            </ol>
         </div>
   
         <div>
            <h3>공지사항 검색 폼</h3>
            <form action="notice" method="get">
               <label>검색어</label>
               <input type="text" name="title" />
               <input type="submit" />
            </form>
         </div> -->
         <table border="1">
            <tr>
               <th>번호</th>
               <th>제목</th>
               <th>작성자</th>
               <th>작성일</th>
               <th>조회수</th>
            </tr>
                 
           <%--  <c:forEach var="n"  items="${list}" begin="0" end="3" step="2">
            <tr>
               <td>${n.id}</td>
               <td><a href="notice-detail">${n.title}</td>
               <td>newlec</td>
               <td>${n.regDate}</td>
               <td>${n.hit}</td>         
            </tr>
            </c:forEach> --%>
         </table>
       
         <span class="btn btn-default" href="">글쓰기</span>
         <a class="btn-img btn-cancel" href="">취소</a>
      </main>   
      </div>
   </div>
   
   <footer id="footer">
      <div class="content-container">
      </div>
   </footer>
   
</body>
</html>