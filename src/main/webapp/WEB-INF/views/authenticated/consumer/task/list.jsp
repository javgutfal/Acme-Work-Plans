<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="authenticated.task.list.label.title" path="title" width="20%"/>
	<acme:list-column code="authenticated.task.list.label.execution_period" path="execution_period" width="20%"/>
	<acme:list-column code="authenticated.task.list.label.workload" path="workload" width="20%"/>
	<acme:list-column code="authenticated.task.list.label.description" path="description" width="60%"/>
	<acme:list-column code="authenticated.task.list.label.link" path="link" width="60%"/>
</acme:list>