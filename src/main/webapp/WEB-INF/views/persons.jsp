<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Please, find below all persons:</h2>
<hr>
<c:forEach var="p" items="${persons}">
  <p>
    <c:out value="${p.getFirstName()}"/> <c:out value="${p.getLastName()}"/>
  </p>
</c:forEach>