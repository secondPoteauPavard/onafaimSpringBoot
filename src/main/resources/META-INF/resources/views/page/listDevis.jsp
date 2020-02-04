<%@include file="../header.jsp" %>

	<h1>Admin : Gestion Devis</h1>
	
	
	
	<div class="container">
	
	
		<table class="table">
			<tr>
				<th>id</th>
				<th>Evaluation</th>
				<th>date de commande</th>
				<th>description</th>
				<th>état</th>
				<th>prix</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${devis}" var="d">
				<tr>
					<td>${d.id}</td>
					<td>${d.dEval}</td>
					<td>${d.date}</td>
					<td>${d.description}</td>
					<td>${d.etat}</td>
					<td>${d.prix}</td>
					<td><a href="${ctx}/page/editProduit/edit?id=${p.id}" class="btn btn-info">editer</a></td>
					<td><a href="${ctx}/page/listViennoiserie/delete?id=${p.id}" class="btn btn-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
	
		<div>
            <a href="${ctx}/page/addProduit" class="btn btn-link">ajout produit</a>
        </div>
		
		
	</div>

<%@include file="../footer.jsp" %>