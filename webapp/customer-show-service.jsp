<%@page import="model.Sman_Ser"%>
<%@page import="dao.ServiceDao"%>
<%@page import="model.Sman_Ser"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="customer-navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<Sman_Ser> list = ServiceDao.getAllServices(); %>
<%for(Sman_Ser s1:list){ %>
	<div class="card" style="width: 18rem;">
		<div class="card-body">
			<h5 class="card-title"><%=s1.getStype() %></h5>
			<h6 class="card-subtitle mb-2 text-body-secondary"><%=s1.getCar_model() %></h6>
			<h6 class="card-subtitle mb-2 text-body-secondary"><%=s1.getSprice()%></h6>
			<h6 class="card-subtitle mb-2 text-body-secondary"><%=s1.getDuration() %></h6>
			<a href="customer-book-services.jsp?id=<%=s1.getSid() %>" class="card-link">Book Service</a> 
		</div>
	</div><%} %>
</body>
</html>