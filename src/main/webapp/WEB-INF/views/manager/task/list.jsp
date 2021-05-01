<%@page language="java"%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="false">
	<acme:list-column code="manager.task.list.label.title" path="title"/>
	<acme:list-column code="manager.task.list.label.initial-time" path="initialTime"/>
	<acme:list-column code="manager.task.list.label.final-time" path="finalTime"/>
	<acme:list-column code="manager.task.list.label.workload" path="workload"/>
	<acme:list-column code="manager.task.list.label.link" path="link"/>
	<acme:list-column code="manager.task.list.label.description" path="description"/>
	<acme:list-column code="manager.task.list.label.public" path="publicTask"/>
</acme:list>
