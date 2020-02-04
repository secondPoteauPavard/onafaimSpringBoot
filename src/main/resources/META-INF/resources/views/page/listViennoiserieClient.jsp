<%@include file="../header.jsp" %>

<div id="content" class="col-12">
		<h2>Liste des viennoiseries</h2>
			<div class="row">
				<c:forEach items="${viennoiseries}" var="v">
					<div class="crew col-3">
						<div>${v.libelle}</div>
						<div>${v.photo}</div>
						<div>${v.description}</div>
						<table>
							<tr>
								<td>${v.taille}</td>
								<td>${v.prix}</td>
								<td><a href="" class="btn btn-success">+</a></td>
							</tr>
						</table>
					</div>
				</c:forEach>
			</div>
			
</div>	

<%@include file="../footer.jsp" %>
