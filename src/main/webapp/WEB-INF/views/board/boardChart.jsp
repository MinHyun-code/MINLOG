<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="chart-area" style="height:30vh; width:50vw"></div>



<script type="text/javascript">
const el = document.getElementById('chart-area');
const data = {
  categories: [
    '01/01/2020',
    '02/01/2020',
    '03/01/2020',
    '04/01/2020',
    '05/01/2020',
    '06/01/2020',
    '07/01/2020',
    '08/01/2020',
    '09/01/2020',
    '10/01/2020',
    '11/01/2020',
    '12/01/2020',
  ],
  series: [
    {
      name: 'Seoul',
      data: [-3.5, -1.1, 4.0, 11.3, 17.5, 21.5, 25.9, 27.2, 24.4, 13.9, 6.6, -0.6],
    },
    {
      name: 'Seattle',
      data: [3.8, 5.6, 7.0, 9.1, 12.4, 15.3, 17.5, 17.8, 15.0, 10.6, 6.6, 3.7],
    },
    {
      name: 'Sydney',
      data: [22.1, 22.0, 20.9, 18.3, 15.2, 12.8, 11.8, 13.0, 15.2, 17.6, 19.4, 21.2],
    },
    {
      name: 'Moscow',
      data: [-10.3, -9.1, -4.1, 4.4, 12.2, 16.3, 18.5, 16.7, 10.9, 4.2, -2.0, -7.5],
    },
    {
      name: 'Jungfrau',
      data: [-13.2, -13.7, -13.1, -10.3, -6.1, -3.2, 0.0, -0.1, -1.8, -4.5, -9.0, -10.9],
    },
  ],
};
const options = {
  responsive: false,
  chart: { title: '24-hr Average Temperature', width: 500, height: 500 },
  xAxis: {
    title: 'Month',
  },
  yAxis: {
    title: 'Amount',
  },
  tooltip: {
    formatter: (value) => `${value}°C`,
  },
  legend: {
    align: 'bottom',
  },
};

const chart = toastui.Chart.lineChart({ el, data, options });
</script>