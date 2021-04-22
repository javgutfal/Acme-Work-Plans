
<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="taskId" />

	<acme:form-textbox code="manager.task.form.label.title" path="title" />
	<acme:form-moment code="manager.task.form.label.initialTime"
		path="initialTime" />
	<acme:form-moment code="manager.task.form.label.finalTime"
		path="finalTime" />
	<acme:form-double code="manager.task.form.label.workload"
		path="workload" />
	<acme:form-textarea code="manager.task.form.label.description"
		path="description" />
	<acme:form-url code="manager.task.form.label.link" path="link" />

	<acme:form-select code="manager.task.form.label.publicTask"
		path="publicTask">
		<acme:form-option code="PUBLIC" value="true" selected="true" />
		<acme:form-option code="PRIVATE" value="false" />
	</acme:form-select>
	<jstl:if test="${command == 'create'}">
		<acme:form-submit code="manager.task.form.button.create"
			action="/manager/task/create" />
	</jstl:if>
	
	<jstl:if test="${command == 'update'}">
		<acme:form-submit code="manager.task.form.button.update"
			action="/manager/task/update" />
	</jstl:if>
	<acme:form-return code="manager.task.form.button.return" />
</acme:form>