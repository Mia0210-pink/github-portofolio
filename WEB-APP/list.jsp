<%@ include file="../shared/header.jsp" %>
<%@ include file="../shared/nav.jsp" %>
<div class="container">
<table class="table table-striped">
    <tr>
        <th>Autor</th>
        <th>Titlul cărții</th>
        <th>Preț</th>
    </tr>

    <c:forEach items="${requestScope.CĂRȚI}" var="CĂRȚI">
    <tr>
        <td><c:out value="${CĂRȚI.Autor}"/></td>
        <td><c:out value="${CĂRȚI.Titlul cărți}"/></td>
        <td><c:out value="${CĂRȚI.Preț}"/></td>
        <td>
            <a href="<c:out value="${pageContext.request.contextPath}"/>/CĂRȚI?action=edit&CĂRȚI=<c:out value="${CĂRȚI}"/>">
                Edit <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
            </a> |
            <a href="<c:out value="${pageContext.request.contextPath}"/>/CĂRȚI?action=delete&CĂRȚI=<c:out value="${CĂRȚI}"/>">
                Delete <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
            </a>
        </td>
    </tr>
    </c:forEach>
</table>

</div>

<%@ include file="../shared/footer.jsp" %>