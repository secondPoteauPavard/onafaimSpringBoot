<%@include file="../header.jsp" %>

<div id="content" class="col-12">
		<h2>Liste des gateaux</h2>
			<div class="row">
				<c:forEach items="${gateaux}" var="g">
					<div class="crew col-3">
						<div>${g.libelle}</div>
						<div>${g.photo}</div>
						<div>${g.description}</div>
						<table>
							<tr>
								<td>${g.taille}</td>
								<td>${g.prix}</td>
								<td><a href="" class="btn btn-success">+</a></td>
							</tr>
						</table>
					</div>
				</c:forEach>
			</div>
</div>	

<%@include file="../footer.jsp" %>
