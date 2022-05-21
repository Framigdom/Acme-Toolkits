<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<h2><acme:message code="inventor.CHIMPUM.message.CHIMPUM"/></h2>
	<acme:input-textbox code="inventor.CHIMPUM.form.label.pattern" path="pattern"/>
	<acme:input-textbox code="inventor.CHIMPUM.form.label.moment" path="moment"/>
	<acme:input-textbox code="inventor.CHIMPUM.form.label.title" path="title"/>
	<acme:input-money code="inventor.CHIMPUM.form.label.description" path="description"/>
	<acme:input-moment code="inventor.CHIMPUM.form.label.startDate" path="startDate"/>
	<acme:input-moment code="inventor.CHIMPUM.form.label.finishDate" path="finishDate"/>
	<acme:input-moment code="inventor.CHIMPUM.form.label.budget" path="budget"/>
	<acme:input-url code="inventor.CHIMPUM.form.label.info" path="link"/>

</acme:form> 