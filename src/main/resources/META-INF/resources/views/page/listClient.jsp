<%@include file="../header.jsp" %>

	<h1>Admin : Gestion compte client</h1>
	
	
	
	<div class="container">
	
	
		<table class="table">
			<tr>
				<th>id</th>
				<th>Etat</th>
				<th>date de creation</th>
				<th>email</th>
				<th>nom</th>
				<th>numero</th>
				<th>prenom</th>
				<th>mot de passe</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${compte}" var="c">
				<tr>
					<td>${c.id}</td>
					<td>${c.compteEtat}</td>
					<td>${c.dateCreation}</td>
					<td>${c.email}</td>
					<td>${c.nom}</td>
					<td>${c.numero}</td>
					<td>${c.prenom}</td>
					<td>${c.mdp}</td>
					<td><a href="${ctx}/page/editCompte?id=${c.id}" class="btn btn-info">editer</a></td>
					<td><a href="${ctx}/page/listClient/delete?id=${c.id}" class="btn btn-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
	
		<div>
            <a href="${ctx}/page/addCompte" class="btn btn-link">ajout compte</a>
        </div>
		
		
	</div>

<%@include file="../footer.jsp" %>