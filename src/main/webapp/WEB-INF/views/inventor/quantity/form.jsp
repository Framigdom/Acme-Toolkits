<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readOnly}"> 
	
	
	<jstl:choose>		
	
		<jstl:when test="${published == false}">
		<acme:input-textbox code="inventor.quantity.form.label.amount" path="amount"/>
		</jstl:when>
		<jstl:otherwise>
		<acme:input-textbox code="inventor.quantity.form.label.amount" path="amount" readonly="true"/>
		</jstl:otherwise>
		
	</jstl:choose>
	
	
	<jstl:choose>		
	
		<jstl:when test="${acme:anyOf(command, 'show,update,delete')}">
			<acme:input-textbox code="inventor.artifact.form.label.name" path="artifact.name" readonly="true"/>			
			<acme:input-textbox code="inventor.artifact.form.label.code" path="artifact.code" readonly="true"/>
			<acme:input-textbox code="inventor.artifact.form.label.technology" path="artifact.technology" readonly="true"/>
			<acme:input-textarea code="inventor.artifact.form.label.description" path="artifact.description" readonly="true"/>
			<acme:input-textbox code="inventor.artifact.form.label.type" path="artifact.artifactType" readonly="true"/>
			<acme:input-textbox code="inventor.artifact.form.label.link" path="artifact.link" readonly="true"/>
			<acme:submit test="${published == false}" code="inventor.quantity.form.button.update" action="/inventor/quantity/update"/>
			<acme:submit test="${published == false}" code="inventor.quantity.form.button.delete" action="/inventor/quantity/delete"/>		
		</jstl:when>
	
		<jstl:when test="${command == 'create'}">
			<acme:input-select code="inventor.quantity.form.label.select.artifact" path="artifactId">
				<jstl:forEach items="${artifacts}" var="optionArtifact">
					<acme:input-option code="${optionArtifact.name}" value="${optionArtifact.id}"/>
				</jstl:forEach>
			</acme:input-select>
			<acme:submit code="inventor.quantity.form.button.create" action="/inventor/quantity/create?toolkitId=${toolkitId}"/>			
		</jstl:when>	
		
	</jstl:choose>
	
</acme:form>

