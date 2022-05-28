<%@ page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.CHIMPUM.list.label.pattern" path="pattern"/>
	<acme:list-column code="inventor.CHIMPUM.list.label.title" path="title"/>
	<acme:list-column code="inventor.CHIMPUM.list.label.description" path="description"/>
	<acme:list-column code="inventor.CHIMPUM.list.label.startDate" path="startDate"/>
	<acme:list-column code="inventor.CHIMPUM.list.label.finishDate" path="finishDate"/>
	<acme:list-column code="inventor.CHIMPUM.list.label.budget" path="budget"/>
	<acme:list-column code="inventor.CHIMPUM.list.label.link" path="link"/>
</acme:list>

<acme:button  code="inventor.CHIMPUM.list.button.create" action="/inventor/chimpum/create"/>