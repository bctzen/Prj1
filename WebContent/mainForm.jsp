<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function logoutProc() {
		location.href="login/loginProc.jsp";
	}

</script>

</head>
<body>
<h1>mainForm.jsp</h1>
<b>
	<font size="3" color="skyblue">메인화면입니다.</font>
	<br /><br />
</b>
<%
	if (session.getAttribute("sessionID") == null) {
		response.sendRedirect("login/loginForm.jsp");
	} else {
		
%>
	<font color="green"><%= session.getAttribute("sessionID") %></font>님 로그인되었습니다.
	
	<br /><br />
	<input type="button" value="logout" onclick="logoutProc()" />
<%
	}
%>
</body>
</html>