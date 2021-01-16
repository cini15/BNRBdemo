function renderChart() {
    google.charts.load('current', {'packages': ['corechart']})
    google.charts.setOnLoadCallback(drawChart)
}

function drawChart() {

    let e = document.getElementById("id");
    let ratesShort = []
    let strUser = e.options[e.selectedIndex].text;
    ratesShort.push(["number", strUser])
    getRates(ratesShort)
    let data = google.visualization.arrayToDataTable(ratesShort)

    let options = {
        curveType: 'function',
        legend: {position: 'bottom', textStyle: {color: 'blue', fontSize: 14}},
        chartArea: {left:80,top:20,width:'80%',height:'70%'}
    }

    let chart = new google.visualization.LineChart(document.getElementById('chart_div'))

    chart.draw(data, options)
}


$(function(){
    renderChart();//calling function on window load
    $(window).resize(function(){
        renderChart();//calling function on window resize
    });
});
