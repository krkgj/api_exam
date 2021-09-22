<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>

<%
Date time = new Date(); // 현재 시간
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcom Labl Redis</title>
</head>
<body>
Welcom Labl Redis

<table>
	<tr>
		<td>SessionID</td><td><%=request.getSession().getId() %></td>
	</tr>
	<tr>
		<td>Session.LastAccessedTime</td><td><%=formatter.format(request.getSession().getLastAccessedTime()) %></td>
	</tr>
	<tr>
		<td>Session.CreationTime</td><td><%=formatter.format(request.getSession().getCreationTime()) %></td>
	</tr>
	<tr>
		<td>Session.MaxInactiveInterval</td><td><%=request.getSession().getMaxInactiveInterval()%></td>
	</tr>
	<tr>
		<td>Session.user_name</td><td><%=request.getSession().getAttribute("user_name") %></td>
	</tr>
</table>
<script type="text/javascript">


</script>
</body>
</html>