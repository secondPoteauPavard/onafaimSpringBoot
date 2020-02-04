<%@include file="../header.jsp" %>

<div id="content" class="col-12">
		<h2>Liste des boissons</h2>
			<div class="row">
				<c:forEach items="${boissons}" var="b">
					<div class="crew col-3">
						<div>${b.libelle}</div>
						<div>${b.photo}</div>
						<div>${b.description}</div>
						<table>
							<tr>
								<td>${b.taille}</td>
								<td>${b.prix}</td>
								<td><a href="" class="btn btn-success">+</a></td>
							</tr>
						</table>
					</div>
				</c:forEach>
			</div>
</div>	

<%@include file="../footer.jsp" %>
