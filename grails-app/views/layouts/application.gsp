<%@ page
	import="org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title><g:layoutTitle default="${meta(name: 'app.name')}" /></title>
<meta name="description"
	content="Please remember, don't forget. A website for to-do lists.">
<meta name="author" content="The Koala Computer Company Limited">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<r:require modules="application" />
<g:layoutHead />
<r:layoutResources />
</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${createLink(uri: '/')}">${meta(name: 'app.name')}</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${createLink(uri: '/')}">Home</a></li>
					<li><g:link controller="info" action="about">About</g:link></li>
					<li><g:link controller="info" action="contact">Contact</g:link></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Dropdown <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<sec:ifNotLoggedIn>
				<g:form uri="/j_spring_security_check" class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" placeholder="Username" class="form-control" name='j_username' id='username'/>
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control" name='j_password' id='password'/>
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</g:form>
				</sec:ifNotLoggedIn>
				<sec:ifLoggedIn>
				<g:form uri="/j_spring_security_logout" class="navbar-form navbar-right">
					<p class="navbar-text">Signed in as <sec:username /></p>
					<button type="submit" class="btn btn-success">Sign out</button>
				</g:form>
				</sec:ifLoggedIn>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>
	<g:layoutBody />
	<div class="container">
		<div class="row">
			<hr>
			<footer>
				<p>Copyright &copy; 2013 The Koala Computer Company Limited</p>
			</footer>
		</div>
	</div>
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-44752619-3' ]);
		_gaq.push([ '_trackPageview' ]);
		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl'
					: 'http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
	<r:layoutResources />
</body>
</html>