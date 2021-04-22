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

<table class="table table-sm">
	<caption>
		<acme:message code="administrator.dashboard.form.title.general-indicators"/>
	</caption>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.publicTaskNumber"/>
		</th>
		<td>
			<acme:print value="${publicTaskNumber}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.privateTaskNumber"/>
		</th>
		<td>
			<acme:print value="${privateTaskNumber}"/>
		</td>
	</tr>
	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.finishedTaskNumber"/>
		</th>
		<td>
			<acme:print value="${finishedTaskNumber}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.notFinishedTaskNumber"/>
		</th>
		<td>
			<acme:print value="${notFinishedTaskNumber}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.averageOfExecutionTaskPeriod"/>
		</th>
		<td>
			<acme:print value="${averageOfExecutionTaskPeriod}"/>
		</td>
	</tr>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.deviationOfExecutionTaskPeriod"/>
		</th>
		<td>
			<acme:print value="${deviationOfExecutionTaskPeriod}"/>
		</td>
	</tr>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minExecutionTaskPeriod"/>
		</th>
		<td>
			<acme:print value="${minExecutionTaskPeriod}"/>
		</td>
	</tr>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maxExecutionTaskPeriod"/>
		</th>
		<td>
			<acme:print value="${maxExecutionTaskPeriod}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.averageOfTaskWorkload"/>
		</th>
		<td>
			<acme:print value="${averageOfTaskWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.deviationOfTaskWorkload"/>
		</th>
		<td>
			<acme:print value="${deviationOfTaskWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minTaskWorkload"/>
		</th>
		<td>
			<acme:print value="${minTaskWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maxTaskWorkload"/>
		</th>
		<td>
			<acme:print value="${maxTaskWorkload}"/>
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
        text: 'Task DashBoard'
    },
    xAxis: {
        categories: [
            'Public',
            'Private',
            'Finished',
            'Not Finished',

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
            '<td style="padding:0"><b>{point.y} tasks</b></td></tr>',
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
        name: 'tasks',
        data: [<jstl:out value="${publicTaskNumber}"/>,<jstl:out value="${privateTaskNumber}"/>,
        				<jstl:out value="${finishedTaskNumber}"/>,<jstl:out value="${notFinishedTaskNumber}"/>]

    }]
});
</script>
