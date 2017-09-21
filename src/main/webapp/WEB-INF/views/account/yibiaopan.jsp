<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>仪表盘</title>
    <script type="text/javascript" src="${ctx}/static/js/highcharts/yibiaopan/highcharts.js"></script>
  	<script type="text/javascript" src="${ctx}/static/js/highcharts/exporting.js"></script>
  	<script type="text/javascript" src="${ctx}/static/js/highcharts/yibiaopan/highcharts-more.js"></script>

	
	<script>
	/**
	 * Dark blue theme for Highcharts JS
	 * @author Torstein Honsi
	 */

	 /**
	  * Gray theme for Highcharts JS
	  * @author Torstein Honsi
	  */

	 Highcharts.theme = {
	 	colors: ["#DDDF0D", "#7798BF", "#55BF3B", "#DF5353", "#aaeeee", "#ff0066", "#eeaaee",
	 		"#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
	 	chart: {
	 		backgroundColor: {
	 			linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	 			stops: [
	 				[0, 'rgb(96, 96, 96)'],
	 				[1, 'rgb(16, 16, 16)']
	 			]
	 		},
	 		borderWidth: 0,
	 		borderRadius: 0,
	 		plotBackgroundColor: null,
	 		plotShadow: false,
	 		plotBorderWidth: 0
	 	},
	 	title: {
	 		style: {
	 			color: '#FFF',
	 			font: '16px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
	 		}
	 	},
	 	subtitle: {
	 		style: {
	 			color: '#DDD',
	 			font: '12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
	 		}
	 	},
	 	xAxis: {
	 		gridLineWidth: 0,
	 		lineColor: '#999',
	 		tickColor: '#999',
	 		labels: {
	 			style: {
	 				color: '#999',
	 				fontWeight: 'bold'
	 			}
	 		},
	 		title: {
	 			style: {
	 				color: '#AAA',
	 				font: 'bold 12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
	 			}
	 		}
	 	},
	 	yAxis: {
	 		alternateGridColor: null,
	 		minorTickInterval: null,
	 		gridLineColor: 'rgba(255, 255, 255, .1)',
	 		minorGridLineColor: 'rgba(255,255,255,0.07)',
	 		lineWidth: 0,
	 		tickWidth: 0,
	 		labels: {
	 			style: {
	 				color: '#999',
	 				fontWeight: 'bold'
	 			}
	 		},
	 		title: {
	 			style: {
	 				color: '#AAA',
	 				font: 'bold 12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
	 			}
	 		}
	 	},
	 	legend: {
	 		itemStyle: {
	 			color: '#CCC'
	 		},
	 		itemHoverStyle: {
	 			color: '#FFF'
	 		},
	 		itemHiddenStyle: {
	 			color: '#333'
	 		}
	 	},
	 	labels: {
	 		style: {
	 			color: '#CCC'
	 		}
	 	},
	 	tooltip: {
	 		backgroundColor: {
	 			linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	 			stops: [
	 				[0, 'rgba(96, 96, 96, .8)'],
	 				[1, 'rgba(16, 16, 16, .8)']
	 			]
	 		},
	 		borderWidth: 0,
	 		style: {
	 			color: '#FFF'
	 		}
	 	},


	 	plotOptions: {
	 		series: {
	 			nullColor: '#444444'
	 		},
	 		line: {
	 			dataLabels: {
	 				color: '#CCC'
	 			},
	 			marker: {
	 				lineColor: '#333'
	 			}
	 		},
	 		spline: {
	 			marker: {
	 				lineColor: '#333'
	 			}
	 		},
	 		scatter: {
	 			marker: {
	 				lineColor: '#333'
	 			}
	 		},
	 		candlestick: {
	 			lineColor: 'white'
	 		}
	 	},

	 	toolbar: {
	 		itemStyle: {
	 			color: '#CCC'
	 		}
	 	},

	 	navigation: {
	 		buttonOptions: {
	 			symbolStroke: '#DDDDDD',
	 			hoverSymbolStroke: '#FFFFFF',
	 			theme: {
	 				fill: {
	 					linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	 					stops: [
	 						[0.4, '#606060'],
	 						[0.6, '#333333']
	 					]
	 				},
	 				stroke: '#000000'
	 			}
	 		}
	 	},

	 	// scroll charts
	 	rangeSelector: {
	 		buttonTheme: {
	 			fill: {
	 				linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	 				stops: [
	 					[0.4, '#888'],
	 					[0.6, '#555']
	 				]
	 			},
	 			stroke: '#000000',
	 			style: {
	 				color: '#CCC',
	 				fontWeight: 'bold'
	 			},
	 			states: {
	 				hover: {
	 					fill: {
	 						linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	 						stops: [
	 							[0.4, '#BBB'],
	 							[0.6, '#888']
	 						]
	 					},
	 					stroke: '#000000',
	 					style: {
	 						color: 'white'
	 					}
	 				},
	 				select: {
	 					fill: {
	 						linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	 						stops: [
	 							[0.1, '#000'],
	 							[0.3, '#333']
	 						]
	 					},
	 					stroke: '#000000',
	 					style: {
	 						color: 'yellow'
	 					}
	 				}
	 			}
	 		},
	 		inputStyle: {
	 			backgroundColor: '#333',
	 			color: 'silver'
	 		},
	 		labelStyle: {
	 			color: 'silver'
	 		}
	 	},

	 	navigator: {
	 		handles: {
	 			backgroundColor: '#666',
	 			borderColor: '#AAA'
	 		},
	 		outlineColor: '#CCC',
	 		maskFill: 'rgba(16, 16, 16, 0.5)',
	 		series: {
	 			color: '#7798BF',
	 			lineColor: '#A6C7ED'
	 		}
	 	},

	 	scrollbar: {
	 		barBackgroundColor: {
	 				linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	 				stops: [
	 					[0.4, '#888'],
	 					[0.6, '#555']
	 				]
	 			},
	 		barBorderColor: '#CCC',
	 		buttonArrowColor: '#CCC',
	 		buttonBackgroundColor: {
	 				linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	 				stops: [
	 					[0.4, '#888'],
	 					[0.6, '#555']
	 				]
	 			},
	 		buttonBorderColor: '#CCC',
	 		rifleColor: '#FFF',
	 		trackBackgroundColor: {
	 			linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	 			stops: [
	 				[0, '#000'],
	 				[1, '#333']
	 			]
	 		},
	 		trackBorderColor: '#666'
	 	},

	 	// special colors for some of the demo examples
	 	legendBackgroundColor: 'rgba(48, 48, 48, 0.8)',
	 	background2: 'rgb(70, 70, 70)',
	 	dataLabelsColor: '#444',
	 	textColor: '#E0E0E0',
	 	maskColor: 'rgba(255,255,255,0.3)'
	 };

	 // Apply the theme
	 var highchartsOptions = Highcharts.setOptions(Highcharts.theme);

	$(function () {
		
	    $('#container').highcharts({
		
		    chart: {
		        type: 'gauge',
		        plotBackgroundColor: null,
		        plotBackgroundImage: null,
		        plotBorderWidth: 0,
		        plotShadow: false
		    },
		    
		    title: {
		        text: 'Speedometer'
		    },
		    
		    pane: {
		        startAngle: -150,
		        endAngle: 150,
		        background: [{
		            backgroundColor: {
		                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
		                stops: [
		                    [0, '#FFF'],
		                    [1, '#333']
		                ]
		            },
		            borderWidth: 0,
		            outerRadius: '109%'
		        }, {
		            backgroundColor: {
		                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
		                stops: [
		                    [0, '#333'],
		                    [1, '#FFF']
		                ]
		            },
		            borderWidth: 1,
		            outerRadius: '107%'
		        }, {
		            // default background
		        }, {
		            backgroundColor: '#DDD',
		            borderWidth: 0,
		            outerRadius: '105%',
		            innerRadius: '103%'
		        }]
		    },
		       
		    // the value axis
		    yAxis: {
		        min: 0,
		        max: 200,
		        
		        minorTickInterval: 'auto',
		        minorTickWidth: 1,
		        minorTickLength: 10,
		        minorTickPosition: 'inside',
		        minorTickColor: '#666',
		
		        tickPixelInterval: 30,
		        tickWidth: 2,
		        tickPosition: 'inside',
		        tickLength: 10,
		        tickColor: '#666',
		        labels: {
		            step: 2,
		            rotation: 'auto'
		        },
		        title: {
		            text: 'km/h'
		        },
		        plotBands: [{
		            from: 0,
		            to: 120,
		            color: '#55BF3B' // green
		        }, {
		            from: 120,
		            to: 160,
		            color: '#DDDF0D' // yellow
		        }, {
		            from: 160,
		            to: 200,
		            color: '#DF5353' // red
		        }]        
		    },
		
		    series: [{
		        name: 'Speed',
		        data: [80],
		        tooltip: {
		            valueSuffix: ' km/h'
		        }
		    }]
		
		}, 
		// Add some life
		function (chart) {
			if (!chart.renderer.forExport) {
			    setInterval(function () {
			        var point = chart.series[0].points[0],
			            newVal,
			            inc = Math.round((Math.random() - 0.5) * 20);
			        
			        newVal = point.y + inc;
			        if (newVal < 0 || newVal > 200) {
			            newVal = point.y - inc;
			        }
			        
			        point.update(newVal);
			        
			    }, 3000);
			}
		});
	});






	$(function () {
		
		/**
		 * Get the current time
		 */
		function getNow () {
		    var now = new Date();
		        
		    return {
		        hours: now.getHours() + now.getMinutes() / 60,
		        minutes: now.getMinutes() * 12 / 60 + now.getSeconds() * 12 / 3600,
		        seconds: now.getSeconds() * 12 / 60
		    };
		};
		
		/**
		 * Pad numbers
		 */
		function pad(number, length) {
			// Create an array of the remaining length +1 and join it with 0's
			return new Array((length || 2) + 1 - String(number).length).join(0) + number;
		}
		
		var now = getNow();
		
		// Create the chart
		$('#containerd').highcharts({
		
		    chart: {
		        type: 'gauge',
		        plotBackgroundColor: null,
		        plotBackgroundImage: null,
		        plotBorderWidth: 0,
		        plotShadow: false,
		        height: 200
		    },
		    
		    credits: {
		        enabled: false
		    },
		    
		    title: {
		    	text: 'The Highcharts clock'
		    },
		    
		    pane: {
		    	background: [{
		    		// default background
		    	}, {
		    		// reflex for supported browsers
		    		backgroundColor: Highcharts.svg ? {
			    		radialGradient: {
			    			cx: 0.5,
			    			cy: -0.4,
			    			r: 1.9
			    		},
			    		stops: [
			    			[0.5, 'rgba(255, 255, 255, 0.2)'],
			    			[0.5, 'rgba(200, 200, 200, 0.2)']
			    		]
			    	} : null
		    	}]
		    },
		    
		    yAxis: {
		        labels: {
		            distance: -20
		        },
		        min: 0,
		        max: 12,
		        lineWidth: 0,
		        showFirstLabel: false,
		        
		        minorTickInterval: 'auto',
		        minorTickWidth: 1,
		        minorTickLength: 5,
		        minorTickPosition: 'inside',
		        minorGridLineWidth: 0,
		        minorTickColor: '#666',
		
		        tickInterval: 1,
		        tickWidth: 2,
		        tickPosition: 'inside',
		        tickLength: 10,
		        tickColor: '#666',
		        title: {
		            text: 'Powered by<br>Highcharts',
		            style: {
		                color: '#BBB',
		                fontWeight: 'normal',
		                fontSize: '8px',
		                lineHeight: '10px'                
		            },
		            y: 10
		        }       
		    },
		    
		    tooltip: {
		    	formatter: function () {
		    		return this.series.chart.tooltipText;
		    	}
		    },
		
		    series: [{
		        data: [{
		            id: 'hour',
		            y: now.hours,
		            dial: {
		                radius: '60%',
		                baseWidth: 4,
		                baseLength: '95%',
		                rearLength: 0
		            }
		        }, {
		            id: 'minute',
		            y: now.minutes,
		            dial: {
		                baseLength: '95%',
		                rearLength: 0
		            }
		        }, {
		            id: 'second',
		            y: now.seconds,
		            dial: {
		                radius: '100%',
		                baseWidth: 1,
		                rearLength: '20%'
		            }
		        }],
		        animation: false,
		        dataLabels: {
		            enabled: false
		        }
		    }]
		}, 
		                                 
		// Move
		function (chart) {
		    setInterval(function () {
		        var hour = chart.get('hour'),
		            minute = chart.get('minute'),
		            second = chart.get('second'),
		            now = getNow(),
		            // run animation unless we're wrapping around from 59 to 0
		            animation = now.seconds == 0 ? 
		                false : 
		                {
		                    easing: 'easeOutElastic'
		                };
		                
		        // Cache the tooltip text
		        chart.tooltipText = 
					pad(Math.floor(now.hours), 2) + ':' + 
		    		pad(Math.floor(now.minutes * 5), 2) + ':' + 
		    		pad(now.seconds * 5, 2);
		        
		        hour.update(now.hours, true, animation);
		        minute.update(now.minutes, true, animation);
		        second.update(now.seconds, true, animation);
		        
		    }, 1000);
		
		});
	});

	// Extend jQuery with some easing (copied from jQuery UI)
	$.extend($.easing, {
		easeOutElastic: function (x, t, b, c, d) {
			var s=1.70158;var p=0;var a=c;
			if (t==0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*.3;
			if (a < Math.abs(c)) { a=c; var s=p/4; }
			else var s = p/(2*Math.PI) * Math.asin (c/a);
			return a*Math.pow(2,-10*t) * Math.sin( (t*d-s)*(2*Math.PI)/p ) + c + b;
		}
	});
	</script>
</head>

<body>
<h1>仪表图--速度计</h1>
	<div id="container" style="width:100%;height:400px"></div>
<h1>时钟图</h1>
	<div id="containerd" style="width:100%;height:400px"></div>
</body>
</html>
