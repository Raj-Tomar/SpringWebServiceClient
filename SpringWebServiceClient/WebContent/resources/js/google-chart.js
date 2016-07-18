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