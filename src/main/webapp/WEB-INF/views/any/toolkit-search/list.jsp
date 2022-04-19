<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-select code="any.toolkit-search.form.label.select" path="artifact">
		<jstl:forEach items="${allArtifact}" var="name">
			<acme:input-option code="prueba" value="${name}"/>
		</jstl:forEach>
	</acme:input-select>
	<acme:submit code="prueba2" action="/any/toolkit-search/perform"/>
</acme:form>