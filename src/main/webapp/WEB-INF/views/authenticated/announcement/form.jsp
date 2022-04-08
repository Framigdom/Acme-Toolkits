<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for authenticated particular
- purposes.  The copyright owner does not offer authenticated warranties or representations, nor do
- they accept authenticated liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:input-textbox code="authenticated.announcement.form.label.title" path="title"/>	
	<acme:input-moment code="authenticated.announcement.form.label.moment" path="moment"/>	
	<acme:input-textarea code="authenticated.announcement.form.label.body" path="body"/>
	<acme:input-url code="authenticated.announcement.form.label.link" path="link"/>
	<acme:input-textbox code="authenticated.announcement.form.label.critical" path="critical"/>
</acme:form>
