

<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.shout.form.label.author" path="author" placeholder="Laura Castillo Ortiz" />
	<acme:form-textarea code="anonymous.shout.form.label.text" path="text" placeholder="Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..." />
	<acme:form-textbox code="anonymous.shout.form.label.info" path="info" placeholder="https://www.google.com" />
	<acme:form-textbox code="anonymous.shout.form.label.xxx1" path="xxx.xxx1" placeholder="yyyy/mm/dd" />
    <acme:form-textbox code="anonymous.shout.form.label.currency" path="xxx.money.currency" placeholder="EUR / USD" />
	<acme:form-textbox code="anonymous.shout.form.label.amount" path="xxx.money.amount" placeholder="123456,78 (ES) / 123456.78 (EN)" />
	<acme:form-textbox code="anonymous.shout.form.label.flag" path="xxx.flag" placeholder="true" />
	
	<acme:form-submit code="anonymous.shout.form.button.create" action="/anonymous/shout/create"/>
  	<acme:form-return code="anonymous.shout.form.button.return"/>
</acme:form>