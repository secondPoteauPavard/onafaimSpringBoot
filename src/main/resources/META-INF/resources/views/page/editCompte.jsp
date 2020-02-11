<%@include file="../header.jsp" %>
	
	
	<div class="container" id="content">
		
		<h1>Edition d'un client</h1>
		
		<form:form action="update" method="post" modelAttribute="compte">
			<form:hidden path="version"/>
			<form:hidden path="id"/>
			
			<div class="form-group">
				<form:label path="email">Email :</form:label>
				<form:input path="email" cssClass="form-control"/>
			</div>
			
			<div class="form-group">
				<form:label path="nom">Nom :</form:label>
				<form:input path="nom" cssClass="form-control"/>	
			</div>
			
			<div class="form-group">
				<form:label path="prenom">Prenom :</form:label>
				<form:input path="prenom" cssClass="form-control"/>	
			</div>
			
			<div class="form-group">
				<form:label path="password">Mot de passe :</form:label>
				<form:input path="password" cssClass="form-control"/>	
			</div>
			


			<div>
				<button type="submit" class="btn btn-success">envoyer</button>
				<a href="${ctx}/page/listClient" class="btn btn-warning">annuler</a>
			</div>
			
		</form:form>
	
	</div>	
	
	<br><br><br><br><br><br><br><br>

		
		
<%@include file="../footer.jsp" %>