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

	<h2><acme:message code="inventor.patronage.message.patron"/></h2>
	<acme:input-textbox code="inventor.patronage.form.label.patron.username" path="username"/>
	<acme:input-textbox code="inventor.patronage.form.label.patron.company" path="company"/>
	<acme:input-textbox code="inventor.patronage.form.label.patron.statement" path="statement"/>
	<acme:input-url code="inventor.patronage.form.label.patron.info" path="patronLink"/>

	<acme:button code="inventor.patronage.form.button.patronageReport" action="/inventor/patronage-report/list?patronageId=${patronageId}"/>

</acme:form> 