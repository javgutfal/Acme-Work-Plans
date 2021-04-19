
<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="manager.task.form.label.title" path="title"/>
	<acme:form-textbox code="manager.task.form.label.initialTime" path="initialTime"/>
	<acme:form-textbox code="manager.task.form.label.finalTime" path="finalTime"/>
	<acme:form-textbox code="manager.task.form.label.workload" path="workload"/>
	<acme:form-textarea code="manager.task.form.label.description" path="description"/>
	
	<acme:form-submit code="manager.task.form.button.create" action="/manager/task/create"/>
  	<acme:form-return code="manager.task.form.button.return"/>
</acme:form>