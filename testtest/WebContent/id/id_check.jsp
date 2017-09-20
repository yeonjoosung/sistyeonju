<%@page import="hj.db.member.UserDao"%>
<%@ page contentType = "text/plain; charset=euc-kr" %>
<%@ page import = "java.util.List" %>
<%
String id = request.getParameter("id");
UserDao dao = new UserDao();
int re = dao.checkId(id);
%>
<%=re%>