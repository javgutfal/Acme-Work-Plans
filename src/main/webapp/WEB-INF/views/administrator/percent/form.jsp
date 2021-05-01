<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="percentId" />
	
	<acme:form-textbox code="administrator.percent.form.label.code" path="code" readonly="true"/>
	<acme:form-textbox code="administrator.percent.form.label.data" path="data"/>
	
	<jstl:if test="${command == 'show'}">
	<acme:form-submit code="administrator.percent.form.button.update"
			action="/administrator/variable/percent/update" />
	</jstl:if>
	<jstl:if test="${command == 'update'}">
		<acme:form-submit code="administrator.percent.form.button.update"
			action="/administrator/variable/percent/update" />
	</jstl:if>
  	<acme:form-return code="administrator.percent.form.button.return"/>
  	
</acme:form>