
<%@page language="java"%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="false">
	<acme:list-column code="administrator.spamWord.list.label.wordEn" path="wordEn"/>
	<acme:list-column code="administrator.spamWord.list.label.wordEs" path="wordEs"/>
</acme:list>