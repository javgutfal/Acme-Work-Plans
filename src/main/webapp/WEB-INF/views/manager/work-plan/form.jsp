<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="workPlanId" />
	
	<acme:form-moment code="manager.workplan.form.label.initialTime" path="initialTime"/>
	<acme:form-moment code="manager.workplan.form.label.finalTime" path="finalTime"/>
	
	
	
	<jstl:if test="${command == 'create'}">
		<acme:form-submit code="manager.workplan.form.button.create"
			action="/manager/workPlans/create" />
	</jstl:if>
	
	
  	<acme:form-return code="manager.workplan.form.button.return"/>
</acme:form>