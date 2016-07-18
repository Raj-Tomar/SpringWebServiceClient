<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Google-Charts</title>

<!-- <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script> -->
<!-- <script type="text/javascript" src="https://www.google.com/jsapi"></script> -->
<script type="text/javascript" src="<c:url value="/resources/js/lib/google-chart-jsapi.js"/>"></script>


<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-3.1.0.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/google-chart.js"/>"></script>

</head>
<body>
	<h3>Google Charts</h3>
	<div style="width: 600px;">
		<div id="google_pieChart"></div>
	</div>
	
	<div style="width: 600px;">
		<div id="google_BarChart"></div>
	</div>
	
	<div style="width: 600px;">
		<div id="google_HistogramChart"></div>
	</div>

</body>
</html>