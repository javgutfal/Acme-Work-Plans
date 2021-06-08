<%--
- form.jsp
-
- Copyright (C) 2012-2021 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<h2>
	<acme:message code="administrator.dashboard.form.title.general-indicators"/>
</h2>

<table class="table table-sm" id="list">
	<caption>
		<acme:message code="administrator.dashboard.form.title.general-indicators"/>
	</caption>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.averageOfShoutCurrencyEUR"/>
		</th>
		<td>
			<acme:print value="${averageOfShoutCurrencyEUR}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.averageOfShoutCurrencyUSD"/>
		</th>
		<td>
			<acme:print value="${averageOfShoutCurrencyUSD}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.deviationOfShoutCurrencyEUR"/>
		</th>
		<td>
			<acme:print value="${deviationOfShoutCurrencyEUR}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.deviationOfShoutCurrencyUSD"/>
		</th>
		<td>
			<acme:print value="${deviationOfShoutCurrencyUSD}"/>
		</td>
	</tr>
	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.ratioOfShoutsFlagged"/>
		</th>
		<td>
			<acme:print value="${ratioOfShoutsFlagged}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.ratioOfShoutsXXX"/>
		</th>
		<td>
			<acme:print value="${ratioOfShoutsXXX}"/>
		</td>
	</tr>
	
</table>
<div id="container" class="container"></div>

<!-- Highcharts JS -->
	<script type="text/javascript"
		src="//code.highcharts.com/highcharts.js"></script>

<script type="text/javascript">
Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Shouts DashBoard'
    },
    xAxis: {
        categories: [
            'Public',
            'Private',
            'Total',

        ],
        crosshair: true
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Number of WorkPlans'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y} shouts</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    },
    plotOptions: {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        }
    },
    series: [{
        name: 'shouts',
        data: [<jstl:out value="${publicShoutNumber}"/>,<jstl:out value="${privateShoutNumber}"/>,
        				<jstl:out value="${publicShoutNumber}"/> + <jstl:out value="${privateShoutNumber}"/>]

    }]
});
</script>