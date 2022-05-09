<%--
- list.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="any.chirp.list.label.title" path="title"/>
	<acme:list-column code="any.chirp.list.label.author" path="author"/>
	<acme:list-column code="any.chirp.list.label.moment" path="moment"/>
	<acme:list-column code="any.chirp.list.label.body" path="body"/>
	<acme:list-column code="any.chirp.list.label.email" path="email"/>
</acme:list>

<acme:button code="any.chirp.list.button.create" action="/any/chirp/create"/>
