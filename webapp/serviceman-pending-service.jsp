<%@page import="dao.CustomerDao"%>
<%@page import="model.Customer"%>
<%@page import="dao.ServiceDao"%>
<%@page import="model.Sman_Ser"%>
<%@page import="dao.BookDao"%>
<%@page import="model.BookService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="serviceman-navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- Booking Start -->
	
		<div class="container">
			<div class="col-lg-12">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Customer Name</th>
							<th scope="col">Car Model</th>
							<th scope="col">Service Price</th>
							<th scope="col">Service Duration</th>
							<th scope="col">Service Status</th>
							<th scope="col">Payment Status</th>
							<th scope="col">Confirm</th>
							<th scope="col">Reject</th>
						</tr>
					</thead>
					<tbody>
					<%List<BookService> list = BookDao.getPendingServiceByServicemanId(s.getId()); %>
					<%for(BookService s1:list){ %>
							<%Customer ser = CustomerDao.getCustomerById(s1.getCid()); %>
							<%Sman_Ser service = ServiceDao.getSingleServiceBySid(s1.getSid()); %>
						<tr>
							<th scope="row"><%=ser.getName() %></th>
							<td><%=service.getCar_model() %></td>
							<td><%=service.getSprice() %></td>
							<td><%=service.getDuration() %></td>
							<td><%=s1.getBooking_status() %></td>
							<td><%=s1.getPayment_status() %></td>
							<td><a href="BookingController?action=confirm&bid=<%=s1.getBid()%>">Confirm</a></td>
							<td><a href="#">Reject</a></td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
		</div>
	<!-- Booking End -->


	<!-- Footer Start -->
	<div
		class="container-fluid bg-dark text-light footer pt-5 mt-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container py-5">
			<div class="row g-5">
				<div class="col-lg-3 col-md-6">
					<h4 class="text-light mb-4">Address</h4>
					<p class="mb-2">
						<i class="fa fa-map-marker-alt me-3"></i>123 Street, New York, USA
					</p>
					<p class="mb-2">
						<i class="fa fa-phone-alt me-3"></i>+012 345 67890
					</p>
					<p class="mb-2">
						<i class="fa fa-envelope me-3"></i>info@example.com
					</p>
					<div class="d-flex pt-2">
						<a class="btn btn-outline-light btn-social" href=""><i
							class="fab fa-twitter"></i></a> <a
							class="btn btn-outline-light btn-social" href=""><i
							class="fab fa-facebook-f"></i></a> <a
							class="btn btn-outline-light btn-social" href=""><i
							class="fab fa-youtube"></i></a> <a
							class="btn btn-outline-light btn-social" href=""><i
							class="fab fa-linkedin-in"></i></a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<h4 class="text-light mb-4">Opening Hours</h4>
					<h6 class="text-light">Monday - Friday:</h6>
					<p class="mb-4">09.00 AM - 09.00 PM</p>
					<h6 class="text-light">Saturday - Sunday:</h6>
					<p class="mb-0">09.00 AM - 12.00 PM</p>
				</div>
				<div class="col-lg-3 col-md-6">
					<h4 class="text-light mb-4">Services</h4>
					<a class="btn btn-link" href="">Diagnostic Test</a> <a
						class="btn btn-link" href="">Engine Servicing</a> <a
						class="btn btn-link" href="">Tires Replacement</a> <a
						class="btn btn-link" href="">Oil Changing</a> <a
						class="btn btn-link" href="">Vacuam Cleaning</a>
				</div>
				<div class="col-lg-3 col-md-6">
					<h4 class="text-light mb-4">Newsletter</h4>
					<p>Dolor amet sit justo amet elitr clita ipsum elitr est.</p>
					<div class="position-relative mx-auto" style="max-width: 400px;">
						<input class="form-control border-0 w-100 py-3 ps-4 pe-5"
							type="text" placeholder="Your email">
						<button type="button"
							class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">SignUp</button>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="copyright">
				<div class="row">
					<div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
						&copy; <a class="border-bottom" href="#">Your Site Name</a>, All
						Right Reserved.

						<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
						Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML
							Codex</a>
					</div>
					<div class="col-md-6 text-center text-md-end">
						<div class="footer-menu">
							<a href="">Home</a> <a href="">Cookies</a> <a href="">Help</a> <a
								href="">FQAs</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer End -->


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/counterup/counterup.min.js"></script>
        
        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>

</body>
</html>