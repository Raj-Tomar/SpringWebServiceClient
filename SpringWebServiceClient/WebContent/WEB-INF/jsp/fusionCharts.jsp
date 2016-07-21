<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fusion Charts</title>

<script type="text/javascript" src="<c:url value="/resources/js/lib/fusioncharts.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/lib/fusioncharts.charts.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/lib/fusioncharts.theme.fint.js"/>"></script>

<script type="text/javascript">
  FusionCharts.ready(function(){
    var revenueChart = new FusionCharts({
        "type": "column2d",
        "renderAt": "chartContainer",
        "width": "500",
        "height": "300",
        "dataFormat": "json",
        "dataSource":  {
          "chart": {
            "caption": "Monthly revenue for last year",
            "subCaption": "Harry's SuperMart",
            "xAxisName": "Month",
            "yAxisName": "Revenues (In USD)",
            "theme": "fint"
         },
         "data": [
            {
               "label": "Jan",
               "value": "420000"
            },
            {
               "label": "Feb",
               "value": "810000"
            },
            {
               "label": "Mar",
               "value": "720000"
            },
            {
               "label": "Apr",
               "value": "550000"
            },
            {
               "label": "May",
               "value": "910000"
            },
            {
               "label": "Jun",
               "value": "510000"
            },
            {
               "label": "Jul",
               "value": "680000"
            },
            {
               "label": "Aug",
               "value": "620000"
            },
            {
               "label": "Sep",
               "value": "610000"
            },
            {
               "label": "Oct",
               "value": "490000"
            },
            {
               "label": "Nov",
               "value": "900000"
            },
            {
               "label": "Dec",
               "value": "730000"
            }
          ]
      }

  });
revenueChart.render();
})
</script>

</head>
<body>

<div id="chartContainer">FusionCharts XT will load here!</div>

</body>
</html>