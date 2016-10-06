<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h2>Please, find below Mentorship Program with ID <c:out value="${program.getId()}"/>:</h2>
<hr>
<p>
  Program Name       :   <c:out value="${program.getName()}"/>
</p>
<p>
  Location           :   <c:out value="${program.getLocation().toString()}"/>
</p>
<p>
  Start Date         :   <fmt:formatDate value="${program.startDate}" pattern="dd/MM/yyyy" />
</p>
<p>
  End Date           :   <fmt:formatDate value="${program.endDate}" pattern="dd/MM/yyyy" />
</p>
<br>
<a href="/mentorship-programs">see All</a>
<a href="/mentorship-programs/${program.getId()}/edit">edit</a>