<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>折线图</title>
	<script src="${ctx}/static/js/highcharts/highcharts.js"  type="text/javascript"></script>
	<script src="${ctx}/static/js/highcharts/exporting.js"  type="text/javascript"></script>
	
	<script>
	/**
	 * Dark blue theme for Highcharts JS
	 * @author Torstein Honsi
	 */

	Highcharts.theme = {
		colors: ["#DDDF0D", "#55BF3B", "#DF5353", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee",
			"#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
		chart: {
			backgroundColor: {
				linearGradient: { x1: 0, y1: 0, x2: 1, y2: 1 },
				stops: [
					[0, 'rgb(48, 48, 96)'],
					[1, 'rgb(0, 0, 0)']
				]
			},
			borderColor: '#000000',
			borderWidth: 2,
			className: 'dark-container',
			plotBackgroundColor: 'rgba(255, 255, 255, .1)',
			plotBorderColor: '#CCCCCC',
			plotBorderWidth: 1
		},
		title: {
			style: {
				color: '#C0C0C0',
				font: 'bold 16px "Trebuchet MS", Verdana, sans-serif'
			}
		},
		subtitle: {
			style: {
				color: '#666666',
				font: 'bold 12px "Trebuchet MS", Verdana, sans-serif'
			}
		},
		xAxis: {
			gridLineColor: '#333333',
			gridLineWidth: 1,
			labels: {
				style: {
					color: '#A0A0A0'
				}
			},
			lineColor: '#A0A0A0',
			tickColor: '#A0A0A0',
			title: {
				style: {
					color: '#CCC',
					fontWeight: 'bold',
					fontSize: '12px',
					fontFamily: 'Trebuchet MS, Verdana, sans-serif'

				}
			}
		},
		yAxis: {
			gridLineColor: '#333333',
			labels: {
				style: {
					color: '#A0A0A0'
				}
			},
			lineColor: '#A0A0A0',
			minorTickInterval: null,
			tickColor: '#A0A0A0',
			tickWidth: 1,
			title: {
				style: {
					color: '#CCC',
					fontWeight: 'bold',
					fontSize: '12px',
					fontFamily: 'Trebuchet MS, Verdana, sans-serif'
				}
			}
		},
		tooltip: {
			backgroundColor: 'rgba(0, 0, 0, 0.75)',
			style: {
				color: '#F0F0F0'
			}
		},
		toolbar: {
			itemStyle: {
				color: 'silver'
			}
		},
		plotOptions: {
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
		legend: {
			itemStyle: {
				font: '9pt Trebuchet MS, Verdana, sans-serif',
				color: '#A0A0A0'
			},
			itemHoverStyle: {
				color: '#FFF'
			},
			itemHiddenStyle: {
				color: '#444'
			}
		},
		credits: {
			style: {
				color: '#666'
			}
		},
		labels: {
			style: {
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

		// special colors for some of the
		legendBackgroundColor: 'rgba(0, 0, 0, 0.5)',
		background2: 'rgb(35, 35, 70)',
		dataLabelsColor: '#444',
		textColor: '#C0C0C0',
		maskColor: 'rgba(255,255,255,0.3)'
	};
		//图表属性，不包含数据
     var options = {
			chart: {
				renderTo:'container',
				type:'spline',
			},
			title: {
		         text: '实时温度曲线',
		         x: -20 //center
      },
      exporting :{
      	url:'${ctx}/admin/user/export', // 配置导出路径
      },
      subtitle: {
          text: 'Source: WorldClimate.com',
          x: -20
      },
      xAxis:{
      },
      yAxis: {
          title: {
              text: 'Temperature (°C)'
          },
          plotLines: [{
              value: 0,
              width: 1,
              color: '#808080'
          }]
      },
      series: [{
		      	name:'温度上海',
		    	data:  []
		  		},
				//{
				//  	name:'温度郑州',
				//	data:   [20, 24.1, 24, 24.8, 26.6, 29.7, 25.8, 22.9]
	  			//}
		  	  ],
      tooltip: {
          valueSuffix: '°C'
      },
      plotOptions: {
			    spline:{
			    	dataLabels: {
		           enabled: true
		        },
		        animation:false,
		      },
			},
   };
   
   //初始函数，设置定时器，定时取数据
   		var timer = "";
	   	var i=0;
		$(function () {
		    queryData(0);
		    var highchartsOptions = Highcharts.setOptions(Highcharts.theme);
		    timer = setInterval(function(){
		    	i++;
		    	if(i>=3) {i=0;}
		    	queryData(i);
		    },3000);
		    
		    //停止刷新
		    $("button").click(function(){
		    	clearInterval(timer);
		    });
		});
		
		var categories = [];
		var datas = [];
		
		//Ajax 获取数据并解析创建Highcharts图表
		function queryData(index) {
			$.ajax({
				url:'${ctx}/admin/user/jsonData',
				type:'get',
				dataType:"json",
				success:function(data) {
						var myobj=eval(data);  
		                  for(var i=0;i<myobj.length;i++){  
		                	  categories[i] = myobj[i].name;  
		                	  //datas[i] = parseFloat(myobj[i].data);  
		                	  datas[i] = myobj[i].data;  
		                  }
						options.xAxis.categories = categories;
						options.series[0].data = datas;
						console.log(datas);
						chart = new Highcharts.Chart(options);
		 		}
			});
		}

		function startTimer() {
			setTimeout(cc,3000);
		}
		function cc(){
			timer = setInterval(restart,3000);
		}	
		function restart(){
	    	i++;
	    	if(i>=3) {i=0;}
	    	queryData(i);
	    }



		
	</script>
</head>

<body>
	<h1>实时温度曲线图</h1>
	<div id="container" style="min-width:800px;height:400px;"></div>
	<p align=center><button>停止刷新</button><button onclick="startTimer();">开始刷新</button></p>

</body>
</html>
