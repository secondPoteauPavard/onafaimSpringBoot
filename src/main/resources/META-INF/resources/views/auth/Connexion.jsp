<%@include file="../header.jsp" %>


<div id="content" class="row">
	<div class="col-12">
		<h1 style:"text-align:center">Connexion</h1>
		<div id="menuConnect">
			<form class="px-4 py-3">
				<div class="form-group">
					<label for="exampleDropdownFormEmail1">Nom</label>
					<input type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="Saisir votre nom">
				</div>
				<div class="form-group">
					<label for="exampleDropdownFormPassword1">Password</label>
					<input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Saisir votre password">
				</div>
				<div class="form-check">
					<input type="checkbox" class="form-check-input" id="dropdownCheck">
					<label class="form-check-label" for="dropdownCheck">Remember me</label>
				</div>
				<button id="btnSubmit" type="submit" class="btn btn-secondary">Connexion</button>
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