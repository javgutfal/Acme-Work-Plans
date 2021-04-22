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

<h2>
	<acme:message code="administrator.dashboard.form.title.application-statuses"/>
</h2>

<div>
	<canvas id="canvas"></canvas>
</div>

<script type="text/javascript">
	
</script>
