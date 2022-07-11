
let jsonlist;
let jsonlist2;
let jsonlist3;

// 데이터 가져오기(매출)
$(function(){
	$.ajax({
		url : "/jspweb/admin/getchart",
		data : {"type" : 1},
		success : function(result){
			console.log(result);
			jsonlist = result;
			
			////////////////////////////////////////////////// 에이엠차트 //////////////////////////////////////////////////
			am5.ready(function() {
			
			// Create root element
			// https://www.amcharts.com/docs/v5/getting-started/#Root_element
			var root = am5.Root.new("chartdiv1");
			
			
			// Set themes
			// https://www.amcharts.com/docs/v5/concepts/themes/
			root.setThemes([
			  am5themes_Animated.new(root)
			]);
			
			
			// Create chart
			// https://www.amcharts.com/docs/v5/charts/xy-chart/
			var chart = root.container.children.push(am5xy.XYChart.new(root, {
			  panX: false,
			  panY: false,
			  wheelX: "panX",
			  wheelY: "zoomX"
			}));
			
			
			// Add cursor
			// https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
			var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {
			  behavior: "zoomX"
			}));
			cursor.lineY.set("visible", false);
			
//			var date = new Date();
//			date.setHours(0, 0, 0, 0);
//			var value = 100;
			
			function generateData(i) {
				
			  // 1. i번째 객체에서 값 가져오기
			  // * 문자열 -> 정수형식
			 let value = parseInt( jsonlist[i]['value'] );
			  // * 문자열 -> 날짜형식[new Date("문자열");]
			  let date = new Date( jsonlist[i]['date'] );
			  
			  date.setHours(0, 0, 0, 0);
			  am5.time.add(date, "day", 1);
			  return {
			    date: date.getTime(),
			    value: value
			  };
			}
			
			function generateDatas(count) {
			  var data = [];
			  for (var i = 0; i < count; ++i) {
			    data.push(generateData(i));
			  }
			  return data;
			}
			
			
			// Create axes
			// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
			var xAxis = chart.xAxes.push(am5xy.DateAxis.new(root, {
			  maxDeviation: 0,
			  baseInterval: {
			    timeUnit: "day",
			    count: 1
			  },
			  renderer: am5xy.AxisRendererX.new(root, {}),
			  tooltip: am5.Tooltip.new(root, {})
			}));
			
			var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
			  renderer: am5xy.AxisRendererY.new(root, {})
			}));
			
			
			// Add series
			// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
			var series = chart.series.push(am5xy.ColumnSeries.new(root, {
			  name: "Series",
			  xAxis: xAxis,
			  yAxis: yAxis,
			  valueYField: "value",
			  valueXField: "date",
			  tooltip: am5.Tooltip.new(root, {
			    labelText: "{valueY}"
			  })
			}));
			
			
			
			// Add scrollbar
			// https://www.amcharts.com/docs/v5/charts/xy-chart/scrollbars/
			chart.set("scrollbarX", am5.Scrollbar.new(root, {
			  orientation: "horizontal"
			}));
			
			var data = generateDatas(jsonlist.length); // 차트에 들어가는 데이터 [인수 : 객체수]
			series.data.setAll(data);
			
			
			// Make stuff animate on load
			// https://www.amcharts.com/docs/v5/concepts/animations/
			series.appear(1000);
			chart.appear(1000, 100);
			
			}); // end am5.ready()
			
			////////////////////////////////////////////////// 아이엠차트 end //////////////////////////////////////////////////
			
				$.ajax({
					url : "/jspweb/admin/getchart",
					data : {"type" : 2},
					success : function(result){
						console.log(result);
						jsonlist2 = result;
						
						////////////////////////////////////////////////// 도넛차트 //////////////////////////////////////////////////
						am5.ready(function() {
						
						// Create root element
						// https://www.amcharts.com/docs/v5/getting-started/#Root_element
						var root = am5.Root.new("chartdiv2");
						
						
						// Set themes
						// https://www.amcharts.com/docs/v5/concepts/themes/
						root.setThemes([
						  am5themes_Animated.new(root)
						]);
						
						
						// Create chart
						// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/
						var chart = root.container.children.push(am5percent.PieChart.new(root, {
						  layout: root.verticalLayout,
						  innerRadius: am5.percent(50)
						}));
						
						
						// Create series
						// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Series
						var series = chart.series.push(am5percent.PieSeries.new(root, {
						  valueField: "value",
						  categoryField: "category",
						  alignLabels: false
						}));
						
						series.labels.template.setAll({
						  textType: "circular",
						  centerX: 0,
						  centerY: 0
						});
						
						
						// Set data
						// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Setting_data
						series.data.setAll(jsonlist2);
						
						
						// Create legend
						// https://www.amcharts.com/docs/v5/charts/percent-charts/legend-percent-series/
						var legend = chart.children.push(am5.Legend.new(root, {
						  centerX: am5.percent(50),
						  x: am5.percent(50),
						  marginTop: 15,
						  marginBottom: 15,
						}));
						
						legend.data.setAll(series.dataItems);
						
						
						// Play initial series animation
						// https://www.amcharts.com/docs/v5/concepts/animations/#Animation_of_series
						series.appear(1000, 100);
						
						}); // end am5.ready()
						
						////////////////////////////////////////////////// 도넛차트 end //////////////////////////////////////////////////
						
					} // success2 end
				}); // ajax2 end

		} // success end
	}); // ajax end
	
});

