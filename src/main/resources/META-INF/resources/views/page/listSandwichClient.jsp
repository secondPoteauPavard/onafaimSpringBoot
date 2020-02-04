<%@include file="../header.jsp" %>

<div id="content" class="col-12">
		<h2>Liste des sandwichs</h2>
			<div class="row">
				<c:forEach items="${sandwichs}" var="s">
					<div class="crew col-3">
						<div>${s.libelle}</div>
						<div>${s.photo}</div>
						<div>${s.description}</div>
						<table>
							<tr>
								<td>${s.taille}</td>
								<td>${s.prix}</td>
								<td><a href="" class="btn btn-success">+</a></td>
							</tr>
						</table>
					</div>
				</c:forEach>
			</div>
</div>	

<%@include file="../footer.jsp" %>
