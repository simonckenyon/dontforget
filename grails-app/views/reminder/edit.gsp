<%@ page import="ie.koala.dontforget.Reminder"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="application">
<g:set var="entityName"
	value="${message(code: 'reminder.label', default: 'Reminder')}" />
<title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>
<body>
	<div class="container">
		<div class="row">

			<div class="col-lg-3">
				<div class="well">
					<ul class="nav nav-list">
						<li class="nav-header">
							${entityName}
						</li>
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
						<g:message code="default.edit.label" args="[entityName]" />
					</h1>
				</div>

				<g:if test="${flash.message}">
					<bootstrap:alert class="alert-info">
						${flash.message}
					</bootstrap:alert>
				</g:if>

				<g:hasErrors bean="${reminderInstance}">
					<bootstrap:alert class="alert-error">
						<ul>
							<g:eachError bean="${reminderInstance}" var="error">
								<li
									<g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
										error="${error}" /></li>
							</g:eachError>
						</ul>
					</bootstrap:alert>
				</g:hasErrors>

				<g:form class="form-horizontal" action="edit"
					id="${reminderInstance?.id}">
					<g:hiddenField name="version" value="${reminderInstance?.version}" />
					<f:field bean="reminderInstance" property="description">
						<g:textArea name="description" />
					</f:field>
					<f:field bean="reminderInstance" property="checked" />
					<sec:ifAllGranted roles="ROLE_ADMIN">
						<f:field bean="reminderInstance" property="user" />
					</sec:ifAllGranted>
					<div class="form-actions">
						<button type="submit" class="btn btn-primary">
							<i class="icon-ok icon-white"></i>
							<g:message code="default.button.update.label" default="Update" />
						</button>
						<button type="submit" class="btn btn-danger" name="_action_delete"
							formnovalidate>
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
