<div class="form-group">
	<label class="col-lg-2 control-label" for="checked"> <g:message
			code="reminder.checked.label" default="Checked" /></label>
	<div class="col-lg-10">
		<g:field type="hidden" name="_checked" />
		<g:checkBox class="form-control" name="checked" id="checked"
			value="${bean?.checked}" />
	</div>
</div>
