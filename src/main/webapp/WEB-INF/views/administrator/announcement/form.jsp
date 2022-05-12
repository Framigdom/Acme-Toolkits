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

<acme:form>
	<acme:input-textbox code="administrator.announcement.form.label.title" path="title"/>	
	<acme:input-textarea code="administrator.announcement.form.label.body" path="body"/>
	<acme:input-url code="administrator.announcement.form.label.link" path="link"/>
	<acme:input-textbox code="administrator.announcement.form.label.critical" path="critical"/>
	
	<acme:input-checkbox code="administrator.announcement.form.label.confirm" path="confirm"/>
	<acme:submit code="administrator.announcement.form.button.create" action="/administrator/announcement/create"/>
</acme:form>
