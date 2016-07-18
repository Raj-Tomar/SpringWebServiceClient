<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Charts</title>

<!-- <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script> -->
<!-- <script type="text/javascript" src="https://www.google.com/jsapi"></script> -->
<script type="text/javascript" src="<c:url value="/resources/js/lib/google-chart-jsapi.js"/>"></script>


<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-3.1.0.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/google-chart.js"/>"></script>

<script type="text/javascript">
//Load the Visualization API and the piechart package.
google.load('visualization', '1.0', {
    'packages' : [ 'corechart' ]
});

// Set a callback to run when the Google Visualization API is loaded.
google.setOnLoadCallback(drawChart);

// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.

function drawChart() {
    // Create the data table.    
    var data = google.visualization.arrayToDataTable([
			                ['Country', 'Area(square km)'],
			               <c:forEach items="${googlePieChart}" var="entry">
			                	['${entry.key}',${entry.value}],
			                </c:forEach>
			                
							]); 
    // Set chart options
    var options = {
        'title' : 'Area-wise Top Seven Countries in the World',
        is3D : true,
        //pieHole: 0.4,
        pieSliceText: 'label',
        tooltip :  {showColorCode: true},
        'width' : 900,
        'height' : 500
    };

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.PieChart(document.getElementById('google_pieChart'));
    chart.draw(data, options);
}
</script>


</head>
<body>
	<h3>Google Charts</h3>
	<div style="width: 600px;">
		<div id="google_pieChart"></div>
	</div>
	
	<div style="width: 600px;">
		<div id="google_Histogram"></div>
	</div>

</body>
</html>