HighCharts = {
	
	pieChart : function(){
		var options = {
				chart: {
					renderTo: 'highChart_barChart',
					type: 'bar'
				},
				title: {
					text: 'Area-wise Top Seven Countries in the World'
				},
				series: []
		};
		
		$.post("highChartData", function(serverdata) {
	        for(i=0; i<serverdata.length; i++){
	        	var json = {
	        		name : serverdata[i].key,
	        		data : [parseInt(serverdata[i].value)],
	        	}
	        	options.series.push(json);
	        }
	        var chart = new Highcharts.Chart(options);
	    });
	},
}