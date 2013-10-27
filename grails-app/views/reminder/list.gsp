<%@ page import="ie.koala.dontforget.Reminder"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="application">
<g:set var="entityName" value="${message(code: 'reminder.label', default: 'Reminder')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
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
						<li class="active"><g:link class="list" action="list">
								<i class="icon-list icon-white"></i>
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
						<g:message code="default.list.label" args="[entityName]" />
					</h1>
				</div>
				<g:if test="${flash.message}">
					<bootstrap:alert class="alert-info">
						${flash.message}
					</bootstrap:alert>
				</g:if>
				<table class="table table-striped">
					<thead>
						<tr>
							<g:sortableColumn property="description"
								title="${message(code: 'reminder.description.label', default: 'Description')}" />
							<g:sortableColumn property="dateCreated"
								title="${message(code: 'reminder.dateCreated.label', default: 'Date Created')}" />
							<th class="header"><g:message code="reminder.checked.label"
									default="Checked" /></th>
							<sec:ifAllGranted roles="ROLE_ADMIN">
								<g:sortableColumn property="user"
									title="${message(code: 'reminder.user.label', default: 'User')}" />
							</sec:ifAllGranted>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<g:each in="${reminderInstanceList}" var="reminderInstance">
							<tr>
								<td>
									${fieldValue(bean: reminderInstance, field: "description")}
								</td>
								<td><g:formatDate date="${reminderInstance.dateCreated}" /></td>
								<td><g:formatBoolean boolean="${reminderInstance.checked}" /></td>
								<sec:ifAllGranted roles="ROLE_ADMIN">
									<td>
										${fieldValue(bean: reminderInstance, field: "user")}
									</td>
								</sec:ifAllGranted>
								<td class="link"><g:link action="show"
										id="${reminderInstance.id}" class="btn btn-primary">Show &raquo;</g:link>
								</td>
							</tr>
						</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<bootstrap:paginate total="${reminderInstanceTotal}" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>
