<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.config-data.list.label.systemCurrency" path="systemCurrency"/>
	<acme:list-column code="authenticated.config-data.list.label.acceptedCurrencies" path="acceptedCurrencies"/>
</acme:list>


