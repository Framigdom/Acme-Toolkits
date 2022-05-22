<%--
- menu.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
     		<acme:menu-suboption code="master.menu.anonymous.favourite-link-diego-ruiz" action="https://www.teamcherry.com.au/"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-pablo-marin" action="https://github.com/TheNeoStormZ"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-david-zamora" action="https://theuselessweb.com/"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-josgarboh" action="https://www.spotify.com/es/"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-pablo-alvarez" action="https://es.bandainamcoent.eu/elden-ring/elden-ring"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-framigdom" action="https://mcdonalds.es/"/>
				<acme:menu-separator/>
			<%--any.useraccount --%>
			<acme:menu-suboption code="master.menu.any.useraccount.inventor" action="/any/user-account/list?role=inventor"/>
			<acme:menu-suboption code="master.menu.any.useraccount.patron" action="/any/user-account/list?role=patron"/>
			  <acme:menu-separator/>
			<%--any.chirp--%>
			<acme:menu-suboption code="master.menu.any.chirps.list" action="/any/chirp/list"/> 
			  <acme:menu-separator/>
			<%--any.artifact --%>
			<acme:menu-suboption code="master.menu.any.artifact.components" action="/any/artifact/list-published?type=component"/>
			<acme:menu-suboption code="master.menu.any.artifact.tools" action="/any/artifact/list-published?type=tool"/>
			<acme:menu-suboption code="master.menu.any.toolkits" action="/any/toolkit/list"/>
		</acme:menu-option>
		

		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.announcement.list" action="/authenticated/announcement/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.authenticated.config-data.show" action="/authenticated/config-data/show"/>
			  <acme:menu-separator/>
			<%--any.useraccount --%>
			<acme:menu-suboption code="master.menu.any.useraccount.inventor" action="/any/user-account/list?role=inventor"/>
			<acme:menu-suboption code="master.menu.any.useraccount.patron" action="/any/user-account/list?role=patron"/>
			  <acme:menu-separator/>
			<%--any.chirp--%>
			<acme:menu-suboption code="master.menu.any.chirps.list" action="/any/chirp/list"/> 
			  <acme:menu-separator/>
			<%--any.artifact --%>
			<acme:menu-suboption code="master.menu.any.artifact.components" action="/any/artifact/list-published?type=component"/>
			<acme:menu-suboption code="master.menu.any.artifact.tools" action="/any/artifact/list-published?type=tool"/>
			<acme:menu-suboption code="master.menu.any.toolkits" action="/any/toolkit/list"/>
		</acme:menu-option>
		

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.create-announcement" action="/administrator/announcement/create"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.populate-initial" action="/administrator/populate-initial"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.populate-sample" action="/administrator/populate-sample"/>			
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shut-down" action="/administrator/shut-down"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.dashboard" action="/administrator/administrator-dashboard/show"/>
      <acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.config-data.show" action="/administrator/config-data/show"/>			
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.patron" access="hasRole('Patron')">
			<acme:menu-suboption code="master.menu.patron.patronages" action="/patron/patronage/list"/>
			<acme:menu-suboption code="master.menu.patron.dashboard" action="/patron/patron-dashboard/show"/>
		</acme:menu-option>
  
		<acme:menu-option code="master.menu.inventor" access="hasRole('Inventor')">
		  <acme:menu-suboption code="master.menu.inventor.patronages" action="/inventor/patronage/list"/>
			<acme:menu-separator/>		 	
		 	<acme:menu-suboption code="master.menu.inventor.components-link" action="/inventor/artifact/list-mine?type=component"/>
			<acme:menu-suboption code="master.menu.inventor.tools-link" action="/inventor/artifact/list-mine?type=tool"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.inventor.toolkits-link" action="/inventor/toolkit/list"/>
    </acme:menu-option>
    
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.user-account.become-inventor" action="/authenticated/inventor/create" access="!hasRole('Inventor')"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.user-account.become-patron" action="/authenticated/patron/create" access="!hasRole('Patron')"/>
			<acme:menu-separator/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>

