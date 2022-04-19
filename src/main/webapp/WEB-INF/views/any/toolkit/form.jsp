<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readOnly}"> 
	<acme:input-textbox code="any.toolkit.form.label.title" path="title"/>
	<acme:input-textbox code="any.toolkit.form.label.code" path="code"/>
	<acme:input-textarea code="any.toolkit.form.label.description" path="description"/>
	<acme:input-textarea code="any.toolkit.form.label.assemblyNotes" path="assemblyNotes"/>
	<acme:input-textbox code="any.toolkit.form.label.link" path="link"/>
	<acme:input-textbox code="any.toolkit.form.label.price" path="price" placeholder="${price}"/>
	
	<acme:button code="any.toolkit.form.button.artifact" action="/any/artifact/list-toolkit?toolkitId=${id}"/>

</acme:form>