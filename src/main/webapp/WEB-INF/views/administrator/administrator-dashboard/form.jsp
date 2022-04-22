<%@page language="java" import="org.springframework.data.util.Pair, java.util.Map, java.util.HashMap,
							acme.entities.patronage.Status, java.lang.String, java.util.Collections"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<h1><acme:message code="administrator.administrator-dashboard.form.title.general-indicators"/></h1>

<h2><acme:message code="administrator.administrator-dashboard.form.title.average"/></h2>
<jstl:forEach items="${statusList}" var="status">
	<h3><acme:message code="administrator.administrator-dashboard.form.title.${status.toString().toLowerCase()}"/></h3>
	<table class="table table-sm">
		<jstl:forEach items="${acceptedCurrencies}" var="currency">
			<tr>
				<th scope="row">
					<acme:print value="${currency}"/>
				</th>
				
				<jstl:forEach items="${technologiesList}" var="technology">
					<th scope="row">
						<acme:print value = "${technology}"/>
					</th>
						<td>
						<jstl:set var="mapKey" value="${Pair.of(technology,currency)}"/>
						<jstl:set var="value" value="${averageRetailPriceOfComponentsGroupedByTechnologyAndCurrency.getOrDefault(mapKey,0.0)}"/>
						<acme:print value="${value}"/>
						
						<jstl:set var="mapKey2" value="${currency}"/>
						<jstl:set var="value2" value="${averageRetailPriceOfToolsGroupedByCurrency.getOrDefault(mapKey,0.0)}"/>
						<acme:print value="${value2}"/>
						
						<jstl:set var="mapKey3" value="${status)}"/>
						<jstl:set var="value3" value="${averageBudgetOfsGroupedByStatus.getOrDefault(mapKey,0.0)}"/>
						<acme:print value="${value3}"/>
					</td>
				</jstl:forEach>
				
			</tr>
		</jstl:forEach>
	</table>
</jstl:forEach>

<h2><acme:message code="administrator.administrator-dashboard.form.title.deviation"/></h2>
<jstl:forEach items="${statusList}" var="status">
	<h3><acme:message code="administrator.administrator-dashboard.form.title.${status.toString().toLowerCase()}"/></h3>
	<table class="table table-sm">
		<jstl:forEach items="${acceptedCurrencies}" var="currency">
			<tr>
				<th scope="row">
					<acme:print value="${currency}"/>
				</th>
				
				<jstl:forEach items="${technologiesList}" var="technology">
					<th scope="row">
						<acme:print value = "${technology}"/>
					</th>
				
					<td>
						<jstl:set var="mapKey" value="${Pair.of(technology,currency)}"/>
						<jstl:set var="value" value="${deviationRetailPriceOfComponentsGroupedByTechnologyAndCurrency.getOrDefault(mapKey,0.0)}"/>
						<acme:print value="${value}"/>
						
						<jstl:set var="mapKey2" value="${currency}"/>
						<jstl:set var="value2" value="${deviationRetailPriceOfToolsGroupedByCurrency.getOrDefault(mapKey,0.0)}"/>
						<acme:print value="${value2}"/>
						
						<jstl:set var="mapKey3" value="${status)}"/>
						<jstl:set var="value3" value="${deviationBudgetOfPatronagesGroupedByStatus.getOrDefault(mapKey,0.0)}"/>
						<acme:print value="${value3}"/>
					</td>
				</jstl:forEach>
			</tr>
		</jstl:forEach>
	</table>
</jstl:forEach>

<h2><acme:message code="administrator.administrator-dashboard.form.title.minimum"/></h2>
<jstl:forEach items="${statusList}" var="status">
	<h3><acme:message code="administrator.administrator-dashboard.form.title.${status.toString().toLowerCase()}"/></h3>
	<table class="table table-sm">
		<jstl:forEach items="${acceptedCurrencies}" var="currency">
			<tr>
				<th scope="row">
					<acme:print value="${currency}"/>
				</th>
				
				<jstl:forEach items="${technologiesList}" var="technology">
					<th scope="row">
						<acme:print value = "${technology}"/>
					</th>
					<td>
						<jstl:set var="mapKey" value="${Pair.of(technology,currency)}"/>
						<jstl:set var="value" value="${minimunRetailPriceOfComponentsGroupedByTechnologyAndCurrency.getOrDefault(mapKey,0.0)}"/>
						<acme:print value="${value}"/>
						
						<jstl:set var="mapKey2" value="${currency}"/>
						<jstl:set var="value2" value="${minimunRetailPriceOfToolsGroupedByCurrency.getOrDefault(mapKey,0.0)}"/>
						<acme:print value="${value2}"/>
						
						<jstl:set var="mapKey3" value="${status)}"/>
						<jstl:set var="value3" value="${minimunBudgetOfPatronagesGroupedByStatus.getOrDefault(mapKey,0.0)}"/>
						<acme:print value="${value3}"/>
					</td>
				</jstl:forEach>
			</tr>
		</jstl:forEach>
	</table>
</jstl:forEach>

<h2><acme:message code="administrator.administrator-dashboard.form.title.maximum"/></h2>
<jstl:forEach items="${statusList}" var="status">
	<h3><acme:message code="administrator.administrator-dashboard.form.title.${status.toString().toLowerCase()}"/></h3>
	<table class="table table-sm">
		<jstl:forEach items="${acceptedCurrencies}" var="currency">
			<tr>
				<th scope="row">
					<acme:print value="${currency}"/>
				</th>
				
				<jstl:forEach items="${technologiesList}" var="technology">
					<th scope="row">
						<acme:print value = "${technology}"/>
					</th>
					
					<td>
						<jstl:set var="mapKey" value="${Pair.of(technology,currency)}"/>
						<jstl:set var="value" value="${maximumRetailPriceOfComponentsGroupedByTechnologyAndCurrency.getOrDefault(mapKey,0.0)}"/>
						<acme:print value="${value}"/>
						
						<jstl:set var="mapKey2" value="${currency}"/>
						<jstl:set var="value2" value="${maximumRetailPriceOfToolsGroupedByCurrency.getOrDefault(mapKey,0.0)}"/>
						<acme:print value="${value2}"/>
						
						<jstl:set var="mapKey3" value="${status)}"/>
						<jstl:set var="value3" value="${maximumBudgetOfPatronagesGroupedByStatus.getOrDefault(mapKey,0.0)}"/>
						<acme:print value="${value3}"/>
					</td>
				</jstl:forEach>
			</tr>
		</jstl:forEach>
	</table>
</jstl:forEach>

<div>
	<canvas id="canvas"></canvas>
</div>


<acme:return/>