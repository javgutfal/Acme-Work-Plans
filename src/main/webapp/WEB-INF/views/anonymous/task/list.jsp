<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="anonymous.task.list.label.title" path="title" width="10%"/>
	<acme:list-column code="anonymous.task.list.label.initial-time" path="initialTime" width="10%"/>
	<acme:list-column code="anonymous.task.list.label.final-time" path="finalTime" width="10%"/>
	<acme:list-column code="anonymous.task.list.label.workload" path="workload" width="10%"/>
	<acme:list-column code="anonymous.task.list.label.link" path="link" width="30%"/>
	<acme:list-column code="anonymous.task.list.label.description" path="description" width="30%"/>
</acme:list>