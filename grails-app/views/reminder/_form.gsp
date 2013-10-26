<%@ page import="ie.koala.dontforget.Reminder" %>



<div class="fieldcontain ${hasErrors(bean: reminderInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="reminder.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${reminderInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reminderInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="reminder.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${ie.koala.dontforget.User.list()}" optionKey="id" required="" value="${reminderInstance?.user?.id}" class="many-to-one"/>
</div>

