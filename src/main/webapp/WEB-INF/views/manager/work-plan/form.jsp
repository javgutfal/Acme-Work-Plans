<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="workPlanId" />
	
	<acme:form-moment code="manager.workplan.form.label.initialTime" path="initialTime"/>
	<acme:form-moment code="manager.workplan.form.label.finalTime" path="finalTime"/>
	<acme:form-select code="manager.workplan.form.label.publicWorkPlan"
		path="publicWorkPlan">
		<jstl:if test="${ publicWorkPlan == 'true'}">
			<acme:form-option code="PUBLIC" value="true" selected="true" />
			<acme:form-option code="PRIVATE" value="false" />
		</jstl:if>
		
		<jstl:if test="${ publicWorkPlan == 'false'}">
			<acme:form-option code="PUBLIC" value="true"  />
			<acme:form-option code="PRIVATE" value="false" selected="true" />
		</jstl:if>
		
	</acme:form-select>
	
	
	
	<acme:form-submit test="${command == 'show' }" code="manager.workplan.form.button.update" action="/manager/workPlans/update"/>
	<acme:form-submit test="${command == 'show' }" method="get" code="manager.workplan.form.button.list.NotTask" action="/manager/task/list-not-workplan?workPlanId=${id}"/>
	<acme:form-submit test="${command == 'show' }" method="get" code="manager.workplan.form.button.list.Task" action="/manager/task/list-workplan?workPlanId=${id}#listWorkPlan"/>
	<acme:form-submit test="${command == 'show' }" code="manager.workplan.form.button.delete" action="/manager/workPlans/delete"/>
	<acme:form-submit test="${command == 'show' && published == 'false' }" code="manager.workplan.form.button.publish" action="/manager/workPlans/publish"/>
	<acme:form-submit test="${command == 'create' }" code="manager.workplan.form.button.create" action="/manager/workPlans/create"/>
	<acme:form-submit test="${command == 'update' }" code="manager.workplan.form.button.update" action="/manager/workPlans/update"/>
	<acme:form-submit test="${command == 'publish' }" code="manager.workplan.form.button.publish" action="/manager/workPlans/publish"/>
	<acme:form-submit test="${command == 'delete' }" code="manager.workplan.form.button.delete" action="/manager/workPlans/delete"/>
  	<acme:form-return code="manager.workplan.form.button.return"/>
  	
</acme:form>