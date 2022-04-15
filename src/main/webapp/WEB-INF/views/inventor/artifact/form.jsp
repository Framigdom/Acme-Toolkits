<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readOnly}"> 
	<acme:input-textbox code="inventor.artifact.list.label.name" path="name"/>
	<acme:input-textbox code="inventor.artifact.list.label.code" path="code"/>
	<acme:input-textbox code="inventor.artifact.list.label.technology" path="technology"/>
	<acme:input-textarea code="inventor.artifact.list.label.description" path="description"/>
	<acme:input-money code="inventor.artifact.list.label.retailprice" path="retailPrice"/>
	<acme:input-textbox code="inventor.artifact.list.label.type" path="artifactType"/>
	<acme:input-textbox code="inventor.artifact.list.label.link" path="link"/>
</acme:form>

