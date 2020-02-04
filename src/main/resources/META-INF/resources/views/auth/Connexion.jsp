<%@include file="../header.jsp" %>


<div id="content" class="row">
	<div class="col-12">
		<h1 style:"text-align:center">Connexion</h1>
		<div id="menuConnect">
		<c:if test="${param.error != null}">
			<div class="alert alert-danger">erreur d'authentification</div>
		</c:if>
			<form method="post" action="" class="px-4 py-3">
			<input type="hidden" name="${_csrf.parameterName}" value ="${_csrf.token}"/>	
				<div class="form-group">
					<label for="name">Nom:</label>
					<input id="name" class="form-control" placeholder="Saisir votre nom">
				</div>
				<div class="form-group">
					<label for="password">Password:</label>
					<input type="password" class="form-control" placeholder="Saisir votre mot de passe">
				</div>
				<div class="form-check">
					<input type="checkbox" class="form-check-input" id="dropdownCheck">
					<label class="form-check-label" for="dropdownCheck">Remember me</label>
				</div>
				<button id="btnSubmit" type="submit" class="btn btn-secondary">Connexion</button>
				<a href="${ctx}" class="btn btn-link">annuler</a>
			</form>
		<div class="dropdown-divider"></div>
			<a class="dropdown-item" href="#">Forgot password?</a>
		</div>
	</div>
</div>

	
<script>
menuConnect.style.display="block";
menuConnect.style.margin="auto";
menuConnect.style.maxWidth="30%";
</script>


<%@include file="../footer.jsp" %>