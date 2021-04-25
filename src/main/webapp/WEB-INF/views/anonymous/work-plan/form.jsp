<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="workPlanId" />
	
	<acme:form-textbox code="anonymous.workplan.form.label.manager" path="manager"/>
	<acme:form-moment code="anonymous.workplan.form.label.initialTime" path="initialTime"/>
	<acme:form-moment code="anonymous.workplan.form.label.finalTime" path="finalTime"/>
	<acme:form-double code="anonymous.workplan.form.label.workload" path="workload"/>

  	<acme:form-return code="anonymous.workplan.form.button.return"/>
</acme:form>