function getchart(snum){
	alert(snum);
	
	$.ajax({
		url : "/jspweb/admin/getchart",
		data : {"type" : 3, "value" : snum},
		success : function(result){
			console.log(result);
			////////////////////////////////////////////////// 선차트 //////////////////////////////////////////////////		
			am5.ready(function() {
			
			// Create root element
			// https://www.amcharts.com/docs/v5/getting-started/#Root_element
			var root = am5.Root.new("chartdiv3");
			
			
			// Set themes
			// https://www.amcharts.com/docs/v5/concepts/themes/
			root.setThemes([
			  am5themes_Animated.new(root)
			]);
			
			
			// Create chart
			// https://www.amcharts.com/docs/v5/charts/xy-chart/
			var chart = root.container.children.push(am5xy.XYChart.new(root, {
			  panX: true,
			  panY: true,
			  wheelX: "panX",
			  wheelY: "zoomX",
			  pinchZoomX:true
			}));
			
			
			// Add cursor
			// https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
			var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {
			  behavior: "none"
			}));
			cursor.lineY.set("visible", false);
			
			
			// Generate random data
//			var date = new Date();
//			date.setHours(0, 0, 0, 0);
//			var value = 100;
			
			function generateData(i) {
//			  value = Math.round((Math.random() * 10 - 5) + value);
			  
			   let value = parseInt( jsonlist3[i]["value"] );  	
			   let date = new Date( jsonlist3[i]["date"] );
			  
			  am5.time.add(date, "day", 1);	  
			  
			  return {
			    date: date.getTime(),
			    value: value
			  };
			}
			
			function generateDatas(count) {
			  var data = [];
			  for (var i = 0; i < count; ++i) {
			    data.push(generateData(i));
			  }
			  return data;
			}
			
			
			// Create axes
			// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
			var xAxis = chart.xAxes.push(am5xy.DateAxis.new(root, {
			  maxDeviation: 0.2,
			  baseInterval: {
			    timeUnit: "day",
			    count: 1
			  },
			  renderer: am5xy.AxisRendererX.new(root, {}),
			  tooltip: am5.Tooltip.new(root, {})
			}));
			
			var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
			  renderer: am5xy.AxisRendererY.new(root, {})
			}));
			
			
			// Add series
			// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
			var series = chart.series.push(am5xy.LineSeries.new(root, {
			  name: "Series",
			  xAxis: xAxis,
			  yAxis: yAxis,
			  valueYField: "value",
			  valueXField: "date",
			  tooltip: am5.Tooltip.new(root, {
			    labelText: "{valueY}"
			  })
			}));
			
			
			// Add scrollbar
			// https://www.amcharts.com/docs/v5/charts/xy-chart/scrollbars/
			chart.set("scrollbarX", am5.Scrollbar.new(root, {
			  orientation: "horizontal"
			}));
			
			
			// Set data
			var data = generateDatas(jsonlist3.length);
			series.data.setAll(data);
			
			
			// Make stuff animate on load
			// https://www.amcharts.com/docs/v5/concepts/animations/
			series.appear(1000);
			chart.appear(1000, 100);
			
			}); // end am5.ready()
			////////////////////////////////////////////////// 선차트 end //////////////////////////////////////////////////	
			
			
		} // success end
	}); // ajax end


}; // 제품별 판매추이 end

