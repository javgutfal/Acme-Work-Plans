
<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="taskId" />

	<acme:form-textbox code="anonymous.task.form.label.title" path="title" />
	<acme:form-moment code="anonymous.task.form.label.initial-time"
		path="initialTime" />
	<acme:form-moment code="anonymous.task.form.label.final-time"
		path="finalTime" />
	<acme:form-double code="anonymous.task.form.label.workload"
		path="workload" />
	<acme:form-textarea code="anonymous.task.form.label.description"
		path="description" />
	<acme:form-url code="anonymous.task.form.label.link" path="link" />
	<acme:form-select code="anonymous.task.form.label.publicTask"
		path="publicTask">
		
		<jstl:if test="${publicTask == 'true'}">
			<acme:form-option code="PUBLIC" value="true" selected="true" />
			<acme:form-option code="PRIVATE" value="false" />
		</jstl:if>
		
		<jstl:if test="${ publicTask == 'false'}">
			<acme:form-option code="PUBLIC" value="true"  />
			<acme:form-option code="PRIVATE" value="false" selected="true" />
		</jstl:if>
	</acme:form-select>
	<acme:form-return code="anonymous.task.form.button.return" />
</acme:form>