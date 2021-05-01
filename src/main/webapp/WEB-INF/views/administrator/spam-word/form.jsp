<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="spamWordId" />
	
	<acme:form-textbox code="administrator.spamWord.form.label.wordEn" path="wordEn"/>
	<acme:form-textbox code="administrator.spamWord.form.label.wordEs" path="wordEs"/>
	
	<jstl:if test="${command == 'show'}">
	<acme:form-submit code="administrator.spamWord.form.button.update"
			action="/administrator/spamword/update" />
	<acme:form-submit code="administrator.spamword.form.button.delete" action="/administrator/spamword/delete"/>
	</jstl:if>
	<jstl:if test="${command == 'create'}">
		<acme:form-submit code="administrator.spamWord.form.button.create"
			action="/administrator/spamword/create" />
	</jstl:if>
	<jstl:if test="${command == 'update'}">
		<acme:form-submit code="administrator.spamWord.form.button.update"
			action="/administrator/spamword/update" />
	</jstl:if>
	<jstl:if test="${command == 'delete'}">
		<acme:form-submit code="administrator.spamword.form.button.delete" action="/administrator/spamword/delete"/>
	</jstl:if>
  	<acme:form-return code="administrator.spamWord.form.button.return"/>
  	
</acme:form>