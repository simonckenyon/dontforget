<body>
	<sec:ifNotLoggedIn>
		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<div class="container">
				<h1>Please remember, don't forget</h1>
				<p>This is a site where you can record todo list.</p>
				<p>
					<g:link controller="info" action="learn"
						class="btn btn-primary btn-lg">Learn more &raquo;</g:link>
				</p>
			</div>
		</div>

		<div class="container">
			<!-- Example row of columns -->
			<div class="row">
				<div class="col-lg-4">
					<h2>Sign Up</h2>
					<p>Sign up and start using dontforget today!</p>
				</div>
				<div class="col-lg-4">
					<h2>Use it to remember birthdays</h2>
					<p>Now you will never forget your loved ones' important
						momemnts.</p>
				</div>
				<div class="col-lg-4">
					<h2>Use it to record those tasks that are so easy to forget</h2>
					<p>On the way home will you...</p>
					<p>In the hussle and bussle of modern life it is so easy to
						forget requests like these. With dontforget, this will never
						happen again.</p>
				</div>
			</div>
		</div>
	</sec:ifNotLoggedIn>
	<div class="container">
		<div class="row">
			<div class="col-lg-4">
				<div class="page-header">
					<h1>
						<i class="icon-info-sign"></i> Menu
					</h1>
					<div class="padded">
						<p>Some sort of menu.</p>
					</div>
				</div>
			</div>
			<div class="col-lg-8">
				<div class="page-header">
					<h1>
						<i class="icon-info-sign"></i> Todo List
					</h1>
					<div class="padded">
						<p>This is where the todo list goes.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<sec:ifLoggedIn></sec:ifLoggedIn>
</body>
