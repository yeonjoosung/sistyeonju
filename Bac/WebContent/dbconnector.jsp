<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Untitled Document</title>
<% request.setCharacterEncoding("utf-8"); %>
<% 
Connection conn=null;


String DB_URL = "jdbc:mysql://localhost:3306/backpackers?autoReconnect=true&useOldAliasMetadataBehavior=true"; 
String DB_USER = "root"; 
String DB_PASSWORD= "7790"; 
Class.forName("org.gjt.mm.mysql.Driver"); 
conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 


try { 
//conn.close(); 
//out.println("성공"); 
} catch(Exception e) 
{out.println(e);} 
%> 




