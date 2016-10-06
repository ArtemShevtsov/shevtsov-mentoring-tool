<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h2>Please, find below all Mentorship Programs:</h2>
<a href="/mentorship-programs/new">Add New Mentorship Program</a>
<hr>
<c:forEach var="p" items="${programs}">
  <p>
    <c:out value="${p.getName()}"/> [<c:out value="${p.getLocation().toString()}"/>]
  </p>
  <p>
    from <fmt:formatDate value="${p.startDate}" pattern="dd/MM/yyyy" /> till <fmt:formatDate value="${p.endDate}" pattern="dd/MM/yyyy" />
  </p>
  <a href="/mentorship-programs/${p.getId()}">details</a>
  <a href="/mentorship-programs/${p.getId()}/edit">edit</a>
  <br>
</c:forEach>