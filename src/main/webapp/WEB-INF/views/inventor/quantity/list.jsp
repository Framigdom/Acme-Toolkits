<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.quantity.list.label.artifact.name" path="artifact.name" width="50%"/>
	<acme:list-column code="inventor.quantity.list.label.amount" path="amount" width="30%"/>	
	<acme:list-column code="inventor.quantity.list.label.total-price" path="totalPrice" width="20%"/>
</acme:list>

<acme:button  test="${showCreate && publishedArtifacts}" code="inventor.quantity.list.button.create" action="/inventor/quantity/create?toolkitId=${toolkitId}"/>
