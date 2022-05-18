<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.artifact.list.label.name" path="name" width="20%"/>
	<acme:list-column code="inventor.artifact.list.label.retailprice" path="retailPrice" width="30%"/>
	<acme:list-column code="inventor.artifact.list.label.type" path="artifactType" width="50%"/>
	<acme:list-column code="inventor.artifact.list.label.published" path="published"/>
</acme:list>

<jstl:if test="${command == 'list-mine'}">
	<acme:button code="inventor.artifact.list.button.create" action="/inventor/artifact/create?type=${type}"/>
</jstl:if>