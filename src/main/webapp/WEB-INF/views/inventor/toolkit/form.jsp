<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readOnly}"> 
	<acme:input-textbox code="inventor.toolkit.form.label.title" path="title"/>
	<acme:input-textbox code="inventor.toolkit.form.label.code" path="code"/>
	<acme:input-textarea code="inventor.toolkit.form.label.description" path="description"/>
	<acme:input-textarea code="inventor.toolkit.form.label.assemblyNotes" path="assemblyNotes"/>
	<acme:input-textbox code="inventor.toolkit.form.label.link" path="link"/>
	
	<jstl:choose>
	
		<jstl:when test="${published == false && acme:anyOf(command, 'show,update,delete,publish')}">
		<acme:input-textbox code="inventor.toolkit.form.label.price" path="price" placeholder="${price}"/>
		<acme:button code="inventor.toolkit.form.button.artifact" action="/inventor/artifact/list?toolkitId=${id}"/>
		<acme:submit code="inventor.toolkit.form.button.update" action="/inventor/toolkit/update"/>
		<acme:submit code="inventor.toolkit.form.button.delete" action="/inventor/toolkit/delete"/>
		<acme:submit code="inventor.toolkit.form.button.publish" action="/inventor/toolkit/publish"/>
		
		</jstl:when>
		<jstl:when test="${published == true}">
		<acme:input-textbox code="inventor.toolkit.form.label.price" path="price" placeholder="${price}"/>
		<acme:button code="inventor.toolkit.form.button.artifact" action="/inventor/artifact/list?toolkitId=${id}"/>
		</jstl:when>
		
		<jstl:when test="${command == 'create'}">
		<jstl:set var = "artifactIndex" value = "1"/>
		<jstl:set var = "amountIndex" value = "101"/>
		<jstl:forEach items="${artifacts}" var="optionArtifact">
			<acme:input-select code="inventor.toolkit.form.label.select.artifacts" path="${artifactIndex}">
			<acme:input-option code=" - " value="none"/>	
			<jstl:forEach items="${artifacts}" var="optionArtifact">
				<acme:input-option code="${optionArtifact.name}" value="${optionArtifact.name}"/>			
			</jstl:forEach>
			</acme:input-select>
			<acme:input-textbox code="inventor.toolkit.form.label.artifact.amount" path="${amountIndex}" placeholder="0"/>
			<jstl:set var = "artifactIndex" value = "${artifactIndex + 1}"/>
			<jstl:set var = "amountIndex" value = "${amountIndex + 1}"/>
		</jstl:forEach>
		<acme:submit code="inventor.toolkit.form.button.create" action="/inventor/toolkit/create"/>		
		</jstl:when>	
		
	</jstl:choose>
</acme:form>

