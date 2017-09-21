<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>饼图</title>
	<script src="${ctx}/static/js/highcharts/exporting.js"  type="text/javascript"></script>
	<script src="${ctx}/static/js/highcharts/3d/highcharts.js"  type="text/javascript"></script>
	<script src="${ctx}/static/js/highcharts/3d/highcharts-3d.js"  type="text/javascript"></script>
	<script>
	/**
	 * Skies theme for Highcharts JS
	 * @author Torstein Honsi
	 */

	Highcharts.theme = {
		colors: ["#514F78", "#42A07B", "#9B5E4A", "#72727F", "#1F949A", "#82914E", "#86777F", "#42A07B"],
		chart: {
			className: 'skies',
			borderWidth: 0,
			plotShadow: true,
			plotBackgroundImage: 'http://www.highcharts.com/demo/gfx/skies.jpg',
			plotBackgroundColor: {
				linearGradient: [0, 0, 250, 500],
				stops: [
					[0, 'rgba(255, 255, 255, 1)'],
					[1, 'rgba(255, 255, 255, 0)']
				]
			},
			plotBorderWidth: 1
		},
		title: {
			style: {
				color: '#3E576F',
				font: '16px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
			}
		},
		subtitle: {
			style: {
				color: '#6D869F',
				font: '12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
			}
		},
		xAxis: {
			gridLineWidth: 0,
			lineColor: '#C0D0E0',
			tickColor: '#C0D0E0',
			labels: {
				style: {
					color: '#666',
					fontWeight: 'bold'
				}
			},
			title: {
				style: {
					color: '#666',
					font: '12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
				}
			}
		},
		yAxis: {
			alternateGridColor: 'rgba(255, 255, 255, .5)',
			lineColor: '#C0D0E0',
			tickColor: '#C0D0E0',
			tickWidth: 1,
			labels: {
				style: {
					color: '#666',
					fontWeight: 'bold'
				}
			},
			title: {
				style: {
					color: '#666',
					font: '12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
				}
			}
		},
		legend: {
			itemStyle: {
				font: '9pt Trebuchet MS, Verdana, sans-serif',
				color: '#3E576F'
			},
			itemHoverStyle: {
				color: 'black'
			},
			itemHiddenStyle: {
				color: 'silver'
			}
		},
		labels: {
			style: {
				color: '#3E576F'
			}
		}
	};

	// Apply the theme
	var highchartsOptions = Highcharts.setOptions(Highcharts.theme);
	$(function () {
	    $('#container').highcharts({
	        chart: {
	            type: 'pie',
	            options3d: {
	                enabled: true,
	                alpha: 45,
	                beta: 0
	            }
	        },
	        title: {
	            text: 'Browser market shares at a specific website, 2014'
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
	        series: [{
	            type: 'pie',
	            name: 'Browser share',
	            data: [
	                ['Firefox',   45.0],
	                ['IE',       26.8],
	                {
	                    name: 'Chrome',
	                    y: 12.8,
	                    sliced: true,
	                    selected: true
	                },
	                ['Safari',    8.5],
	                ['Opera',     6.2],
	                ['Others',   0.7]
	            ]
	        }]
	    });
	});	


	//2d
	$(function () {
    $('#container2').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: 'Browser market shares at a specific website, 2010'
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
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: [
                ['Firefox',   45.0],
                ['IE',       26.8],
                {
                    name: 'Chrome',
                    y: 12.8,
                    sliced: true,
                    selected: true
                },
                ['Safari',    8.5],
                ['Opera',     6.2],
                ['Others',   0.7]
            ]
        }]
    });
});
	</script>
</head>

<body>
	<h1>3D饼图柱状图</h1>
	<div id="container" style="min-width:800px;height:400px;"></div>
	<hr>
	<h1>2D饼图柱状图</h1>
	<div id="container2" style="min-width:800px;height:400px;"></div>

</body>
</html>
