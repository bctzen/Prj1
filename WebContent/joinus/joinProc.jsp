<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String pwd2 = request.getParameter("pwd2");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	String birth = String.format("%s-%s-%s", year, month, day);
	
	String IsLunar = request.getParameter("IsLunar");
	String cphone = request.getParameter("cphone");
	String email = request.getParameter("email");
	
	String[] habits = request.getParameterValues("habit");
	String habit = "";
	
	if (habits != null) {
		for (int i = 0; i < habits.length; i++) {
			habit += habits[i];
			if (habits.length > i + 1) {
				habit +=", ";
			}
		}
	}
	out.println(habit + "<br>");
%>

<%=id %> <br />
<%=pwd %> <br />
<%=birth %> <br />
<%=cphone %> <br />
<%=habit %> <br />


</body>
</html>