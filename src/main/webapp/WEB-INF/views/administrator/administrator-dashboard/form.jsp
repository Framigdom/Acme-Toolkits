<%@page language="java" import="org.springframework.data.util.Pair, java.util.Map, java.util.HashMap,
							acme.entities.patronage.Status, java.lang.String, java.util.Collections"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>


<!-- Showing components data -->

<h1><acme:message code="administrator.administrator-dashboard.form.title.component"/></h1>

<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.component"/></caption>
	<tr>
		<th scope="row">
			<acme:message code="administrator.administrator-dashboard.form.title.total-components"/>
		</th>
		<td>
			<jstl:set var="value" value="${totalNumberOfComponents}"/>
			<acme:print value="${value}"/>
		</td>
	</tr>
</table>

<h2><acme:message code="administrator.administrator-dashboard.form.title.average"/></h2>
<jstl:forEach items="${technologiesList}" var="technology">
	<h3><acme:print value = "${technology}"/></h3>
	<table class="table table-sm">
	<caption><acme:message code="administrator.administrator-dashboard.form.title.average"/></caption>
		<jstl:forEach items="${acceptedCurrencies}" var="currency">
			<tr>
				<th scope="row">
					<acme:print value="${currency}"/>
				</th>
				<td>
					<jstl:set var="mapKey" value="${Pair.of(technology,currency)}"/>
					<jstl:set var="value" value="${averageRetailPriceOfComponentsGroupedByTechnologyAndCurrency.getOrDefault(mapKey,0.0)}"/>
					<acme:print value="${value}"/>
				</td>
			</tr>
		</jstl:forEach>
	</table>
</jstl:forEach>

<h2><acme:message code="administrator.administrator-dashboard.form.title.deviation"/></h2>
<jstl:forEach items="${technologiesList}" var="technology">
	<h3><acme:print value = "${technology}"/></h3>
	<table class="table table-sm">
	<caption><acme:message code="administrator.administrator-dashboard.form.title.deviation"/></caption>
		<jstl:forEach items="${acceptedCurrencies}" var="currency">
			<tr>
				<th scope="row">
					<acme:print value="${currency}"/>
				</th>
				<td>
					<jstl:set var="mapKey" value="${Pair.of(technology,currency)}"/>
					<jstl:set var="value" value="${deviationRetailPriceOfComponentsGroupedByTechnologyAndCurrency.getOrDefault(mapKey,0.0)}"/>
					<acme:print value="${value}"/>
				</td>
			</tr>
		</jstl:forEach>
	</table>
</jstl:forEach>

<h2><acme:message code="administrator.administrator-dashboard.form.title.minimum"/></h2>
<jstl:forEach items="${technologiesList}" var="technology">
	<h3><acme:print value = "${technology}"/></h3>
	<table class="table table-sm">
	<caption><acme:message code="administrator.administrator-dashboard.form.title.minimum"/></caption>
		<jstl:forEach items="${acceptedCurrencies}" var="currency">
			<tr>
				<th scope="row">
					<acme:print value="${currency}"/>
				</th>
				<td>
					<jstl:set var="mapKey" value="${Pair.of(technology,currency)}"/>
					<jstl:set var="value" value="${minimumRetailPriceOfComponentsGroupedByTechnologyAndCurrency.getOrDefault(mapKey,0.0)}"/>
					<acme:print value="${value}"/>
				</td>
			</tr>
		</jstl:forEach>
	</table>
</jstl:forEach>

<h2><acme:message code="administrator.administrator-dashboard.form.title.maximum"/></h2>
<jstl:forEach items="${technologiesList}" var="technology">
	<h3><acme:print value = "${technology}"/></h3>
	<table class="table table-sm">
	<caption><acme:message code="administrator.administrator-dashboard.form.title.maximum"/></caption>
		<jstl:forEach items="${acceptedCurrencies}" var="currency">
			<tr>
				<th scope="row">
					<acme:print value="${currency}"/>
				</th>
				<td>
					<jstl:set var="mapKey" value="${Pair.of(technology,currency)}"/>
					<jstl:set var="value" value="${maximumRetailPriceOfComponentsGroupedByTechnologyAndCurrency.getOrDefault(mapKey,0.0)}"/>
					<acme:print value="${value}"/>
				</td>
			</tr>
		</jstl:forEach>
	</table>
</jstl:forEach>

<!-- Showing tools data -->

<h1><acme:message code="administrator.administrator-dashboard.form.title.tool"/></h1>

<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.total-tools"/></caption>
	<tr>
		<th scope="row">
			<acme:message code="administrator.administrator-dashboard.form.title.total-tools"/>
		</th>
		<td>
			<jstl:set var="value" value="${totalNumberOfTools}"/>
			<acme:print value="${value}"/>
		</td>
	</tr>
</table>
<h2><acme:message code="administrator.administrator-dashboard.form.title.average"/></h2>
<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.average"/></caption>
	<jstl:forEach items="${acceptedCurrencies}" var="currency">
		<tr>
			<th scope="row">
				<acme:print value="${currency}"/>
			</th>
			<td>
				<jstl:set var="value" value="${averageRetailPriceOfToolsGroupedByCurrency.getOrDefault(currency,0.0)}"/>
				<acme:print value="${value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h2><acme:message code="administrator.administrator-dashboard.form.title.deviation"/></h2>
<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.deviation"/></caption>
	<jstl:forEach items="${acceptedCurrencies}" var="currency">
		<tr>
			<th scope="row">
				<acme:print value="${currency}"/>
			</th>
			<td>
				<jstl:set var="value" value="${deviationRetailPriceOfToolsGroupedByCurrency.getOrDefault(currency,0.0)}"/>
				<acme:print value="${value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h2><acme:message code="administrator.administrator-dashboard.form.title.minimum"/></h2>
