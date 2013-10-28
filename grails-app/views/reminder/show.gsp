<%@ page import="ie.koala.dontforget.Reminder"%>
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
						<g:message code="default.show.label" args="[entityName]" />
					</h1>
				</div>

				<g:if test="${flash.message}">
					<bootstrap:alert class="alert-info">
						${flash.message}
					</bootstrap:alert>
				</g:if>

				<g:form class="form-horizontal" role="form">
					<g:if test="${reminderInstance?.description}">
						<div class="form-group">
							<label class="col-lg-2 control-label"><g:message
									code="reminder.description.label" default="Description" /></label>
							<div class="col-lg-10">
								<p class="form-control-static">
									<g:fieldValue bean="${reminderInstance}" field="description" />
								</p>
							</div>
						</div>
					</g:if>
					<g:if test="${reminderInstance?.dateCreated}">
						<div class="form-group">
							<label class="col-lg-2 control-label"><g:message
									code="reminder.dateCreated.label" default="Date Created" /></label>
							<div class="col-lg-10">
								<p class="form-control-static">
									<g:formatDate date="${reminderInstance?.dateCreated}" />
								</p>
							</div>
						</div>
					</g:if>
						<div class="form-group">
							<label class="col-lg-2 control-label"><g:message
									code="reminder.checked.label" default="Checked" /></label>
							<div class="col-lg-10">
								<p class="form-control-static">
									<g:formatBoolean boolean="${reminderInstance?.checked}" />
								</p>
							</div>
						</div>
					<sec:ifAllGranted roles="ROLE_ADMIN">
						<g:if test="${reminderInstance?.user}">
							<div class="form-group">
								<label class="col-lg-2 control-label"><g:message
										code="reminder.user.label" default="User" /></label>
								<div class="col-lg-10">
									<p class="form-control-static">
										${reminderInstance?.user?.encodeAsHTML()}
									</p>
								</div>
							</div>
						</g:if>
					</sec:ifAllGranted>
					<g:hiddenField name="id" value="${reminderInstance?.id}" />
					<div class="form-actions">
						<g:link class="btn btn-primary" action="edit" id="${reminderInstance?.id}">
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
