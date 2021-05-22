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
			<acme:message code="administrator.dashboard.form.label.publicWorkPlans"/>
		</th>
		<td>
			<acme:print value="${publicWorkPlanNumber}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.privateWorkPlans"/>
		</th>
		<td>
			<acme:print value="${privateWorkPlanNumber}"/>
		</td>
	</tr>
	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.finishedWorkPlan"/>
		</th>
		<td>
			<acme:print value="${finishedWorkPlanNumber}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.notFinishedWorkPlan"/>
		</th>
		<td>
			<acme:print value="${notFinishedWorkPlanNumber}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.averageOfExecutionWorkPlanPeriod"/>
		</th>
		<td>
			<acme:print value="${averageOfExecutionWorkPlanPeriod}"/>
		</td>
	</tr>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.deviationOfExecutionWorkPlanPeriod"/>
		</th>
		<td>
			<acme:print value="${deviationOfExecutionWorkPlanPeriod}"/>
		</td>
	</tr>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minExecutionWorkPlanPeriod"/>
		</th>
		<td>
			<acme:print value="${minExecutionWorkPlanPeriod}"/>
		</td>
	</tr>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maxExecutionWorkPlanPeriod"/>
		</th>
		<td>
			<acme:print value="${maxExecutionWorkPlanPeriod}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.averageOfWorkPlanWorkload"/>
		</th>
		<td>
			<acme:print value="${averageOfWorkPlanWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.deviationOfWorkPlanWorkload"/>
		</th>
		<td>
			<acme:print value="${deviationOfWorkPlanWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minWorkPlanWorkload"/>
		</th>
		<td>
			<acme:print value="${minWorkPlanWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maxWorkPlanWorkload"/>
		</th>
		<td>
			<acme:print value="${maxWorkPlanWorkload}"/>
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
        text: 'WorkPlans DashBoard'
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
            '<td style="padding:0"><b>{point.y} workplans</b></td></tr>',
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
        name: 'workplans',
        data: [<jstl:out value="${publicWorkPlanNumber}"/>,<jstl:out value="${privateWorkPlanNumber}"/>,
        				<jstl:out value="${publicWorkPlanNumber}"/> + <jstl:out value="${privateWorkPlanNumber}"/>]

    }]
});
</script>