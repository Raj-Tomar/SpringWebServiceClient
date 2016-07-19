<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>High-Charts</title>

<script type="text/javascript" src="<c:url value="/resources/js/lib/highcharts-4.2.5.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/lib/high-chart-exporting-4.2.5.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/lib/highcharts-3d-4.2.5.js"/>"></script>

<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-3.1.0.min.js"/>"></script>

<script type="text/javascript" src="<c:url value="/resources/js/high-chart.js"/>"></script>

</head>
<body>
<h3>High-Charts</h3>

<div id="highChart_barChart" style="width:100%; height:400px;"></div>

<div id="highChart_pieChart" style="width:100%; height:400px;"></div>

<div id="highChart_pieChart3d" style="width:100%; height:400px;"></div>

<div id="highChart_histogramChart3d" style="width:100%; height:400px;"></div>
<div id="sliders">
    <table>
        <tr>
        	<td>Alpha Angle</td>
        	<td><input id="alpha" type="range" min="0" max="45" value="15"/> <span id="alpha-value" class="value"></span></td>
        </tr>
        <tr>
        	<td>Beta Angle</td>
        	<td><input id="beta" type="range" min="-45" max="45" value="15"/> <span id="beta-value" class="value"></span></td>
        </tr>
        <tr>
        	<td>Depth</td>
        	<td><input id="depth" type="range" min="20" max="100" value="50"/> <span id="depth-value" class="value"></span></td>
        </tr>
    </table>
 </div>

<div style="width:100%; height: 100%;">
	<div>
		<select id="countryCodes">
		</select>
	</div>
	<div id="highChart_cityPopulation" style="width:100%; height:400px;"></div>
</div>

<div style="width:100%; height: 100%;">
	<div>
		<select id="stateNames">
		</select>
	</div>
	<div id="highChart_geoChart" style="width:100%; height:400px;"></div>
</div>



<script type="text/javascript">

$(document).ready(function() {
	HighCharts.barChart();
	HighCharts.pieChart();
	HighCharts.pieChart3D();
	HighCharts.histogramChart3d();
	HighCharts.getAllCountryCode();
	$('#countryCodes').change(function(){
		HighCharts.cityPopulationChart();
	});
	HighCharts.getStateNames();
	$('#stateNames').change(function(){
		HighCharts.stateWisePopulation();
	});
});

</script>

</body>
</html>