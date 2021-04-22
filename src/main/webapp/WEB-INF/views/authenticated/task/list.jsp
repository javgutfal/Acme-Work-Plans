<%@page language="java"%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="authenticated.task.list.label.title" path="title" width="10%"/>
	<acme:list-column code="authenticated.task.list.label.initial-time" path="initialTime" width="10%"/>
	<acme:list-column code="authenticated.task.list.label.final-time" path="finalTime" width="10%"/>
	<acme:list-column code="authenticated.task.list.label.workload" path="workload" width="10%"/>
	<acme:list-column code="authenticated.task.list.label.link" path="link" width="30%"/>
	<acme:list-column code="authenticated.task.list.label.description" path="description" width="30%"/>
</acme:list>