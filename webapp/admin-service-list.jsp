<%@page import="model.Sman_Ser"%>
<%@page import="dao.ServiceDao"%>
<%@page import="dao.ServicemanDao"%>
<%@page import="model.ServiceMan"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="admin-header-navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i> Basic Table Examples</h3>
				<div class="row">
				
	                  <div class="col-md-12">
	                  	  <div class="content-panel">
	                  	  	  <h4><i class="fa fa-angle-right"></i> Basic Table</h4>
	                  	  	  <hr>
		                      <table class="table">
		                          <thead>
		                          <tr>
		                              <th>Service Id</th>
		                              <th>Serviceman Id</th>
		                              <th>Service Type</th>
		                              <th>Car Model</th>
		                              <th>Service Price</th>
		                              <th>Service Duration</th>
		                              <th>Edit</th>
		                              <th>Delete</th>
		                          </tr>
		                          </thead>
		                          <tbody>
		                          <%List<Sman_Ser> list = ServiceDao.getAllServices(); %>
		                          <%for(Sman_Ser s1:list){ %>
		                          <tr>
		                              <td><%=s1.getSid() %></td>
		                              <td><%=s1.getSer_id() %></td>
		                              <td><%=s1.getStype() %></td>
		                              <td><%=s1.getCar_model() %></td>
		                              <td><%=s1.getSprice() %></td>
		                              <td><%=s1.getDuration() %></td>
		                              <td><a href="">Edit</a></td>
		                              <td><a href="">Delete</a></td>
		                          </tr>
		                          <%} %>
		                          </tbody>
		                      </table>
	                  	  </div><! --/content-panel -->
	                  </div><!-- /col-md-12 -->
				</div><!-- row -->
		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->
</body>
</html>