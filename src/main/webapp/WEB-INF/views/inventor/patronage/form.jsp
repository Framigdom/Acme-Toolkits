<%@page language="java" import="acme.entities.patronage.Status"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<h2><acme:message code="inventor.patronage.message.patronage"/></h2>
	<acme:input-textbox code="inventor.patronage.form.label.status" path="status"/>
	<acme:input-textbox code="inventor.patronage.form.label.code" path="code"/>
	<acme:input-textbox code="inventor.patronage.form.label.legalStuff" path="legalStuff"/>
	<acme:input-money code="inventor.patronage.form.label.budget" path="budget"/>
	<acme:input-moment code="inventor.patronage.form.label.startDate" path="startDate"/>
	<acme:input-moment code="inventor.patronage.form.label.finishDate" path="finishDate"/>
	<acme:input-url code="inventor.patronage.form.label.info" path="link"/>
	
	<jstl:choose>
		<jstl:when test="${acme:anyOf(command, 'show, update-status') && status == Status.PROPOSED}">
			<acme:submit code="inventor.patronage.form.button.updateStatus.accept" action="/inventor/patronage/update-status?status=${Status.ACCEPTED.toString()}"/>
			<acme:submit code="inventor.patronage.form.button.updateStatus.deny" action="/inventor/patronage/update-status?status=${Status.DENIED.toString()}"/>
		</jstl:when>
		<jstl:when test="${command == 'show' && status != Status.PROPOSED}">
			<h2><acme:message code="inventor.patronage.message.patron"/></h2>
			<acme:input-textbox code="inventor.patronage.form.label.patron.username" path="username"/>
			<acme:input-textbox code="inventor.patronage.form.label.patron.company" path="company"/>
			<acme:input-textbox code="inventor.patronage.form.label.patron.statement" path="statement"/>
			<acme:input-url code="inventor.patronage.form.label.patron.info" path="patronLink"/>
		
			<acme:button code="inventor.patronage.form.button.patronageReport" action="/inventor/patronage-report/list?patronageId=${patronageId}"/>
		</jstl:when>
	</jstl:choose>

</acme:form> 