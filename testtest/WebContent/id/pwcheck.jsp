<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
 $(function(){
  $('#user-pw').keyup(function(){
   $('font[name=check]').text('');
  }); //#user_pass.keyup

  $('#user-pw-repeat').keyup(function(){
   if($('#user-pw').val()!=$('#user-pw-repeat').val()){
    $('font[name=check]').text('');
    $('font[name=check]').html("암호틀림");
   }else{
    $('font[name=check]').text('');
    $('font[name=check]').html("암호맞음");
   }
  }); //#chpass.keyup
 });
</script>

</head>
<body>
<table>
  <tr>
   <td>비밀번호</td>
   <td><input type="password" name="pw" id="user-pw" size="10" /></td>
  </tr>
  <tr>
   <td>비밀번호확인</td>
   <td>
    <input type="password" name="pw-re" id="user-pw-repeat" size="10" />
    <font name="check" size="2" color="red"></font> 
   </td>
  </tr>
 </table> 

</body>
</html>