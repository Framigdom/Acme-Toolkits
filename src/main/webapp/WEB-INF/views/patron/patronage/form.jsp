<%@ page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<h2><acme:message code="patron.patronage.message.patronage"/></h2>
	<acme:input-textbox code="patron.patronage.form.label.code" path="code" placeholder="ABC-012-D"/>
	<acme:input-textbox code="patron.patronage.form.label.legalStuff" path="legalStuff"/>
	<acme:input-money code="patron.patronage.form.label.budget" path="budget"/>
	<acme:input-moment code="patron.patronage.form.label.startDate" path="startDate"/>
	<acme:input-moment code="patron.patronage.form.label.finishDate" path="finishDate"/>
	<acme:input-url code="patron.patronage.form.label.info" path="link"/>
	
	<jstl:choose>
		<jstl:when test="${command == 'show' && draftMode == false}">
			<acme:input-textbox code="patron.patronage.form.label.status" path="status"/>
		
			<h2><acme:message code="patron.patronage.message.inventor"/></h2>
			<acme:input-textbox code="patron.patronage.form.label.inventor.username" path="inventor.userAccount.username"/>
			<acme:input-textbox code="patron.patronage.form.label.inventor.company" path="inventor.company"/>
			<acme:input-textbox code="patron.patronage.form.label.inventor.statement" path="inventor.statement"/>
			<acme:input-url code="patron.patronage.form.label.inventor.info" path="inventor.link"/>
		
			<acme:button code="patron.patronage.form.button.patronageReport" action="/patron/patronage-report/list?patronageId=${patronageId}"/>
		</jstl:when>
		<jstl:when test="${acme:anyOf(command, 'show, update, publish, delete') && draftMode == true}">
			<acme:input-select code="patron.patronage.form.label.select.inventor" path="inventor">
				<jstl:forEach items="${inventors}" var="optionInventor">
					<acme:input-option code="${optionInventor.userAccount.username}" value="${optionInventor.userAccount.username}"
										selected="${inventor.equals(optionInventor)}"/>
				</jstl:forEach>
			</acme:input-select>
			<acme:submit code="patron.patronage.form.button.update" action="/patron/patronage/update"/>
			<acme:submit code="patron.patronage.form.button.publish" action="/patron/patronage/publish"/>
			<acme:submit code="patron.patronage.form.button.delete" action="/patron/patronage/delete"/>
		</jstl:when>
		<jstl:when test="${command == 'create'}">
			<acme:input-select code="patron.patronage.form.label.select.inventor" path="inventor">
				<jstl:forEach items="${inventors}" var="optionInventor">
					<acme:input-option code="${optionInventor.userAccount.username}" value="${optionInventor.userAccount.username}"/>
				</jstl:forEach>
			</acme:input-select>
			
			<acme:submit code="patron.patronage.form.button.create" action="/patron/patronage/create"/>
		</jstl:when>
	</jstl:choose>
</acme:form>