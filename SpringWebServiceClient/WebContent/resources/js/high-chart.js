HighCharts = {
	
	barChart : function(){
		var options = {
				chart: {
					renderTo: 'highChart_barChart',
					type: 'bar',
					options3d: {
						enabled: true,
						alpha: 45,
						beta: 0
					}
				},
				credits: {
					enabled: false
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
	
	pieChart : function(){
		var options = {
		          chart: {
		        	  renderTo: 'highChart_pieChart',
		        	  plotBackgroundColor: null,
		        	  plotBorderWidth: null,
		        	  plotShadow: true,
		        	  plotBorderColor: '#606063',
		        	  style: {
		        		  fontFamily: "'Unica One', sans-serif"
		        	  },
		        	  type: 'pie'
		          },
				exporting: {
			        buttons: {
			            contextButtons: {
			                enabled: true,
			                menuItems: null
			            }
			        },
			        enabled: true
			    },
				credits: {
					enabled: false
				},
				title: {
					text: 'Area-wise Top Seven Countries in the World'
				},
				subtitle: {
					style: {
						color: '#E0E0E3',
						textTransform: 'uppercase'
					}
				},
				tooltip: {
					pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
				},
				plotOptions: {
					pie: {
						allowPointSelect: true,
						cursor: 'pointer',
						dataLabels: {
							enabled: true,
							format: '<b>{point.name}</b>: {point.percentage:.1f} %',
							style: {
								color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
							}
						}
					}
				},
				series: []
		};
		$.post("highChartData", function(serverdata) {
			var highChartData = [];
	        for(i=0; i<serverdata.length; i++){
	        	var dataJson = {
	        			name : serverdata[i].key,
	        			y : parseInt(serverdata[i].value),
	        	}
	        	highChartData.push(dataJson);
	        }
	        var json = {
	        		name : "Countries",
	        		colorByPoint: true,
	        		data : highChartData,
	        	}
			options.series.push(json);
	        var chart = new Highcharts.Chart(options);
	    });
	},
	
	pieChart3D : function(){
		var options = {
				chart: {
					renderTo: 'highChart_pieChart3d',
					type: 'pie',
					options3d: {
						enabled: true,
						alpha: 45,
						beta: 0
					}
				},
				credits: {
					enabled: false
				},
				title: {
					text: 'Area-wise Top Seven Countries in the World'
				},
				tooltip: {
					pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
				},
				plotOptions: {
					pie: {
						allowPointSelect: true,
						cursor: 'pointer',
						depth: 35,
						dataLabels: {
							enabled: true,
							format: '{point.name}'
						}
					}
				},
				series: []
		};
		$.post("highChartData", function(serverdata) {
			var highChartData = [];
	        for(i=0; i<serverdata.length; i++){
	        	var dataJson = {
	        			name : serverdata[i].key,
	        			y : parseInt(serverdata[i].value),
	        	}
	        	highChartData.push(dataJson);
	        }
	        var json = {
	        		name : "Countries",
	        		colorByPoint: true,
	        		data : highChartData,
	        	}
			options.series.push(json);
	        var chart = new Highcharts.Chart(options);
	    });
	},
	
	histogramChart3d : function(){
		var options = {
				 chart: {
			            renderTo: 'highChart_histogramChart3d',
			            type: 'column',
			            options3d: {
			                enabled: true,
			                alpha: 15,
			                beta: 15,
			                depth: 50,
			                viewDistance: 25
			            }
			        },
			        credits: {
						enabled: false
					},
			        title: {
			            text: 'Chart rotation demo'
			        },
			        subtitle: {
			        	text: 'Area-wise Top Seven Countries in the World'
			        },
			        plotOptions: {
			            column: {
			                depth: 25
			            }
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
	        
	        $('#alpha-value').html(chart.options.chart.options3d.alpha);
	        $('#beta-value').html(chart.options.chart.options3d.beta);
	        $('#depth-value').html(chart.options.chart.options3d.depth);
	        
	        // Activate the sliders
	        $('#sliders input').on('input change', function () {
	        	chart.options.chart.options3d[this.id] = this.value;
	        	chart.redraw(false);
	        });
	    });
		
	},
}


