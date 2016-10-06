<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h2>Please, find below all persons:</h2>
<a href="/persons/new">Add New Person</a>
<hr>
<c:forEach var="p" items="${persons}">
  <p>
    <c:out value="${p.getFirstName()}"/> <c:out value="${p.getLastName()}"/>
    [<c:out value="${p.getEmail()}"/>] (Manager: <c:out value="${p.getManagerFullName()}"/>)
  </p>
  <p>
    <c:out value="${p.getPrimarySkill().toString()}"/> <c:out value="${p.getProfessionalLevel().toString()}"/>
    (<fmt:formatDate value="${p.birthDate}" pattern="dd/MM/yyyy" />)
  </p>
  <a href="/persons/${p.getId()}">details</a>
  <a href="/persons/${p.getId()}/edit">edit</a>
  <br>
</c:forEach>