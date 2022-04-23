<%@page language="java" import="org.springframework.data.util.Pair, java.util.Map, java.util.HashMap,
							acme.entities.patronage.Status, java.lang.String, java.util.Collections"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<h1><acme:message code="patron.patron-dashboard.form.title.general-indicators"/></h1>

<h2><acme:message code="patron.patron-dashboard.form.title.average"/></h2>
<jstl:forEach items="${statusList}" var="status">
	<h3><acme:message code="patron.patron-dashboard.form.title.${status.toString().toLowerCase()}"/></h3>
	<table class="table table-sm">
	<caption><acme:message code="patron.patron-dashboard.form.title.average"/></caption>
		<jstl:forEach items="${acceptedCurrencies}" var="currency">
			<tr>
				<th scope="row">
					<acme:print value="${currency}"/>
				</th>
				<td>
					<jstl:set var="mapKey" value="${Pair.of(status,currency)}"/>
					<jstl:set var="value" value="${averageBudgetOfPatronagesGroupedByStatusAndCurrency.getOrDefault(mapKey,0.0)}"/>
					<acme:print value="${value}"/>
				</td>
			</tr>
		</jstl:forEach>
	</table>
</jstl:forEach>

<h2><acme:message code="patron.patron-dashboard.form.title.deviation"/></h2>
<jstl:forEach items="${statusList}" var="status">
	<h3><acme:message code="patron.patron-dashboard.form.title.${status.toString().toLowerCase()}"/></h3>
	<table class="table table-sm">
	<caption><acme:message code="patron.patron-dashboard.form.title.deviation"/></caption>
		<jstl:forEach items="${acceptedCurrencies}" var="currency">
			<tr>
				<th scope="row">
					<acme:print value="${currency}"/>
				</th>
				<td>
					<jstl:set var="mapKey" value="${Pair.of(status,currency)}"/>
					<jstl:set var="value" value="${deviationBudgetOfPatronagesGroupedByStatusAndCurrency.getOrDefault(mapKey,0.0)}"/>
					<acme:print value="${value}"/>
				</td>
			</tr>
		</jstl:forEach>
	</table>
</jstl:forEach>

<h2><acme:message code="patron.patron-dashboard.form.title.minimum"/></h2>
<jstl:forEach items="${statusList}" var="status">
	<h3><acme:message code="patron.patron-dashboard.form.title.${status.toString().toLowerCase()}"/></h3>
	<table class="table table-sm">
	<caption><acme:message code="patron.patron-dashboard.form.title.minimum"/></caption>
		<jstl:forEach items="${acceptedCurrencies}" var="currency">
			<tr>
				<th scope="row">
					<acme:print value="${currency}"/>
				</th>
				<td>
					<jstl:set var="mapKey" value="${Pair.of(status,currency)}"/>
					<jstl:set var="value" value="${minimunBudgetOfPatronagesGroupedByStatusAndCurrency.getOrDefault(mapKey,0.0)}"/>
					<acme:print value="${value}"/>
				</td>
			</tr>
		</jstl:forEach>
	</table>
</jstl:forEach>

<h2><acme:message code="patron.patron-dashboard.form.title.maximum"/></h2>
<jstl:forEach items="${statusList}" var="status">
	<h3><acme:message code="patron.patron-dashboard.form.title.${status.toString().toLowerCase()}"/></h3>
	<table class="table table-sm">
	<caption><acme:message code="patron.patron-dashboard.form.title.maximum"/></caption>
		<jstl:forEach items="${acceptedCurrencies}" var="currency">
			<tr>
				<th scope="row">
					<acme:print value="${currency}"/>
				</th>
				<td>
					<jstl:set var="mapKey" value="${Pair.of(status,currency)}"/>
					<jstl:set var="value" value="${maximunBudgetOfPatronagesGroupedByStatusAndCurrency.getOrDefault(mapKey,0.0)}"/>
					<acme:print value="${value}"/>
				</td>
			</tr>
		</jstl:forEach>
	</table>
</jstl:forEach>

<h1><acme:message code="patron.patron-dashboard.form.title.patronages-total-number-status"/></h1>

<div>
	<canvas id="canvas"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		var data = {
			labels : [
					"PROPOSED", "ACCEPTED", "DENIED"
			],
			datasets : [
				{
					data : [
						<jstl:out value="${totalNumberofProposedPatronages}"/>, 
						<jstl:out value="${totalNumberofAcceptedPatronages}"/>, 
						<jstl:out value="${totalNumberofDeniedPatronages}"/>
					]
				}
			]
		};
		var options = {
			scales : {
				yAxes : [
					{
						ticks : {
							suggestedMin : 0.0
						}
					}
				]
			},
			legend : {
				display : false
			}
		};
	
		var canvas, context;
	
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "bar",
			data : data,
			options : options
		});
	});
</script>

<acme:return/>