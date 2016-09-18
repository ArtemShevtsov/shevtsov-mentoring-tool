<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Please, find below all Mentorship Programs:</h2>
<a href="/mentorship-programs/new">Add New Mentorship Program</a>
<hr>
<c:forEach var="p" items="${programs}">
  <p>
    <c:out value="${p.getName()}"/> [<c:out value="${p.getLocation().toString()}"/>]
  </p>
  <p>
    from <c:out value="${p.getStartDate()}"/> till <c:out value="${p.getEndDate()}"/>
  </p>
  <a href="/mentorship-programs/${p.getId()}">details</a>
  <a href="/mentorship-programs/${p.getId()}/edit">edit</a>
  <br>
</c:forEach>