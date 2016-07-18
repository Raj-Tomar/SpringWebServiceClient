<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>High-Charts</title>

<script type="text/javascript" src="<c:url value="/resources/js/lib/highcharts-4.2.5.js"/>"></script>
<!-- <script src="http://code.highcharts.com/highcharts.js"></script> -->
<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-3.1.0.min.js"/>"></script>

<script type="text/javascript" src="<c:url value="/resources/js/high-chart.js"/>"></script>

</head>
<body>
<h3>High-Charts</h3>

<div id="highChart_barChart" style="width:100%; height:400px;"></div>

<script type="text/javascript">

$(document).ready(function() {
	HighCharts.pieChart();
});

</script>

</body>
</html>