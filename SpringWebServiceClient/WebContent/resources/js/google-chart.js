// Google PieChart Start
function drawPieChart() {
	var options = {
			'title' : 'Area-wise Top Seven Countries in the World',
			is3D : true,
			//pieHole: 0.4,
			pieSliceText: 'label',
			tooltip :  {showColorCode: true},
			'width' : 900,
			'height' : 500
	};
	$.ajax({
		url: "googlePieChartData",
		type: "POST",
		dataType: "JSON",
	}).done(function(data) {
		var statesArray = [["Country",'Area(square km)']];
		for(i=0; i<data.length; i++){
			var stateitem = [data[i].key, parseInt(data[i].value)];
			statesArray.push(stateitem);
		}
		var statesData = google.visualization.arrayToDataTable(statesArray);
		var chart = new google.visualization.PieChart(document.getElementById('google_pieChart'));
		chart.draw(statesData, options);
	});
}
google.load('visualization', '1.0', {'packages' : [ 'corechart' ]});
google.setOnLoadCallback(drawPieChart);
//Google PieChart End

//Google BarChart Start
function drawBarChart() {
	var options = {
			'title' : 'Area-wise Top Seven Countries in the World',
			is3D : true,
			width: 900,
	        height: 500,
	        bar: {groupWidth: "95%"},
	        legend: { position: "none" },
	};
	
	// For Material Chart
	/*var options = {
			chart: {
				'title' : 'Area-wise Top Seven Countries in the World',
				subtitle: 'Area of Countries',
			},
			bars: 'horizontal' // Required for Material Bar Charts.
	};*/
	$.ajax({
		url: "googlePieChartData",
		type: "POST",
		dataType: "JSON",
	}).done(function(data) {
		var statesArray = [["Country",'Area(square km)']];
		for(i=0; i<data.length; i++){
			var stateitem = [data[i].key, parseInt(data[i].value)];
			statesArray.push(stateitem);
		}
		var statesData = google.visualization.arrayToDataTable(statesArray);
		var chart = new google.visualization.BarChart(document.getElementById('google_BarChart'));
		chart.draw(statesData, options);
	});
}
google.load('visualization', '1.0', {'packages' : [ 'corechart' ]});
google.setOnLoadCallback(drawBarChart);
//Google BarChart End


//Google HistogramChart Start
function drawHistogramChart() {
	var options = {
			'title' : 'Area-wise Top Seven Countries in the World',
			legend: { position: 'none' },
			colors: ['#e7711c'],
			histogram: { lastBucketPercentile: 5 },
			vAxis: { scaleType: 'mirrorLog' }
	};
	
	$.ajax({
		url: "googlePieChartData",
		type: "POST",
		dataType: "JSON",
	}).done(function(data) {
		var statesArray = [["Country",'Area(square km)']];
		for(i=0; i<data.length; i++){
			var stateitem = [data[i].key, parseInt(data[i].value)];
			statesArray.push(stateitem);
		}
		var statesData = google.visualization.arrayToDataTable(statesArray);
		var chart = new google.visualization.Histogram(document.getElementById('google_HistogramChart'));
		chart.draw(statesData, options);
	});
}
google.load('visualization', '1.0', {'packages' : [ 'corechart' ]});
google.setOnLoadCallback(drawHistogramChart);
//Google HistogramChart End