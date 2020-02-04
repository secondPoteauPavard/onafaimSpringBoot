<%@include file="../header.jsp" %>
	
	
	<div class="container" id="content">
		
		<h1>Edition d'un client</h1>
		
		<form:form action="saveCompte" method="post" modelAttribute="compte">
			<form:hidden path="version"/>
			<form:hidden path="id"/>
			
			
			<div class="form-group">
				<form:label path="compteEtat">Etat :</form:label>
				<form:select path="compteEtat" items="${etat}" cssClass="form-control"/>
				<form:errors path="compteEtat"></form:errors>
			</div>
			
			<div class="form-group"> <!-- Le souci vient du format de date -->
				<form:label path="dateCreation">Date de creation :</form:label>
				<form:input path="dateCreation" cssClass="form-control"/>
				<form:errors path="dateCreation"></form:errors>
			</div>
			
			<div class="form-group">
				<form:label path="email">Email :</form:label>
				<form:input path="email" cssClass="form-control"/>
			</div>
			
			<div class="form-group">
				<form:label path="nom">Nom :</form:label>
				<form:input path="nom" cssClass="form-control"/>	
			</div>
			
			<div class="form-group">
				<form:label path="numero">Numero :</form:label>
				<form:input path="numero" cssClass="form-control"/>	
			</div>
			
			<div class="form-group">
				<form:label path="prenom">Prenom :</form:label>
				<form:input path="prenom" cssClass="form-control"/>	
			</div>
			
			<div class="form-group">
				<form:label path="mdp">Mot de passe :</form:label>
				<form:input path="mdp" cssClass="form-control"/>	
			</div>
			


			<div>
				<button type="submit" class="btn btn-success">envoyer</button>
				<a href="${ctx}/page/listClient" class="btn btn-warning">annuler</a>
			</div>
			
		</form:form>
	
	</div>	
	
	<br><br><br><br><br><br><br><br>

		
		
<%@include file="../footer.jsp" %>