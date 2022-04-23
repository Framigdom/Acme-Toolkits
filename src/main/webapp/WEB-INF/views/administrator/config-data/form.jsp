<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:input-textbox code="administrator.config-data.form.label.systemCurrency" path="systemCurrency"/>	
	<acme:input-textbox code="administrator.config-data.form.label.acceptedCurrencies" path="acceptedCurrencies"/>
	<acme:input-textbox code="administrator.config-data.form.label.strongSpamTerms" path="strongSpamTerms"/>	
	<acme:input-textbox code="administrator.config-data.form.label.weakSpamTerms" path="weakSpamTerms"/>
	<acme:input-textbox code="administrator.config-data.form.label.strongSpamTreshold" path="strongSpamTreshold"/>	
	<acme:input-textbox code="administrator.config-data.form.label.weakSpamTreshold" path="weakSpamTreshold"/>
</acme:form>