<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.minimum"/></caption>
	<jstl:forEach items="${acceptedCurrencies}" var="currency">
		<tr>
			<th scope="row">
				<acme:print value="${currency}"/>
			</th>
			<td>
				<jstl:set var="value" value="${minimumRetailPriceOfToolsGroupedByCurrency.getOrDefault(currency,0.0)}"/>
				<acme:print value="${value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h2><acme:message code="administrator.administrator-dashboard.form.title.maximum"/></h2>
<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.maximum"/></caption>
	<jstl:forEach items="${acceptedCurrencies}" var="currency">
		<tr>
			<th scope="row">
				<acme:print value="${currency}"/>
			</th>
			<td>
				<jstl:set var="value" value="${maximumRetailPriceOfToolsGroupedByCurrency.getOrDefault(currency,0.0)}"/>
				<acme:print value="${value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<!-- Showing patronages data -->

<h1><acme:message code="administrator.administrator-dashboard.form.title.patronage"/></h1>

<h2><acme:message code="administrator.administrator-dashboard.form.title.total-patronages"/></h2>
<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.total-patronages"/></caption>
	<jstl:forEach items="${statusList}" var="status">
		<tr>
			<th scope="row">
				<acme:print value="${status}"/>
			</th>
			<td>
				<jstl:set var="value" value="${totalNumberOfPatronagesGroupedByStatus.getOrDefault(status,0)}"/>
				<acme:print value="${value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h2><acme:message code="administrator.administrator-dashboard.form.title.average"/></h2>
<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.average"/></caption>
	<jstl:forEach items="${statusList}" var="status">
		<tr>
			<th scope="row">
				<acme:print value="${status}"/>
			</th>
			<td>
				<jstl:set var="value" value="${averageRetailPriceOfToolsGroupedByCurrency.getOrDefault(status,0.0)}"/>
				<acme:print value="${value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h2><acme:message code="administrator.administrator-dashboard.form.title.deviation"/></h2>
<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.deviation"/></caption>
	<jstl:forEach items="${statusList}" var="status">
		<tr>
			<th scope="row">
				<acme:print value="${status}"/>
			</th>
			<td>
				<jstl:set var="value" value="${deviationRetailPriceOfToolsGroupedByCurrency.getOrDefault(status,0.0)}"/>
				<acme:print value="${value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h2><acme:message code="administrator.administrator-dashboard.form.title.minimum"/></h2>
<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.minimum"/></caption>
	<jstl:forEach items="${statusList}" var="status">
		<tr>
			<th scope="row">
				<acme:print value="${status}"/>
			</th>
			<td>
				<jstl:set var="value" value="${minimumRetailPriceOfToolsGroupedByCurrency.getOrDefault(status,0.0)}"/>
				<acme:print value="${value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h2><acme:message code="administrator.administrator-dashboard.form.title.maximum"/></h2>
<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.maximum"/></caption>
	<jstl:forEach items="${statusList}" var="status">
		<tr>
			<th scope="row">
				<acme:print value="${status}"/>
			</th>
			<td>
				<jstl:set var="value" value="${maximumRetailPriceOfToolsGroupedByCurrency.getOrDefault(status,0.0)}"/>
				<acme:print value="${value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<!-- Showing CHIMPUMs data -->

<h1><acme:message code="administrator.administrator-dashboard.form.title.CHIMPUM"/></h1>

<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.total-CHIMPUMs"/></caption>
	<tr>
		<th scope="row">
			<acme:message code="administrator.administrator-dashboard.form.title.total-CHIMPUMs"/>
		</th>
		<td>
			<jstl:set var="value" value="${ratioOfARTIFACTSWithCHIMPUMP}"/>
			<acme:print value="${value}"/>
		</td>
	</tr>
</table>
<h2><acme:message code="administrator.administrator-dashboard.form.title.average"/></h2>
<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.average"/></caption>
	<jstl:forEach items="${acceptedCurrencies}" var="currency">
		<tr>
			<th scope="row">
				<acme:print value="${currency}"/>
			</th>
			<td>
				<jstl:set var="value" value="${averageBudgetOfCHIMPUMPSGroupedByCurrency.getOrDefault(currency,0.0)}"/>
				<acme:print value="${value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h2><acme:message code="administrator.administrator-dashboard.form.title.deviation"/></h2>
<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.deviation"/></caption>
	<jstl:forEach items="${acceptedCurrencies}" var="currency">
		<tr>
			<th scope="row">
				<acme:print value="${currency}"/>
			</th>
			<td>
				<jstl:set var="value" value="${deviationBudgetOfCHIMPUMPSGroupedByCurrency.getOrDefault(currency,0.0)}"/>
				<acme:print value="${value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h2><acme:message code="administrator.administrator-dashboard.form.title.minimum"/></h2>
<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.minimum"/></caption>
	<jstl:forEach items="${acceptedCurrencies}" var="currency">
		<tr>
			<th scope="row">
				<acme:print value="${currency}"/>
			</th>
			<td>
				<jstl:set var="value" value="${minimumBudgetOfCHIMPUMPSGroupedByCurrency.getOrDefault(currency,0.0)}"/>
				<acme:print value="${value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h2><acme:message code="administrator.administrator-dashboard.form.title.maximum"/></h2>
<table class="table table-sm">
<caption><acme:message code="administrator.administrator-dashboard.form.title.maximum"/></caption>
	<jstl:forEach items="${acceptedCurrencies}" var="currency">
		<tr>
			<th scope="row">
				<acme:print value="${currency}"/>
			</th>
			<td>
				<jstl:set var="value" value="${maximumBudgetOfCHIMPUMPSGroupedByCurrency.getOrDefault(currency,0.0)}"/>
				<acme:print value="${value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>


<acme:return/>