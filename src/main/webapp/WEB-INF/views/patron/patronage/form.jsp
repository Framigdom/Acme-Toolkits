<%@ page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<h2><acme:message code="patron.patronage.message.patronage"/></h2>
	<acme:input-textbox code="patron.patronage.form.label.status" path="status"/>
	<acme:input-textbox code="patron.patronage.form.label.code" path="code"/>
	<acme:input-textbox code="patron.patronage.form.label.legalStuff" path="legalStuff"/>
	<acme:input-money code="patron.patronage.form.label.budget" path="budget"/>
	<acme:input-moment code="patron.patronage.form.label.startDate" path="startDate"/>
	<acme:input-moment code="patron.patronage.form.label.finishDate" path="finishDate"/>
	<acme:input-url code="patron.patronage.form.label.info" path="link"/>

	<h2><acme:message code="patron.patronage.message.inventor"/></h2>
	<acme:input-textbox code="patron.patronage.form.label.inventor.username" path="username"/>
	<acme:input-textbox code="patron.patronage.form.label.inventor.company" path="company"/>
	<acme:input-textbox code="patron.patronage.form.label.inventor.statement" path="statement"/>
	<acme:input-url code="patron.patronage.form.label.inventor.info" path="link"/>
</acme:form>