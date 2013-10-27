<%@ page import="ie.koala.dontforget.User" %>
<div class="form-group ">
	<label class="col-lg-2 control-label" for="user"> <g:message
			code="reminder.user.label" default="User" /></label>
	<div class="col-lg-10">
		<g:select name="user.id" from="${User.list()}" value="${bean?.id}"
			optionKey="id" />
	</div>
</div>
