

<%@ page import="ie.koala.dontforget.Reminder" %>
<!doctype html>
<html>
<head>
<meta name="layout" content="application">
<g:set var="entityName"
	value="${message(code: 'reminder.label', default: 'Reminder')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
	<div class="container">
		<div class="row">

			<div class="col-lg-3">
				<div class="well">
					<ul class="nav nav-list">
						<li class="nav-header">${entityName}</li>
						<li><g:link class="list" action="list">
								<i class="icon-list"></i>
								<g:message code="default.list.label" args="[entityName]" />
							</g:link></li>
						<li><g:link class="create" action="create">
								<i class="icon-plus"></i>
								<g:message code="default.create.label" args="[entityName]" />
							</g:link></li>
					</ul>
				</div>
			</div>

			<div class="col-lg-9">

				<div class="page-header">
					<h1>
						<g:message code="default.show.label" args="[entityName]" />
					</h1>
				</div>

				<g:if test="${flash.message}">
					<bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
				</g:if>

				<dl>
					
					<g:if test="${reminderInstance?.description}">
						<dt><g:message code="reminder.description.label" default="Description" /></dt>
						
							<dd><g:fieldValue bean="${reminderInstance}" field="description"/></dd>
						
					</g:if>
				
					<g:if test="${reminderInstance?.dateCreated}">
						<dt><g:message code="reminder.dateCreated.label" default="Date Created" /></dt>
						
							<dd><g:formatDate date="${reminderInstance?.dateCreated}" /></dd>
						
					</g:if>
				
					<g:if test="${reminderInstance?.user}">
						<dt><g:message code="reminder.user.label" default="User" /></dt>
						
							<dd><g:link controller="user" action="show" id="${reminderInstance?.user?.id}">${reminderInstance?.user?.encodeAsHTML()}</g:link></dd>
						
					</g:if>
				
				</dl>

				<g:form>
					<g:hiddenField name="id" value="${reminderInstance?.id}" />
					<div class="form-actions">
						<g:link class="btn" action="edit" id="${reminderInstance?.id}">
							<i class="icon-pencil"></i>
							<g:message code="default.button.edit.label" default="Edit" />
						</g:link>
						<button class="btn btn-danger" type="submit" name="_action_delete">
							<i class="icon-trash icon-white"></i>
							<g:message code="default.button.delete.label" default="Delete" />
						</button>
					</div>
				</g:form>

			</div>
		</div>
	</div>
</body>
</html>
