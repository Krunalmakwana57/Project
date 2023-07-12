<%@page import="dao.ServiceDao"%>
<%@page import="model.Sman_Ser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="customer-navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int id = Integer.parseInt(request.getParameter("id")); %>
<%Sman_Ser s1 = ServiceDao.getSingleServiceBySid(id); %>
<div class="card" style="width: 18rem;">
		<div class="card-body">
			<h5 class="card-title"><%=s1.getStype() %></h5>
			<h6 class="card-subtitle mb-2 text-body-secondary"><%=s1.getCar_model() %></h6>
			<h6 class="card-subtitle mb-2 text-body-secondary"><%=s1.getSprice()%></h6>
			<h6 class="card-subtitle mb-2 text-body-secondary"><%=s1.getDuration() %></h6>
			<a href="BookingController?action=book&sid=<%=s1.getSid() %>&cid=<%=s.getId() %>&serviceman_id=<%=s1.getSer_id() %>" class="card-link">Book Now</a> 
		</div>
	</div>
</body>
</html>