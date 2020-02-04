<%@include file="../header.jsp" %>


<div class="container">
		<h1>Inscription</h1>
		
		<form:form action="save" method="post" modelAttribute="compte">
			<form:hidden path="version"/>
				<div class="form-group">
					<form:label path="nom">nom:</form:label>
					<form:input path="nom" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="prenom">prenom:</form:label>
					<form:input path="prenom" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="numero">numero de telephone:</form:label>
					<form:input type="number" path="numero" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="email">email:</form:label>
					<form:input type="email" path="email" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="mdp">mot de passe:</form:label>
					<form:input type="password" path="mdp" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">sinscrire</button>
					<a href="${ctx}/accueil" class="btn btn-warning">annuler</a>
				</div>
				
		</form:form>
	</div>	
<%@include file="../footer.jsp" %>
