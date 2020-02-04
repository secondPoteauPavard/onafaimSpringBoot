<%@include file="../header.jsp" %>
	
	<div class="container" id="content">
		
		<h1>Edition d'un sandwich</h1>
		
	<form:form action="save" method="post" modelAttribute="produit">
			<form:hidden path="version"/>
			<form:hidden path="id"/>
			
			<div class="form-group">
				<form:label path="libelle">Libelle :</form:label>
				<form:input path="libelle" cssClass="form-control"/>
				<form:errors path="libelle" cssClass="alert alert-danger" element="div"></form:errors>	
			</div>
			
			<div class="form-group">
				<form:label path="type">Type :</form:label>
				<form:select path="type" items="${type}" cssClass="form-control"/>
			</div>
			
			<div class="form-group">
				<form:label path="taille">Taille :</form:label>
				<form:select path="taille" items="${taille}" cssClass="form-control"/>
			</div>
			
			<div class="form-group">
				<form:label path="prix">Prix :</form:label>
				<form:input path="prix" cssClass="form-control"/>
			</div>
			
			<div class="form-group">
				<form:label path="description">Description :</form:label>
				<form:input path="description" cssClass="form-control"/>
			</div>
			
			
<!-- 			<div class="form-group"> -->
<%-- 				<form:label path="photo">Photo :</form:label> --%>
<%-- 				<form:input path="photo" cssClass="form-control"/>	 --%>
<!-- 			</div> -->

			<div>
				<button type="submit" class="btn btn-success">envoyer</button>
				<a href="${ctx}${chemin}" class="btn btn-warning">annuler</a>
			</div>
			
		</form:form>
	
	</div>	
	<br><br><br><br><br><br><br><br><br>
	
		
		
<%@include file="../footer.jsp" %>