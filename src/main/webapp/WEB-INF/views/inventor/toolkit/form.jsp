<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form> 
	<acme:input-textbox code="inventor.toolkit.form.label.title" path="title"/>
	<acme:input-textbox code="inventor.toolkit.form.label.code" path="code"/>
	<acme:input-textarea code="inventor.toolkit.form.label.description" path="description"/>
	<acme:input-textarea code="inventor.toolkit.form.label.assemblyNotes" path="assemblyNotes"/>
	<acme:input-textbox code="inventor.toolkit.form.label.link" path="link"/>
	
	<jstl:choose>
	
		<jstl:when test="${published == false && acme:anyOf(command, 'show,update,delete,publish')}">
		<acme:input-money code="inventor.toolkit.form.label.price" path="price" placeholder="${price}" readonly="true"/>
		<acme:button code="inventor.toolkit.form.button.quantity" action="/inventor/quantity/list?toolkitId=${id}"/>
		<acme:submit code="inventor.toolkit.form.button.update" action="/inventor/toolkit/update"/>
		<acme:submit code="inventor.toolkit.form.button.delete" action="/inventor/toolkit/delete"/>
		<acme:submit code="inventor.toolkit.form.button.publish" action="/inventor/toolkit/publish"/>
		
		</jstl:when>
		<jstl:when test="${published == true && command == 'show'}">
		<acme:input-money code="inventor.toolkit.form.label.price" path="price" placeholder="${price}" readonly="true"/>
		<acme:button code="inventor.toolkit.form.button.quantity" action="/inventor/quantity/list?toolkitId=${id}"/>
		</jstl:when>
		
		<jstl:when test="${command == 'create'}">		
		<acme:submit code="inventor.toolkit.form.button.create" action="/inventor/toolkit/create"/>			
		</jstl:when>	
		
	</jstl:choose>
</acme:form>

